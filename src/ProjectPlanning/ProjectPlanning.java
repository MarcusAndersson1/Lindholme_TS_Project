package ProjectPlanning;

import utilities.Input;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectPlanning implements Serializable {
    private String startDate;
    private String endDate;
    private ArrayList<Activity> activities = new ArrayList<>();
    private ArrayList<Milestone> milestones = new ArrayList<>();

    public ProjectPlanning(String startDate, String endDate){
        this.startDate = startDate;
        this.endDate=endDate;
    }

    public void addMilestone(){
        String name = Input.fetchInputString("Enter milestone Name: ");
        String milestoneDate = Input.fetchInputString("Enter milestoneDate: dd/MM/YYYY");
        milestones.add(new Milestone(name, milestoneDate));
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
}

