package view;

import controllers.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.CheckBox;


import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import menus.Print;

public class LogInView {
    public Button signInButton;
    public PasswordField passwordField;
    public TextField usernameField;
    public Button quitButton;
    public CheckBox rememberMe;

    public void signIn(ActionEvent event){
            try{
                int id = Integer.parseInt(usernameField.getText());
                if(!Controller.checkUserID(id)){

                }else {
                    new ChangeScene().changeScene(event, "MainMenu.Page.fxml");
                }
            }catch (Exception e){
                System.out.println(Print.ERROR_INPUT);
            }



    }


}
