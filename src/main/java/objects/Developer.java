package objects;


public class Developer extends TeamMember {
    private String role;

    public Developer(String name, int userID, String date, String password, int teamID) {
        super(name, userID, date, password, teamID);
        this.role = "Developer";

    }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = "Developer"; }

    @Override
    public String toString() {
        return "Username: " + getName() + " Team: " + getTeamID()+ " Role: " + role;
    }

}
