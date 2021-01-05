package view;

import controllers.TeamController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import objects.Team;
import utilities.IO;


import java.net.URL;
import java.util.ResourceBundle;

public class TeamView implements Initializable {

    public ListView<Team> teamListView;
    ObservableList<Team> teamList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IO.loadAllTeams();
        teamList = FXCollections.observableArrayList(TeamController.getTeams());
        teamListView.setItems(teamList);
    }

    public void openTeam(ActionEvent actionEvent) {
        //should pass the selected team to the next page somehow
        //controllers.TeamController.setTeam(Selected team from list);
        Team t = teamListView.getSelectionModel().getSelectedItem();
        if(t != null) {
            TeamController.setTeam(t);
            new ChangeScene().changeScene(actionEvent, "Team.Home.Page.fxml");
        }
    }

    public void newTeam(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "Create-Team.Page.fxml");
    }

    public void deleteTeam(ActionEvent actionEvent) {
        //get selected team in list then pass it to team controller
        //Team team;
        //TeamController.deleteTeam(Team team);
    }

    public void backButton(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "MainMenu.Page.fxml");
    }
}
