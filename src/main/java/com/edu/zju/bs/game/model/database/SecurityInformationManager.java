package com.edu.zju.bs.game.model.database;

import com.edu.zju.bs.game.model.data.SecurityInformation;
import com.ibatis.sqlmap.client.SqlMapClient;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kehanyang on 15/6/26.
 */
public class SecurityInformationManager {

    private SqlMapClient sqlMapClient;

    public SecurityInformationManager(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public boolean existUser(String accountName) {
        try {
            List<SecurityInformation> queryResult = sqlMapClient.queryForList("selectSecurityInformation", new SecurityInformation(accountName, "%"));
            return queryResult.size() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkPassword(String accountName, String passwordCipher) {
        try {
            List<SecurityInformation> queryResult = sqlMapClient.queryForList("selectSecurityInformation", new SecurityInformation(accountName, passwordCipher));
            return queryResult.size() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean add(String accountName, String passwordCipher) {
        try {
            sqlMapClient.insert("insertSecurityInformation", new SecurityInformation(accountName, passwordCipher));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changePassword(String accountName, String passwordCipher) {
        try {
            sqlMapClient.update("updatePassword", new SecurityInformation(accountName, passwordCipher));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remove(String accountName) {
        try {
            sqlMapClient.update("deleteSecurityInformation", accountName);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
