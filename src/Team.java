

import java.util.ArrayList;

public class Team {
    private String name;
    private int iD;
    private String createdDate;
    private ArrayList<User> teamArray = new ArrayList();

    public Team (String name, int iD, String date){
        this.name = name;
        this.iD = iD;
        this.createdDate = date;
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
