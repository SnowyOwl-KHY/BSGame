package com.edu.zju.bs.game.controller;

import com.edu.zju.bs.game.exception.BattleException;
import com.edu.zju.bs.game.model.data.City;
import com.edu.zju.bs.game.model.data.Resources;
import com.edu.zju.bs.game.model.data.Site;
import com.edu.zju.bs.game.model.database.DataSolver;
import com.edu.zju.bs.game.util.Battle;
import com.edu.zju.bs.game.util.BattleResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kehanyang on 15/7/9.
 */
@Controller
public class BattleController {

    DataSolver dataSolver = new DataSolver();

    @RequestMapping(value = {"/attack"})
    public ModelAndView attack(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        int targetX = Integer.valueOf(req.getParameter("targetX"));
        int targetY = Integer.valueOf(req.getParameter("targetY"));
        Site site = dataSolver.getSite(targetX, targetY);
        String siteType = site.getSiteType();
        City sourceCity = dataSolver.getCity(username);
        City targetCity;
        String targetResourcesInfo;
        if (siteType.equals("playerCity")) {
            targetCity = dataSolver.getCity(site.getCityId());
            targetResourcesInfo = targetCity.getResources();
        } else if (siteType.equals("npcCity")) {
            targetCity = new City("computer", site.getArmy(), site.getResources());
            targetResourcesInfo = site.getResources();
        } else {
            targetCity = new City("empty");
            targetResourcesInfo = new Resources().getResources();
        }
        BattleResult result = null;
        try {
            result = Battle.battle(sourceCity, targetCity, targetResourcesInfo);
            dataSolver.updateCity(sourceCity);
            if (site.getSiteType().equals("playerCity")) {
                dataSolver.updateCity(targetCity);
            } else if (site.getSiteType().equals("npcCity")) {
                site.setArmy(targetCity.getArmy());
                site.setResources(targetCity.getResources());
                dataSolver.updateSite(site);
            }
        } catch (BattleException e) {
            e.printStackTrace();
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("result", result);
        mv.addObject("targetX", targetX);
        mv.addObject("targetY", targetY);
        mv.addObject("username", username);
        mv.setViewName("battleResult");
        return mv;
    }
}
