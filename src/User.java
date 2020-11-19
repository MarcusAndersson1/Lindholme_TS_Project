

public class User {
            String name;
            int ID;
    public User(){}
    public User(String name,int ID){
        this.name = name;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "ID: " + getID();
    }
}
