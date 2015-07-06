package com.edu.zju.bs.game.controller;

import com.edu.zju.bs.game.model.database.DataSolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by kehanyang on 15/7/6.
 */
@Controller
public class LoginController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value = {"/login", "/", "logup"})
    public ModelAndView log(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        DataSolver dataSolver = new DataSolver();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String uri = req.getRequestURI();
        boolean isLogin = uri.equals("/login") || uri.equals("/");
        if (isLogin) {
            req.setAttribute("action", "login");
        } else {
            req.setAttribute("action", "logup");
        }
        ModelAndView mv = new ModelAndView();
        if (username == null) {
            mv.setViewName("log");
        } else if (isLogin && dataSolver.checkPassword(username, password) == false) {
            req.setAttribute("problem", "wrongAccount");
            mv.setViewName("log");
        } else if (!isLogin && dataSolver.addUser(username, password) == false) {
            req.setAttribute("problem", "existUser");
            mv.setViewName("log");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/home");
            dispatcher.forward(req, resp);
        }
        return mv;
    }
}
