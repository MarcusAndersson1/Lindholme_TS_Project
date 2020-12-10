package objects;

import java.io.Serializable;
import java.util.ArrayList;

import ProjectPlanning.*;
import utilities.DateHandler;


public class Project implements Serializable {
    private String name;
    private int id;
    private String createdDate;
    private String endDate;
    private String lastTimeOpened;
    private ScrumBoard scrumboard;
    private Team assignedTeam;
    public ProjectPlanning projectPlanning;
    public ArrayList<Team> teamList = new ArrayList<>();
/*

    private Scanner input = new Scanner(System.in);
    private ArrayList<ToDo> toDoList = new ArrayList<>();

*/

    public Project(String name, int teamID, String startDate, String endDate) {
        this.name = name;
        this.id = teamID;
        this.createdDate = startDate;
        this.endDate = endDate;
        this.projectPlanning = new ProjectPlanning();
    }

    public void assignTeam(Team team) {
        teamList.add(team);
    }

    public void removeTeam(Team team) {
        teamList.remove(team.getTeamID());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return createdDate;
    }
    public void setLastTimeOpened(String lastTimeOpened) {
        this.lastTimeOpened = lastTimeOpened;
    }

    public Team getTeam() {
        return assignedTeam;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setTeam(Team assignedTeam) {
        this.assignedTeam = assignedTeam;
    }
    public int daysLeft(){
        int workingDays=0;
        try{
         workingDays =   DateHandler.getBusinessDaysBetween(DateHandler.getCurrentDate(),getEndDate());
        }catch(Exception e){

        }
        return workingDays;
    }

    public int getID() {
        return id;
    }


    public ScrumBoard getScrumboard() {
        return scrumboard;
    }

    @Override
    public String toString() {
        return  " id: " + id +"  Project name: " + name + " Created date: " + getCreatedDate() + " " + daysLeft() +" days to complete.";
    }
}
/*
    public void addUserStories(){
        
        System.out.println("Type your user story");
        String description = input.nextLine();
        System.out.println("Type the score of the user story");
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
                toDo.printDescription();
            }
        }

        for(int i = 0; i<6; i++){     
            cal.add(Calendar.DATE,1);
            String date = cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR);
            System.out.println(date);
            
            for(ToDo toDo : toDoList){
                if(toDo.getDate().equals(date)){
                    toDo.printDescription();
                }
            }
        }
    }

    public void addToDo(){
        
        System.out.println("Add a short description for your team to see (Example meeting at 14:00)");
        String description = input.nextLine();
        System.out.println("Type the date you want to add it to (Example 22-10-2020) ");
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
*/


