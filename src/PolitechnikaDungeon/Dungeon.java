package PolitechnikaDungeon;/*
* Class PolitechnikaDungeon.Dungeon:
* Description:
* - PolitechnikaDungeon.Dungeon class is responsible for handling data for fights and whole "adventure"
* - It is responsible for choosing what monsters will be in another "room"
* - for deciding what loot
* */

import Rooms.EncounterRoom;
import Rooms.Room;
import org.json.JSONArray;
import org.json.JSONObject;
import Monsters.*;

import java.util.List;
import java.util.random.RandomGenerator;

public class Dungeon {
    private static Room currentLevel;
    private int mobsPerLevel = 3;
    final private static int INITIAL_CHANCE_OF_LOOT = 100;
    final private static int MAX_LEVELS = 15;

    private static int currentDepth;

    private List<Room> roomLevels;

    private static JSONObject monstersJSONObject;

    public Dungeon(final JSONObject jo) {
        // Make first level

        SetCurrentDepth(0);
        monstersJSONObject = jo;
        currentLevel = MakeEncounterRoom();

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

    private Room MakeEncounterRoom() {
        // Make monster

        Monster m = GenerateMonsterFromDepth();
        Room encounteRoom = new EncounterRoom(m);


        return null;
    }

    private void SetCurrentDepth(final int d) {
        currentDepth = d;
    }

    private Monster GenerateMonsterFromDepth() {

        // Parse json
        // For now return random monster

        System.out.println(monstersJSONObject);
        JSONArray monsters = monstersJSONObject.getJSONArray("monsters");

        for (int i = 0; i < monsters.length(); i++) {
            JSONObject monster = monsters.getJSONObject(i);
            System.out.println(monster.getInt("id"));

        }

        return null;
    }

}
