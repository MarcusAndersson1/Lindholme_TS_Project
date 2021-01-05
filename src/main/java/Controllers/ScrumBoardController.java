package Controllers;

import Objects.Project.ProjectPlanning.ProjectPlanning;
import Objects.Project.ScrumBoard;
import Utilities.Input;

public class ScrumBoardController {
    ScrumBoard scrumBoard;
    ProjectPlanning projectPlanning;

    public ScrumBoardController(ProjectPlanning projectPlanning){
        this.projectPlanning = projectPlanning;
        this.scrumBoard = projectPlanning.getScrumBoard();
    }
    public void moveStory(){
        int id = Input.fetchInputInt("what story do you wanna move");
        scrumBoard.moveStory(id);
    }
    public void endSprint(){
        scrumBoard.endSprint();
    }

}
