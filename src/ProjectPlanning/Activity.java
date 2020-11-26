package ProjectPlanning;

public class Activity {
    private String name;
    private String duration;
    public Activity(String name, String duration){
        this.name = name;
        this.duration= duration;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
}
