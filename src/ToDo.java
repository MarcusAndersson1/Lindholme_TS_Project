public class ToDo {
    
    String description;
    String date;
    
    public ToDo(String description, String date){

        this.description = description;
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void printDesription(){
        System.out.println(description);
    }
}
