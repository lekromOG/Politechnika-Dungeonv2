package PolitechnikaDungeon;

/* InteractionResult structure.
 * All fields should be public.
 * Interaction result is used to determine the outcome of a turn.
 * In other languages this could be a bit field.
 */
public class InteractionResult {
    public int damageDealtToPlayer;
    public int damageDealtToMonster;
    public boolean isMonsterKilled;
    public boolean isItemTaken;

}
