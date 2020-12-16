package controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objects.*;
import utilities.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import menus.*;

public class ProjectController {

    private static TeamController teamController;
    private static int projectID; // save to file
    private static Project currentProject;
    private static HashMap<Integer, Project> projectStorage = new HashMap<Integer, Project>();

    public ProjectController() { // move the try catch out of the constructor
        try {
            this.projectID = IO.loadProjectID();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int idMaker() {
        int id;
        int size;
        size = currentProject.getUserStories().size();
        if (size == 0) {
            id = 1;
        } else {
            id = size + 1;
        }
        return id;
    }

    public static UserStory createUserStory(String desc, Project p) {

    UserStory u = new UserStory(desc, idMaker());
        p.addUserStories(u);
    return u;
}

    public static ObservableList<Project> getProjects(){
        loadProject();
        return FXCollections.observableArrayList(projectStorage.values());
    }
    public static  ObservableList<UserStory> getBacklog(Project p){

        return FXCollections.observableArrayList(p.getUserStories());
    }
    public static void addToBacklog(Project p, UserStory u){
        p.addUserStories(u);
    }

    public static void setCurrentProject(Project currentProject) {
        ProjectController.currentProject = currentProject;
    }

    public static Project getCurrentProject() {
        return ProjectController.currentProject;
    }


    public static Project createProject(String name, LocalDate date) {
        LocalDate currentDateTime = LocalDate.now();
        LocalDate endDate = date;
        try {
            projectID = IO.loadProjectID();
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            projectID++;
            currentProject = new Project(name, projectID, currentDateTime, endDate);
            projectStorage.put(projectID, currentProject);
            IO.saveProject(currentProject);
        }catch (Exception e){
        }
        try {
            IO.saveProjectID(projectID);
        }catch(Exception e){
            e.printStackTrace();
        }
        return currentProject;
    }
    public static void removeProject(Project p){
        projectStorage.remove(p.getID());
    }
    public static void removeUserStory(Project p, UserStory u){
        p.getUserStories().remove(u);
    }

    public static void openProject() {
        // String currentDateTime =
        // LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
        // project.setLastTimeOpened(currentDateTime);
        int id;
        do {
            id = Input.fetchInputInt("");
            if (!projectStorage.containsKey(id)) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (!projectStorage.containsKey(id));
        currentProject = projectStorage.get(id);
        System.out.println(currentProject);
        int choice;
        Print.print(Print.PROJECT_PLANNING_MENU);

        do {
            choice = Input.fetchInputInt("");
            if (choice == 0 || choice < 1 || choice > 6) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 6);

        switch (choice) {
            case 1 -> new ProjectPlanningController(currentProject).createUserStory();
            case 2 -> new ProjectPlanningController(currentProject).viewUserStories();
            case 3 -> new ProjectPlanningController(currentProject).createRisk();
            case 4 -> new ProjectPlanningController(currentProject).viewRisks();
            case 5 -> Controller.runProjectController();
        }
    }
    public static void addProject(Project project){
        projectStorage.put(project.getID(),project);
    }
    public static void saveProjects() {
        for (Project project : projectStorage.values()) {
            try {
                IO.saveProject(project);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveProject(Project p) { // this method is better but implementations comes later =)
        try {
            IO.saveProject(p);
        } catch (IOException e) {
            e.printStackTrace(); // fix error handling later
        }
    }

    public static void saveProjectToExcel() { // this method is better but implementations comes later =)
        
        printProjectStorage();
        int id;
        Print.print("Input project id to save: ");

        do {
            id = Input.fetchInputInt("");
            if (!projectStorage.containsKey(id)) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (!projectStorage.containsKey(id));
        currentProject = projectStorage.get(id);

        try {
           SaveToExcel.saveToExcel(currentProject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadProject() {
        ArrayList<Integer> usersProjects = new ArrayList<>(); // take this list as input for the method instead
        usersProjects.add(1);
        for (Integer projectID : usersProjects) {
            try {
                Project loadedProject = IO.loadProject(projectID); // perhaps check if file exists
                projectStorage.put(loadedProject.getID(), loadedProject);
            } catch (Exception e) { // or check what type of error is received here instead
                e.printStackTrace();
            }
        }
    }

    public static void deleteProject(String s) {
        int check;
        if (projectStorage.isEmpty()) {
            System.out.println(Print.THE_LIST_IS_EMPTY);
        } else {
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

    }

    public static void printProjectStorage() {
        if (projectStorage.isEmpty()) {
            System.out.println(Print.THE_LIST_IS_EMPTY);
            Controller.runProjectController();
        } else {
            for (Map.Entry<Integer, Project> entry : projectStorage.entrySet()) {
                System.out.println(entry.getValue());
            }
        }

        // String content = teamStorage.toString();
        // System.out.println(content);
    }
    public static void setProjectDescription(String s, Project p){
        p.setProjectDescription(s);
    }
    public static String getProjectDescription(Project p){
        return p.getProjectDescription();
    }

    public static String setEndDate() {
        String endDate = "";
        int check;
        do {

            try {
                endDate = DateHandler.setDate();

            } catch (Exception e) {
                check = 1;
            }
            check = 0;
        } while (check == 1);
        return endDate;
    }

    public static void runScrum() {
        int choice;
        //ScrumBoardController scrumController = new ScrumBoardController(project.projectPlanning);
        Print.print(Print.SCRUM_BOARD_MENU);
        do {
            choice = Input.fetchInputInt("");
            if (choice == 0 || choice < 1 || choice > 4) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 4);

        switch (choice) {
           // case 1 -> scrumController.moveStory();
            //case 2 -> scrumController.endSprint();
            // case 3 -> scrumController.planSprint();
            case 4 -> Controller.runProjectController();
        }
    }

}
