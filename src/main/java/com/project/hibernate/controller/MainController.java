package com.project.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = {"/", "/login"})
public class MainController {

//    @Autowired
//    HttpSession session;
//
//    @RequestMapping(value="/userControl")
//    @ResponseBody
//    public String getByEmail(@RequestParam String lgnUser,@RequestParam String lgnPass) {
//        String userId;
//        try {
//            User user = userDao.getControlUser(lgnUser,lgnPass);
//            userId = String.valueOf(user.getId());
//        }
//        catch (Exception ex) {
//            return "hata";
//        }
//        session.setAttribute("userId",userId);
//        return userId;
//    }
}
