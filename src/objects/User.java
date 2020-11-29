package objects;

import java.io.Serializable;

public class User implements Serializable{
    private String name;
    private int iD;
    private String createdDate;


    public User(String name,int iD, String date){
        this.name = name;
        this.iD = iD;
        this.createdDate = date;
    }


    public int getID() {
        return iD;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return getID() + ", " + getName();
    }


    public String getCreatedDate() {
        return createdDate;
    }
}
