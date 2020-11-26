import utilities.Input;

public class ScrumBoardController {
    ScrumBoard scrumBoard;
    Project project;

    public ScrumBoardController(Project project){
        this.project = project;
        this.scrumBoard = project.getScrumboard();
    }

    public void moveStory(){
        int id = Input.fetchInputInt("what story do you wanna move");
        scrumBoard.moveStory(id);
    }
    public void endSprint(){
        scrumBoard.endSprint();
    }
    public void planSprint(){
        scrumBoard.planSprint(project.getBacklog());
    }
}
