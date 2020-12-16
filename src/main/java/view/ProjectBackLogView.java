package view;

import controllers.ProjectController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import objects.Project;
import objects.UserStory;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectBackLogView implements Initializable {
    @FXML
    public ListView<UserStory> backlogListView;
    @FXML
    public Text teamName;
    @FXML
    public TextField textBox;
    @FXML
    public TextField storyPoints;

    ObservableList<UserStory> backlogList;
    Project p;
    int storyPoint;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p= ProjectController.getCurrentProject();
        backlogList = FXCollections.observableList(ProjectController.getBacklog(p));
        backlogListView.setItems(backlogList);
    }
    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "Open-Project.Page.fxml");
    }
    public void createUserStory(ActionEvent actionEvent) {
        if(textBox.getText()!="") {
            UserStory u = ProjectController.createUserStory(textBox.getText(), p);

            if(storyPoints.getText() != ""){
                try{
                    u.setPoints(Integer.parseInt(storyPoints.getText()));
                    storyPoints.clear();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            backlogListView.getItems().add(u);

            textBox.clear();
        }

    }

    public void setValue(ActionEvent actionEvent) {
        UserStory u = backlogListView.getSelectionModel().getSelectedItem();
        if(u!=null) {
            try {
                u.setPoints(Integer.parseInt(storyPoints.getText()));
            }catch (Exception e){
                e.printStackTrace();
            }

            backlogListView.getItems().remove(u);
            backlogListView.getItems().add(u);
            storyPoints.clear();
        }
    }
}
