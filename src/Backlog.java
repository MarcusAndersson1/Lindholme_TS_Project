

import java.io.Serializable;
import java.util.ArrayList;


public class Backlog implements IBacklog, Serializable{

    private ArrayList<UserStory> backlogList = new ArrayList<>();  //inheritance interface kanske+???
    private ArrayList<UserStory> toDoList = new ArrayList<>();
    private ArrayList<UserStory> inProgressList = new ArrayList<>();
    private ArrayList<UserStory> reviewList = new ArrayList<>();
    private ArrayList<UserStory> doneList = new ArrayList<>();
    private ArrayList<UserStory> allUserStoriesList = new ArrayList<>();



    
    public void addToBacklog(String desc, int score, int id){

        UserStory story = new UserStory(desc, score, id);
        backlogList.add(story);

        allUserStoriesList.add(story);

    }
    public void remove(){
        //
    }

    public void printAll(){
        System.out.println("    Backlog: ");
        for(UserStory story : backlogList){
            System.out.println(story.description + " " + story.points + "p" + " Id: " + story.id);
        }
        System.out.println("    To Do: ");
        for(UserStory story : toDoList){
            System.out.println(story.description + " " + story.points + "p" + " Id: " + story.id);
        }
        System.out.println("    In progress: ");
        for(UserStory story : inProgressList){
            System.out.println(story.description + " " + story.points + "p" + " Id: " + story.id);
        }
        System.out.println("    Review: ");
        for(UserStory story : reviewList){
            System.out.println(story.description + " " + story.points + "p" + " Id: " + story.id);
        }
        System.out.println("    Done: ");
        for(UserStory story : doneList){
            System.out.println(story.description + " " + story.points + "p" + " Id: " + story.id);
        }
    }
    
    public int idMaker(){ 
        
        return allUserStoriesList.size();
    }

    public UserStory getUserStoryById(int id){

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

    public void remove(UserStory story){
        
        if (story != null)
		{
            allUserStoriesList.remove(story);
            backlogList.remove(story);
            toDoList.remove(story);
            inProgressList.remove(story);
            reviewList.remove(story);
            doneList.remove(story);
			System.out.println("Removed");
		}
		else
		{
			System.out.println("Given ID is invalid, user story not found");
		}
    }

    public void changeList(UserStory story){
        if(backlogList.contains(story)){
            backlogList.remove(story);
            toDoList.add(story);
        }else if(toDoList.contains(story)){
            toDoList.remove(story);
            inProgressList.add(story);
        }else if(inProgressList.contains(story)){
            inProgressList.remove(story);
            reviewList.add(story);
        }else if(reviewList.contains(story)){
            reviewList.remove(story);
            doneList.add(story);
        }
    }

    
    public void view(){
        //
    }


}
