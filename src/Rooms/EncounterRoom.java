package Rooms;

import Monsters.Monster;
import PolitechnikaDungeon.InteractionResult;
import PolitechnikaDungeon.Player;
import PolitechnikaDungeon.Parser;

public class EncounterRoom extends Room {
    private Monster monsterEncounter;
    private boolean isPlayerTurn = true;

    public EncounterRoom(Monster monsterToPlace) {
//        monsterEncounter = CreateMonsterEncounter();

    }

    /* Play the actual room (interact with player).
     * Return some data stating the outcome of player interaction
     *
     */
    @Override
    public InteractionResult Interact(Player player, final Parser parser) {

        /* TODO:
         * 1. Czy jest tura gracza?
         *    Jezeli jest, to popros go o input (uzyc parser)
         *    a) Chce atakowac:
         *       Player.Attack
         *    b) Chce sie bronic:
         *      Player.Defend
         *    (...)
         *
         *    x) Chce wyjsc z gry:
         *       result.playerWantstoExit = true;
         */

        InteractionResult result = new InteractionResult();

        if (isPlayerTurn) {

        }

        this.TogglePlayerTurn();
        return result;
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

    private void TogglePlayerTurn() {
        this.isPlayerTurn = !this.isPlayerTurn;
    }
}
