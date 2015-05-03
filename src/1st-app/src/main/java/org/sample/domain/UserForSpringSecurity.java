package org.sample.domain;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserForSpringSecurity extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	
	org.sample.domain.User user;
	
	public UserForSpringSecurity(org.sample.domain.User user) {
		super(user.getUserName(), user.getPassword(), createRole(user)); // (2)
		this.user = user;
	}
	
	private static Collection<? extends GrantedAuthority> createRole(org.sample.domain.User user) {
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")); // (3)
	}
	
	public org.sample.domain.User getUser() {
		return user;
	}
}
