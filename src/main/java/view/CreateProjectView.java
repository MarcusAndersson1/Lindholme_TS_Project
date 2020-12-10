package view;

import controllers.ProjectController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utilities.DateHandler;

import java.time.LocalDate;
import java.util.Calendar;

public class CreateProjectView {
    ProjectController p;
    @FXML
    TextField projectName;
    @FXML
    DatePicker datePicker;
    @FXML
    Label label;

    public void createProject(ActionEvent actionEvent){
        p.createProject(setName(),datePicker.getValue());
        new ChangeScene().changeScene(actionEvent,"Projects.Page.fxml");
    }
    public void setDate(ActionEvent actionEvent){
     datePicker.setValue(datePicker.getValue());
    }
    public String setName() {
        String s = projectName.getText();
        return s;
    }

    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Projects.Page.fxml");
    }
}
