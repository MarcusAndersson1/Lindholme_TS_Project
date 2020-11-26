package controllers;

import controllers.Controller;
import menus.Print;
import objects.User;
import utilities.Input;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class UserController {

    private static int userID;
    private static User user;
    private static final HashMap<Integer, User> userStorage = new HashMap();

    public static void createUser() {
        String name = Input.fetchInputString(Print.ENTER_USER_NAME);
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
        userID++;
        user = new User(name, userID, currentDateTime );
        userStorage.put(userID, user);

        printUserStorage();

        Controller.runUserController();
    }

    public static void openUser(){
        printUserStorage();

        Controller.runUserController();
    }

    public static void saveUser(){

        Controller.runUserController();
    }

    public static void deleteUser(String s){
        int check;
        if (userStorage.isEmpty()){
            System.out.println(Print.THE_LIST_IS_EMPTY);
        }else {
            do {
                try {
                    s = Input.fetchInputString(Print.TYPE_ID);
                } catch (Exception e) {
                    check = 1;
                }
                check = 0;
            } while (check == 1);

            if (userStorage.containsKey(Integer.parseInt(s))) {
                System.out.println("The user with ID " + s + " has been deleted");
                userStorage.remove(Integer.parseInt(s));
            } else {
                System.out.println(Print.ERROR_INPUT);
            }
        }

        Controller.runUserController();
    }

/*
    public static void addToUserStorage(Integer integer, objects.User user) {
        userStorage.put(integer, user);

    }
    public static void removeFromUserStorage (Integer integer){
        userStorage.remove(integer);
    }
*/

    public static void printUserStorage() {

        if (userStorage.isEmpty()){
            System.out.println(Print.THE_LIST_IS_EMPTY);
        }else{
            for(Map.Entry<Integer,User> entry: userStorage.entrySet()){
                System.out.println("objects.User " + entry.getValue().getID() + ": " + entry.getValue().getName()
                        + " " + entry.getValue().getCreatedDate());
            }
        }

        // String content = teamStorage.toString();
        //  System.out.println(content);
    }
}
