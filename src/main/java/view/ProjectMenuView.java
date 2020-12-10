package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import controllers.*;
import javafx.scene.text.Text;
import objects.*;
import utilities.IO;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectMenuView {
    ProjectController p ;
    @FXML
    ListView projectList;
    //ObservableList<Project> projects = FXCollections.observableArrayList() ;
    public void openProject(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Open-Project.Page.fxml");
    }
    public void newProject(ActionEvent actionEvent){
        new ChangeScene().changeScene(actionEvent,"Create-Project.Page.fxml");

    }
    public void loadProjects(ActionEvent actionEvent){
        System.out.println("Det funkade iaf");
            projectList.getItems().addAll(p.getProjects());

    }
}
