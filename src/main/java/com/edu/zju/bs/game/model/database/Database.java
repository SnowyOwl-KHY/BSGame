package com.edu.zju.bs.game.model.database;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by kehanyang on 15/6/26.
 */
public class Database {

    private SqlMapClient sqlMapClient;

    private AccountManager accountManager;

    private static boolean initialFlag = false;

    public Database() {
        super();
        try {
            Reader reader = Resources.getResourceAsReader("mybatis/config.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
            accountManager = new AccountManager(sqlMapClient);
            if (initialFlag == false) {
                accountManager.initial();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean existUser(String username) {
        return accountManager.existUser(username);
    }

    public boolean checkPassword(String username, String passwordCipher) {
        return accountManager.checkPassword(username, passwordCipher);
    }

    public void addUser(String username, String passwordCipher) {
        accountManager.add(username, passwordCipher);
    }

    public void changePassword(String username, String passwordCipher) {
        accountManager.changePassword(username, passwordCipher);
    }

    public void removeUser(String username) {
        accountManager.remove(username);
    }

    public static void main(String[] args) {
        Logger logger= Logger.getLogger(Database.class.getName());
        logger.info("test");
    }
}
