import menus.Print;
import utilities.Input;

public class Controller {
    Main main;

    public static void controllerMenu() {
        int choice;
        Print.print(Print.CONTROLLER_MENU);

        do {
            choice = Input.fetchInputInt();
            if (choice == 0 || choice < 1 || choice > 3) {
                Print.print(Print.ERROR_INPUT);
            }
        } while (choice < 1 || choice > 3);

        switch (choice) {
            case 1 -> runProjectController();
            case 2 -> runUserController();
            case 3 -> runTeamController();

        }
    }

    public static void runProjectController(){
       int choice;
        Print.print(Print.PROJECT_MENU);

       do{
            choice = Input.fetchInputInt();
            if(choice == 0 || choice < 1 || choice > 5 ){
                Print.print(Print.ERROR_INPUT);
            }
       }while(choice < 1 || choice > 5 );


           switch (choice){
               case 1 -> ProjectController.createProject();
               case 2 -> ProjectController.openProject();
               case 3 -> ProjectController.saveProject();
               case 4 -> ProjectController.deleteProject("");
               case 5 -> controllerMenu();

           }


   }

    public static void runUserController(){
        int choice;
        Print.print(Print.USER_MENU);

        do{
            choice = Input.fetchInputInt();
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
    public static void runProjectLeaderController(){
        int choice;
        Print.print(Print.PROJECT_LEADER_MENU);

        do{
            choice = Input.fetchInputInt();
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
            choice = Input.fetchInputInt();
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
    private Project project = new Project();
    
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
}


