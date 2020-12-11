package objects;


public class ScrumMaster extends TeamMember {
    private String role;

    public ScrumMaster(String name, int userID, String date, String password, int teamID) {
        super(name, userID, date, password, teamID);
        this.role = "Scrum Master";

    }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = "Scrum Master"; }

        @Override
        public String toString() {
            return "Username: " + getName() + " Team: " + getTeamID()  + " Role: " + role;
        }

    }
