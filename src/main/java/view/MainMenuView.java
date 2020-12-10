package view;

import javafx.event.ActionEvent;

public class MainMenuView {
    public void openProjectView(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Projects.Page.fxml");
    }
}
