package com.edu.zju.bs.game.controller;

import com.edu.zju.bs.game.model.database.Database;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kehanyang on 15/7/6.
 */
@Controller
public class LoginController {
    @RequestMapping(value = {"/login", "/"})
    public ModelAndView login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Database db = new Database();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        ModelAndView mv = new ModelAndView();
        if (username == null) {
            mv.setViewName("login");
        } else if (db.checkPassword(username, password) == false) {
            mv.addObject("wrongAccount", true);
            mv.setViewName("login");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/home");
            dispatcher.forward(req, resp);
        }
        return mv;
    }
}
