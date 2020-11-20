
import java.util.HashMap;

    public class Storage {

        private static final HashMap <Integer, Team> teamStorage = new HashMap();
        private static final HashMap <Integer, User> userStorage = new HashMap();
        private static final HashMap <Integer, Project> projectStorage = new HashMap();



        public static void addToTeamStorage (Integer integer, Team team ){
            teamStorage.put(integer, team);
        }

        public static void removeFromTeamStorage (Integer integer){
            teamStorage.remove(integer);
        }

        public static void printTeamStorage(){
            String content = teamStorage.toString();
            System.out.println(content);
        }


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


        public static void addToProjectStorage (Integer integer, Project project){
            projectStorage.put(integer, project);
        }

        public static void removeFromProjectStorage (Integer integer){
            projectStorage.remove(integer);
        }

        public static void printProjectStorage(){
            String content = projectStorage.toString();
            System.out.println(content);
        }

    }


