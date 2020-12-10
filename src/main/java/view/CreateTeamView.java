package view;

import controllers.UserController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import objects.User;

public class CreateTeamView {
    ObservableList<User> users;//= UserController.getUserMap.entry
    ObservableList<User> usersInTeam;
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
