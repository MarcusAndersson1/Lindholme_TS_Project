

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<User> teamArray = new ArrayList();

    public Team (String name){
        this.name = name;
    }
    void addTeamMember(User user){
        teamArray.add(user);
    }
    void removeTeamMember(User user){
        teamArray.remove(user);
    }
    void viewTeam(){
        for(User user : teamArray) {
            user.toString();
        }
    }
}
