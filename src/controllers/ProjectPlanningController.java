package controllers;

import ProjectPlanning.ProjectPlanning;
import objects.Project;
import objects.UserStory;
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
            id = stories.get(size).getId() + 1;
        }
        return id;
    }
    public void createUserStory(){
        int id = idMaker();
        String desc = Input.fetchInputString("Write title");
        UserStory userStory = new UserStory(desc,id);
        projectPlanning.addToBacklog(userStory);
        ProjectController.openProject();
    }
    public void viewUserStories(){
        for (UserStory u: projectPlanning.getBacklog()) {
            System.out.println(u);

        }
        Controller.runProjectController();
    }
    public void planSprint(){
        //add more code later
    }

}
