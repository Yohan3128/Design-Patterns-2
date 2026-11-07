package ccom.hnys.model;

import java.util.Stack;

class Player {
    private String name;
    private int health;
    private int score;

    public Player(String name, int health, int score) {
        this.name = name;
        this.health = health;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Score: " + score);
    }


}

final class PlayerMemento {

    private int score;

    public PlayerMemento(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

}

class GameCareTaker {

    private Stack<PlayerMemento> mementoStack = new Stack<>();

    public void saveGame(Player player) {
        PlayerMemento playerMemento = new PlayerMemento(player.getScore());
        mementoStack.push(playerMemento);
        System.out.println("Game saved successfully ");
    }

    public void loadGame(Player player) {
        PlayerMemento playerMemento = mementoStack.pop();
        player.setScore(playerMemento.getScore());
        System.out.println("Game loaded successfully");
    }
}

public class Test {
    public static void main(String[] args) {
        Player player = new Player("Alice", 100, 0);

        GameCareTaker careTaker = new GameCareTaker();
        careTaker.saveGame(player);

        player.setScore(100);
        careTaker.saveGame(player);

        player.setScore(250);
        careTaker.saveGame(player);

        player.setScore(600);
        player.display();

        careTaker.loadGame(player);
        player.display();

        careTaker.loadGame(player);
        player.display();
    }
}
