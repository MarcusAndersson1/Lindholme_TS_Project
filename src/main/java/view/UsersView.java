package view;

import controllers.Controller;
import controllers.UserController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;

import java.awt.*;

public class UsersView {

    public void openUser(ActionEvent actionEvent){

    }
    public void newUserView(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Create-User.Page.fxml");
    }

    public void deleteUser(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"");
    }
    public void backToMainMenu (ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"MainMenu.Page.fxml");
    }
}
