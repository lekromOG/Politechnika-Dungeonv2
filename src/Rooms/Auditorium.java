package Rooms;

import PolitechnikaDungeon.InteractionResult;
import PolitechnikaDungeon.Parser;
import PolitechnikaDungeon.Player;

public class Auditorium extends Room {
    @Override
    public InteractionResult Interact(Player player, Parser parser) {
        return null;
    }

    @Override
    public boolean getIsRoomBeaten() {
        return false;
    }
}
