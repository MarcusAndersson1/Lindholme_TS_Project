import controllers.ProjectController;
import controllers.UserController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;
import java.time.LocalDate;

public class GradleMain extends Application {

    public static void main(String[] args) {
        UserController.addTestUser();
        System.out.println(ProjectController.getProjects());
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/SignIn.Page.fxml"));

        Image icon = new Image ("/icons/LTSCP-icon.png");

        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Open Minded Cougar (LTSCP)");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        //new ChangeScene().changeScene(primaryStage,"Create-Team.Page.fxml");
    }
}
