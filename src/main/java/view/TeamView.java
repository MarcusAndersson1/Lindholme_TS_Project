package view;

import controllers.TeamController;
import javafx.event.ActionEvent;
import objects.Team;
public class TeamView {
    public void openTeam(ActionEvent actionEvent) {
        //should pass the selected team to the next page somehow
        //controllers.TeamController.setTeam(Selected team from list);
        new ChangeScene().changeScene(actionEvent, "Team.Page.fxml");
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
