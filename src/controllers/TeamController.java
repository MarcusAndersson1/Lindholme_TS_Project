package controllers;

import controllers.Controller;
import menus.Print;
import objects.Team;
import objects.User;
import utilities.Input;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TeamController {

    private static int teamID;
    private static Team team;
    private static final HashMap<Integer, Team> teamStorage = new HashMap();

/*
    public static void addToTeamStorage (Integer integer, objects.Team team ){
        teamStorage.put(integer, team);
    }

    public static void removeFromTeamStorage (Integer integer){
        teamStorage.remove(integer);
    }

 */

    public static void createTeam() {
        String name = Input.fetchInputString(Print.ENTER_TEAM_NAME);
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
        teamID++;
        team = new Team(name, teamID, currentDateTime);
        teamStorage.put(teamID, team);

        printTeamStorage();

        Controller.runTeamController();
    }

    public static void openTeam() {
        printTeamStorage();

        Controller.runTeamController();
    }

    public static void saveTeam() {

        Controller.runTeamController();
    }

    public static void deleteTeam(String s) {
        int check;
        if (teamStorage.isEmpty()) {
            System.out.println(Print.THE_LIST_IS_EMPTY);
        } else {
            do {
                try {
                    s = Input.fetchInputString(Print.TYPE_ID);
                } catch (Exception e) {
                    check = 1;
                }
                check = 0;
            } while (check == 1);

            if (teamStorage.containsKey(Integer.parseInt(s))) {
                System.out.println("The team with ID " + s + " has been deleted");
                teamStorage.remove(Integer.parseInt(s));
            } else {
                System.out.println(Print.ERROR_INPUT);
            }
        }

        Controller.runTeamController();
    }

    public static void printTeamStorage() {

        if (teamStorage.isEmpty()) {
            System.out.println(Print.THE_LIST_IS_EMPTY);
        }else{
            for(Map.Entry<Integer, Team> entry: teamStorage.entrySet()){
                System.out.println(entry.getValue());
            }
        }
    }

    public static void addTeamMember(User teamMember) {
        team.addTeamMember(teamMember);

    }


}
