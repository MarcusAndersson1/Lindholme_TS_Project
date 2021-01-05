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
    public ListView mileStones;
    ObservableList<Milestone> milestoneList;
    public ListView risks;
    ObservableList<Risk> risksList;
    public ListView activities;
    ObservableList<Activity> activityList;

    public void newMilestone(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "CreateMilestonePage.fxml");
    }

    public void newRisk(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "CreateRiskPage.fxml");
    }

    public void newActivity(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "CreateActivityPage.fxml");

    }

    public void deleteItem(ActionEvent actionEvent) {
        if(mileStones.getSelectionModel().getSelectedItem() != null) {
            mileStones.getItems().remove(mileStones.getSelectionModel().getSelectedItem());
            ProjectController.getCurrentProject().getMilestones().remove(mileStones.getSelectionModel().getSelectedItem());
        }
        if(activities.getSelectionModel().getSelectedItem() != null) {
            activities.getItems().remove(activities.getSelectionModel().getSelectedItem());
            ProjectController.getCurrentProject().getActivities().remove(activities.getSelectionModel().getSelectedItem());
        }
        if(risks.getSelectionModel().getSelectedItem() != null) {
            risks.getItems().remove(risks   .getSelectionModel().getSelectedItem());
            ProjectController.getCurrentProject().getRisks().remove(risks.getSelectionModel().getSelectedItem());
        }

    }

    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "OpenProjectPage.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activityList = ProjectController.getActivities();
        activities.getItems().addAll(activityList);
        milestoneList = ProjectController.getMilestones();
        mileStones.getItems().addAll(milestoneList);
        risksList = ProjectController.getRisk();
        risks.getItems().addAll(risksList);
    }
}
