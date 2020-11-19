
import java.util.HashMap;

    public class Storage {

        private static final HashMap <Integer, Project> projectStorage = new HashMap();

        public static void addToClass (Integer integer, Project project){
            projectStorage.put(integer, project);
        }


        public static void printHashMap(){
            String content = projectStorage.toString();
            System.out.println(content);
        }

    }


