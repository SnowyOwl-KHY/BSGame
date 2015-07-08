package com.edu.zju.bs.game.model.data;

import java.util.*;

/**
 * Created by kehanyang on 15/7/7.
 */
public class Army {

    static final SoldierType[] soldierTypes = SoldierType.values();

    List<Soldier> soldiers = new ArrayList<Soldier>(soldierTypes.length);

    public Army() {
        for (int i = 0; i < soldierTypes.length; i++) {
            soldiers.add(null);
        }
        int[] numbers = new int[soldierTypes.length];
        setSoldiers(numbers);
    }

    public void increase(int index, int number) {
        Soldier soldier = soldiers.get(index);
        soldier.increase(number);
    }

    private void setSoldiers(int[] numbers) {
        int i = 0;
        for (; i < numbers.length && i < soldierTypes.length; i++) {
            soldiers.set(i, new Soldier(soldierTypes[i], numbers[i]));
        }
        for (; i < soldierTypes.length; i++) {
            soldiers.set(i, new Soldier(soldierTypes[i]));
        }
    }

    public String getSoldiers() {
        return toString();
    }

    public void setSoldiers(String soldierInfo) {
        String[] temp = soldierInfo.split(",");
        int[] numbers = new int[temp.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.valueOf(temp[i]);
        }
        setSoldiers(numbers);
    }

    public List<Soldier> getSoldierList() {
        return soldiers;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < soldiers.size(); i++) {
            result.append(soldiers.get(i).getNumber());
            if (i < soldiers.size() - 1) {
                result.append(",");
            }
        }
        return result.toString();
    }

}
