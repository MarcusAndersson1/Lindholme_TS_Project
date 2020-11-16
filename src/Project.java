import java.util.Scanner;

public class Project {

    private Backlog backlog = new Backlog();
    private Scanner input = new Scanner(System.in);
    

    public void addUserStories(){
        
        System.out.println("Type your user storie");
        String description = input.nextLine();
        System.out.println("Type the score of the user storie");
        int score = input.nextInt();
        input.nextLine();

        int id = backlog.idMaker();

        backlog.addToBacklog(description, score, id);

    }

    public void printScrumBoard(){
       backlog.printAll(); 
        
    }

    public void removeUserStories(){
        System.out.println("Please type the id of the user storie you want to remove");
        int remove = input.nextInt();
        input.nextLine();

        UserStorie storie = backlog.getUserStorieById(remove);
        
		backlog.remove(storie);

    }

    public void moveUserStorie(){

        System.out.println("Please type the id of the user storie that is ready to move to the next stage");

        int id = input.nextInt();
        input.nextLine();

        UserStorie storie = backlog.getUserStorieById(id);
        
        backlog.changeList(storie);

    }
    
    public void getTime(){
        //
    }

    public void planning(){
        //
    }

    

    public void view(){
        //
    }


}
