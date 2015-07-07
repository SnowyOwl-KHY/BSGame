package com.edu.zju.bs.game.model.data;

/**
 * Created by kehanyang on 15/7/7.
 */
public enum SoldierType {

    AXE("axe", 50, 10, "斧兵", "生命值: 50<br />攻击力: 10", 0),
    SWORD("sword", 100, 20, "剑兵", "生命值: 100<br />攻击力: 20", 5);

    String name;
    int health;
    int attack;
    String title;
    String desc;
    int level;

    SoldierType(String name, int health, int attack, String title, String desc, int level) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.title = title;
        this.desc = desc;
        this.level = level;
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

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getLevel() {
        return level;
    }
}
