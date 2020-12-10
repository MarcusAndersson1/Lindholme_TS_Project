package view;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.CheckBox;


import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class LogInView {
    public Button signInButton;
    public PasswordField passwordField;
    public TextField usernameField;
    public Button quitButton;
    public CheckBox rememberMe;

    public void signIn(ActionEvent event){
        usernameField.setText("holaa");
        System.out.println(rememberMe.isSelected());
    }


}
