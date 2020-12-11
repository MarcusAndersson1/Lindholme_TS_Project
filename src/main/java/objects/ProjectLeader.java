package objects;

public class ProjectLeader extends TeamMember {
    private String role;

    public ProjectLeader(String name, int userID, String date, String password, int teamID) {
        super(name, userID, date, password, teamID);
        this.role = "Project Leader";

    }

    public String getRole() { return role; }

    public void setRole(String role) {
        this.role= "Project Leader";
    }
    @Override
    public String toString() {
        return "Username: " + getName() + " Team: " + getTeamID()  + " Role: " + role;
    }

}

