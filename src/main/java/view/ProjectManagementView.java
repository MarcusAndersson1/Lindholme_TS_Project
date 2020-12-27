package view;

import controllers.ProjectController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.ListView;
import objects.Activity;
import objects.Milestone;
import objects.Project;
import objects.Risk;
import utilities.GraphBuilder;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectManagementView implements Initializable {
    public StackedBarChart<Number, String> ganttChart;
    public ListView mileStones;
    ObservableList<Milestone> milestoneList;
    public ListView activities;
    ObservableList<Activity> activityList;

    public void newMilestone(ActionEvent actionEvent) {
    }

    public void newRisk(ActionEvent actionEvent) {
    }

    public void newActivity(ActionEvent actionEvent) {
    }

    public void deleteItem(ActionEvent actionEvent) {
    }

    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "OpenProjectPage.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Project p = ProjectController.getCurrentProject();
        ganttChart.getData().addAll(GraphBuilder.ganttChart(p).getData());
    }
}
