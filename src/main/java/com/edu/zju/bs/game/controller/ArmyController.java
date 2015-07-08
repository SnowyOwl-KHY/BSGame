package com.edu.zju.bs.game.controller;

import com.edu.zju.bs.game.model.data.SoldierType;
import com.edu.zju.bs.game.model.database.DataSolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kehanyang on 15/7/8.
 */
@Controller
public class ArmyController {

    DataSolver dataSolver = new DataSolver();

    @RequestMapping(value = {"train"}, method = {RequestMethod.POST})
    public void train(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String soldierType = req.getParameter("soldierType");
        String soldierNumber = req.getParameter("soldierNumber");
        int index = SoldierType.getIndex(soldierType);
        dataSolver.trainSoldiers(username, index, Integer.valueOf(soldierNumber));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
