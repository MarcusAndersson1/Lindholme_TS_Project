package objects;

import java.io.Serializable;

public class UserStory implements Serializable {


    String description;
    int points;
    int id;

    UserStoryState state = UserStoryState.BACK_LOGG;

    public UserStory(String description, int id, int points){
        this.description = description;
        this.id = id;
        this.points = points;
    }
    public int getId()
    {
	return this.id;
    }

    public int getPoints()
    {
	return this.points;
    }

    public String getDescription()
    {
	return this.description;
    }

    public void setState() {
        if(state.equals(UserStoryState.BACK_LOGG)) {
            this.state = UserStoryState.TODO;
        }else if(state.equals(UserStoryState.TODO)) {
            this.state = UserStoryState.IN_PROGRESS;
        }else if (state.equals(UserStoryState.IN_PROGRESS)) {
            this.state = UserStoryState.TESTING;
        }else if (state.equals(UserStoryState.TESTING)) {
            this.state = UserStoryState.DONE;
        }
    }

    public UserStoryState getState() {
        return state;
    }

    @Override
    public String toString() {
        return "UserStory: "+" description: " + description + "points=" + points +
                " id: " + getId() +
                " state: " + getState();
    }
}
