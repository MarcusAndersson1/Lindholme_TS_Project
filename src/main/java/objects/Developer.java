package objects;

import java.util.HashMap;
import java.util.HashSet;

public class Developer extends User {

    private static final String role = "Developer" ;
    private String teamName;
    HashSet<Integer> ProjectsID = new HashSet<>();

    public Developer(String teamName, String role, String name, int iD, String date) {
        super(name, iD, date,"password123", "", "");


        this.teamName = teamName;
    }

    public String getRole() { return "Developer"; }

    public String getTeamName() { return teamName; }

    @Override
    public String toString() {
        return "Username: " + getName() + " Team: " + getTeamName() + " Role: " + role;
    }

}
