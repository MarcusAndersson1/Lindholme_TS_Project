package objects;

import utilities.Input;

import java.io.Serializable;
import java.util.ArrayList;

public class ScrumBoard implements Serializable {
    ArrayList<UserStory> sprint = new ArrayList<>();

    void ScrumBoard(Backlog b){
        setSprint(b);
    }
    //Puts all storys in todu in a separate list for this sprint
    public void setSprint(Backlog b){
        ArrayList<UserStory> list = b.getBacklogList();
        for (UserStory u: list ) {
            if(u.getState().equals(UserStoryState.TODO)){
                sprint.add(u);
                b.remove(u.getId());
            }
        }
    }
    // Move a user story from todo --> in progress --> testing --> done
    public void moveStory(int id){
        UserStory u= sprint.get(id);

   }

    // moves all storys not done to backlogg
    public void endSprint(){
        for (UserStory u: sprint) {
            if(!u.getState().equals(UserStoryState.DONE)){
                u.state= UserStoryState.BACK_LOGG;
            }
        }
    }
    public void planSprint(Backlog b){
        int id = Input.fetchInputInt("choose story id");
        ArrayList<UserStory> backlogList = b.getBacklogList();
        backlogList.get(id).setState();
    }
}
