package com.hnys.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractZombie {
    public abstract void display();
}

class SharedZombie {

    private String type;
    private int attackPower;
    private String texture;

    public SharedZombie(String type, int attackPower, String texture) {
        this.type = type;
        this.attackPower = attackPower;
        this.texture = texture;
    }

    public String getType() {
        return type;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getTexture() {
        return texture;
    }

}

class Zombie extends AbstractZombie{
    private int x;
    private int y;
    private int health;

    private SharedZombie sharedZombie;

    public Zombie(String type, int attackPower, String texture,int x, int y, int health) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.sharedZombie = ZombiePool.getZombie(type, attackPower, texture);
    }


    @Override
    public void display() {
        System.out.println("Zombie Type: " + this.sharedZombie.getType());
        System.out.println("Attack Power: " + this.sharedZombie.getAttackPower());
        System.out.println("Texture: " + this.sharedZombie.getTexture());
        System.out.println("Position: (" + this.x + ", " + this.y + ")");
        System.out.println("Health: " + this.health);
        System.out.println("-----------------------------");
        System.out.println(this.sharedZombie);
    }
}

class ZombiePool {
//    private static Map<String, Zombie> zombieMap = new HashMap<>();
//
//    public static Zombie getZombie(String type, int attackPower, String texture) {
//        String key = type + "-" + attackPower + "-" + texture;
//        if (!zombieMap.containsKey(key)) {
//            SharedZombie sharedZombie =new SharedZombie(type, attackPower, texture);
//            zombieMap.put(key, sharedZombie);
//            return sharedZombie;
//        }
//        return zombieMap.get(key);
//    }

    private static final ArrayList<SharedZombie> zombies = new ArrayList<>();

    public static SharedZombie getZombie(String type, int attackPower, String texture) {

            SharedZombie sz = null;

        for (SharedZombie szItem : zombies) {
            if (szItem.getType().equals(type) && szItem.getAttackPower() == attackPower && szItem.getTexture().equals(texture)) {
                sz = szItem;
                break;
            }
        }
        if (sz == null) {
            sz = new SharedZombie(type, attackPower, texture);
            zombies.add(sz);
        }
        return sz;
    }

}


public class Test {

    public static void main(String[] args) {
        Zombie z1 = new Zombie("IceZombie",10,"blue",250,250,100);
        Zombie z2 = new Zombie("FireZombie",25,"blue",100,200,50);
        Zombie z3 = new Zombie("IceZombie",10,"blue",500,200,90);
        Zombie z4 = new Zombie("IceZombie",10,"blue",750,200,50);

        z1.display();
        z2.display();
        z3.display();
        z4.display();
    }
}
