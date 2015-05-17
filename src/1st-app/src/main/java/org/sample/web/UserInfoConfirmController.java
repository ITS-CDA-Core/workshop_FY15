package org.sample.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.sample.domain.User;
import org.sample.service.UserService;

@Controller
public class UserInfoConfirmController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/UserInfoConfirm", method=RequestMethod.POST)
	String form(
		@RequestParam("userName") String userName,
		@RequestParam("password") String password,
		@RequestParam("avatarId") String avatarId) {
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setAvatarId(avatarId);
		user.setCreatedAt(new Date());
		service.save(user);
		
		return "redirect:/";
	}
}
