package objects;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Team  implements Serializable {
    private String teamName;
    private int iD;
    private String createdDate;
    public static ArrayList<User> memberMap = new ArrayList<>();

   // public static HashMap<Integer, User> getMemberMap() { return memberMap; }
    //public static void setMemberMap(HashMap<Integer, User> memberMap) { Team.memberMap = memberMap; }

    public Team (String teamName, int iD, String date){
        this.teamName = teamName;
        this.iD = iD;
        this.createdDate = date;
    }

    public void addTeamMember(User user){
        memberMap.add(user);
        System.out.println(user + " added");
    }
    public void removeTeamMember(User user){ memberMap.remove(user.getID());
    }

    public void viewTeam(){
        for(User user : memberMap) {
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

    public int getID() {
        return iD;
    }

    @Override
    public String toString() {
        return "ID: "+ getID()+" Team: " + teamName + "Team members :" + memberMap.toString();
    }
}
