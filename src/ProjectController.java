

import menus.Print;
import utilities.Input;

import javax.swing.text.Utilities;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProjectController {

    private static int projectID; //save to file
    private static Project project;
    private static final HashMap<Integer, Project> projectStorage = new HashMap();


public ProjectController(){ //move the try catch out of the constructor
    try {
        this.projectID = IO.loadProjectID();
    }catch(Exception e){
        e.printStackTrace();
    }
}


    public static void createProject(){
        try {
            projectID = IO.loadProjectID();
        }catch(Exception e){
            e.printStackTrace();
        }


        String name = Input.fetchInputString(Print.ENTER_PROJECT_NAME);
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
        String endDate = setEndDate();
        projectID++;
        project = new Project(name, projectID, currentDateTime, endDate);
        projectStorage.put(projectID, project);

        printProjectStorage();

        try {
            IO.saveProjectID(projectID);
        }catch(Exception e){
            e.printStackTrace();
        }

        Controller.runProjectController();
    }

    public static void openProject(){
      //  String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
      //  project.setLastTimeOpened(currentDateTime);
        printProjectStorage();
        int id;
        Print.print("Input project id: ");

        do{
            id = Input.fetchInputInt("");
            if(!projectStorage.containsKey(id)){
                Print.print(Print.ERROR_INPUT);
            }
        }while(!projectStorage.containsKey(id));
           project=projectStorage.get(id);
        System.out.println(project);
        }



    public static void saveProjects() {
        for (Project project : projectStorage.values()){
            try{
            IO.saveProject(project);}
            catch (IOException e){
                e.printStackTrace();
            }
    }
        Controller.runProjectController();
    }
    public static void saveProject(Project p){ //this method is better but implementations comes later =)
        try{
            IO.saveProject(p);}
        catch (IOException e){
            e.printStackTrace(); //fix error handling later
        }
        Controller.runProjectController();
    }

    public static void loadProject() {
        ArrayList<Integer> usersProjects = new ArrayList<>(); //take this list as input for the method instead
        usersProjects.add(1);
        for (Integer projectID : usersProjects){
            try{
                Project loadedProject = IO.loadProject(projectID);  //perhaps check if file exists
                projectStorage.put(loadedProject.getID(),loadedProject);
            }
            catch (Exception e){ //or check what type of error is received here instead
                e.printStackTrace();
            }
        }
        Controller.runProjectController();
    }

    public static void deleteProject(String s){
        int check;
        if (projectStorage.isEmpty()){
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

            if (projectStorage.containsKey(Integer.parseInt(s))) {
                System.out.println("The project with ID " + s + " has been deleted");
                projectStorage.remove(Integer.parseInt(s));
            } else {
                System.out.println(Print.ERROR_INPUT);
            }
        }

        Controller.runProjectController();
    }

    public static void printProjectStorage() {
        if (projectStorage.isEmpty()){
            System.out.println(Print.THE_LIST_IS_EMPTY);
        }else{
            for(Map.Entry<Integer,Project> entry: projectStorage.entrySet()){
                System.out.println(entry.getValue());
            }
        }

        // String content = teamStorage.toString();
        //  System.out.println(content);
    }
    public static String setEndDate(){
    String endDate="";
    int check;
    do {

        try {
            endDate = Input.fetchInputString("Enter end Date dd/MM/YYYY");

        } catch (Exception e) {
            check = 1;
        }
        check = 0;
    }while (check==1);
        return endDate;
    }
    public static void runScrum(){
        int choice;
        ScrumBoardController scrumController = new ScrumBoardController(project);
        Print.print(Print.SCRUM_BOARD_MENU);
        do{
            choice = Input.fetchInputInt("");
            if(choice == 0 || choice < 1 || choice > 4 ){
                Print.print(Print.ERROR_INPUT);
            }
        }while(choice < 1 || choice > 4 );


        switch (choice){
            case 1 -> scrumController.moveStory();
            case 2 -> scrumController.endSprint();
            case 3 -> scrumController.planSprint();
            case 4 -> Controller.runProjectController();
        }
    }

}
