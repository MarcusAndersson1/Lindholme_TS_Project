

import java.util.ArrayList;
import java.util.HashMap;

public class Team {
    private String name;
    private int iD;
    private String createdDate;
    public static HashMap<Integer,User> memberMap = new HashMap<>();

   // public static HashMap<Integer, User> getMemberMap() { return memberMap; }
    //public static void setMemberMap(HashMap<Integer, User> memberMap) { Team.memberMap = memberMap; }

    public Team (String name, int iD, String date){
        this.name = name;
        this.iD = iD;
        this.createdDate = date;
    }
    void addTeamMember(User user){ memberMap.put(user.getID(),user); }
    void removeTeamMember(User user){ memberMap.remove(user.getID());
    }
    void viewTeam(){
        for(User user : memberMap.values()) {
            System.out.println(user);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCreatedDate() {
        return createdDate;
    }

    public int getID() {
        return iD;
    }
}
