package Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangeScene {
    public void changeScene(ActionEvent event, String nextScenePath){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        try {
            Parent nextScenee = FXMLLoader.load(getClass().getResource(nextScenePath));
            Scene nextScene = new Scene(nextScenee);
            window.setScene(nextScene);
        } catch (Exception e){
            System.out.println(" File path not found ");
        }


        //getting stage information below

        window.show();

    }
}
