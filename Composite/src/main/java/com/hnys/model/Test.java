package com.hnys.model;

import java.util.ArrayList;
import java.util.List;

interface Component {
    public void display();

    public double getSize();
}

class File implements Component {
    private String name;
    private double size;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("File: " + this.name + ", Size: " + this.size + "MB");
    }

    @Override
    public double getSize() {
        return this.size;
    }
}

class Folder implements Component {
    private String name;
    private ArrayList<Component> components;

    public Folder(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    public void removeComponent(Component component) {
        this.components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + this.name + ", Total Size: " + this.getSize() + "MB");
        for (Component component : this.components) {
            component.display();
        }
    }

    @Override
    public double getSize() {
        double totalSize = 0;
        for (Component component : this.components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}

public class Test {
    public static void main(String[] args) {

        Folder folder1 = new Folder("Desktop");

        Folder folder2 = new Folder("Documents");
        folder2.addComponent(new File("Resume.docx", 0.5));
        folder2.addComponent(new File("Project.pdf", 1.2));


        Folder folder3 = new Folder("Images");
        folder3.addComponent(new File("Vacation.jpg", 2.5));
        folder3.addComponent(new File("Family.png", 1.8));

        folder1.addComponent(folder2);
        folder1.addComponent(folder3);

        folder1.display();
    }
}
