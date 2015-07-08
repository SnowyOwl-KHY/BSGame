package com.edu.zju.bs.game.model.database;

import com.edu.zju.bs.game.exception.ResourceNotEnoughException;
import com.edu.zju.bs.game.model.data.*;
import com.edu.zju.bs.game.util.PlatCoordinateRange;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.Logger;

/**
 * Created by kehanyang on 15/6/26.
 */
public class DataSolver {

    private SqlMapClient sqlMapClient;

    private AccountTable accountTable;

    private CityTable cityTable;

    private PlatTable platTable;

    private static Boolean initialFlag = false;

    private static Logger logger = Logger.getLogger(DataSolver.class.getName());

    public DataSolver() {
        super();
        try {
            Reader reader = Resources.getResourceAsReader("mybatis/config.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
            accountTable = new AccountTable(sqlMapClient);
            cityTable = new CityTable(sqlMapClient);
            platTable = new PlatTable(sqlMapClient);
            if (initialFlag == false) {
                accountTable.initial();
                cityTable.initial();
                platTable.initial();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean existUser(String username) {
        return accountTable.existUser(username);
    }

    public boolean checkPassword(String username, String passwordCipher) {
        return accountTable.checkPassword(username, passwordCipher);
    }

    public boolean addUser(String username, String passwordCipher) {
        if (existUser(username)) {
            return false;
        }
        accountTable.add(username, passwordCipher);
        City city = new City(username);
        city.setResources("200,200");
        int id = cityTable.add(city);
        int x = (int) (PlatCoordinateRange.MAX_RANGE * Math.random());
        int y = (int) (PlatCoordinateRange.MAX_RANGE * Math.random());
        Site site = new Site(x, y);
        site.setSiteType("playerCity");
        site.setCityId(id);
        platTable.update(site);
        return true;
    }

    public void changePassword(String username, String passwordCipher) {
        accountTable.changePassword(username, passwordCipher);
    }

    public void removeUser(String username) {
        accountTable.remove(username);
    }

    public City getCity(String username) {
        return cityTable.getCity(username);
    }

    public City updateBuilding(String username, BuildingType type, int id, int level) {
        City city = getCity(username);
        int oldLevel = city.getBuildingList().get(id).getLevel();
        city = increaseResource(username, 1, -(level - oldLevel) * type.getCost());
        if (city == null) {
            return null;
        }
        Building building = new Building(type, id, level);
        city.updateBuilding(building);
        cityTable.update(city);
        return city;
    }

    public City increaseResource(String username, int index, int number) {
        City city = getCity(username);
        try {
            city.increaseResource(index, number);
        } catch (ResourceNotEnoughException e) {
            e.printStackTrace(System.out);
            return null;
        }
        cityTable.update(city);
        return city;
    }

    public City trainSoldiers(String username, int index, int number) {
        SoldierType type = SoldierType.values()[index];
        City city = increaseResource(username, 0, -number * type.getCost());
        if (city == null) {
            return null;
        }
        city.increaseSoldier(index, number);
        cityTable.update(city);
        return city;
    }

    public Plat getPlat(int centerX, int centerY) {
        PlatCoordinateRange platCoordinateRange = new PlatCoordinateRange(centerX, centerY);
        return platTable.getPlat(platCoordinateRange);
    }

    public Site getSite(String username) {
        City city = getCity(username);
        return platTable.getSite(city.getId());
    }

    public static void main(String[] args) {
        DataSolver test = new DataSolver();
        test.addUser("test2", "123");
    }
}
