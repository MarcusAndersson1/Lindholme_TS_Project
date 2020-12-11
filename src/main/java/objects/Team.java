package objects;

import menus.Print;
import utilities.Input;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Team  implements Serializable {
    private String teamMember;
    private String teamName;
    private int teamID;
    private String createdDate;
    public static ArrayList<TeamMember> memberList = new ArrayList<>();

   // public static HashMap<Integer, User> getMemberMap() { return memberMap; }
    //public static void setMemberMap(HashMap<Integer, User> memberMap) { Team.memberMap = memberMap; }

    public Team (String teamName, int teamID, String date, String teamMember){
        this.teamMember = teamMember;
        this.teamName = teamName;
        this.teamID = teamID;
        this.createdDate = date;
    }
    public static ArrayList<TeamMember> getMemberList() {
        return memberList;
    }

    public void addTeamMember(TeamMember user){
        memberList.add(user);
        System.out.println(user + " added");
    }
    public void removeTeamMember(TeamMember user){ memberList.remove(user.getUserID());
    }

    public void viewTeam(){ for(TeamMember user : memberList) { System.out.println(user); }
    }
    public static void assignRole(User user) { memberList.add((TeamMember) user); }
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
        return "ID: "+ getTeamID()+" Team: " + teamName + "Team Members :" + memberList.toString();
    }
}
