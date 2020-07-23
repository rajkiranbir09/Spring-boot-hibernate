package com.project.hibernate.controller;

import javax.servlet.http.HttpSession;

import com.project.hibernate.dto.LoginDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginInfo(@RequestBody LoginDTO loginDTO) {
//        , HttpSession session
//        if (session.getAttribute("SESSION_USER") != null) {
//            return "home";// return the page name Home
//        }
//        return "login";// return the page name Login
        return "Show login page";

    }

}
