package PolitechnikaDungeon;

public abstract class Item {

    private String name;
    private int damage;
    private int strength;

    public Item() {
        this.name = "PolitechnikaDungeon.Item";
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
}
