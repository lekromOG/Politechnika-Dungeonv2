package PolitechnikaDungeon;

public abstract class Item {

    private String name;
    private int damage;
    private int strength;

    public Item(String name, int damage, int strength) {
        this.name = name;
        this.damage = damage;
        this.strength = strength;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean isUsable() {return true;}
}
