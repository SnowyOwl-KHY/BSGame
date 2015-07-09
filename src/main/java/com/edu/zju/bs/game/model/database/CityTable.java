package com.edu.zju.bs.game.model.database;

import com.edu.zju.bs.game.model.data.Building;
import com.edu.zju.bs.game.model.data.City;
import com.ibatis.sqlmap.client.SqlMapClient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kehanyang on 15/7/6.
 */
public class CityTable {

    private SqlMapClient sqlMapClient;

    public CityTable(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public void initial() {
        try {
            sqlMapClient.update("createCity");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public City getCity(String username) {
        try {
            List<City> citys = (List<City>) sqlMapClient.queryForList("selectCityByUsername", username);
            return citys.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public City getCity(int id) {
        try {
            City city = (City) sqlMapClient.queryForObject("selectCityById", id);
            return city;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(City city) {
        try {
            sqlMapClient.insert("insertCity", city);
            city = getCity(city.getUsername());
            return city.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void update(City city) {
        try {
            sqlMapClient.update("updateCityByUsername", city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
