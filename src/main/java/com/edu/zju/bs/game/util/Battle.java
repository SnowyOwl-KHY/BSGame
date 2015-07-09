package com.edu.zju.bs.game.util;

import com.edu.zju.bs.game.exception.BattleException;
import com.edu.zju.bs.game.exception.ResourceNotEnoughException;
import com.edu.zju.bs.game.model.data.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kehanyang on 15/7/9.
 */
public class Battle {

    public static final double PLUNDER_PERCENTAGE = 0.2;

    public static BattleResult battle(City sourceCity, City targerCity, String targetResourceInfo) throws BattleException {
        List<Soldier> sourceSoldierList = sourceCity.getSoldierList();
        List<Soldier> targetSoldierList = targerCity.getSoldierList();
        BattleResult battleResult = battle(sourceSoldierList, targetSoldierList, targetResourceInfo);

        // 更新资源和军队信息
        if (battleResult.getType() == BattleResultType.WIN) {
            List<Resource> resourceList = battleResult.getWinResources().getResourceList();
            for (int i = 0; i < resourceList.size(); i++) {
                try {
                    sourceCity.increaseResource(i, resourceList.get(i).getNumber());
                    targerCity.increaseResource(i, -resourceList.get(i).getNumber());
                } catch (ResourceNotEnoughException e) {
                    e.printStackTrace();
                }
            }
        }
        sourceCity.setArmy(battleResult.getSourceRemainArmy());
        targerCity.setArmy(battleResult.getTargetRemainArmy());
        return battleResult;
    }

    private static BattleResult battle(final List<Soldier> sourceSoldiers, final List<Soldier> targetSoldiers, String targetResourcesInfo) throws BattleException {
        List<Soldier> sourceSoldierList = new ArrayList<Soldier>(sourceSoldiers);
        List<Soldier> targetSoldierList = new ArrayList<Soldier>(targetSoldiers);
        BattleResult battleResult = new BattleResult();

        int sourceAttack = totalAttack(sourceSoldierList);
        int targetAttack = totalAttack(targetSoldierList);
        int[] sourceOldAttack = new int [sourceSoldierList.size()];
        int[] targetOldAttack = new int [targetSoldierList.size()];

        while (sourceAttack > 0 && targetAttack > 0) {
            attack(sourceAttack, targetSoldierList, sourceOldAttack, battleResult.getTargetLostArmy());   // once attack
            attack(targetAttack, sourceSoldierList, targetOldAttack, battleResult.getSourceLostArmy());
            sourceAttack = totalAttack(sourceSoldierList);
            targetAttack = totalAttack(targetSoldierList);
        }

        battleResult.setSourceRemainArmy(new Army(sourceSoldierList));
        battleResult.setTargetRemainArmy(new Army(targetSoldierList));
        int sourceRemainNumber = remainTypeNumber(sourceSoldierList);
        int targetRemainNumber = remainTypeNumber(targetSoldierList);
        if (sourceRemainNumber == 0 && targetRemainNumber == 0) {
            battleResult.setType(BattleResultType.DRAW);
            battleResult.setWinResources(new Resources());
        } else if (sourceRemainNumber == 0) {
            battleResult.setType(BattleResultType.LOSE);
            battleResult.setWinResources(new Resources());
        } else if (targetRemainNumber == 0) {
            battleResult.setType(BattleResultType.WIN);
            battleResult.setWinResources(new Resources(targetResourcesInfo));

            // win 0.1 * targetResources
            List<Resource> resourceList = battleResult.getWinResources().getResourceList();
            for (int i = 0; i < resourceList.size(); i++) {
                Resource resource = resourceList.get(i);
                resource.setNumber((int)(resource.getNumber() * PLUNDER_PERCENTAGE));
            }
        } else {
            throw new BattleException("Loop unfinished.");
        }
        return battleResult;
    }

    private static void attack(int attack, List<Soldier> soldierList, int[] oldAttack, Army lostArmy) {
        int number = remainTypeNumber(soldierList);
        int avgAttack = attack / number;
        for (int i = 0; i < soldierList.size(); i++) {
            if (soldierList.get(i).getNumber() > 0) {
                int health = soldierList.get(i).getType().getHealth();
                int dead = Math.min((avgAttack + oldAttack[i]) / health, soldierList.get(i).getNumber());
                oldAttack[i] = (avgAttack + oldAttack[i]) % health;
                soldierList.get(i).setNumber(soldierList.get(i).getNumber() - dead);

                lostArmy.increase(i, dead);
            }
        }
    }

    private static int remainTypeNumber(List<Soldier> soldierList) {
        int count = 0;
        for (int i = 0; i < soldierList.size(); i++) {
            if (soldierList.get(i).getNumber() > 0) {
                count++;
            }
        }
        return count;
    }

    private static int totalAttack(List<Soldier> soldierList) {
        int result = 0;
        for (int i = 0; i < soldierList.size(); i++) {
            if (soldierList.get(i).getNumber()> 0) {
                result += soldierList.get(i).getNumber() * soldierList.get(i).getType().getAttack();
            }
        }
        return result;
    }

}
