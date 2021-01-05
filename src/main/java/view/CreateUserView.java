package view;

import controllers.UserController;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import menus.Print;

public class CreateUserView {

    public TextField name;
    public TextField password;
    public TextField confirmPassword;
    public String userType;
    public ToggleGroup toggleGroup;
    public Label errorMessage;

    public void backToUserView (ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Users.Page.fxml");
    }

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
            if(name.getText().isEmpty() || name.getText().isBlank()){
                errorMessage.setText("Name cannot be empty or blank");
                System.out.println("Name cannot be empty or blank");
            }else if(password.getText().isEmpty() || password.getText().isBlank()){
                errorMessage.setText("Password cannot be empty or blank");
                System.out.println("Password cannot be empty or blank");
            }else if(confirmPassword.getText().isEmpty() || confirmPassword.getText().isBlank()){
                errorMessage.setText("Confirm Password cannot be empty or blank");
                System.out.println("Confirm Password cannot be empty or blank");
            }else if(password.getText().equals(confirmPassword.getText())){
                if(UserController.isValidPassword(password.getText())){
                    if (userType != null ){
                        UserController.createUser(name.getText(), password.getText(),  userType);
                        new ChangeScene().changeScene(actionEvent,"Users.Page.fxml");
                        userType = null;
                    } else{
                        noUserTypeSelected();
                    }
                }else{
                    errorMessage.setText("Passwords must be between 8-20 characters and contain at least \na uppercase character, a lowercase character and a digit");
                    System.out.println("Passwords must be between 8-20 characters and contain at least a uppercase character, a lowercase character and a digit");
                }

            }else{
                errorMessage.setText("Passwords does not match");
                System.out.println("Passwords does not match");
            }
    }

    public void noUserTypeSelected (){
        errorMessage.setText(Print.A_USERTYPE_MUST_BE_CHOSEN);
        System.out.println(Print.A_USERTYPE_MUST_BE_CHOSEN);
    }

}
