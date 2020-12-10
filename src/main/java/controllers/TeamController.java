package controllers;

import controllers.Controller;
import menus.Print;
import objects.Project;
import objects.Team;
import objects.User;
import utilities.DateHandler;
import utilities.IO;
import utilities.Input;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TeamController {

    private static int teamID;
    private static Team team;
    public static HashMap<Integer, Team> teamStorage = new HashMap();
/*
    public static void addToTeamStorage (Integer integer, objects.Team team ){
        teamStorage.put(integer, team);
    }

    public static void removeFromTeamStorage (Integer integer){
        teamStorage.remove(integer);
    }

 */
    public static HashMap<Integer, Team> getTeamStorage() {
    return teamStorage;
}

    public static void createTeam() {
        try {
            teamID = IO.loadTeamID();
        }catch(Exception e){
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
        }catch(Exception e){
            e.printStackTrace();
        }

        Controller.runTeamController();
    }



    public static void openTeam(){
        printTeamStorage();
        Team mTeam;
        int id;
        Print.print(Print.TYPE_ID);
        do{
            id = Input.fetchInputInt("");
            if(!teamStorage.containsKey(id)){
                Print.print(Print.ERROR_INPUT);
            }
            if(id == 0){
                Controller.runTeamController();
            }
        }while(!teamStorage.containsKey(id));
        mTeam=teamStorage.get(id);
        System.out.println(mTeam);



        int choice;
        Print.print(Print.EDIT_TEAM);

        do{
            choice = Integer.parseInt(Input.fetchInputString(""));
            if(choice == 0 ||choice < 1 || choice > 2 ){
                Print.print(Print.ERROR_INPUT);
            }
        }while(choice < 1 || choice > 2 );

        switch (choice){
            case 1 -> TeamController.addTeamMember(mTeam);
            case 2 -> Controller.runTeamController();
        }


        Controller.runTeamController();
    }

    public static void saveTeam(){
        for (Team team : teamStorage.values()){
            try{
                IO.saveTeam(team);}
            catch (IOException e){
                e.printStackTrace();
            }
        }
        Controller.runTeamController();
    }
    public static void loadTeam() {
        ArrayList<Integer> usersTeams = new ArrayList<>(); //take this list as input for the method instead
        usersTeams.add(1);
        for (Integer teamID : usersTeams){
            try{
                Team loadedTeam = IO.loadTeam(teamID);  //perhaps check if file exists
                teamStorage.put(loadedTeam.getTeamID(),loadedTeam);
            }
            catch (Exception e){ //or check what type of error is received here instead
                e.printStackTrace();
            }
        }
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
                teamStorage.remove(Integer.parseInt(s));
                System.out.println("The team with ID " + s + " has been deleted");
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
        if(UserController.userExists(id)) {
            team.addTeamMember(UserController.getUser(id));
        }
        Controller.runTeamController();
    }

}
