package com.edu.zju.bs.game.util;

/**
 * Created by kehanyang on 15/7/6.
 */
public class CoordinateCalculator {

    private static final int INIT_TOP = 200;

    private static final int INIT_LEFT = 250;

    private static final int TOP_SCALE = 50;

    private static final int LEFT_SCALE = 100;

    static public Coordinate calculate(int x, int y) {
        int top = INIT_TOP + TOP_SCALE * (x + y);
        int left = INIT_LEFT + LEFT_SCALE * (x - y);
        return new Coordinate(top, left);
    }

}
