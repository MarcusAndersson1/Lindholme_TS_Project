package view;

import controllers.Controller;
import controllers.UserController;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import javafx.event.ActionEvent;
import menus.Print;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInView {
    public Button signInButton;
    public PasswordField passwordField;
    public TextField usernameField;
    public Label errorMessage;
    public Button quitButton;
    public CheckBox rememberMe;


    public void signIn(ActionEvent event){
            try{
                int id = Integer.parseInt(usernameField.getText());
                if(!Controller.checkUserID(id)){errorMessage.setText("Sign In Failed");

                }else {
                    Controller.loginSuccessful(UserController.getUser(id));
                    new ChangeScene().changeScene(event, "MainMenu.Page.fxml");
                }
            }catch (Exception e){
                System.out.println(Print.ERROR_INPUT);
            }
    }
}
