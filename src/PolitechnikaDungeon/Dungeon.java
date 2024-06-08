package PolitechnikaDungeon;/*
* Class PolitechnikaDungeon.Dungeon:
* Description:
* - PolitechnikaDungeon.Dungeon class is responsible for handling data for fights and whole "adventure"
* - It is responsible for choosing what monsters will be in another "room"
* - for deciding what loot
* */

import Rooms.*;
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
    final private static int ROOM_TYPES_MAX = 7;
    private RoomType[] rooms = new RoomType[ROOM_TYPES_MAX];
    private static Context gameContext;
    private static Player player;
    private static Parser parser;
    private static boolean wasFinalMonsterBeaten = false;
    private static int currentDepth;
    private List<Room> roomLevels;
    private static JSONObject monstersJSONObject;

    public Dungeon(final JSONObject jo, Player _player, Parser _parser) {
        // Make first level
        SetCurrentDepth(0);
        monstersJSONObject = jo;
        currentLevel = MakeEncounterRoom();
        player = _player;
        parser = _parser;

        rooms[0] = RoomType.SHOP;
        rooms[1] = RoomType.TOILET;
        rooms[2] = RoomType.ENCOUNTER;
        rooms[3] = RoomType.AUDITORIUM;
        rooms[4] = RoomType.CISCO_LABS;
        rooms[5] = RoomType.BOSS_ROOM;
        rooms[6] = RoomType.END;
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

        System.out.println("You descend further into the dungeones...");
        System.out.println("Smrut kokosinskiego jest coraz mocniejszy....");
        System.out.println("You have encountered a " + m.getName() + "!");
        System.out.println(m.getCreatedTalk());

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
        final String sMonsterTalk = simpleMonsterJSONObj.getString("monsterCreatedTalk");
        final String sMonsterDeath = simpleMonsterJSONObj.getString("deathMessage");
        final JSONArray sMonsterAbilityName = simpleMonsterJSONObj.getJSONArray("abilities");
        final JSONArray sMonsterLoot = simpleMonsterJSONObj.getJSONArray("loot");

        simpleMonsterObject.setName(sMonsterName);
        simpleMonsterObject.setDescription(sMonsterDesc);
        simpleMonsterObject.setHealth(sMonsterHlth);
        simpleMonsterObject.setAttack(sMonsterAttc);
        simpleMonsterObject.setDefense(sMonsterDefs);
        simpleMonsterObject.setCreatedTalk(sMonsterTalk);
        simpleMonsterObject.setDeathMessage(sMonsterDeath);
        simpleMonsterObject.setAbilities(sMonsterAbilityName);
        simpleMonsterObject.setLoot(sMonsterLoot);

        return simpleMonsterObject;
    }

    public Room ChooseNextRoom() {

        if (wasFinalMonsterBeaten) {
            return new EndRoom();
        }

        currentLevel = MakeEncounterRoom();
//        Random rand = new Random();
//        int randomNum = rand.nextInt(ROOM_TYPES_MAX);
//        switch (rooms[randomNum]) {
//            case SHOP -> currentLevel = new Shop();
//            case TOILET -> currentLevel = new Toilet();
//            case ENCOUNTER -> currentLevel = MakeEncounterRoom();
//            case AUDITORIUM -> currentLevel = new Auditorium();
//            case CISCO_LABS -> currentLevel = new CiscoLabs();
//            case BOSS_ROOM -> currentLevel = new BossRoom();
//        }
        return currentLevel;
    }

    public void SetCurrentLevel(Room r) {
        currentLevel = r;
    }

    public int PlayCurrentLevel() {
        InteractionResult interactionResult = new InteractionResult();

        int state = 0;

        while (!currentLevel.getIsRoomBeaten()) {
                interactionResult = currentLevel.Interact(player, parser);

                if (interactionResult != null) {

                    if (interactionResult.playerWantsToFlee) {
                        System.out.println("You flee from the fugging roomes :DD XDD");
                        state = -2;
                        return state;
                    }

                    if (interactionResult.playerWantstoExit) {
                        state = -1;
                        return state;
                    }
                }
        }


        if (currentLevel.getIsRoomBeaten() && currentLevel instanceof EncounterRoom) {
            // loot

            ((EncounterRoom) currentLevel).GetMonsterEncounter().PrintDeathMessage();
            ((EncounterRoom) currentLevel).GetMonsterEncounter().PrintItemsDropped();
        }

        /* TODO:
         * 1. Parse interactionResult
         * 2. If interactionResult.playerWantsToExit, return state = -1 -> to wyjdzie z gry
         * 3.
         *
         */

        return state;
    }
}
