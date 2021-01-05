package objects;

public class TeamMember extends User {

    private String role;
    private int teamID;

    public TeamMember(String name, int userID, String date, int teamID) {
        super(name, userID, date, "password123");
        this.role = "none";
        this.teamID = teamID;

    }
    public String getRole() { return "none"; }

    public int getTeamID() { return teamID; }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    @Override
    public String toString() {
        return "Username: " + getName() + " Team: " + getTeamID() + " Role: " + getRole();
    }

    public User setRole(String role) { this.role= role;
        return null;
    }
}