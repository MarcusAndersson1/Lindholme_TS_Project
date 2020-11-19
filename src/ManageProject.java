

import src.menus.Print;
import src.utilities.Input;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ManageProject {



    public static void createProject(){
        String name = Input.fetchInputString(Print.ENTER_PROJECT_NAME);
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
        Project project = new Project(name, currentDateTime);
        System.out.println(project.getName());
        System.out.println(project.getCreatedDate());

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
