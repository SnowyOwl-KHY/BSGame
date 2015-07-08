package com.edu.zju.bs.game.controller;

import com.edu.zju.bs.game.model.data.Plat;
import com.edu.zju.bs.game.model.data.Site;
import com.edu.zju.bs.game.model.database.DataSolver;
import com.edu.zju.bs.game.util.Direction;
import com.edu.zju.bs.game.util.PlatCoordinateRange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kehanyang on 15/7/8.
 */
@Controller
public class PlatController {

    DataSolver dataSolver = new DataSolver();

    @RequestMapping(value = {"/plat"})
    public ModelAndView plat(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        Site site = dataSolver.getSite(username);
        Plat plat = dataSolver.getPlat(site.getX(), site.getY());
        ModelAndView mv = new ModelAndView();
        mv.addObject("siteList", plat.getSites());
        mv.addObject("username", username);
        mv.addObject("centerX", site.getX());
        mv.addObject("centerY", site.getY());
        mv.addObject("userX", site.getX());
        mv.addObject("userY", site.getY());
        mv.setViewName("plat");
        return mv;
    }

    @RequestMapping(value = {"/westPlat", "/eastPlat", "/northPlat", "/southPlat"})
    public ModelAndView move(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String userX = req.getParameter("userX");
        String userY = req.getParameter("userY");
        int x = Integer.valueOf(req.getParameter("x"));
        int y = Integer.valueOf(req.getParameter("y"));
        String uri = req.getRequestURI();
        uri = uri.substring(1, uri.length() - 4);
        switch (Direction.getDirection(uri)) {
            case WEST: x -= Plat.SIZE; break;
            case EAST: x += Plat.SIZE; break;
            case NORTH: y -= Plat.SIZE; break;
            case SOUTH: y += Plat.SIZE; break;
        }
        Plat plat = dataSolver.getPlat(x, y);
        ModelAndView mv = new ModelAndView();
        mv.addObject("siteList", plat.getSites());
        mv.addObject("username", username);
        mv.addObject("centerX", plat.getCenterX());
        mv.addObject("centerY", plat.getCenterY());
        mv.addObject("userX", userX);
        mv.addObject("userY", userY);
        mv.setViewName("plat");
        return mv;
    }
}
