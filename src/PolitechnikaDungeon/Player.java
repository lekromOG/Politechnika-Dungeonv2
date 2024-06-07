package PolitechnikaDungeon;

import java.util.Timer;

public class Player {
    private Timer timer;
    private int remainingTime;
    private String name;

    private int health;
    private int defense;
    private int mana;

    public Player() {
        this.timer = new Timer();
        this.remainingTime = 0;
    }

    public void Attack(Monster monster) {
        // Zrobimy tak, że tutaj monster ma odejmowany health
    }

    public void TakeDamage(final int damage) {

    }

    public void MakeTurn() {
    }

    public String GetName() {
        return this.name;
    }

    public String SetName(final String _name) {
        this.name = _name;
        return _name;
    }
}
