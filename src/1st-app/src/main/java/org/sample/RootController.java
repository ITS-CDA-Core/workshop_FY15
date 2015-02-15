package org.sample;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class RootController
{

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
