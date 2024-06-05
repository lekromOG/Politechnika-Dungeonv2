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
import java.util.Random;

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
        return new EncounterRoom(m);
    }

    private void SetCurrentDepth(final int d) {
        currentDepth = d;
    }

    private Monster GenerateMonsterFromDepth() {

        // Parse json
        // For now return random monster

        BasicMonster simpleMonsterObject = new BasicMonster();
        Random rand = new Random();

        System.out.println(monstersJSONObject);
        JSONArray monsters = monstersJSONObject.getJSONArray("monsters");

        final int monstersNum = monsters.length();
        final int randomMonsterNum = rand.nextInt(monstersNum);

        JSONObject simpleMonsterJSONObj = (JSONObject) monsters.get(randomMonsterNum);
        final String sMonsterName = simpleMonsterJSONObj.getString("name");
        final String sMonsterDesc = simpleMonsterJSONObj.getString("description");
        final int    sMonsterHlth = simpleMonsterJSONObj.getInt("health");
        final int    sMonsterAttc = simpleMonsterJSONObj.getInt("attackPower");
        final int    sMonsterDefs = simpleMonsterJSONObj.getInt("defense");

        simpleMonsterObject.setName(sMonsterName);
        simpleMonsterObject.setDescription(sMonsterDesc);
        simpleMonsterObject.setHealth(sMonsterHlth);
        simpleMonsterObject.setAttack(sMonsterAttc);
        simpleMonsterObject.setDefense(sMonsterDefs);

        return simpleMonsterObject;
    }

    private Room ChooseNextRoom() {

        // Create next room

        return null;
    }

    public void PlayCurrentLevel() {

         currentLevel.Interact();

         if (currentLevel.getIsRoomBeaten()) {
            currentLevel = ChooseNextRoom();
         }
    }
}
