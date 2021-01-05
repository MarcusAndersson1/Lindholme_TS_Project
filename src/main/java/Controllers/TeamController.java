package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Utilities.Print;
import Objects.Team.Team;
import Objects.User.User;
import Utilities.DateHandler;
import Utilities.IO;
import Utilities.Input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TeamController {

    private static int teamID;
    private static Team team;
    public static HashMap<Integer, Team> teamStorage = new HashMap();
    private static Team currentTeam;

    /*
        public static void addToTeamStorage (Integer integer, objects.Team.Team team ){
            teamStorage.put(integer, team);
        }

        public static void removeFromTeamStorage (Integer integer){
            teamStorage.remove(integer);
        }

     */
    public static HashMap<Integer, Team> getTeamStorage() {
        return teamStorage;
    }

    public static void setTeam(Team team) {
        currentTeam = team;
    }

    public static void createTeam() {
        try {
            teamID = IO.loadTeamID();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name = Input.fetchInputString(Print.ENTER_TEAM_NAME);
        String currentDateTime = DateHandler.getCurrentDate();
        teamID++;
        team = new Team(name, teamID, currentDateTime);
        teamStorage.put(teamID, team);

        printTeamStorage();
        try {
            IO.saveTeamID(teamID);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static ObservableList<Team> getTeams() {
        return FXCollections.observableArrayList(teamStorage.values());
    }


    public static Team getTeam() {
        return team;
    }

    public static void createTeam(String name, ArrayList<User> teamMembers) { //this is used by the GUI
        teamID = IO.loadTeamID();
        String currentDateTime = DateHandler.getCurrentDate();
        teamID++;
        team = new Team(name, teamID, currentDateTime, teamMembers);
        teamStorage.put(teamID, team);
        printTeamStorage();
        currentTeam = team;
        try {
            IO.saveTeamID(teamID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void addTeam(Team t) {
        teamStorage.put(t.getTeamID(), t);
    }


    public static void deleteTeam(Team team) {
        team.getTeamID();
        teamStorage.remove(team.getTeamID());
        //should remove team from file aswell =))
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
                teamStorage.remove(Integer.parseInt(s));
                System.out.println("The team with ID " + s + " has been deleted");
            } else {
                System.out.println(Print.ERROR_INPUT);
            }
        }
    }

    public static void printTeamStorage() {

        if (teamStorage.isEmpty()) {
            System.out.println(Print.THE_LIST_IS_EMPTY);
        } else {
            for (Map.Entry<Integer, Team> entry : teamStorage.entrySet()) {
                System.out.println(entry.getValue().toString());

            }
        }
    }

    public static void addTeamMember(Team team) {
        int id;
        UserController.printUserStorage();
        System.out.println(team);
        Print.print(Print.TYPE_ID);
        id = Input.fetchInputInt("");
        if (UserController.userExists(id)) {
            team.addTeamMember(UserController.getUser(id));
        }
    }


}