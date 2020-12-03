package objects;


import java.util.HashMap;
import java.util.HashSet;

public class ProjectLeader extends User {

    private String leader;
    private String teamName;
    public static HashMap<Integer,User> leaderMap = new HashMap<>();
    HashSet<Integer> ProjectsID = new HashSet<>();

    public ProjectLeader(String teamName, String leader, String name, int iD, String date) {
        super(name, iD, date,"password123");
        this.leader = leader;
        this.teamName = teamName;

    }
    public String getLeader() { return leader; }

    public String getTeamName() { return teamName; }

    @Override
    public String toString() {
        return "Username: " + getName() + " Team: " + getTeamName() + " Role: " + getLeader();
    }

}

