package objects;

import java.util.HashMap;
import java.util.HashSet;

public class ScrumMaster extends User {

    private String scrumMaster;
    private String teamName;
    HashSet<Integer> ProjectsID = new HashSet<>();

    public ScrumMaster(String scrumMaster, String name, int iD, String date) {
        super(name, iD, date, "password123");

        this.scrumMaster = scrumMaster;
        this.teamName = teamName;
    }

        public String getScrumMaster() { return scrumMaster; }

        public String getTeamName() { return teamName; }

        @Override
        public String toString() {
            return "Username: " + getName() + " Team: " + getTeamName() + " Role: " + getScrumMaster();
        }

    }
