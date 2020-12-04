package objects;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

public class User implements Serializable{


    private String name;
    private int iD;
    private String createdDate;
    private String password;
    private int timeOutInc;
    private LocalDateTime timeOut = LocalDateTime.now();
    private Set<Integer> teamIDs;
    public User(String name,int iD, String date, String password){
        this.name = name;
        this.iD = iD;
        this.createdDate = date;
        this.password = password;

    }


    public int getID() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void addTeam(int teamID){this.teamIDs.add(teamID);}

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Name: " + getName() + " ID: " + getID() + " Passwprd: " + getPassword();
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public int getTimeOutInc() {
        return timeOutInc;
    }
    public int incTimeOut(){return this.timeOutInc++;}

    public void setTimeOutInc(int timeOutInc) {
        this.timeOutInc = timeOutInc;
    }
    public void setTimeOut(LocalDateTime timeOut){
        this.timeOut = timeOut;
    }

    public void timeOut30Minutes() {
        this.timeOut = LocalDateTime.now().plusMinutes(1);
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }
}
