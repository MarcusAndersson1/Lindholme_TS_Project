package controllers;

import menus.Print;
import objects.User;
import utilities.Input;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    private static int userID;
    private static HashMap<Integer, User> userStorage = new HashMap<>();

    public static void addTestUser() {
        userStorage.put(1, new User("stefan", 1, "hallå", "Password123"));
        userStorage.put(2, new User("olof", 2, "hallå", "Password123"));
        userStorage.put(3, new User("per", 3, "hallå", "Password123"));

    }

    public static void createUser() {
        String name = Input.fetchInputString(Print.ENTER_USER_NAME);
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
        String password = setUserPassword();
        userID = getMaxKey() + 1;
        User user = new User(name, userID, currentDateTime, password);
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

    public static void deleteUser() {
        int input = 0;
        if (userStorage.isEmpty()) {
            System.out.println(Print.THE_LIST_IS_EMPTY);
        } else {
                try {
                    input = Integer.parseInt(Input.fetchInputString(Print.TYPE_ID));
                } catch (Exception e) {

                }
            if (userStorage.containsKey(input)) {
                System.out.println("The user with ID " + input + " has been deleted");
                userStorage.remove(input);
            } else {
                System.out.println(Print.ERROR_INPUT);
            }
        }
        Controller.runUserController();
    }

    public static void printUserStorage() {

        if (userStorage.isEmpty()){
            System.out.println(Print.THE_LIST_IS_EMPTY);
        }else{
            for(Map.Entry<Integer,User> entry: userStorage.entrySet()){
                System.out.println(entry.getValue());
            }
        }
    }
    public static boolean userExists(int id){
        if (userStorage.containsKey(id)){
            return true;
        }else{
            return false;
        }
    }
    public static User getUser(int userID){
        return userStorage.get(userID);
    }

    public static String getUserPassword(int userID) {
        return userStorage.get(userID).getPassword();
    }

    public static String setUserPassword() {
        String password;
        do {
            password = Input.fetchInputString(Print.ENTER_PASSWORD);
            if(isValidPassword(password)){
                Print.print(Print.INVALID_PASSWORD);
            }else{
                Print.print(Print.VALID_PASSWORD);
            }
        } while (isValidPassword(password));
        return password;
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            return false;
        }else{
            return true;
        }
    }

    public static int getMaxKey() {
        int maxKey = 0;
        for (Map.Entry<Integer, User> entry : userStorage.entrySet()) {
            if (maxKey < entry.getKey()) {
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}