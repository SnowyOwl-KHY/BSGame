package com.edu.zju.bs.game.util;

import com.edu.zju.bs.game.model.data.Army;
import com.edu.zju.bs.game.model.data.Resources;

/**
 * Created by kehanyang on 15/7/9.
 */
public class BattleResult {

    BattleResultType type;
    Resources winResources;
    Army sourceLostArmy = new Army();
    Army sourceRemainArmy;
    Army targetLostArmy = new Army();
    Army targetRemainArmy;

    public void setType(BattleResultType type) {
        this.type = type;
    }

    public void setWinResources(Resources winResources) {
        this.winResources = winResources;
    }

    public void setSourceRemainArmy(Army sourceRemainArmy) {
        this.sourceRemainArmy = sourceRemainArmy;
    }

    public void setTargetRemainArmy(Army targetRemainArmy) {
        this.targetRemainArmy = targetRemainArmy;
    }

    public BattleResultType getType() {
        return type;
    }

    public Resources getWinResources() {
        return winResources;
    }

    public Army getSourceLostArmy() {
        return sourceLostArmy;
    }

    public Army getSourceRemainArmy() {
        return sourceRemainArmy;
    }

    public Army getTargetLostArmy() {
        return targetLostArmy;
    }

    public Army getTargetRemainArmy() {
        return targetRemainArmy;
    }
}
