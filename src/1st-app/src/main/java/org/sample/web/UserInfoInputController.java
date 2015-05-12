package org.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserInfoInputController {
	@RequestMapping("/UserInfoInput")
	String index(Model model) {
		return "UserInfoInput";
	}
	
	@RequestMapping(value="/UserInfoInput", method=RequestMethod.POST)
	ModelAndView form(
		@RequestParam("userName") String userName,
		@RequestParam("password") String password) {
		
		ModelAndView modelAndView = new ModelAndView("UserInfoConfirm");
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("password", password);
		return modelAndView;
	}
}
