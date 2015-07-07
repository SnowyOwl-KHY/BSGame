package com.edu.zju.bs.game.model.data;

import java.util.*;

/**
 * Created by kehanyang on 15/7/7.
 */
public class Army {

    Map<SoldierType, Integer> soldierNumber = new HashMap<SoldierType, Integer>();

    static SoldierType[] soldierTypes = SoldierType.values();

    public Army() {
        int[] numbers = new int[soldierTypes.length];
        init(numbers);
    }

    public Army(int[] numbers) {
        init(numbers);
    }

    public Army(String numberInfo) {
        String[] temp = numberInfo.split(",");
        int[] numbers = new int[temp.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.valueOf(temp[i]);
        }
        init(numbers);
    }

    private void init(int[] numbers) {
        int i = 0;
        for (; i < numbers.length && i < soldierTypes.length; i++) {
            soldierNumber.put(soldierTypes[i], numbers[i]);
        }
        for (; i < soldierTypes.length; i++) {
            soldierNumber.put(soldierTypes[i], 0);
        }
    }

    @Override
    public String toString() {
        Collection<Integer> soldiers = soldierNumber.values();
        return soldiers.toString();
    }

}
