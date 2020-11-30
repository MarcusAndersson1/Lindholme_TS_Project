package controllers;


import menus.Print;
import objects.Project;
import objects.ProjectLeader;
import objects.ScrumMaster;
import utilities.Input;

import javax.naming.ldap.Control;

public class Controller {

    public static void logIn(){
            Print.print(Print.LOGIN_MENU_USERID);
            checkUserID();


    }

    public static void controllerMenu() {
        int choice;
        Print.print(Print.CONTROLLER_MENU);

        do {
            choice = Input.fetchInputInt("");
            if (choice == 0 || choice < 1 || choice > 4) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1 -> runProjectController();
            case 2 -> runUserController();
            case 3 -> runTeamController();
            case 4 -> logIn();

        }
    }

    public static void runProjectController(){
       int choice;
        Print.print(Print.PROJECT_MENU);

       do{
            choice = Input.fetchInputInt("");
            if(choice == 0 || choice < 1 || choice > 6 ){
                Print.print(Print.ERROR_INPUT);
            }
       }while(choice < 1 || choice > 6 );


           switch (choice){
               case 1 -> ProjectController.createProject();
               case 2 -> ProjectController.openProject();
               case 3 -> ProjectController.saveProjects();
               case 4 -> ProjectController.deleteProject("");
               case 5 -> ProjectController.loadProject();
               case 6 -> controllerMenu();
           }
   }

    public static void runUserController(){
        int choice;
        Print.print(Print.USER_MENU);

        do{
            choice = Input.fetchInputInt("");
            if(choice == 0 || choice < 1 || choice > 5 ){
                Print.print(Print.ERROR_INPUT);
            }
        }while(choice < 1 || choice > 5 );


        switch (choice){
            case 1 -> UserController.createUser();
            case 2 -> UserController.openUser();
            case 3 -> UserController.saveUser();
            case 4 -> UserController.deleteUser("");
            case 5 -> controllerMenu();

        }


    }


    public static void runTeamController(){
        int choice;
        Print.print(Print.TEAM_MENU);

        do{
            choice = Input.fetchInputInt("");
            if(choice == 0 || choice < 1 || choice > 5 ){
                Print.print(Print.ERROR_INPUT);
            }
        }while(choice < 1 || choice > 5 );


        switch (choice){
            case 1 -> TeamController.createTeam();
            case 2 -> TeamController.openTeam();
            case 3 -> TeamController.saveTeam();
            case 4 -> TeamController.deleteTeam("");
            case 5 -> controllerMenu();

        }


    }

    /*
    private Scanner input = new Scanner(System.in);
    private objects.Project project = new objects.Project();
    
    public void projectMenu(){
        
        boolean run = true;
        while(run){

        System.out.println("Press 1 for the scrum board");
        System.out.println("Press 2 for planing/scedule");
        System.out.println("Press 3 to to exit:");
         
        String menu = input.nextLine();

        switch(menu){
            case "1" -> scrumBoard();     
            case "2" -> planning();
            case "3" -> { System.out.println("Exiting...");
                        System.out.println("Done");
                        run = false;
        }
            default ->  System.out.println("Please type a number 1-4");
        }
       
    }
    }
    public void scrumBoard(){ 

        boolean run = true;
        while(run){    

        project.printScrumBoard();

        System.out.println("Press 1 for adding a user storie");
        System.out.println("Press 2 for removing a user storie");
        System.out.println("Press 3 to move user storie to next stage");
        System.out.println("Press 4 to move back to main menu");

        String menu = input.nextLine();
        
        switch(menu){
            case "1" -> project.addUserStories(); 
            case "2" -> project.removeUserStories();
            case "3" -> project.moveUserStorie();
            case "4" -> run = false;
            default -> System.out.println("Please type a number 1-4");
        }
        
    }
    }

    public void planning(){
        boolean run = true;
        while(run){    

        project.printCal();

        System.out.println("Press 1 to Add a To-Do task");
        System.out.println("Press 2 for removing a To-Do task");
        System.out.println("Press 3 to move back to main menu");

        String menu = input.nextLine();
        
        switch(menu){
            case "1" -> project.addToDo(); 
            case "2" -> project.removeToDo();
            case "3" -> run = false;
            default -> System.out.println("Please type a number 1-4");
        }
    }
    }

     */
    public static void checkUserID() {
        int userID = Input.fetchInputInt("");
        if(userID != 0){
            if((UserController.userExists(userID))){
                checkPassword(userID);


            }else{
                Print.print(Print.USER_DOES_NOT_EXIST);
                checkUserID();
            }

        } else{
            Print.print(Print.ERROR_INPUT);
            checkUserID();
        }

    }

    public static void checkPassword(int userID){
        String input = Input.fetchInputString(Print.LOGIN_MENU_PASSWORD);

        if(input.isEmpty()){
            Controller.logIn();
        }else if(UserController.getUserPassword(userID).equals(input)){
            Print.print(Print.ACCESS_GRANTED);
            Controller.controllerMenu();
        }else{
            Print.print(Print.WRONG_PASSWORD);
            checkPassword(userID);
        }

    }

}


