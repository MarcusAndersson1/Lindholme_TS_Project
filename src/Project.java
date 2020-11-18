import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Project {

    private Backlog backlog = new Backlog();
    private Scanner input = new Scanner(System.in);
    private ArrayList<ToDo> toDoList = new ArrayList<>();
    

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

    public void printCal(){
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE,0);
        String date0 = cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR);
        System.out.println(date0);
        for(ToDo toDo : toDoList){
            if(toDo.getDate().equals(date0)){
                toDo.printDesription();
            }
        }

        for(int i = 0; i<6; i++){     
            cal.add(Calendar.DATE,1);
            String date = cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR);
            System.out.println(date);
            
            for(ToDo toDo : toDoList){
                if(toDo.getDate().equals(date)){
                    toDo.printDesription();
                }
            }
        }
    }

    public void addToDo(){
        
        System.out.println("Add a short description for your team to see (Example meeting at 14:00)");
        String description = input.nextLine();
        System.out.println("Type the date you want to add it to (Exampel 22-10-2020) ");
        String date  = input.nextLine();

        ToDo toDo = new ToDo(description, date);
        toDoList.add(toDo);

    }

    public void removeToDo(){
        System.out.println("Under Construction...");
    }

    

    public void view(){
        //
    }


}
