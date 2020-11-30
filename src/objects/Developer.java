package objects;

import java.util.HashMap;
import java.util.HashSet;

public class Developer extends User {

    private String developer;
    private String teamName;
    public static HashMap<Integer,User> developerMap = new HashMap<>();
    HashSet<Integer> ProjectsID = new HashSet<>();

    public Developer(String teamName, String developer, String name, int iD, String date) {
        super(name, iD, date);

        this.developer = developer;
        this.teamName = teamName;
    }
    public String getDeveloper() { return developer; }

    public String getTeamName() { return teamName; }

    @Override
    public String toString() {
        return "Username: " + getName() + " Team: " + getTeamName() + " Role: " + getDeveloper();
    }

}
