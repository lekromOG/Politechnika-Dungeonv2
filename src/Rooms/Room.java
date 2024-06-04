package Rooms;
import Monsters.Monster;
import PolitechnikaDungeon.Item;
import java.util.List;

public abstract class Room {

    private List<Item> lootList = null;
    public abstract int Interact();


}
