package org.sample.web;

import java.util.List;

import org.sample.domain.ChatRoom;
import org.sample.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatRoomListController
{
	@Autowired
	ChatRoomService service;

	@RequestMapping("/")
	String index(Model model) {
		List<ChatRoom> chatRoomList = service.findAll();
		
		String message = "";
		for (ChatRoom chatRoom : chatRoomList) {
			message += chatRoom.getTitle();
		}
		
		model.addAttribute("message", message);
		return "ChatRoomList";
	}

	@RequestMapping(value="/post", method=RequestMethod.POST)
	public ModelAndView postForm(
		@RequestParam("text1") String text1) {
		ModelAndView mv = new ModelAndView("ChatRoomList");
		mv.addObject("message", "you typed '" + text1 + "'");
		return mv;
	}
}
