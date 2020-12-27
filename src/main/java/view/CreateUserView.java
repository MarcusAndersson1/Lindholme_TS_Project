package view;

import controllers.UserController;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import menus.Print;

public class CreateUserView {

    public TextField usernameField;
    public TextField email;
    public TextField password;
    public TextField confirmPassword;
    public TextField personalPresentation;
    public String userType;
    public ToggleGroup toggleGroup;
    public Label errorMessage;

    public void backToUserView (ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Users.Page.fxml");
    }
//
    public void setUserTypeToManager(){
        this.userType = "Manager";
    }
    public void setUserTypeToDeveloper(){
        this.userType = "Developer";
    }
    public void setUserTypeToStakeholder(){
        this.userType = "Stakeholder";
    }


    public void createUser (ActionEvent actionEvent){
        if (userType != null ){
            UserController.createUser(usernameField.getText(), password.getText(), email.getText(), personalPresentation.getText(), userType);
            new ChangeScene().changeScene(actionEvent,"Users.Page.fxml");
            userType = null;
        } else{
            noUserTypeSelected();
        }
    }

    public void noUserTypeSelected (){
        errorMessage.setText(Print.A_USERTYPE_MUST_BE_CHOSEN);
        System.out.println(Print.A_USERTYPE_MUST_BE_CHOSEN);
    }

}
