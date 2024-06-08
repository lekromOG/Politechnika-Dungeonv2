package PolitechnikaDungeon;

import Monsters.Monster;

import java.util.Timer;

public class Player {
//    private Timer timer;
//    private int remainingTime;
    private final int BASE_HEALTH = 250;
    private final int BASE_DEFENSE = 50;
    private final int BASE_MANA = 100;
    private Inventory playerInventory;
    private String name;
    private float stamina = 1;
    private int health;
    private int defense;
    private int mana;

    public Player(final String name) {

        this.health  = BASE_HEALTH;
        this.defense = BASE_DEFENSE;
        this.mana    = BASE_MANA;
        this.name    = name;
    }

    public void Attack(Monster monster, Item item) {
        int monsterHealth = monster.getHealth();
        int damage = getDamage(item);
        if (getStamina() <= 0) {
            System.out.println("You need to rest! ");
        } else {
            monster.setHealth( monsterHealth - damage );
        }
        if (monster.getHealth() <= 0) {
            System.out.println("Monster" + monster.getName() + " is dead. Go to the next room...");
            // delete monster ? <- No, there will be new room

        } else {
            monster.TakeDamage(damage);
            System.out.println("Monster " + monster.getName() + " has " + monster.getHealth() + " HP.");
        }
        // Zrobimy tak, że tutaj monster ma odejmowany health
    }

    public void Defend() {
        this.defense += 8;
    }

    public int getDamage(Item item) {
        return (int)(item.getDamage() * getStamina());
    }

    public void MakeTurn() {}

    public String GetName() {
        return this.name;
    }

    public String SetName(final String _name) {
        this.name = _name;
        return _name;
    }

    public float getStamina() {
        return stamina;
    }

    public void setStamina(float stamina) {
        this.stamina = stamina;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Inventory getPlayerInventory() {return playerInventory;}

    public void setPlayerInventory(Inventory playerInventory) {this.playerInventory = playerInventory;}

    public Item getPlayerCurrentItem() {return getPlayerInventory().getItems().getFirst();}
}


