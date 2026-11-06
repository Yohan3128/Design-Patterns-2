package com.hnys.model;

class Gun implements Cloneable {
    int bullets = 10;

    public void fire() {
        System.out.println("Firing a bullet");
        bullets--;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Test {
    public static void main(String[] args) {
        Gun gun = new Gun();
        gun.fire();

        try {
            Gun clonedGun = (Gun) gun.clone();
            clonedGun.fire();
            System.out.println("Bullets left in cloned gun: " + clonedGun.bullets);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Bullets left in original gun: " + gun.bullets);
    }
}
