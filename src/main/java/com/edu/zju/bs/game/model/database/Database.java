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

    private SecurityInformationManager securityInformationManager;

    private static boolean initialFlag = false;

    public Database() {
        super();
        try {
            Reader reader = Resources.getResourceAsReader("mybatis/config.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
            securityInformationManager = new SecurityInformationManager(sqlMapClient);
            if (initialFlag == false) {
                sqlMapClient.update("createSecurityInformation");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existUser(String accountName) {
        return securityInformationManager.existUser(accountName);
    }

    public boolean checkPassword(String accountName, String passwordCipher) {
        return securityInformationManager.checkPassword(accountName, passwordCipher);
    }

    public boolean addUser(String accountName, String passwordCipher) {
        return securityInformationManager.add(accountName, passwordCipher);
    }

    public boolean changePassword(String accountName, String passwordCipher) {
        return securityInformationManager.changePassword(accountName, passwordCipher);
    }

    public boolean removeUser(String accountName) {
        return securityInformationManager.remove(accountName);
    }

    public static void main(String[] args) {
        Logger logger= Logger.getLogger(Database.class.getName());
        logger.info("test");
    }
}