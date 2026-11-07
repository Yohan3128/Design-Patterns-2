package com.hnys.model;

interface prototype {
    public prototype clone();
}

class Zombie implements prototype {
    @Override
    public prototype clone() {
        return new Zombie(this.type, this.attackPower, this.health);
    }

    private String type;
    private int attackPower;
    private int health;

    public Zombie(String type, int attackPower, int health) {
        this.type = type;
        this.attackPower = attackPower;
        this.health = health;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void display() {
        System.out.println("Zombie Type: " + type);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("Health: " + health);
    }
}

public class PrototypeTest {
    public static void main(String[] args) {
        Zombie originalZombie = new Zombie("Walker", 10, 100);
        System.out.println("Original Zombie:");
        originalZombie.display();

        Zombie clonedZombie = (Zombie) originalZombie.clone();
        clonedZombie.setType("Runner"); // Modifying the cloned zombie's type
        clonedZombie.setAttackPower(15); // Modifying the cloned zombie's attack power
        System.out.println("\nCloned Zombie:");
        clonedZombie.display();
    }
}
