package com.hnys.model;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractCar {
    public abstract void Paint();
}

class Car extends AbstractCar {

    private String model;
    private Color color;

    public Car(String model, String color) {
        this.model = model;
        this.color = ColorFactory.getColor(color);
    }

    @Override
    public void Paint() {
        System.out.println("Car Model: " + this.model);
        System.out.println("Car Color: " + this.color.getColor());
        System.out.println("Car Painted Successfully!");
        System.out.println("-----------------------------");
        System.out.println(this.color);
    }
}

class Color {
    private String color;

    public Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class ColorFactory {
    private static final Map<String, Color> colorMap = new HashMap<>();

    public static Color getColor(String color) {
        Color c = colorMap.get(color);
        if (c == null) {
            c = new Color(color);
            colorMap.put(color, c);
        }
        return c;
    }
}

public class FlyweightColorPractical {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Red");
        Car car2 = new Car("Honda", "Blue");
        Car car3 = new Car("Ford", "Red");

        car1.Paint();
        car2.Paint();
        car3.Paint();
    }
}
