package ProjectPlanning;

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

    public void createGantt(ArrayList<Activity> activities, ArrayList<Milestone> milestones ){
        for (Activity a: activities) {
            System.out.println(a.getDuration());
        }
        for (Milestone m: milestones) {
            System.out.println(m.getName() + " : "+ m.getEndDate());
        }
    }
}

