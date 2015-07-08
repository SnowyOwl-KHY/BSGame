package com.edu.zju.bs.game.model.data;

/**
 * Created by kehanyang on 15/7/8.
 */
public enum ResourceType {

    GOLD("gold", 20, "金币"),
    WOOD("wood", 80, "木材");

    String name;
    int left;
    String title;

    ResourceType(String name, int left, String title) {
        this.name = name;
        this.left = left;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public int getLeft() {
        return left;
    }

    public String getTitle() {
        return title;
    }
}
