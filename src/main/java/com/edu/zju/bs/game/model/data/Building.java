package com.edu.zju.bs.game.model.data;

import com.edu.zju.bs.game.util.Coordinate;
import com.edu.zju.bs.game.util.CoordinateCalculator;

/**
 * Created by kehanyang on 15/7/6.
 */
public class Building {
    String name;
    String top;
    String left;
    String height;
    String width;
    int id;

    private static final int SIZE = 4;

    public Building(BuildingType type, int x, int y) {
        this.name = type.name;
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
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
