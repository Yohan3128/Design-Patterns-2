package com.hnys.model;

interface Visitor {
    void visit(Lion lion);
    void visit(Elephant elephant);
    void visit(Dog dog);
}

interface Animal{
  public void run();
  public void accept(Visitor visitor);
}

class Lion implements Animal{
    @Override
    public void run(){
        System.out.println("Lion is running");
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Elephant implements Animal{
    @Override
    public void run(){
        System.out.println("Elephant is running");
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Dog implements Animal{
    @Override
    public void run(){
        System.out.println("Dog is running");
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class eatVisitor implements Visitor {
    @Override
    public void visit(Lion lion) {
        System.out.println("Lion is eating meat");
    }
    @Override
    public void visit(Elephant elephant) {
        System.out.println("Elephant is eating grass");
    }
    @Override
    public void visit(Dog dog) {
        System.out.println("Dog is eating bones");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal lion = new Lion();
        Animal elephant = new Elephant();
        Animal dog = new Dog();

        lion.run();
        elephant.run();
        dog.run();

        Visitor eatVisitor = new eatVisitor();
        lion.accept(eatVisitor);
        elephant.accept(eatVisitor);
        dog.accept(eatVisitor);
    }
}
