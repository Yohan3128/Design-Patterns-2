package com.hnys.model;

class Zombie {
    private String type;
    private int attackPower;
    private String texture;
    private int x;
    private int y;
    private int health;

    public Zombie(String type, int attackPower, String texture, int x, int y, int health) {
        this.type = type;
        this.attackPower = attackPower;
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.health = health;
    }

    public void display() {
        System.out.println("Zombie Type: " + this.type);
        System.out.println("Attack Power: " + this.attackPower);
        System.out.println("Texture: " + this.texture);
        System.out.println("Position: X = " + this.x + ", Y = " + this.y);
        System.out.println("Health: " + this.health);
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
