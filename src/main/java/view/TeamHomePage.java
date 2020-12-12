package view;

import controllers.ProjectController;
import controllers.TeamController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import javafx.scene.text.Text;
import objects.Team;
import objects.User;
import objects.UserStory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;


import java.net.URL;
import java.util.ResourceBundle;


public class TeamHomePage implements Initializable {
    public Text teamName;
    @FXML
    ListView<User> teamListView;
    public ObservableList<User> teamList;
    @FXML
    ListView<UserStory> backlogListView;
    public ObservableList<UserStory> backLogList;
    Team t;
    String back;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        t = TeamController.getTeam();
        System.out.println(t.backlog);
        teamName.setText(t.getName());
        backLogList = FXCollections.observableArrayList(t.getBacklog());
        teamList = FXCollections.observableArrayList(t.memberList);
        backlogListView.setItems(backLogList);
        teamListView.setItems(teamList);


    }

    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "Add.Team.Page.fxml");
    }

    public void editTeam(ActionEvent actionEvent) {
    }
}
