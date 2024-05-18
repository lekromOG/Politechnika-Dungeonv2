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
    *  Maybe context dependent? Menu can ask for load new or quit
    *  Game can ask for Attack, Defend, Save etc.
    *  How to represent the possible options?
    *
    * */
    private PlayerAction Prompt(String msg) {
        PlayerAction actionToReturn = PlayerAction.UNDEFINED;

        // Make it look like "msg |"
        if (msg.isEmpty())
        {
            System.out.print(defaultMsg);
        } else {
            System.out.print(msg);
        }

        return actionToReturn;
    }

    public PlayerAction ReturnPlayerActionFromInput(final Context context, final String input) {

        switch (context)
        {
            case MENU:
                return Prompt(input);
            case ENCOUNTER:
                return Prompt(input);
        }

//        Prompt()

        PlayerAction actionToReturn = PlayerAction.UNDEFINED;
        return actionToReturn;
    }

}
