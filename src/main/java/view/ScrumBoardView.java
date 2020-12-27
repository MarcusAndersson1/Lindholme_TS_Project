package view;

import controllers.ProjectController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import objects.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScrumBoardView implements Initializable {

    public ListView<UserStory> open;
    public ListView<UserStory> toDo;
    public ListView<UserStory> doing;
    public ListView<UserStory> closed;

    ObservableList<UserStory> storyList;
    ArrayList<ListView<UserStory>> a = new ArrayList<>();
    Project p;

    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "OpenProjectPage.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //storyList = FXCollections.observableArrayList(project.getUserStories());
        //storyListView.setItems(storyList);

        p = ProjectController.getCurrentProject();
        storyList = FXCollections.observableList(ProjectController.getBacklog(p));

        for (int i = 0; i < storyList.size(); i++) {

            if (storyList.get(i).getState().equals(UserStoryState.BACK_LOGG)) {
                open.getItems().add(storyList.get(i));
            } else if (storyList.get(i).getState().equals(UserStoryState.TODO)) {
                toDo.getItems().add(storyList.get(i));
            } else if (storyList.get(i).getState().equals(UserStoryState.IN_PROGRESS)) {
                doing.getItems().add(storyList.get(i));
            } else if (storyList.get(i).getState().equals(UserStoryState.DONE)) {
                closed.getItems().add(storyList.get(i));
            }
        }

        a.add(open);
        a.add(toDo);
        a.add(doing);
        a.add(closed);

    }

    public void moveRight(ActionEvent actionEvent) {

        for (ListView<UserStory> l : a) {
            UserStory u = l.getSelectionModel().getSelectedItem();
            l.getSelectionModel().select(null);

            if (open.getItems().contains(u)) {
                u.setState();
                open.getItems().remove(u);
                toDo.getItems().add(u);
            } else if (toDo.getItems().contains(u)) {
                u.setState();
                toDo.getItems().remove(u);
                doing.getItems().add(u);
            } else if (doing.getItems().contains(u)) {
                u.setState();
                u.setState();
                doing.getItems().remove(u);
                closed.getItems().add(u);

            }
        }
    }

    public void moveLeft(ActionEvent actionEvent) {
        // u = null;

        for (ListView<UserStory> l : a) {
            UserStory u = l.getSelectionModel().getSelectedItem();
            l.getSelectionModel().select(null);
            if (toDo.getItems().contains(u)) {
                u.reverseState();
                toDo.getItems().remove(u);
                open.getItems().add(u);
            } else if (doing.getItems().contains(u)) {
                u.reverseState();
                doing.getItems().remove(u);
                toDo.getItems().add(u);
            } else if (closed.getItems().contains(u)) {
                u.reverseState();
                u.reverseState();
                closed.getItems().remove(u);
                doing.getItems().add(u);
            }
        }
    }

    public void delete(ActionEvent actionEvent) {
        for (ListView<UserStory> l : a) {
           UserStory u = l.getSelectionModel().getSelectedItem();
           l.getItems().remove(u);
           ProjectController.removeUserStory(p, u);
        }
    }

    public void addStory(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "Project.BackLog.Page.fxml");
    }


}