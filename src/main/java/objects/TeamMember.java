package objects;


public class TeamMember extends User {
    private int teamID;

    public TeamMember(String name, int userID, String date, String password, int teamID) {
        super(name, userID, date, "password123","", "");
        this.teamID = teamID;

    }

    public int getTeamID() { return teamID; }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    @Override
    public String toString() {
        return "Username: " + getName() + " Team: " + getTeamID() ;
    }

}