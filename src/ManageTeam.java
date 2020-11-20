import utilities.Input;

import java.util.HashMap;

public class ManageTeam {
    HashMap<Integer,Team> teamList = new HashMap<>();
    String name= Input.fetchInputString("Type name");
    Team team = new Team(name);

    void ManageTeam(){
        this.team= team;
        team.viewTeam();
    }
    Team getTeam(Integer id){
        team = teamList.get(id);
        return team;
    }
}
