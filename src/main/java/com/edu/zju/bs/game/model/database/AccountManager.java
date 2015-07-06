package com.edu.zju.bs.game.model.database;

import com.edu.zju.bs.game.model.data.Account;
import com.ibatis.sqlmap.client.SqlMapClient;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kehanyang on 15/6/26.
 */
public class AccountManager {

    private SqlMapClient sqlMapClient;

    public AccountManager(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public void initial() {
        try {
            sqlMapClient.update("createAccount");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existUser(String username) {
        try {
            List<Account> queryResult = sqlMapClient.queryForList("selectAccount", new Account(username, "%"));
            return queryResult.size() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkPassword(String username, String passwordCipher) {
        try {
            List<Account> queryResult = sqlMapClient.queryForList("selectAccount", new Account(username, passwordCipher));
            return queryResult.size() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void add(String username, String passwordCipher) {
        try {
            sqlMapClient.insert("insertAccount", new Account(username, passwordCipher));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(String username, String passwordCipher) {
        try {
            sqlMapClient.update("updatePassword", new Account(username, passwordCipher));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(String username) {
        try {
            sqlMapClient.update("deleteAccount", username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
