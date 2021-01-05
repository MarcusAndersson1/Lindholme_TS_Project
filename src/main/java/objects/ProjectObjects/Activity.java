package objects.ProjectObjects;

import objects.ProjectObjects.Milestone;
import utilities.DateHandler;

import java.io.Serializable;
import java.time.LocalDate;

public class Activity implements Serializable {
    private String name;
    private int duration;
    private Milestone m;
    private LocalDate startDate;

    public Activity(String name, int duration, Milestone m) {
        this.name = name;
        this.duration = duration;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        LocalDate startDate = m.getMilestoneDate().minusDays(duration);
        return startDate;
    }

    public Milestone getMilestone() {
        return m;
    }

    public int getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return getName() + " " + getStartDate().format(DateHandler.format());
    }
}