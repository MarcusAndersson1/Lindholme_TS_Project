

public class UserStory {


    String description;
    int points;
    int id;

    public UserStory(String description, int points, int id){
        this.description = description;
        this.points = points;
        this.id = id;
    }


    public int getId()
    {
	return this.id;
    }
    
}
