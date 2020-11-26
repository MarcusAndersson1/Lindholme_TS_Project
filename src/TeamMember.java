import java.util.Map;
import java.util.HashSet;
    public class TeamMember extends User {

        HashSet<Integer> ProjectsID = new HashSet<>();

        String role;
        String teamName;

        public TeamMember(int iD, String TeamName, String name, String date, String Role) {
            super(name, iD, date);

            this.teamName = teamName;
            this.role = role;
        }

        public String getTeamName() { return teamName; }

        public String getRole() { return role; }

        @Override
        public String toString() {
            return "Name: " + getTeamName() + "ID: " + getRole();
        }

}
