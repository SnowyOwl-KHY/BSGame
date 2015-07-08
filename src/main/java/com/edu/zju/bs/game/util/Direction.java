package com.edu.zju.bs.game.util;

/**
 * Created by kehanyang on 15/7/9.
 */
public enum Direction {
    WEST,
    EAST,
    NORTH,
    SOUTH;

    public static Direction getDirection(String direction) {
        return valueOf(direction.toUpperCase());
    }
}
