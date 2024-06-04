package PolitechnikaDungeon;

public abstract class Item {

    private String name;

    public Item() {
        this.name = "PolitechnikaDungeon.Item";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
