package com.hnys.model;

interface IceCream {
    public String getDescription();
    public double getPrice();
}

class VanillaIceCream implements IceCream {
    @Override
    public String getDescription() {
        return "Vanilla Ice Cream";
    }

    @Override
    public double getPrice() {
        return 100;
    }
}

class ChocolateIceCream implements IceCream {
    @Override
    public String getDescription() {
        return "Chocolate Ice Cream";
    }

    @Override
    public double getPrice() {
        return 150;
    }
}

abstract class IceCreamDecorator implements IceCream {
    protected IceCream iceCream;

    public IceCreamDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }
}

class ChocolateTopping extends IceCreamDecorator {

    public ChocolateTopping(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + " with Chocolate Topping";
    }

    @Override
    public double getPrice() {
        return iceCream.getPrice() + 50;
    }
}

class NutsTopping extends IceCreamDecorator {

    public NutsTopping(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + " with Nuts Topping";
    }

    @Override
    public double getPrice() {
        return iceCream.getPrice() + 30;
    }
}

public class Test {
    public static void main(String[] args) {
        IceCream iceCream = new VanillaIceCream();
        iceCream = new ChocolateTopping(iceCream);
        iceCream = new NutsTopping(iceCream);
        System.out.println(iceCream.getDescription() + " - LKR " + iceCream.getPrice());
    }
}


