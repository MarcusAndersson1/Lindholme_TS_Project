package view;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class NewMessageView implements Initializable {
    public Button back;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void back(ActionEvent actionEvent) {new ChangeScene().changeScene(actionEvent, "Inbox.Page.fxml");
    }
}
