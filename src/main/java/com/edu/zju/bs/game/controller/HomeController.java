package com.edu.zju.bs.game.controller;

import com.edu.zju.bs.game.model.data.Building;
import com.edu.zju.bs.game.model.data.BuildingType;
import com.edu.zju.bs.game.model.data.City;
import com.edu.zju.bs.game.model.database.CityTable;
import com.edu.zju.bs.game.model.database.DataSolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by kehanyang on 15/7/5.
 */
@Controller
public class HomeController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    DataSolver dataSolver = new DataSolver();

    @RequestMapping(value = {"/home"})
    public ModelAndView enterHome(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        City city = dataSolver.getCity(username);
        List<Building> buildings = city.getBuildings(true);
        ModelAndView mv = new ModelAndView();
        mv.addObject("buildings", buildings);
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping(value = {"/building/{id}"})
    public ModelAndView build(HttpServletRequest req, HttpServletResponse resp, @PathVariable String identity) throws Exception {
        int id = Integer.valueOf(identity);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("building");
        return mv;
    }

}
