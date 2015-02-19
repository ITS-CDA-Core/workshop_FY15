package org.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;;

@Controller
public class RootController
{

    @RequestMapping("/")
    String index(Model model) {
    	model.addAttribute("message", "this is index page!");
        return "Root";
    }
}
