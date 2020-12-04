package controllers;


import menus.Print;
import objects.User;
import utilities.Input;
import java.time.LocalDateTime;

public class Controller {
    private static User currentUser;


    public static void logIn() {
        Print.print(Print.LOGIN_MENU_USERID);
        checkUserID();


    }

    public static void controllerMenu(){
        int choice;
        Print.print(Print.EOL + "Welcome " + currentUser.getName() + "!");
        Print.print(Print.CONTROLLER_MENU);

        do {
            choice = Input.fetchInputInt("");
            if (choice < 1 || choice > 4) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1 -> runProjectController();
            case 2 -> runUserController();
            case 3 -> runTeamController();
            case 4 -> logOut();

        }
    }

    public static void runProjectController() {
        int choice;
        Print.print(Print.PROJECT_MENU);

        do {
            choice = Input.fetchInputInt("");
            if (choice < 1 || choice > 6) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 6);


        switch (choice) {
            case 1 -> ProjectController.createProject();
            case 2 -> ProjectController.openProject();
            case 3 -> ProjectController.saveProjects();
            case 4 -> ProjectController.deleteProject("");
            case 5 -> ProjectController.loadProject();
            case 6 -> controllerMenu();
        }
    }

    public static void runUserController() {
        int choice;
        Print.print(Print.USER_MENU);

        do {
            choice = Input.fetchInputInt("");
            if (choice < 1 || choice > 5) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 5);


        switch (choice) {
            case 1 -> UserController.createUser();
            case 2 -> UserController.openUser();
            case 3 -> UserController.saveUser();
            case 4 -> UserController.deleteUser();
            case 5 -> controllerMenu();

        }


    }


    public static void runTeamController() {
        int choice;
        Print.print(Print.TEAM_MENU);

        do {
            choice = Input.fetchInputInt("");
            if (choice < 1 || choice > 5) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1 -> TeamController.createTeam();
            case 2 -> TeamController.openTeam();
            case 3 -> TeamController.saveTeam();
            case 4 -> TeamController.deleteTeam("");
            case 5 -> TeamController.loadTeam();
            case 6 -> controllerMenu();
        }
    }

    public static void checkUserID() {
        int userID = Input.fetchInputInt("");

            if (userID != 0) {
                if ((!UserController.userExists(userID))) {
                    Print.print(Print.USER_DOES_NOT_EXIST);
                    logIn();
                } else {
                    checkPassword(userID, UserController.getUser(userID));
                }
            } else {
                Print.print(Print.ERROR_INPUT);
                logIn();
            }
    }


    public static void checkPassword(int userID, User user) {
        String input = Input.fetchInputString(Print.LOGIN_MENU_PASSWORD);

        if (input.isEmpty()) { //Option that sends user back to login page
            Controller.logIn();}
        if (timeOutChecker(userID)){
            if (UserController.getUserPassword(userID).equals(input)) {
                Print.print(Print.ACCESS_GRANTED);
                user.setTimeOutInc(0);
                loginSuccessful(user);
            }else if(user.getTimeOutInc() < 3) {
                Print.print(Print.WRONG_PASSWORD);
                user.incTimeOut();
                System.out.println(4 - user.getTimeOutInc() + " attempts left. ");
                checkPassword(userID, user);
            } else{
                setTimeOut(user);
                logIn();
            }
                }else{
                    lockedOutPrint(user);
                    logIn();
                }
            }


    public static User getCurrentUser() {
        return currentUser;
    }

    public static void loginSuccessful(User user) {
        currentUser = user;
        user.setTimeOut(LocalDateTime.now());
        Controller.controllerMenu();
    }

    public static void logOut() {
        currentUser = null;
        logIn();
    }

    public static boolean timeOutChecker(int userID) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime timeOut = UserController.getUser(userID).getTimeOut();
        return now.isAfter(timeOut);
        }

    public static void setTimeOut(User user){
        user.timeOut30Minutes();
        System.out.println("The user account has been locked");
        lockedOutPrint(user);

    }

    public static void lockedOutPrint(User user){
        System.out.println("Locked out until: " + user.getTimeOut() +
                " Remaining Time: " + (user.getTimeOut().getMinute() - LocalDateTime.now().getMinute()) + " minutes");
    }
}





