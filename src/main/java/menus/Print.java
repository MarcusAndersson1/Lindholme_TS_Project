package menus;

public class Print {

    public static final String EOL = System.lineSeparator();
    public static final String ERROR_INPUT = (" * Illegal value * ") + EOL;
    public static final String TYPE_ID = ("Type ID");
    public static final String THE_LIST_IS_EMPTY = ("The list is currently empty");


    //login related
    public static final String LOGIN_MENU_USERID = ("Login Menu ") + EOL
            + ("User ID:") + EOL;
    public static final String LOGIN_MENU_PASSWORD = ("Password: ") + EOL;
    public static final String ACCESS_GRANTED = ("* ACCESS GRANTED *") + EOL;
    public static final String WRONG_PASSWORD = ("Wrong Password") + EOL + ("Press \"Enter\" to go back") + EOL;


    //controller related
    public static final String CONTROLLER_MENU = EOL + (" Menu ") + EOL
            + ("[1] Project") + EOL
            + ("[2] User") + EOL
            + ("[3] Team") + EOL
            + ("[4] Log Out") + EOL;

    //project related
    public static final String PROJECT_MENU = EOL +  (" objects.Project Menu") + EOL
            + ("[1] New Project") + EOL
            + ("[2] Open Project") + EOL
            + ("[3] Assign to Team")
            + ("[4] Save Project") + EOL
            + ("[5] Delete Project") + EOL
            + ("[6] Load Project From File") + EOL
            + ("[7] Save to Excel") + EOL
            + ("[8] Back") + EOL;

    public static final String ENTER_PROJECT_NAME = (" Enter Project Name: ");

  /*  public static final String SCRUM_MASTER_MENU = EOL + (" Scrum Master Menu: ") + EOL
            + ("[1] View Team ") + EOL
            + ("[2] View Schedule") + EOL
            + ("[3] View Project") + EOL
            + ("[4] Team Chat") + EOL
            + ("[5] Back") + EOL;
*/

    /*  public static final String DEVELOPER_MENU = EOL + (" Developer Menu: ") + EOL
              + ("[1] View Team ") + EOL
              + ("[2] View Schedule") + EOL
              + ("[3] Work on Project") + EOL
              + ("[4] Team Chat") + EOL
              + ("[5] Back") + EOL;
  */
    //user related
    public static final String CANNOT_DELETE_LOGGED_IN_USER = ("Error: Cannot delete, user is currently logged in");
    public static final String USER_DOES_NOT_EXIST = ("User does not exist") + EOL;
    public static final String ENTER_PASSWORD = ("Enter Password") + EOL;
    public static final String VALID_PASSWORD = ("Valid Password") + EOL;
    public static final String INVALID_PASSWORD = ("Invalid Password: \n" +
            "Password must contain at least one lower case letter, one upper case letter, one digit, " +
            "and contain at least 8 characters and at most 20 characters. \n" +
            "No white spaces allowed. \n") + EOL;

            
    public static final String USER_MENU = EOL +  (" User Menu") + EOL
            + ("[1] New User") + EOL
            + ("[2] Open User") + EOL
            + ("[3] Save User") + EOL
            + ("[4] Delete User") + EOL
            + ("[5] Back") + EOL;

    /*  public static final String PROJECT_LEADER_MENU = EOL +  (" Poject Leader Menu") + EOL
              + ("[1] Create Team") + EOL
              + ("[2] Open Team") + EOL
              + ("[3] Save Team") + EOL
              + ("[4] Delete Team") + EOL
              + ("[5] Add Team Member") + EOL
              + ("[6] Delete Team Member") + EOL
              + ("[7] Assign Role to Team Member") + EOL
              + ("[8] Back") + EOL;
  */
    public static final String ENTER_USER_NAME = ("Enter User Name: ");
    public static final String ENTER_ROLE = ("Enter Role: ");
    //team related
    public static final String TEAM_MENU = EOL + (" Team Menu") + EOL
            + ("[1] New Team") + EOL
            + ("[2] Open Team") + EOL
            + ("[3] Save Team") + EOL
            + ("[4] Delete Team") + EOL
            + ("[5] load Team") + EOL
            + ("[6] Back") + EOL;

    public static final String SCRUM_BOARD_MENU = EOL +  (" Scrum Board Menu") + EOL
            + ("[1] Plan Sprint") + EOL
            + ("[2] Move User Stories") + EOL
            + ("[3] End Sprint") + EOL
            + ("[4] Back") + EOL;
    public static final String PROJECT_PLANNING_MENU = EOL +  (" Plan Your Project Bro!") + EOL
            + ("[1] Create User Story") + EOL
            + ("[2] View Backlog") + EOL
            + ("[3] Create Risk") + EOL
            + ("[4] View Risks") + EOL
            + ("[5] Back") + EOL;

    public static final String ENTER_TEAM_NAME = ("Enter Team Name: ");
    public static final String EDIT_TEAM = EOL +  (" Edit your team ") + EOL
            + ("[1] Add team member") + EOL
            + ("[2] Back") + EOL;
    public static final String ADD_MEMBER = EOL +  (" Edit your team ") + EOL
            + ("[1] Add Member") + EOL
            + ("[0] Back") + EOL;
    public static void print(String stringToPrint) {
        System.out.print(stringToPrint);
    }
}
