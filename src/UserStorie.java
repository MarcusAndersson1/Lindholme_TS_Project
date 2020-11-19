
public class UserStorie{


    String description;
    int points;
    int id;

    public UserStorie(String description, int points, int id){
        this.description = description;
        this.points = points;
        this.id = id;
    }


    public int getId()
    {
	return this.id;
    }
    
}
