package objects;

import utilities.DateHandler;

import java.io.Serializable;
import java.time.LocalDate;

public class Activity implements Serializable {
    private String name;
    private String duration;
    private int id;
    private Milestone m;
    private LocalDate startDate;

    public Activity(String name, String duration, Milestone m) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        LocalDate endDate = m.getMilestoneDate();
        LocalDate startDate = m.getMilestoneDate().minusDays(Integer.parseInt(duration));
        return startDate;
    }

    public Milestone getMilestone() {
        return m;
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

    @Override
    public String toString() {
        return "Activity:" + name;
    }
}