package com.example.hs_project.data;

/**
 The class Hero is used in order to save every characteristic needed from a hero taken
 directly from the Hearthstone official API
 **/
public class Hero {
    String id;
    int health;
    int armor;
    String name;
    String image;
    int tier;

    public Hero(String id, int health, int armor, String name, String image, int tier) {
        this.id = id;
        this.health = health;
        this.armor = armor;
        this.name = name;
        this.image = image;
        this.tier = tier;
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

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTier() {return tier;}

    public void setTier(int tier) {this.tier = tier;}

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", health=" + health +
                ", armor=" + armor +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", tier=" + tier +
                '}';
    }

}