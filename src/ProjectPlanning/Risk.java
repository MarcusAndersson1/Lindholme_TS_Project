package ProjectPlanning;

public class Risk extends ProjectPlanning {
    private String name;
    private int ID;
    private int severity;
    private int occurrence;
    private int rating;
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

    public int getRating() {
        this.rating = getOccurrence() * getSeverity();
        return this.rating;
    }
}
