package ProjectPlanning;

public class Milestone {
    String name;
    String endDate;
    public  Milestone(String name, String endDate){
        this.endDate = endDate;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getEndDate() {
        return endDate;
    }
}
