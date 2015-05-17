package org.sample.web;

import java.util.ArrayList;
import java.util.List;

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
		List<String> avaterIdList = new ArrayList<String>();
		for (int i=1; i<=81; i++) {
			avaterIdList.add(String.format("%1$02d",i));
		}
		model.addAttribute("avaterIdList", avaterIdList);
		return "UserInfoInput";
	}
	
	@RequestMapping(value="/UserInfoInput", method=RequestMethod.POST)
	ModelAndView form(
		@RequestParam("userName") String userName,
		@RequestParam("password") String password,
		@RequestParam("avatarId") String avatarId) {
		
		ModelAndView modelAndView = new ModelAndView("UserInfoConfirm");
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("password", password);
		modelAndView.addObject("avatarId", avatarId);
		return modelAndView;
	}
}
