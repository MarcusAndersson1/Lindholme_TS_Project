package view;

import com.sun.prism.shader.AlphaOne_Color_AlphaTest_Loader;
import controllers.ProjectController;
import controllers.ProjectPlanningController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
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
    public MenuButton load;
    ObservableList<UserStory> backlogList;
    Project p;
    int storyPoint;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p= ProjectController.getProject();
        backlogList = FXCollections.observableList(ProjectController.getBacklog(p));
        backlogListView.setItems(backlogList);
    }
    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "Open-Project.Page.fxml");
    }
    public void createUserStory(ActionEvent actionEvent) {
        if(textBox!=null) {
            UserStory u = ProjectController.createUserStory(textBox.getText(), p);
            backlogListView.getItems().add(u);
            textBox.clear();
        }

    }
}
