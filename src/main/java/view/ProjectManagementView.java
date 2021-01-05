package view;

import controllers.ProjectController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import objects.ProjectObjects.Activity;
import objects.ProjectObjects.Milestone;
import objects.ProjectObjects.Risk;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectManagementView implements Initializable {
    public ListView<Milestone> mileStones;
    ObservableList<Milestone> milestoneList;
    public ListView<Risk> risks;
    ObservableList<Risk> risksList;
    public ListView<Activity> activities;
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
            ProjectController.getCurrentProject().getMilestones().remove(mileStones.getSelectionModel().getSelectedItem());
            mileStones.getItems().remove(mileStones.getSelectionModel().getSelectedItem());
        }
        if(activities.getSelectionModel().getSelectedItem() != null) {
            ProjectController.getCurrentProject().getActivities().remove(activities.getSelectionModel().getSelectedItem());
            activities.getItems().remove(activities.getSelectionModel().getSelectedItem());
        }
        if(risks.getSelectionModel().getSelectedItem() != null) {
            ProjectController.getCurrentProject().getRisks().remove(risks.getSelectionModel().getSelectedItem());
            risks.getItems().remove(risks.getSelectionModel().getSelectedItem());
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
