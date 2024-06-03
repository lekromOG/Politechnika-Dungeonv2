import java.util.Scanner;

public class Engine {
    private static Player player;
    private static GameState state;
    private static Parser parser;
//  private static Room currentRoom;

    public Engine() {
        Engine.state = GameState.RUNNING;
        parser = new Parser();
    }

    public int Run() {

        // Setup New Game (what to setup)?
        // Maybe multiple classes of the player?
        // Print menu

        // prompt



        System.out.println("Welcome to Politechnika Dungeon");
        System.out.println("What is Thine name?");

        final String name = parser.Prompt("(Enter your name): ");
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

//        switch (Engine.state) {
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

}
