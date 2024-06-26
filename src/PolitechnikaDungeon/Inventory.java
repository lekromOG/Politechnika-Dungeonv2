package PolitechnikaDungeon;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private int capacity = 10;
    private int inventoryWeight;
    private int currentItems = 1;

    private boolean isFull = false;

    public Inventory(final ArrayList<Item> arrayOfItems) {
        this.items = new ArrayList<Item>(arrayOfItems);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList items) {
        this.items = items;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getInventoryWeight() {
        return this.inventoryWeight;
    }

    public void setInventoryWeight(int inventoryWeight) { this.inventoryWeight = inventoryWeight;}

    public int getCurrentItems() {
        return this.currentItems;
    }

    public void setCurrentItems(int currentItems) {
        this.currentItems = currentItems;
    }

    public void showInventory() {
        if (currentItems != 0) {
            System.out.println("INVENTORY: ");
            for (int i = 0; i < currentItems; i++) {
                System.out.print(items.get(i).getName() + " ");
            }
        } else {
            System.out.println("Your inventory is empty!");
        }
    }

    public void ChooseItem(Item item) {items.set(0, item);}

    public void dropItem(Item chosen) {
        int i = 0;
        if (currentItems != 0) {
            while (i < currentItems) {
                if (items.get(i) == chosen) {
                    items.remove(i);
                    break;
                }
            }
            System.out.println("Did not find chosen item!");
        } else {
            System.out.println("Your inventory is empty!");
        }
    }

    public void SetIsFull() {
        this.isFull = true;
    }

    public void SetNotFull() {
        this.isFull = false;
    }

    public boolean CheckIsFull() {
        return items.size() == capacity;
    }
}
