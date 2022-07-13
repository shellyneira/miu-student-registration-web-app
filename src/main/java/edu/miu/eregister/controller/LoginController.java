package edu.miu.eregister.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping({"/public/login", "/eregister/public/login"})
    public String displayLoginPage() {
        return "public/login/login";
    }

    @PostMapping({"/public/logout", "/eregister/public/logout"})
    public String doLogout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/eregister/public/login?logout";
    }
}
