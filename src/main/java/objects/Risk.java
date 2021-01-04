package objects;

import ProjectPlanning.ProjectPlanning;

public class Risk extends ProjectPlanning {
    private String name;
    private int ID;
    private int severity;
    private int occurrence;
    private int rating;
    private int impact;
    private double cost;
    public Risk(String name){
        super();
        this.name = name;
    }
    public String getName() {
            return name;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }

    public double getCost() {
        cost = (severity * occurrence * impact )/100;
        return this.cost;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Risk: "+ name + " Cost Of Risk " + getCost();
    }
}
