package objects;

import controllers.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Set;

public abstract class User implements Serializable{


    private String name;
    private int iD;
    private String createdDate;
    private String password;
    private String email;
    private String personalPresentation;
    private int timeOutInc;
    private LocalDateTime timeOut = LocalDateTime.now();
    private Set<Integer> teamIDs;
    private HashMap<Long, Message> messageStorage = new HashMap<>();

    public User(String name,int iD, String date, String password, String email, String personalPresentation){
        this.name = name;
        this.iD = iD;
        this.email = email;
        this.personalPresentation = personalPresentation;
        this.createdDate = date;
        this.password = password;

    }


    public ObservableList<Message> getMessages() {
        return FXCollections.observableArrayList(messageStorage.values());
    }


    public Message getMessage(long messageID){
        return messageStorage.get(messageID);
    }
    public void removeMessage(long messageID) {
        messageStorage.remove(messageID);
    }
    public void addMessage(long messageID, Message message) {
        messageStorage.put(messageID, message);
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

    public User setRole(String role){
        return null;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " ID: " + getID();
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
