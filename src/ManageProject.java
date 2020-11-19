package src;

import src.menus.Print;
import src.utilities.Input;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ManageProject {
    Main main;
    private Input input = new Input();
    private Controller controller = new Controller();
    private Project project;

    public ManageProject(Main main){ this.main = main; }


    public void createProject(){
        String name = Input.fetchInputString(Print.ENTER_PROJECT_NAME);
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
        this.project = new Project(name, currentDateTime);
        System.out.println(project.getName());
        System.out.println(project.getCreatedDate());

        controller.runManageProject();
    }

    public void openProject(){
      //  String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
      //  project.setLastTimeOpened(currentDateTime);

        controller.runManageProject();
    }

    public void saveProject(){

        controller.runManageProject();
    }

    public void deleteProject(){

        controller.runManageProject();
    }

}
