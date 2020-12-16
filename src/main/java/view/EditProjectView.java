package view;

import controllers.ProjectController;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
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
        project = ProjectController.getCurrentProject();
        projectName.setText(project.getName());
        projectInformationView.getItems().addAll(project.daysLeft(),project.getName(),project.getTeamList(), project.getProjectDescription());
    }

    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,
                "Projects.Page.fxml");
    }

    public void openBacklog(ActionEvent actionEvent){
        new ChangeScene().changeScene(actionEvent,
                "Project.BackLog.Page.fxml");

    }
    public void editTeam(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,
                "Add.Team.Page.fxml");

        //project.setTeam();
    }
}
