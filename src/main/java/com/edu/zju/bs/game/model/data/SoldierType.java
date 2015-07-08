package com.edu.zju.bs.game.model.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kehanyang on 15/7/7.
 */
public enum SoldierType {

    AXE("axe", 50, 10, 20, "斧兵", 0, 10),
    SWORD("sword", 100, 20, 80, "剑兵", 5, 20),
    KNIGHT("knight", 200, 50, 140, "骑士", 10, 50),
    UHLAN("uhlan", 500, 100, 200, "枪骑士", 15, 100);

    String name;
    int health;
    int attack;
    int left;   // HTML attribute
    String title;
    String desc;
    int level;
    int cost;

    private static Map<String, Integer> typeIndex = new HashMap<String, Integer>();

    private static List<SoldierType> types = new ArrayList<SoldierType>();

    static {
        SoldierType[] soldierTypes = SoldierType.values();
        for (int i = 0; i < soldierTypes.length; i++) {
            typeIndex.put(soldierTypes[i].getName(), i);
            types.add(soldierTypes[i]);
        }
    }

    public static int getIndex(String typeName) {
        return typeIndex.get(typeName);
    }

    SoldierType(String name, int health, int attack, int left, String title, int level, int cost) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.left = left;
        this.title = title;
        this.desc = "生命值: " + health + "<br />攻击力: " + attack;
        this.level = level;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getLeft() {
        return left;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getLevel() {
        return level;
    }

    public int getCost() {
        return cost;
    }
}
