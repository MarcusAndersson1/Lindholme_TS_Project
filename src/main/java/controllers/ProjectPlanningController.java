package controllers;

import ProjectPlanning.*;
import objects.Project;
import objects.*;
import utilities.Input;

import java.util.ArrayList;

public class ProjectPlanningController {
    private ProjectPlanning projectPlanning;
    public ProjectPlanningController(Project project){

       this.projectPlanning=project.projectPlanning;

    }
    public int idMaker(){
        int id;
        int size;
        ArrayList<UserStory> stories =projectPlanning.getBacklog();
        size=stories.size();
        if(size==0){
            id=1;
        }else {
            id = size+1;
        }
        return id;
    }
    public void createUserStory(){
        int id = idMaker();
        String desc = Input.fetchInputString("Write title ");
        int score = Input.fetchInputInt("Type score ");
        UserStory userStory = new UserStory(desc,id,score);
        projectPlanning.addToBacklog(userStory);
        ProjectController.openProject();
    }
    public void createRisk(){
        projectPlanning.addRisk();
        ProjectController.openProject();
    }
    public void viewUserStories(){
        for (UserStory u: projectPlanning.getBacklog()) {
            System.out.println(u);

        }
        Controller.runProjectController();
    }
    public void viewRisks(){
        for (Risk u: projectPlanning.getRisks()) {
            System.out.println(u);
        }
        Controller.runProjectController();
    }
    public void planSprint(){
        //add more code later
    }

}
