class PlayerInventory implements Inventory {

    private Item[] items;
    private int capacity = 10;
    private int inventoryWeight;
    private int currentItems = 0;

    public void PlayerInventory() {
        this.items = new Item[capacity];
        this.inventoryWeight = 0;
        this.currentItems = 0;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getInventoryWeight() {
        return inventoryWeight;
    }

    public void setInventoryWeight(int inventoryWeight) {
        this.inventoryWeight = inventoryWeight;
    }

    public int getCurrentItems() {
        return currentItems;
    }

    public void setCurrentItems(int currentItems) {
        this.currentItems = currentItems;
    }

    @Override
    public void showInventory() {
        if (currentItems != 0) {
            System.out.println("INVENTORY: ");
            for (int i = 0; i < currentItems; i++) {
                System.out.print(items[i].getName() + " ");
            }
        } else {
            System.out.println("INVENTORY IS EMPTY");
        }
    }

    @Override
    public void setCharacterItem() {

    }

    @Override
    public void useItem() {

    }

    @Override
    public void dropItem() {

    }
}
