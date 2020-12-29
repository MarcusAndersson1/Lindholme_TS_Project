package view;

import controllers.Controller;
import controllers.UserController;
import javafx.event.ActionEvent;
import utilities.IO;

public class MainMenuView {

    public void openProjectView(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Projects.Page.fxml");
    }
    public void openUsersView(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Users.Page.fxml");
    }

    public void openTeamView(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Teams.Page.fxml");
    }

    public void openScheduleView(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Schedule.Page.fxml");
    }

    public void openInboxView(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Inbox.Page.fxml");
    }

    public void signOut(ActionEvent actionEvent) {
        Controller.logOut();

        new ChangeScene().changeScene(actionEvent,"SignIn.Page.fxml");
    }
}
