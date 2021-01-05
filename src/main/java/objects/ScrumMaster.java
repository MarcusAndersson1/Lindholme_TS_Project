package objects;

import java.util.HashMap;
import java.util.HashSet;

public class ScrumMaster extends User {

    private static final String role = "Scrum Master" ;
    private String teamName;
    HashSet<Integer> ProjectsID = new HashSet<>();

    public ScrumMaster(String name, String teamName, int userID, String date, String role) {
        super(name, userID, date, "password123");

        this.teamName = teamName;
    }
        public String getRole() { return role; }

        public String getTeamName() { return teamName; }

        @Override
        public String toString() {
            return "Username: " + getName() + " Team: " + getTeamName() + " Role: " + role;
        }

    }
