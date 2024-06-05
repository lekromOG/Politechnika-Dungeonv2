package PolitechnikaDungeon;
import org.json.*;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.newInputStream;

public class Engine {
    private static Player player;
    private static GameState state;
    private static Parser parser;
    private static Dungeon dungeon;
//  private static Rooms.Room currentRoom;

    private static JSONObject monstersJSONObject;

    public Engine() {
        Engine.state = GameState.RUNNING;
        parser = new Parser();
    }

    public int Run() {

        int exitCode = 0;

        // Setup New Game (what to setup)?
        // Maybe multiple classes of the player?
        // Print menu

        // prompt

        player = new Player();

        System.out.println("Welcome to Politechnika PolitechnikaDungeon.Dungeon");
        System.out.println("What is Thine name?");
        final String name = parser.Prompt("(Enter your name): ");
        player.SetName(name);

        try {
            ParseMonsterJSONAndLoadObject();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't load JSON... :(");
            exitCode = -1;
            return exitCode;
        }
        SetupNewDungeon();

//         Main loop

        return 0;
    }

    private static int MainLoop() {
        return 0;
    }

    public static void SetupNewGame() {
    }

    private static boolean LoadGame() {
        return true;
    }

    private static void PrintContextActions() {

        // TODO:

//        switch (PolitechnikaDungeon.Engine.state) {
//
////            case
//        }
        switch(Engine.state){
            case MENU:
                PrintMenuActions();
                break;
            case RUNNING:
                PrintRunningActions();
                break;
            case SAVING:
                PrintSavingActions();
                break;
            case EXITING:
                PrintExitingActions();
                break;
            case RESTART:
                PrintRestartActions();
                break;
        }

    }

    private static void PrintMenuActions() {
        System.out.println("(N)ew Game");
        System.out.println("(L)oad Game");
        System.out.println("(Q)uit Game");
    }

    private static void PrintRunningActions() {
        System.out.println("(A)ttack");
        System.out.println("(D)efend");
        System.out.println("(S)ave");
        System.out.println("(Q)uit");
    }

    private static void PrintSavingActions() {
        System.out.println("Saving...");
    }

   private static void PrintExitingActions() {
        System.out.println("Exiting...");
   }

   private static void PrintRestartActions() {
        System.out.println("Restarting...");
   }

   private static void SetupNewDungeon() {
        dungeon = new Dungeon(monstersJSONObject);

   }

   private static void ParseMonsterJSONAndLoadObject() throws IOException {

        try {
            Path path = Paths.get("src/PolitechnikaDungeon/monsters.json");
            String jsonString = parser.readFileAsString(path.toString());
            monstersJSONObject = new JSONObject(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }
   }
}
