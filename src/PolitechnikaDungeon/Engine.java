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
import Rooms.*;
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

        System.out.println("Welcome to Politechnika Politechnika Dungeon!");
        System.out.println("What is Thine name?");
//        final String name = parser.Prompt("(Enter your name): ");
        player.SetName("Nigga");

        try {
            ParseMonsterJSONAndLoadObject();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't load JSON... :(");
            exitCode = -1;
            return exitCode;
        }
        SetupNewDungeon();

        parser.SetCurrentContext(Context.FIGHT);
        System.out.println(parser.ReturnPlayerActionFromInput("test: "));

        int loopState = 0;

//         Main loop
        while (state != GameState.RUNNING) {
            // if not room beaten, don't advance

            /*
             * TODO:
             * Handle exiting the game ()
             *
             *
             *
             */

            loopState = dungeon.PlayCurrentLevel();
            if (loopState == -1) {
                state = GameState.EXITING;
            }

            Room newRoom = dungeon.ChooseNextRoom();
            dungeon.SetCurrentLevel(newRoom);
        }
        return state;
    }

    public static void SetupNewGame() {
    }

    private static boolean LoadGame() {
        return true;
    }

    private static void PrintMenuActions() {
        System.out.println("(N)ew Game");
        System.out.println("(L)oad Game");
        System.out.println("(Q)uit Game");
    }

   private static void SetupNewDungeon() {
        dungeon = new Dungeon(monstersJSONObject, player, parser);
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
