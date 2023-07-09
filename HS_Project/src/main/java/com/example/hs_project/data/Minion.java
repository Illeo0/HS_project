package com.example.hs_project.data;

import java.util.Set;

/**
 The class Minion is used in order to save every characteristic needed from a minion taken
 directly from the Hearthstone official API
 **/
public class Minion {
    String id;
    int health;
    int attack;
    int tier;
    String name;
    Set<String> type;
    String image;

    //Constructor for minions with two types
    public Minion(String id, int health, int attack, int tier, String name, Set<String> type, String image) {
        this.id = id;
        this.health = health;
        this.attack = attack;
        this.tier = tier;
        this.name = name;
        this.type = type;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getType() {
        return type;
    }

    public void setType(Set<String> type) {this.type = type;}

    public String getImage() {return image;}

    public void setImage(String image) { this.image = image;}

    @Override
    public String toString() {
        return "Minion{" +
                "id=" + id +
                ", health=" + health +
                ", attack=" + attack +
                ", tier=" + tier +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}