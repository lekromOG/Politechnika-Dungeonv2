/*
* Class Dungeon:
* Description:
* - Dungeon class is responsible for handling data for fights and whole "adventure"
* - It is responsible for choosing what monsters will be in another "room"
* - for deciding what loot
* */


import Rooms.Room;

import java.util.List;

public class Dungeon {
    private Room currentLevel;
    private int mobsPerLevel = 3;
    final private static int INITIAL_CHANCE_OF_LOOT = 100;
    final private static int MAX_LEVELS = 15;

    private List<Room> roomLevels;

    public Dungeon() {




    }

    /* Setters */
    public void SetLevel(int level) {
        this.currentLevel = level;
    }

    /* Getters */
    public int GetLevel(){
        return this.currentLevel;
    }

    private void IncrementLevel() {
    }
}
