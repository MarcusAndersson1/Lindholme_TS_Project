package sample.hallå;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public PasswordField pangpang;
    public TextField username;
    public Text redText;
    public Slider dragger;
    String password;
    String name;

    public boolean checkPassword(String password, String Name){
        if (name == "åke"&& password == "password123123"){
            return true;
        }
        else{
            return false;
        }
    }
    public void dragCheckValue(ActionEvent event){
        double i = dragger.getValue();
        System.out.println(i);
        dragger.setValue(0);
    }
    public void changeScene(ActionEvent event)throws IOException{
        Parent nextScenee = FXMLLoader.load(getClass().getResource("nextscene.fxml"));
        Scene nextScene = new Scene(nextScenee);
        //getting stage information below
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void checkPassword(ActionEvent actionEvent) {
        String uggo = pangpang.getText();
        String uggo2 = username.getText();
        if (uggo.toLowerCase().equals("a")){
            username.setText("zONGO");
            redText.setText("");
        }
        else redText.setText("invalido");
    }
}
