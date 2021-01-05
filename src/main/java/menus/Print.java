package menus;

public class Print {

    public static final String EOL = System.lineSeparator();
    public static final String ERROR_INPUT = (" * Illegal value * ") + EOL;
    public static final String TYPE_ID = ("Type ID");
    public static final String THE_LIST_IS_EMPTY = ("The list is currently empty");


    //login related
    public static final String ACCESS_GRANTED = ("* ACCESS GRANTED *") + EOL;
    public static final String WRONG_PASSWORD = ("Wrong Password") + EOL;

    //message related
    public static final String SELECT_A_MESSAGE = ("Select a message");

    //user related
    public static final String CANNOT_DELETE_LOGGED_IN_USER = ("Cannot delete, user is currently logged in");
    public static final String A_USERTYPE_MUST_BE_CHOSEN = ("A user type must be chosen");
    public static final String SELECT_A_USER = ("Select a user");
    public static final String USER_DOES_NOT_EXIST = ("User does not exist") + EOL;
    public static final String ENTER_PASSWORD = ("Enter Password") + EOL;
    public static final String VALID_PASSWORD = ("Valid Password") + EOL;
    public static final String INVALID_PASSWORD = ("Invalid Password: \n" +
            "Password must contain at least one lower case letter, one upper case letter, one digit, " +
            "and contain at least 8 characters and at most 20 characters. \n" +
            "No white spaces allowed. \n") + EOL;


    public static final String ENTER_USER_NAME = ("Enter User Name: ");
    public static final String ENTER_ROLE = ("Enter Role: ");
    //team related

    public static final String ENTER_TEAM_NAME = ("Enter Team Name: ");

    public static void print(String stringToPrint) {
        System.out.print(stringToPrint);
    }
}
