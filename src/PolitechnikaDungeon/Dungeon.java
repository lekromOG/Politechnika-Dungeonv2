package PolitechnikaDungeon;/*
* Class PolitechnikaDungeon.Dungeon:
* Description:
* - PolitechnikaDungeon.Dungeon class is responsible for handling data for fights and whole "adventure"
* - It is responsible for choosing what monsters will be in another "room"
* - for deciding what loot
* */


import Rooms.EncounterRoom;
import Rooms.Room;

import java.util.List;

public class Dungeon {
    private static Room currentLevel;
    private int mobsPerLevel = 3;
    final private static int INITIAL_CHANCE_OF_LOOT = 100;
    final private static int MAX_LEVELS = 15;

    private static int currentDepth;

    private List<Room> roomLevels;

    public Dungeon() {

        // Make first level
        currentLevel = new EncounterRoom(currentDepth);


    }

    /* Setters */
    public void SetLevel(int level) {
    }

    /* Getters */
    public Room GetLevel(){
        return currentLevel;
    }

    private void IncrementLevel() {
    }
}