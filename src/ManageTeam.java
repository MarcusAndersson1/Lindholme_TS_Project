import utilities.Input;

public class ManageTeam {

    String name= Input.fetchInputString("Type name");
    Team team = new Team(name);

    void ManageTeam(){
        this.team= team;
        team.viewTeam();

    }

}
