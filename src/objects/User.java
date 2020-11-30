package objects;

import java.io.Serializable;

public class User implements Serializable{


    private static String name;
    private static int iD;
    private static String createdDate;
    private static String password;
    public User(String name,int iD, String date, String password){
        this.name = name;
        this.iD = iD;
        this.createdDate = date;
        this.password = password;

    }

    public static int getID() {
        return iD;
    }

    public static String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        User.password = password;
    }


    @Override
    public String toString() {
        return "Name: " + getName() + "ID: " + getID();
    }

    public static String getCreatedDate() {
        return createdDate;
    }
}
