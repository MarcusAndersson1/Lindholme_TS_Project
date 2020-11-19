

import menus.Print;
import utilities.Input;

import java.security.PrivateKey;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.HashMap;

public class ManageProject {

    private static int projectID;



    public static void createProject(){
        String name = Input.fetchInputString(Print.ENTER_PROJECT_NAME);
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
        Project project = new Project(name, currentDateTime);
        System.out.println(project.getName());
        System.out.println(project.getCreatedDate());
        projectID++;
        Storage.addToClass(projectID, project);

        Storage.printHashMap();

        Controller.runManageProject();
    }

    public static void openProject(){
      //  String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
      //  project.setLastTimeOpened(currentDateTime);

        Controller.runManageProject();
    }

    public static void saveProject(){

        Controller.runManageProject();
    }

    public static void deleteProject(){

        Controller.runManageProject();
    }

}
