import utilities.Input;

import java.io.Serializable;
import java.util.ArrayList;

public class ScrumBoard implements Serializable {
    ArrayList<UserStory> sprint = new ArrayList<>();

    void ScrumBoard(Backlog b){
        setSprint(b);
    }
    //Puts all storys in todu in a separate list for this sprint
    void setSprint(Backlog b){
        ArrayList<UserStory> list = b.getBacklogList();
        for (UserStory u: list ) {
            if(u.getState().equals(UserStoryState.TODO)){
                sprint.add(u);
                b.remove(u.getId());
            }
        }
    }
    // Move a user story from todo --> in progress --> testing --> done
    void moveStory(int id){
        UserStory  u= sprint.get(id);

        u.setState();
    }

    // moves all storys not done to backlogg
    void endSprint(){
        for (UserStory u: sprint) {
            if(!u.getState().equals(UserStoryState.DONE)){
                u.state=UserStoryState.BACK_LOGG;
            }
        }
    }
    void planSprint(Backlog b){
        int id = Input.fetchInputInt("chise story id");
        ArrayList<UserStory> backlogList = b.getBacklogList();
        backlogList.get(id).setState();
    }
}
