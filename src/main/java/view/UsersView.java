package view;

import controllers.Controller;
import controllers.ProjectController;
import controllers.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import objects.Project;
import objects.User;

import java.net.URL;
import java.util.ResourceBundle;


public class UsersView implements Initializable {
    ObservableList<User> userList;
    @FXML
    public ListView<User> userListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("vi kom hit");
        userList = FXCollections.observableArrayList(UserController.getUsers());
        userListView.setItems(userList);
    }

    public void newUserView(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Create-User.Page.fxml");
    }

    public void deleteUser(ActionEvent actionEvent) {
            User user = userListView.getSelectionModel().getSelectedItem();
            UserController.deleteUser(user);
            userList.remove(user);
    }
    public void backToMainMenu (ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"MainMenu.Page.fxml");
    }
}
