package Rooms;

import Monsters.Monster;
import PolitechnikaDungeon.Player;

public class EncounterRoom extends Room {
    private Monster monsterEncounter;

    public EncounterRoom(Monster monsterToPlace) {
//        monsterEncounter = CreateMonsterEncounter();

    }

    /* Play the actual room (interact with player).
     * Return some data stating the outcome of player interaction
     *
     */
    @Override
    public int Interact(Player player) {




        return 0;
    }

    private Monster GenerateMonster(final int depth) {
        return null;
    }

    private Monster CreateMonsterEncounter(final int depth) {

        return null;
    }

    private void PrintIntroduction(int depth) {

    }

    @Override
    public boolean getIsRoomBeaten() {
        return this.monsterEncounter.getHealth() <= 0;
    }
}
