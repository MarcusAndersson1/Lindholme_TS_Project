package controllers;

import ProjectPlanning.*;
import objects.Project;
import objects.*;
import utilities.*;

public class ProjectPlanningController {
    private ProjectPlanning projectPlanning;
    public static Project project;
    public ProjectPlanningController(Project project){
     this.project = project;
    }
    public static int idMaker(){
        int id;
        int size;
        size= project.getUserStories().size();
        if(size==0){
            id=1;
        }else {
            id = size+1;
        }
        return id;
    }
    public static UserStory createUserStory(){
        int id = idMaker();
        String desc = Input.fetchInputString("Write title ");
        int score = Input.fetchInputInt("Type score ");
        UserStory userStory = new UserStory(desc,id);
        return userStory;
    }
    public void createRisk(){
        projectPlanning.addRisk();
        //ProjectController.openProject();
    }
    public void viewUserStories(){
        for (UserStory u: projectPlanning.getBacklog()) {
            System.out.println(u);

        }
       // Controller.runProjectController();
    }
    public void viewRisks(){
        for (Risk u: projectPlanning.getRisks()) {
            System.out.println(u);
        }
        //Controller.runProjectController();
    }
    public void planSprint(){
        //add more code later
    }
    public static Project getProject() {
        return project;
    }
}
