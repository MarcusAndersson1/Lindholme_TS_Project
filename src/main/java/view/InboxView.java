package view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;
import objects.Project;

import java.net.URL;
import java.util.ResourceBundle;

public class InboxView implements Initializable {
    public Button newMessage;
    public Button unreadMessage;
    public Button sentMessage;
    public Button drafts;
    public DatePicker datePickerSentDate;
    public DatePicker datePickerReceivedDate;
    public Button deleteMessage;
    public ListView allMessages;
    ObservableList<Project> messageList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void delete(ActionEvent actionEvent) {
    }

    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "MainMenu.Page.fxml");
    }

    public void newMessage(ActionEvent actionEvent) {new ChangeScene().changeScene(actionEvent, "NewMessage.Page.fxml");
    }

    public void unreadMessage(ActionEvent actionEvent) {
    }

    public void sentMessage(ActionEvent actionEvent) {
    }

    public void drafts(ActionEvent actionEvent) {

    }

    public void allMessages(ScrollEvent scrollEvent) {

    }
}
