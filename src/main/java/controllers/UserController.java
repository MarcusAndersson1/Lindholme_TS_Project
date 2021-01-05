package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import menus.Print;
import objects.*;
import utilities.IO;
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
        userStorage.put(1, new Manager("stefan", 1, "hallå", "Password123"));
        userStorage.put(2, new Manager("olof", 2, "hallå", "Password123"));
        userStorage.put(3, new Manager("per", 3, "hallå", "Password123"));
    }


    public static ObservableList<User> getUsers() {
        return FXCollections.observableArrayList(userStorage.values());
    }


    public static void createUser(String name, String password, String userType) {
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
       // password = setUserPassword();

            User user;
            userID = getMaxKey() + 1;
            if(userType.equals("Manager")){
                user = new Manager(name, userID, currentDateTime, password);
                userStorage.put(userID, user);
                System.out.println("Manager created");
           }else if(userType.equals("Developer")){
                user = new DeveloperSubClass(name, userID, currentDateTime, password);
                userStorage.put(userID, user);
                System.out.println("Developer created");
           }else if(userType.equals("Stakeholder")){
                user = new Stakeholder(name, userID, currentDateTime, password);
                userStorage.put(userID, user);
                System.out.println("Stakeholder created");
            }
        saveUserMap();
        printUserStorage();
    }

    public static void saveUserMap(){
        IO.saveUsers(userStorage);
    }


    public static void loadUsers(){
       HashMap<Integer,User> users= IO.readUsers();
       if(users != null){
           userStorage = users;
       }
    }


    public static void deleteUser(User user) {
            System.out.println(getUser(user.getID()) + " has been deleted");
            userStorage.remove(user.getID());
            saveUserMap();
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



    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            return true;
        }else{
            return false;
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