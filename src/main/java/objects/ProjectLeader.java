package objects;


import java.util.HashMap;
import java.util.HashSet;

public class ProjectLeader extends User {

    private static final String role = "Project Leader" ;
    private String teamName;
    HashSet<Integer> ProjectsID = new HashSet<>();

    public ProjectLeader(String teamName, String name, int iD, String date, String role) {
        super(name, iD, date,"password123");
        this.teamName = teamName;

    }
    public String getRole() { return role; }

    public String getTeamName() { return teamName; }

    @Override
    public String toString() {
        return "Username: " + getName() + " Team: " + getTeamName() + " Role: " + role ;
    }

}

