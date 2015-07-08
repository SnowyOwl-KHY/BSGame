package com.edu.zju.bs.game.controller;

import com.edu.zju.bs.game.model.data.*;
import com.edu.zju.bs.game.model.database.DataSolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
        List<Building> buildings = city.getBuildingList();
        ModelAndView mv = new ModelAndView();
        mv.addObject("buildings", buildings);
        mv.addObject("username", username);
        mv.addObject("soldiers", city.getSoldierList());
        mv.addObject("resources", city.getResourceList());
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping(value = {"/building"}, method = {RequestMethod.GET})
    public ModelAndView building(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        String id = req.getParameter("id");
        City city = dataSolver.getCity(username);
        List<Building> buildings = city.getBuildingList();
        ModelAndView mv;
        Building building = buildings.get(Integer.valueOf(id));
        if (building.getType() == BuildingType.EMPTY) {
            mv = listBuilding();
        } else {
            mv = showBuilding(building.getType(), building.getLevel(), req, city);
        }
        mv.addObject("id", id);
        mv.addObject("username", username);
        return mv;
    }

    private ModelAndView listBuilding() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<BuildingType> buildingList = new ArrayList<BuildingType>();
        buildingList.add(BuildingType.BARRACKS);
        mv.addObject("buildingList", buildingList);
        mv.setViewName("buildingList");
        return mv;
    }

    private ModelAndView showBuilding(BuildingType type, int level, HttpServletRequest req, City city) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("type", type);
        mv.addObject("level", level);
        req.setAttribute("buildingType", BuildingType.BARRACKS.getName());
        mv.addObject("soldierTypes", SoldierType.values());
        mv.addObject("presentGold", city.getResourceList().get(0).getNumber());
        mv.setViewName("building");
        return mv;
    }

    @RequestMapping(value = {"/building"}, method = {RequestMethod.POST})
    public ModelAndView build(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        int bid = Integer.valueOf(id);
        int level = Integer.valueOf(req.getParameter("level"));
        BuildingType type = BuildingType.getType(req.getParameter("type"));
        String username = req.getParameter("username");
        dataSolver.updateBuilding(username, type, bid, level);
        return enterHome(req, resp);
    }
}
