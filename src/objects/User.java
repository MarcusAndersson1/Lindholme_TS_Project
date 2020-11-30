package objects;

import java.io.Serializable;

public class User implements Serializable{


    private static String name;
    private static int iD;
    private static String createdDate;
    public User(String name,int iD, String date){
        this.name = name;
        this.iD = iD;
        this.createdDate = date;

    }

    public static int getID() {
        return iD;
    }

    public static String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Name: " + getName() + "ID: " + getID();
    }

    public static String getCreatedDate() {
        return createdDate;
    }
}
