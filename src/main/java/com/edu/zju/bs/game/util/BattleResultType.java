package com.edu.zju.bs.game.util;

/**
 * Created by kehanyang on 15/7/9.
 */
public enum BattleResultType {
    WIN("胜利"),
    LOSE("失败"),
    DRAW("平手");

    String title;

    BattleResultType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
