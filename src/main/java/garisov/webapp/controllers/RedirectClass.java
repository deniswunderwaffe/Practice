package garisov.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class RedirectClass {

    @GetMapping()
    public String redirect(){
        return "redirect:/main";
    }
}
