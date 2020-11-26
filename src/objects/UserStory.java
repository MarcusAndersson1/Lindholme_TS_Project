package objects;

public class UserStory {


    String description;
    int points;
    int id;
    UserStoryState state = UserStoryState.BACK_LOGG;

    public UserStory(String description, int points, int id){
        this.description = description;
        this.points = points;
        this.id = id;
    }
    public int getId()
    {
	return this.id;
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
}
