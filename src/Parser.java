import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {

    /*
    * Parser takes input
    *
    * */
    private final Scanner scanner;
    private static final String defaultMsg = ">>";
    private static Context currentContext;

    /* Z mapa chodzi o to, bymozna bylo miec wszystkie mozliwe
    * opcje podajac kontekst. Wtedy tylko sprawdzamy czy user wprowadzil
    * poprawny input (czyli czy input usera jest w array)
    *  */
    private static final Map<Context, String[]> inputContextMap = new HashMap<Context, String[]>()
    {{
        String[] menuArray = new String[10];
        menuArray[0] = "new";
        menuArray[1] = "load";
        menuArray[2] = "quit";
        put(Context.MENU, menuArray);

    }};

    public Parser() {
        this.scanner = new Scanner(System.in);
    }

    /* Prompt user for action
     * Return raw string that user have input.
     * Check for empty string
     *
     * */
    public String Prompt(String msg) {
        String input;
        do {
            if (msg.isEmpty()) {
                System.out.print(defaultMsg);
            } else {
                System.out.print(msg);
            }
            input = this.scanner.nextLine();
        } while (input.isEmpty());
        return input;
    }

    public Action ReturnPlayerActionFromInput(final String msg) {
        Action actionToReturn = Action.UNDEFINED;
        String input = Prompt(msg);

        switch (currentContext)
        {
            case MENU:
                if (input.equals("new")) {
                    actionToReturn = Action.NEW_GAME;
                } else if (input.equals("load")) {
                    actionToReturn = Action.LOAD_GAME;
                } else if (input.equals("quit")) {
                    actionToReturn = Action.QUIT;
                }
                break;
            case RUNNING:
                if (input.equals("attack")) {
                    actionToReturn = Action.ATTACK;
                } else if (input.equals("defend")) {
                    actionToReturn = Action.DEFEND;
                } else if (input.equals("descend")) {
                    actionToReturn = Action.DESCEND;
                } else if (input.equals("use item")) {
                    actionToReturn = Action.USE_ITEM;
                } else if (input.equals("cast spell")) {
                    actionToReturn = Action.CAST_SPELL;
                } else if (input.equals("look")) {
                    actionToReturn = Action.LOOK;
                }
                break;
            case SAVING:
                if (input.equals("save")) {
                    actionToReturn = Action.SAVE_GAME;
                } else if (input.equals("quit")) {
                    actionToReturn = Action.QUIT;
                }
                break;
            case EXITING:
                if (input.equals("yes")) {
                    actionToReturn = Action.YES;
                } else if (input.equals("no")) {
                    actionToReturn = Action.NO;
                }
                break;
            default:
                actionToReturn = Action.UNDEFINED;
                break;
        }

        if (currentContext == Context.NO_CONTEXT) {
            return Action.NOT_SPECIFIC;
        }

        return actionToReturn;
    }

    private boolean ValidateInput(final String) {
        return false;
    }

    public Context GetCurrentContext() {
        return currentContext;
    }

    public void SetCurrentContext(final Context context) {
        currentContext = context;
    }
}
