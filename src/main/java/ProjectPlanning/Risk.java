package ProjectPlanning;

public class Risk extends ProjectPlanning {
    private String name;
    private int ID;
    private int severity;
    private int occurrence;
    private int rating;
    public Risk(String name, int ID){
        super();
        this.name = name;
        this.ID = ID;
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

    public int getRating() {
        this.rating = getOccurrence() * getSeverity();
        return this.rating;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Risk: "+ name +" ID: " + getID()+ " Rating: " + getRating();
    }
}
