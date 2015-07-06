package com.edu.zju.bs.game.model.data;

import java.util.HashMap;

/**
 * Created by kehanyang on 15/7/6.
 */
public enum BuildingType {

    EMPTY("empty", 80, 160, 0, 0),
    BARRACKS("barracks");

    String name;
    int height = 100;
    int width = 0;
    int topChange = -30;
    int leftChange = 20;

    BuildingType(String name) {
        this.name = name;
    }

    BuildingType(String name, int height, int width, int topChange, int leftChange) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.topChange = topChange;
        this.leftChange = leftChange;
    }

    private static HashMap<String, BuildingType> types = new HashMap<String, BuildingType>();

    static {
        types.put("empty", EMPTY);
        types.put("barracks", BARRACKS);
    }

    public static BuildingType getType(String name) {
        return types.get(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
