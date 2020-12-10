package controllers;


import menus.*;
import objects.*;
import objects.Team;
import objects.User;
import utilities.*;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Controller {
    static User currentUser;


    public static boolean logIn(int id, String password) {
        checkUserID(id);
        checkPassword(id, password);
        Print.print(Print.LOGIN_MENU_USERID);

        return true;

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
            if (choice < 1 || choice > 7) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 7);


        switch (choice) {
            //case 1 -> ProjectController.createProject();
            case 2 -> ProjectController.openProject();
            //case 3 -> ProjectController.assignTeam();
            case 4 -> ProjectController.saveProjects();
            case 5 -> ProjectController.deleteProject("");
            case 6 -> ProjectController.loadProject();
            case 7 -> ProjectController.saveProjectToExcel();
            case 8 -> controllerMenu();
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
       //     case 1 -> UserController.createUser();
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
            if (choice < 1 || choice > 6) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 6);

        switch (choice) {
            case 1 -> TeamController.createTeam();
            case 2 -> TeamController.openTeam();
            case 3 -> TeamController.saveTeam();
            case 4 -> TeamController.deleteTeam("");
            case 5 -> TeamController.loadTeam();
            case 6 -> controllerMenu();
        }
    }

    public static boolean checkUserID(int userID) {
        if (!UserController.userExists(userID)) {
            Print.print(Print.USER_DOES_NOT_EXIST);
            return false;
        } else {
            Print.print(" Succe!!! ");
            return true;
        }
    }


    public static boolean checkPassword(int userID, String password) {
        User user = UserController.getUser(userID);
        if (timeOutChecker(userID)){
            if (UserController.getUserPassword(userID).equals(password)) {
                Print.print(Print.ACCESS_GRANTED);
                user.setTimeOutInc(0);
                loginSuccessful(user);
                return true;
            }else if(user.getTimeOutInc() < 3) {
                Print.print(Print.WRONG_PASSWORD);
                user.incTimeOut();
                System.out.println(4 - user.getTimeOutInc() + " attempts left. ");
                return false;
            } else{
                setTimeOut(user);
                return false;
            }
                }else{
                    lockedOutPrint(user);
                 return false;
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





