package com.edu.zju.bs.game.model.database;

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

    public static void main(String[] args) {
        Logger logger= Logger.getLogger(DataSolver.class.getName());
        logger.info("test");
    }
}
