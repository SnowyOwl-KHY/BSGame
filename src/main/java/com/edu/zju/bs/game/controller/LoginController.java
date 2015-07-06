package com.edu.zju.bs.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kehanyang on 15/7/6.
 */
@Controller
public class LoginController {
    @RequestMapping(value = {"/login", "/"})
    public ModelAndView login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = (String) req.getAttribute("username");
        String password = (String) req.getAttribute("password");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
}
