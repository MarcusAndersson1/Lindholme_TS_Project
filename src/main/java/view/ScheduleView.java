package view;

import javafx.event.ActionEvent;

public class ScheduleView {

    public void backToMainMenu (ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"MainMenu.Page.fxml");
    }
}
