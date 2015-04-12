package org.sample;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;


@Configuration
public class AppConfig {
	@Autowired
	DataSourceProperties properties;
	DataSource dataSource;
	
	@ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
	@Bean(destroyMethod = "close")
	DataSource realDataSource() {
		DataSourceBuilder factory = DataSourceBuilder
			.create(this.properties.getClassLoader())
			.url(this.properties.getUrl())
			.username(this.properties.getUsername())
			.password(this.properties.getPassword());
		this.dataSource = factory.build();
		return this.dataSource;
	}
	
	@Bean
	DataSource dataSource() {
		return new Log4jdbcProxyDataSource(this.dataSource);
	}
	
	@Bean
	Filter corsFilter() {
		return new Filter() {
			public void doFilter(
				ServletRequest request,
				ServletResponse response,
				FilterChain chain) throws IOException, ServletException {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				String method = httpRequest.getMethod();
				httpResponse.setHeader("Access-Control-Allow-Origin", "*");
				httpResponse.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
				httpResponse.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
				httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
				httpResponse.setHeader("Access-Control-Allow-Headers",
					"Origin,Accept,X-Requested-With,"
						+ "Content-Type,Access-Control-Request-Method,"
						+ "Access-Control-Request-Headers,Authorization");
				
				if ("OPTIONS".equals(method)) {
					httpResponse.setStatus(HttpStatus.OK.value());
				} else {
					chain.doFilter(request, response);
				}
			}
			
			public void init(FilterConfig filterConfig) {
				
			}
			
			public void destroy() {
				
			}
		};
	}
}
