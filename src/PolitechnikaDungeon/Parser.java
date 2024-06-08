package PolitechnikaDungeon;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.nio.file.Paths;

public class Parser {

    /*
    * PolitechnikaDungeon.Parser takes input
    *
    * */
    private final Scanner scanner;
    private static final String defaultMsg = ">>";
    private static Context currentContext = Context.MENU;

    public static final String NO_MSG = "NOMSG";

    /* Z mapa chodzi o to, bymozna bylo miec wszystkie mozliwe
    * opcje podajac kontekst. Wtedy tylko sprawdzamy czy user wprowadzil
    * poprawny input (czyli czy input usera jest w array)
    *  */
    private static final Map<Context, String[]> inputContextMap = new HashMap<>();
//        String[] menuArray = new String[3];
//        menuArray[0] = "new";
//        menuArray[1] = "load";
//        menuArray[2] = "quit";
//        put(PolitechnikaDungeon.Context.MENU, menuArray);


    private static final Map<String, Action> stringActionMap = new HashMap<>();
//        String n = "new";
//        put(n, PolitechnikaDungeon.Action.NEW_GAME);
    public Parser() {
        this.scanner = new Scanner(System.in);

        String[] menuArray = new String[]{"new", "load", "quit"};
        inputContextMap.put(Context.MENU, menuArray);
        stringActionMap.put(menuArray[0], Action.NEW_GAME);
        stringActionMap.put(menuArray[1], Action.LOAD_GAME);
        stringActionMap.put(menuArray[2], Action.QUIT);

        String[] fightArray = new String[]{"Attack", "Defend", "Use item", "Flee", "Quit"};
        inputContextMap.put(Context.FIGHT, fightArray);
        stringActionMap.put(fightArray[0], Action.ATTACK);
        stringActionMap.put(fightArray[1], Action.DEFEND);
        stringActionMap.put(fightArray[2], Action.USE_ITEM);
        stringActionMap.put(fightArray[3], Action.FLEE);
        stringActionMap.put(fightArray[4], Action.QUIT);
    }

    /* Prompt user for action
     * Return raw string that user have input.
     * Check for empty string
     *
     * */
    public String Prompt(String msg) {
        String input;
        do {
            if (!msg.equals(NO_MSG)) {
                System.out.print(msg);
            }
            input = this.scanner.nextLine();
        } while (input.isEmpty());
        return input;
    }

    public Action ReturnPlayerActionFromInput(final String msg) {
        Action actionToReturn = Action.UNDEFINED;
        String input = Prompt(msg);

        for (String actionString : inputContextMap.get(currentContext)) {
            if (input.toLowerCase().charAt(0) == actionString.toLowerCase().charAt(0) ||
                    input.split("\\s+")[0].equalsIgnoreCase(actionString.split("\\s+")[0])
                ) {
                System.out.println("Got " + actionString);
                actionToReturn = stringActionMap.get(actionString);
            }
        }

        if (currentContext == Context.NO_CONTEXT) {
            actionToReturn = Action.NOT_SPECIFIC;
        }
        return actionToReturn;
    }

    public String readFileAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public Context GetCurrentContext() {
        return currentContext;
    }

    public void SetCurrentContext(final Context context) {
        currentContext = context;
    }
}
