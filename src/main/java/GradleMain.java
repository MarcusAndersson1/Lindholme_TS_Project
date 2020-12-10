import controllers.ProjectController;
import controllers.UserController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.time.LocalDate;

public class GradleMain extends Application {

    public static void main(String[] args) {
        UserController.addTestUser();
        ProjectController.createProject("Kuk", LocalDate.now().plusDays(1));
        ProjectController.createProject("Banan", LocalDate.now().plusDays(3));
        ProjectController.createProject("Ollon", LocalDate.now().plusDays(80));
        ProjectController.createProject("Rövsmör", LocalDate.now().plusDays(45));
        System.out.println("1");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/SignIn.Page.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        //new ChangeScene().changeScene(primaryStage,"Create-Team.Page.fxml");
    }
}
