package com.edu.zju.bs.game.model.data;

import java.util.HashMap;

/**
 * Created by kehanyang on 15/7/6.
 */
public enum BuildingType {

    EMPTY("empty", 80, 160, 0, 0, "空地", "空地可以建造建筑。", 0),
    BARRACKS("barracks", "兵营", "兵营可以生产士兵，用于进攻和防守。", 100);

    String name;
    int height = 100;
    int width = 0;
    int topChange = -30;
    int leftChange = 20;
    String title;
    String desc;
    int cost;

    BuildingType(String name, String title, String desc, int cost) {
        this.name = name;
        this.title = title;
        this.desc = desc;
        this.cost = cost;
    }

    BuildingType(String name, int height, int width, int topChange, int leftChange, String title, String desc, int cost) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.topChange = topChange;
        this.leftChange = leftChange;
        this.title = title;
        this.desc = desc;
        this.cost = cost;
    }

    private static HashMap<String, BuildingType> types = new HashMap<String, BuildingType>();

    static {
        types.put("empty", EMPTY);
        types.put("barracks", BARRACKS);
    }

    public static BuildingType getType(String name) {
        return types.get(name);
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name;
    }
}
