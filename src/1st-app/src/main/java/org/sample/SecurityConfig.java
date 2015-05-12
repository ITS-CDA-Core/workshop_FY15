package org.sample;

import java.util.ArrayList;
import java.util.List;

import org.sample.service.UserForSpringSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserForSpringSecurityService userDetailsService;

	/*
	@Autowired
	Md5PasswordEncoder passwordEncoder;
	
	@Autowired
	SaltSource saltSource;
	*/

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception {
		
		super.configure(auth);
		auth.authenticationProvider(daoAuthenticationProvider());
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetailsService);
//		dao.setPasswordEncoder(passwordEncoder);
//		dao.setSaltSource(saltSource);
		return dao;
	}

	@Bean
	public ProviderManager providerManager() {
		List<AuthenticationProvider> list = new ArrayList<AuthenticationProvider>();
		list.add(daoAuthenticationProvider());
		return new ProviderManager(list);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
			"/static/**",
			"/api/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				"/",
				"/loginForm").permitAll()
			.anyRequest().authenticated();
		http.formLogin()
			.permitAll();
		http.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.permitAll();
		/*
		http.formLogin().loginProcessingUrl("/login").loginPage("/loginForm")
			.failureUrl("/loginForm?error").defaultSuccessUrl("/bookmark/list")
			.usernameParameter("username").passwordParameter("password")
			.permitAll();
		http.logout().logoutUrl("/logout").permitAll();
		*/
	}
}
