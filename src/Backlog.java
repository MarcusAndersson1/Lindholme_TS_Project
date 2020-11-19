package src;

import java.util.ArrayList;


public class Backlog implements IBacklog {

    private ArrayList<UserStory> backlogList = new ArrayList<>();
    private ArrayList<UserStory> toDoList = new ArrayList<>();
    private ArrayList<UserStory> inProgressList = new ArrayList<>();
    private ArrayList<UserStory> reviewList = new ArrayList<>();
    private ArrayList<UserStory> doneList = new ArrayList<>();

    private ArrayList<UserStory> allUserStoriesList = new ArrayList<>();



    
    public void addToBacklog(String desc, int score, int id){

        UserStory storie = new UserStory(desc, score, id);
        backlogList.add(storie);

        allUserStoriesList.add(storie);

    }
    public void remove(){
        //
    }

    public void printAll(){
        System.out.println("    Backlog: ");
        for(UserStory storie : backlogList){
            System.out.println(storie.description + " " + storie.points + "p" + " Id: " + storie.id);
        }
        System.out.println("    To Do: ");
        for(UserStory storie : toDoList){
            System.out.println(storie.description + " " + storie.points + "p" + " Id: " + storie.id);
        }
        System.out.println("    In progress: ");
        for(UserStory storie : inProgressList){
            System.out.println(storie.description + " " + storie.points + "p" + " Id: " + storie.id);
        }
        System.out.println("    Review: ");
        for(UserStory storie : reviewList){
            System.out.println(storie.description + " " + storie.points + "p" + " Id: " + storie.id);
        }
        System.out.println("    Done: ");
        for(UserStory storie : doneList){
            System.out.println(storie.description + " " + storie.points + "p" + " Id: " + storie.id);
        }
    }
    
    public int idMaker(){ 
        
        return allUserStoriesList.size();
    }

    public UserStory getUserStorieById(int id){

        UserStory result = null;
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

    public void remove(UserStory storie){
        
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

    public void changeList(UserStory storie){
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
