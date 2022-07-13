package edu.miu.eregister.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping({"/", "/eregister", "/eregister/home"})
    public String displayHomePage() {
        return "public/home/index";
    }
}
