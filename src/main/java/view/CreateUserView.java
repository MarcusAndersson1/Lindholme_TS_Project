package view;

import controllers.UserController;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class CreateUserView {

    public TextField usernameField;
    public TextField email;
    public TextField password;
    public TextField confirmPassword;
    public TextField personalPresentation;

    public void backToUserView (ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Users.Page.fxml");
    }

    public void createUser (ActionEvent actionEvent){
        UserController.createUser(usernameField.getText(), password.getText(), email.getText(), personalPresentation.getText());
        new ChangeScene().changeScene(actionEvent,"Users.Page.fxml");
    }

}
