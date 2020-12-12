package objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Team  implements Serializable {
    private String teamName;
    private int teamID;
    private String createdDate;
    public ArrayList<User> memberList = new ArrayList<>();
    public ArrayList<UserStory> backlog = new ArrayList<>();

   // public static HashMap<Integer, User> getMemberMap() { return memberMap; }
    //public static void setMemberMap(HashMap<Integer, User> memberMap) { Team.memberMap = memberMap; }

    public Team (String teamName, int teamID, String date){
        this.teamName = teamName;
        this.teamID = teamID;
        this.createdDate = date;
    }

    public ObservableList<UserStory> getBacklog() {
        return FXCollections.observableArrayList(backlog);
    }
    public void addToBacklog(UserStory u){
    backlog.add(u);
    }

    public Team (String teamName, int teamID, String date, ArrayList<User> memberList){
        this.teamName = teamName;
        this.teamID = teamID;
        this.createdDate = date;
        this.memberList = memberList;
    }
    public ArrayList<User> getMemberList() {
        return memberList;
    }

    public void addTeamMember(User user){
        memberList.add(user);
        System.out.println(user + " added");
    }
    public void removeTeamMember(User user){ memberList.remove(user.getID());
    }

    public void viewTeam(){
        for(User user : memberList) {
            System.out.println(user);
        }
    }

    public String getName() {
        return teamName;
    }

    public void setName(String name) {
        this.teamName = teamName;
    }
    public String getCreatedDate() {
        return createdDate;
    }

    public int getTeamID() {
        return teamID;
    }

    @Override
    public String toString() {
        return "ID: "+ getTeamID()+" Team: " + teamName + "Team members :" + memberList.toString();
    }
}
