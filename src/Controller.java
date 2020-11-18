import java.util.Scanner;

public class Controller {
    
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

    
}
