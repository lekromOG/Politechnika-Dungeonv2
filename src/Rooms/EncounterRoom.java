package Rooms;

import Monsters.Monster;
import PolitechnikaDungeon.Action;
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
        InteractionResult result = new InteractionResult();
        if (isPlayerTurn) {
            Action action = parser.ReturnPlayerActionFromInput("(Choose your action: )");
            switch (action) {
                case ATTACK -> player.Attack(monsterEncounter, player.currentitem);
                case DEFEND -> player.defend;
                case FLEE -> player.runAway;
                case USE_ITEM -> player.setcurrentItem;
                case QUIT -> result.playerWantstoExit = true;
                default: {
                    System.out.println("Unrecognizable action!");
                    result.actionIsNothing = true;
                    return result;
                }
            }
        } else {
            // this has to return the outcome (what damage the monster dealt)
            final int damageByMonster = monsterEncounter.Attack(player);
            player.setHealth( player.getHealth() - damageByMonster );
            if (player.getHealth() <= 0) {
                System.out.println("GAME OVER! PLAYER DIED.");
                result.playerWantstoExit = true;
            } else {
                System.out.println(STR."Monster took \{damageByMonster} HP. \{player.getHealth()} remaining!");
            }
        }
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
         *    Monster nie żyje, to już jest sprawdzane
         *
         */

        // TODO: Print what player has done and what monster has done.
        //       Print result of the turn

        result.PrintResult(Context);

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
