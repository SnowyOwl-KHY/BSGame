package com.edu.zju.bs.game.model.database;

import com.edu.zju.bs.game.model.data.Building;
import com.edu.zju.bs.game.model.data.BuildingType;
import com.edu.zju.bs.game.model.data.City;
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

    private static boolean initialFlag = false;

    private static Logger logger= Logger.getLogger(DataSolver.class.getName());

    public DataSolver() {
        super();
        try {
            Reader reader = Resources.getResourceAsReader("mybatis/config.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
            accountTable = new AccountTable(sqlMapClient);
            cityTable = new CityTable(sqlMapClient);
            if (initialFlag == false) {
                accountTable.initial();
                cityTable.initial();
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
        cityTable.add(new City(username));
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
        Building building = new Building(type, id, level);
        city.build(building);
        cityTable.update(city);
        return city;
    }

    public City increaseResource(String username, int index, int number) {
        City city = getCity(username);
        city.increaseResources(index, number);
        cityTable.update(city);
        return city;
    }

    public static void main(String[] args) {
        DataSolver test = new DataSolver();
        test.increaseResource("test", 0, 100);
    }
}
