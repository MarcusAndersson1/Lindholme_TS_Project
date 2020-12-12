package view;

import controllers.ProjectController;
import controllers.ProjectPlanningController;
import controllers.TeamController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import objects.Project;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProjectView implements Initializable {
    public ListView projectInformationView;
    public Text projectName;
    Project project;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        project = ProjectController.getProject();
        projectName.setText(project.getName());
        projectInformationView.getItems().addAll(project.daysLeft(),project.getName(),project.teamList);
    }

    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Projects.Page.fxml");
    }

    public void addTeam(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Add.Team.Page.fxml");

        //project.setTeam();
    }
}
