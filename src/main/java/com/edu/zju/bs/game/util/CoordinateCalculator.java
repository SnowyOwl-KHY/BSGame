package com.edu.zju.bs.game.util;

/**
 * Created by kehanyang on 15/7/6.
 */
public class CoordinateCalculator {

    private static final int INIT_TOP = 200;

    private static final int INIT_LEFT = 400;

    private static final int TOP_SCALE = 50;

    private static final int LEFT_SCALE = 100;

    static public Coordinate cityCalculate(int x, int y) {
        return calculate(x, y, true);
    }

    static public Coordinate mapCalculate(int x, int y) {
        return calculate(x, y, false);
    }

    static private Coordinate calculate(int x, int y, boolean isCity) {
        int top = (isCity ? INIT_TOP : 0) + TOP_SCALE * (x + y);
        int left = (isCity ? INIT_LEFT : 0) + LEFT_SCALE * (x - y);
        return new Coordinate(top, left);
    }

}
