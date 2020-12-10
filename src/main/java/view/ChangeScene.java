package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeScene {

    public void changeScene(ActionEvent event, String nextSceneLocation)throws IOException {
        Parent nextScene = FXMLLoader.load(getClass().getResource(nextSceneLocation));
        Scene scene = new Scene(nextScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
