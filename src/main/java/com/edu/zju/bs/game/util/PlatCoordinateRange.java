package com.edu.zju.bs.game.util;

import com.edu.zju.bs.game.model.data.Plat;

/**
 * Created by kehanyang on 15/7/8.
 */
public class PlatCoordinateRange {

    int centerX;
    int centerY;
    int left;
    int right;
    int top;
    int bottom;

    public static int MAX_RANGE = 25;

    public PlatCoordinateRange(int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.left = centerX - (Plat.SIZE - 1) / 2;
        this.right = centerX + (Plat.SIZE - 1) / 2 + 1;
        this.top = centerY - (Plat.SIZE - 1) / 2;
        this.bottom = centerY + (Plat.SIZE - 1) / 2 + 1;
        if (this.left < 0) {
            this.right += -this.left;
            this.centerX += -this.left;
            this.left = 0;
        }
        if (this.top < 0) {
            this.bottom += -this.top;
            this.centerY += -this.top;
            this.top = 0;
        }
        if (this.right > MAX_RANGE) {
            this.left -= this.right - MAX_RANGE;
            this.centerX -= this.right - MAX_RANGE;
            this.right = MAX_RANGE;
        }
        if (this.bottom > MAX_RANGE) {
            this.top -= this.bottom - MAX_RANGE;
            this.centerY -= this.bottom - MAX_RANGE;
            this.bottom = MAX_RANGE;
        }
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }
}
