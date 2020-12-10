import controllers.Controller;
import controllers.ProjectController;
import controllers.UserController;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        UserController.addTestUser();
        System.out.println(ProjectController.getProjects().toString());
    }
}
