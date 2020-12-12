package ProjectPlanning;

import controllers.ProjectPlanningController;
import objects.Backlog;
import objects.ScrumBoard;
import objects.UserStory;
import utilities.Input;

import java.io.Serializable;
import java.util.ArrayList;
 public class ProjectPlanning implements Serializable, IProjectPlanning  {
    private ArrayList<Activity> activities;
    private ArrayList<Milestone> milestones;
    private ArrayList<Risk> risks;
    private ArrayList<UserStory>backlog;

    public ScrumBoard scrumBoard;

     public ProjectPlanning(){
        activities = new ArrayList<>();
        milestones = new ArrayList<>();
        risks = new ArrayList<>();
        backlog = new ArrayList<>();
    }

     public ScrumBoard getScrumBoard() {
         return scrumBoard;
     }

     public ArrayList<UserStory> getBacklog() {
         return backlog;
     }
     public int idMaker(){
         int id;
         int size;
         size=risks.size();
         if(size==0){
             id=1;
         }else {
             id = size+1;
         }
         return id;
     }

     Risk createRisk(String name){
         int id = idMaker();
         Risk risk = new Risk(name,id);
         return risk;
    }
    public void addRisk(){
        String name = Input.fetchInputString("Enter risk name: ");
        risks.add(createRisk(name));
    }
    public void riskAssesment(){
        for (Risk r: risks) {
            if(r.getSeverity()<=0){
                System.out.println(r.getName());
                r.setSeverity(Input.fetchInputInt("Enter severity of risk"));
            }
            if(r.getOccurrence()<=0){
                System.out.println(r.getName());
                r.setOccurrence(Input.fetchInputInt("Enter Occurrence of risk"));
            }
        }
    }

    public void addMilestone(){
        String name = Input.fetchInputString("Enter milestone Name: ");
        String milestoneDate = Input.fetchInputString("Enter milestoneDate: dd/MM/YYYY");
        milestones.add(new Milestone());
    }
    public void addActivity(){
        String name = Input.fetchInputString("Enter Activity name: ");
        String duration = Input.fetchInputString("Enter Activity duration: dd/MM/YYY");
        activities.add(new Activity(name, duration));
    }
    public void createGantt(){
        for (Activity a: activities) {
            System.out.println(a.getDuration());
        }
        for (Milestone m: milestones) {
            System.out.println(m.getName() + " : "+ m.getEndDate());
        }
    }
     public void addToBacklog(UserStory u){

         backlog.add(u);

     }

     public ArrayList<Risk> getRisks() {
         return risks;
     }

 }

