package com.edu.zju.bs.game.model.data;

import com.edu.zju.bs.game.util.Coordinate;
import com.edu.zju.bs.game.util.CoordinateCalculator;

/**
 * Created by kehanyang on 15/7/6.
 */
public class Building {
    BuildingType type;
    String top;
    String left;
    String height;
    String width;
    int id;
    int level;

    static final int SIZE = 4;

    public Building(int id) {
        this(BuildingType.EMPTY, id, 0);
    }

    public Building(BuildingType type, int id, int level) {
        this(type, id % SIZE, id / SIZE, level);
    }

    public Building(BuildingType type, int x, int y, int level) {
        this.type = type;
        Coordinate coordinate = CoordinateCalculator.calculate(x, y);
        this.top = String.valueOf(coordinate.top + type.topChange);
        this.left = String.valueOf(coordinate.left + type.leftChange);
        this.height = String.valueOf(type.height);
        if (type.width > 0) {
            this.width = String.valueOf(type.width);
        } else {
            this.width = "";
        }
        this.id = y * SIZE + x;
        this.level = level;
    }

    public BuildingType getType() {
        return type;
    }

    public void setType(BuildingType type) {
        this.type = type;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
