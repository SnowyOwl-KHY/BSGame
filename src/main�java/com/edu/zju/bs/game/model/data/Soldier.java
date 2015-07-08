package com.edu.zju.bs.game.model.data;

/**
 * Created by kehanyang on 15/7/8.
 */
public class Soldier {

    SoldierType type;
    int number;

    public Soldier(SoldierType type) {
        this.type = type;
    }

    public Soldier(SoldierType type, int number) {
        this.type = type;
        this.number = number;
    }

    public SoldierType getType() {
        return type;
    }

    public void setType(SoldierType type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
