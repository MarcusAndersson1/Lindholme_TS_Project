package menus;

public class Print {

    public static final String EOL = System.lineSeparator();
    public static final String ERROR_INPUT = (" * Illegal value * ") + EOL;
    public static final String TYPE_ID = ("Type ID");
    public static final String THE_LIST_IS_EMPTY = ("The list is currently empty");


    //controller related
    public static final String CONTROLLER_MENU = EOL + (" Controller Menu") + EOL
            + ("[1] Project") + EOL
            + ("[2] User") + EOL
            + ("[3] Team") + EOL;


    //project related
    public static final String PROJECT_MENU = EOL +  (" Project Menu") + EOL
            + ("[1] New Project") + EOL
            + ("[2] Open Project") + EOL
            + ("[3] Save Project") + EOL
            + ("[4] Delete Project") + EOL
            + ("[5] Back") + EOL;

    public static final String ENTER_PROJECT_NAME = (" Enter Project Name: ");

    //user related
    public static final String USER_MENU = EOL +  (" User Menu") + EOL
            + ("[1] New User") + EOL
            + ("[2] Open User") + EOL
            + ("[3] Save User") + EOL
            + ("[4] Delete User") + EOL
            + ("[5] Back") + EOL;

    public static final String ENTER_USER_NAME = ("Enter User Name: ");

    //team related
    public static final String TEAM_MENU = EOL + (" Team Menu") + EOL
            + ("[1] New Team") + EOL
            + ("[2] Open Team") + EOL
            + ("[3] Save Team") + EOL
            + ("[4] Delete Team") + EOL
            + ("[5] Back") + EOL;

    public static final String ENTER_TEAM_NAME = ("Enter Team Name: ");

    public static void print(String stringToPrint) {
        System.out.print(stringToPrint);
    }
}
