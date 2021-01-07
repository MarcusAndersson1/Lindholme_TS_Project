package Utilities;

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
    public static final String INVALID_PASSWORD = ("Passwords must be between 8-20 characters and contain at least \na uppercase character, a lowercase character and a digit") + EOL;
    //team related
    public static final String SELECT_A_TEAM = ("Select a team");


    public static void print(String stringToPrint) {
        System.out.print(stringToPrint);
    }
}
