

import menus.Print;
import utilities.Input;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.HashMap;

public class ProjectController {

    private static int projectID;
    private static final HashMap<Integer, Project> projectStorage = new HashMap();



    public static void createProject(){
        String name = Input.fetchInputString(Print.ENTER_PROJECT_NAME);
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
        Project project = new Project(name, currentDateTime);
        System.out.println(project.getName());
        System.out.println(project.getCreatedDate());
        projectID++;
        projectStorage.put(projectID, project);

        printProjectStorage();

        Controller.runManageProject();
    }

    public static void openProject(){
      //  String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
      //  project.setLastTimeOpened(currentDateTime);
        printProjectStorage();

        Controller.runManageProject();
    }

    public static void saveProject(){

        Controller.runManageProject();
    }

    public static void deleteProject(String s){
        int check;
        do {
            try{
                s = Input.fetchInputString("Type ID");
            }catch(Exception e){
                check = 1;
            }
            check = 0;
        }while(check == 1);

        if(projectStorage.containsKey(s)) {
            System.out.println(Print.ERROR_INPUT);
        }else{
            System.out.println("The project with ID " + s + "has been deleted");
            projectStorage.remove(Integer.parseInt(s));
        }

        Controller.runManageProject();
    }

    public static void printProjectStorage(){
        String content = projectStorage.toString();
        System.out.println(content);
    }

}
