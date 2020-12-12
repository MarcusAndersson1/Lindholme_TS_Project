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
    private static Project project;
    private static HashMap<Integer, Project> projectStorage = new HashMap<Integer, Project>();

    public ProjectController() { // move the try catch out of the constructor
        try {
            this.projectID = IO.loadProjectID();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ObservableList<Project> getProjects(){
        loadProject();
        printProjectStorage();
        return FXCollections.observableArrayList(projectStorage.values());
    }

    public static void setProject(Project project) {
        ProjectController.project = project;
    }

    public static Project getProject() {
        return ProjectController.project;
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
            project = new Project(name, projectID, currentDateTime, endDate);
            projectStorage.put(projectID, project);
            System.out.println(project);
            IO.saveProject(project);
        }catch (Exception e){
        }
        try {
            IO.saveProjectID(projectID);
        }catch(Exception e){
            e.printStackTrace();
        }
        return project;
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
        project = projectStorage.get(id);
        System.out.println(project);
        int choice;
        Print.print(Print.PROJECT_PLANNING_MENU);

        do {
            choice = Input.fetchInputInt("");
            if (choice == 0 || choice < 1 || choice > 6) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 6);

        switch (choice) {
            case 1 -> new ProjectPlanningController(project).createUserStory();
            case 2 -> new ProjectPlanningController(project).viewUserStories();
            case 3 -> new ProjectPlanningController(project).createRisk();
            case 4 -> new ProjectPlanningController(project).viewRisks();
            case 5 -> Controller.runProjectController();
        }
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
        project = projectStorage.get(id);

        try {
           SaveToExcel.saveToExcel(project);
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
        ScrumBoardController scrumController = new ScrumBoardController(project.projectPlanning);
        Print.print(Print.SCRUM_BOARD_MENU);
        do {
            choice = Input.fetchInputInt("");
            if (choice == 0 || choice < 1 || choice > 4) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1 -> scrumController.moveStory();
            case 2 -> scrumController.endSprint();
            // case 3 -> scrumController.planSprint();
            case 4 -> Controller.runProjectController();
        }
    }

}
