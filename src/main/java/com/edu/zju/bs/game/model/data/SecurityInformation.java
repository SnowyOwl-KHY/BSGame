package com.edu.zju.bs.game.model.data;

/**
 * Created by kehanyang on 15/6/26.
 */
public class SecurityInformation {

    private String accountName = "";

    private String password = "";

    public SecurityInformation() {
    }

    public SecurityInformation(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
