package view;

import controllers.ProjectController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.*;
import objects.Project;
import objects.Risk;
import objects.UserStory;
import utilities.DateHandler;
import utilities.GraphBuilder;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardView implements Initializable {
    public LineChart burnDownChart;
    public LineChart budgetChart;
    public BarChart riskChart;

    Project project;

    public void back(ActionEvent actionEvent) {
        new ChangeScene().changeScene(actionEvent, "OpenProjectPage.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        project = ProjectController.getCurrentProject();
        ObservableList<UserStory> userStories = project.getUserStories();
        burnDownChart.getData().add(GraphBuilder.burnDownChart(userStories,project));
        burnDownChart.getData().add(GraphBuilder.burnDownForecast(userStories,project));
        burnDownChart.setLegendSide(Side.TOP);
        burnDownChart.setCreateSymbols(false);
        budgetChart.getData().add(GraphBuilder.budgetReport(userStories,project));
        budgetChart.getData().add(GraphBuilder.budgetForecast(userStories,project));
        budgetChart.setLegendSide(Side.TOP);
        budgetChart.setCreateSymbols(false);

        ObservableList<Risk> risks = ProjectController.getRisk();
        riskChart.getData().add(GraphBuilder.riskChart(risks,project));

        riskChart.setLegendSide(Side.BOTTOM);

    }
}
