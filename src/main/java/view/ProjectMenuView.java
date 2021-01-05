package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import controllers.*;

import objects.ProjectObjects.Project;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectMenuView implements Initializable  {

    public Button openProject;
    ObservableList<Project> projectList;
    @FXML
    public ListView<Project> projectListView;

    public void openProject(ActionEvent actionEvent) {
        Project p = projectListView.getSelectionModel().getSelectedItem();
        ProjectController.setCurrentProject(p);
        if(p!=null) {
            new ChangeScene().changeScene(actionEvent, "OpenProjectPage.fxml");
        }
    }
    public void newProject(ActionEvent actionEvent){
        new ChangeScene().changeScene(actionEvent,"Create-Project.Page.fxml");

    }

    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"MainMenu.Page.fxml");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("vi kom hit");
        projectList = FXCollections.observableArrayList(ProjectController.getProjects());
        projectListView.setItems(projectList);
    }


    public void removeProject(ActionEvent actionEvent) {
        Project p = projectListView.getSelectionModel().getSelectedItem();
        ProjectController.removeProject(p);
        projectList.remove(p);
    }
}
