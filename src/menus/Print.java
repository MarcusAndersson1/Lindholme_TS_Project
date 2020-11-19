package src.menus;

public class Print {

    public static final String EOL = System.lineSeparator();
    public static final String ERROR_INPUT = (" * Illegal value * ") + EOL;
//controller related
    public static final String CONTROLLER_MENU = ("Controller Menu") + EOL
            + ("[1] Project") + EOL
            + ("[2] User") + EOL;


//project related
    public static final String Project_Menu = ("Project Menu") + EOL
            + ("[1] New Project") + EOL
            + ("[2] Open Project") + EOL
            + ("[3] Save Project") + EOL
            + ("[4] Delete Project") + EOL
            + ("[5] Back") + EOL;

    public static final String ENTER_PROJECT_NAME = ("Enter Project Name: ");

    public static void print(String stringToPrint) {
        System.out.print(stringToPrint);
    }
}
