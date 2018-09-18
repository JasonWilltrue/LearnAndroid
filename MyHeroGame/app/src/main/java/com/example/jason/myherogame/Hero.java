package com.example.jason.myherogame;

/**
 * 新类
 */
public class Hero {
    private String name;
    private int attack;
    private String type;

    public Hero(String name, int attack, String type) {
        this.name = name;
        this.attack = attack;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
