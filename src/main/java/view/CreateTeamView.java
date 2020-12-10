package view;

import controllers.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import objects.User;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateTeamView implements Initializable {
    public ListView<User> usersInTeamListView;
    public ListView<User> usersListView;
    ObservableList<User> userList;
    ObservableList<User> userIntTeamList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userList = FXCollections.observableArrayList(UserController.getUsers());
        usersListView.setItems(userList);
        usersInTeamListView.setItems(userIntTeamList);
        System.out.println("end");
    }


    public void backButton(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "Teams.Page.fxml");
    }


    public void removeSelectedFromTeam(ActionEvent actionEvent) {
    }


    public void moveSelectedToTeam(ActionEvent actionEvent) {
    }


    public void createTeam(ActionEvent actionEvent) {
    }
}
