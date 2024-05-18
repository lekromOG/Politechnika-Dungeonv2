/*
* Class Dungeon:
* Description:
* - Dungeon class is responsible for handling data for fights and whole "adventure"
* - It is responsible for choosing what monsters will be in another "room"
* - for deciding what loot
* */
public class Dungeon {
    private int currentLevel = 0;

    /* Setters */
    public void SetLevel(int level) {
        this.currentLevel = level;
    }

    /* Getters */
    public int GetLevel(){
        return this.currentLevel;
    }

    private void IncrementLevel() {
        this.currentLevel++;
    }

    /* called at the end of the fight (end of the room) */
    private void AdvanceLevel() {

    }

}
