package view;

import controllers.ProjectController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import objects.ProjectObjects.Activity;
import objects.ProjectObjects.Milestone;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateActivityView implements Initializable {

    public ListView<Milestone> mileStones;
    public Spinner<Integer> duration;
    public TextField activityName;
    ObservableList<Milestone> milestoneList;

    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "ProjectDetailsView.fxml");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        milestoneList = ProjectController.getMilestones();
        mileStones.getItems().addAll(milestoneList);

    }

    public void createActivity(ActionEvent actionEvent) {
        if(!duration.getValue().toString().equals("")
                && !activityName.getText().equals("")
                && mileStones.getSelectionModel().getSelectedItem() != null){

            Activity a = ProjectController.createActivity(activityName.getText(),
                                                        Integer.parseInt(duration.getValue().toString()),
                                                        mileStones.getSelectionModel().getSelectedItem());

            activityName.clear();
        }
    }
}
