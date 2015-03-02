package org.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController
{

	@RequestMapping("/")
	String index(Model model) {
		model.addAttribute("message", "this is index page!");
		return "Root";
	}

	@RequestMapping(value="/post", method=RequestMethod.POST)
	public ModelAndView postForm(
		@RequestParam("text1") String text1) {
		ModelAndView mv = new ModelAndView("Root");
		mv.addObject("message", "you typed '" + text1 + "'");
		return mv;
	}
}
