import java.util.HashMap;

public class UserController {

    private static final HashMap<Integer, User> userStorage = new HashMap();

    public static void addToUserStorage (Integer integer, User user ){
        userStorage.put(integer, user);
    }

    public static void removeFromUserStorage (Integer integer){
        userStorage.remove(integer);
    }

    public static void printUserStorage(){
        String content = userStorage.toString();
        System.out.println(content);
    }
}
