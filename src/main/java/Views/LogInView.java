package Views;

import Controllers.Controller;
import Controllers.UserController;
import javafx.scene.control.*;


import javafx.event.ActionEvent;

public class LogInView {
    public Button signInButton;
    public PasswordField passwordField;
    public TextField usernameField;
    public Label errorMessage;
    public Button quitButton;
    public CheckBox rememberMe;


    public void signIn(ActionEvent event){
            try{

                int userID = Integer.parseInt(usernameField.getText());
                String password = passwordField.getText();
                UserController.saveUserMap();
                if(Controller.checkUserID(userID) && Controller.checkPassword(userID, password)){
                    Controller.loginSuccessful(UserController.getUser(userID));
                    new ChangeScene().changeScene(event, "MainMenu.Page.fxml");
                }else if(Controller.timeOutChecker(userID)) {
                    errorMessage.setText("Sign In Failed: " +  Controller.getAttemptsLeft(UserController.getUser(userID)));
                    } else{
                  errorMessage.setText(Controller.getLockedOutTime(UserController.getUser(userID)));
                }


            }catch (Exception e){
                errorMessage.setText("User does not exist");
                System.out.println("User does not exist");
            }
    }
}
