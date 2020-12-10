package objects;

import java.io.Serializable;
import java.util.ArrayList;


public class Backlog implements IBacklog, Serializable{
    private ArrayList<UserStory> backlogList = new ArrayList<>();

    @Override
    public void addToBacklog(String desc, int score){
        int id  = idMaker();
        UserStory story = new UserStory(desc,id,score);
        backlogList.add(story);

    }
    @Override
    public void remove(int id){
        backlogList.remove(id);
    }

    public void printAll(){
        System.out.println("    objects.Backlog: ");
        for(UserStory story : backlogList) {
            System.out.println(story.description + " " + story.points + "p" + " Id: " + story.id);
        }
    }

    public int idMaker(){
        int id;
        UserStory u =backlogList.get(backlogList.size());
        id = u.getId()+1;
        return id;
    }

    public UserStory getUserStoryById(int id){
		return backlogList.get(id);
    }


    public void changeList(UserStory story){
        //
    }


    public ArrayList<UserStory> getBacklogList() {
        return backlogList;
    }

    public void view(){
        //
    }


}
