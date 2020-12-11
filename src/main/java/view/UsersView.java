package view;

import controllers.Controller;
import controllers.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import objects.User;


public class UsersView {

    private static ListView<User> listView;

    public static void runUserView(){
        ObservableList<User> list = FXCollections.observableArrayList();
        list.addAll(UserController.getUser(1), UserController.getUser(2), UserController.getUser(3));
        listView = new ListView<>();
        listView.getItems().addAll(list);

    }

    public void openUser(ActionEvent actionEvent){}

    public void newUserView(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"Create-User.Page.fxml");
    }

    public void deleteUser(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"");
    }
    public void backToMainMenu (ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent,"MainMenu.Page.fxml");
    }
}
