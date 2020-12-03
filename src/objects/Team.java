package objects;

import java.util.HashMap;

public class Team {
    private String teamName;
    private int iD;
    private String createdDate;
    public HashMap<Integer,User> memberMap = new HashMap<>();


    public Team (String teamName, int iD, String date){
        this.teamName = teamName;
        this.iD = iD;
        this.createdDate = date;
    }

    public void addTeamMember(User user){ this.memberMap.put(user.getID(),user); }
    public void removeTeamMember(User user){ this.memberMap.remove(user.getID());
    }

    public void viewTeam(){
        for(User user : memberMap.values()) {
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
}
