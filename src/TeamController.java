import utilities.Input;

import java.util.HashMap;

public class TeamController {

    private static final HashMap<Integer, Team> teamStorage = new HashMap();

    String name= Input.fetchInputString("Type name");
    Team team = new Team(name);

    void ManageTeam(){
        this.team= team;
        team.viewTeam();

    }

    public static void addToTeamStorage (Integer integer, Team team ){
        teamStorage.put(integer, team);
    }

    public static void removeFromTeamStorage (Integer integer){
        teamStorage.remove(integer);
    }

    public static void printTeamStorage(){
        String content = teamStorage.toString();
        System.out.println(content);
    }

}
