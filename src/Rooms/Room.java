package Rooms;
import Monsters.Monster;
import PolitechnikaDungeon.Item;
import PolitechnikaDungeon.Player;
import java.util.List;


public abstract class Room {

    private List<Item> lootList = null;
    public abstract int Interact(Player player);

    public abstract boolean getIsRoomBeaten();

}
