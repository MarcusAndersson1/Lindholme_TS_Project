import java.util.ArrayList;


public class Backlog implements IBacklog {

    private ArrayList<UserStorie> backlogList = new ArrayList<>();
    private ArrayList<UserStorie> toDoList = new ArrayList<>();
    private ArrayList<UserStorie> inProgressList = new ArrayList<>();
    private ArrayList<UserStorie> reviewList = new ArrayList<>();
    private ArrayList<UserStorie> doneList = new ArrayList<>();

    private ArrayList<UserStorie> allUserStoriesList = new ArrayList<>();



    
    public void addToBacklog(String desc, int score, int id){

        UserStorie storie = new UserStorie(desc, score, id);
        backlogList.add(storie);

        allUserStoriesList.add(storie);

    }
    public void remove(){
        //
    }

    public void printAll(){
        System.out.println("    Backlog: ");
        for(UserStorie storie : backlogList){
            System.out.println(storie.description + " " + storie.points + "p" + " Id: " + storie.id);
        }
        System.out.println("    To Do: ");
        for(UserStorie storie : toDoList){
            System.out.println(storie.description + " " + storie.points + "p" + " Id: " + storie.id);
        }
        System.out.println("    In progress: ");
        for(UserStorie storie : inProgressList){
            System.out.println(storie.description + " " + storie.points + "p" + " Id: " + storie.id);
        }
        System.out.println("    Review: ");
        for(UserStorie storie : reviewList){
            System.out.println(storie.description + " " + storie.points + "p" + " Id: " + storie.id);
        }
        System.out.println("    Done: ");
        for(UserStorie storie : doneList){
            System.out.println(storie.description + " " + storie.points + "p" + " Id: " + storie.id);
        }
    }
    
    public int idMaker(){ 
        
        return allUserStoriesList.size();
    }

    public UserStorie getUserStorieById(int id){

        UserStorie result = null;
		boolean found = false;
		int index = 0; 
        int indexWhereFound = -1;
        
		while (!found && index < allUserStoriesList.size())

		{
			if (id == (allUserStoriesList.get(index).getId()))
			{
				found = true;
				indexWhereFound = index;
			}
			index++;
		}
		if (found)
		{
			result = allUserStoriesList.get(indexWhereFound);
        }
        
		return result;
    }

    public void remove(UserStorie storie){
        
        if (storie != null)
		{
            allUserStoriesList.remove(storie);
            backlogList.remove(storie);
            toDoList.remove(storie);
            inProgressList.remove(storie);
            reviewList.remove(storie);
            doneList.remove(storie);
			System.out.println("Removed");
		}
		else
		{
			System.out.println("Given ID is invalid, user storie not found");
		}
    }

    public void changeList(UserStorie storie){
        if(backlogList.contains(storie)){
            backlogList.remove(storie);
            toDoList.add(storie);
        }else if(toDoList.contains(storie)){
            toDoList.remove(storie);
            inProgressList.add(storie);
        }else if(inProgressList.contains(storie)){
            inProgressList.remove(storie);
            reviewList.add(storie);
        }else if(reviewList.contains(storie)){
            reviewList.remove(storie);
            doneList.add(storie);
        }
    }

    
    public void view(){
        //
    }


}
