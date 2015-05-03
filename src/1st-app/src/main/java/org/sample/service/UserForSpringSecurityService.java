package org.sample.service;

import org.sample.domain.User;
import org.sample.domain.UserForSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserForSpringSecurityService implements UserDetailsService {

	@Autowired
	UserService service;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = service.findOne(userName);
		
		if (user == null) throw new UsernameNotFoundException("user not found");
		
		return new UserForSpringSecurity(user);
	}
}
