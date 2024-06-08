package Rooms;
import Monsters.BasicMonster;
import Monsters.Monster;
import Monsters.Monsters;
import PolitechnikaDungeon.Item;
import PolitechnikaDungeon.Player;
import PolitechnikaDungeon.Parser;
import PolitechnikaDungeon.InteractionResult;
import java.util.List;


public abstract class Room {

    private List<Item> lootList = null;
    public abstract InteractionResult Interact(Player player, Parser parser);
    public abstract boolean getIsRoomBeaten();
    public BasicMonster createFromJSON () {
        return null;
    }
}
