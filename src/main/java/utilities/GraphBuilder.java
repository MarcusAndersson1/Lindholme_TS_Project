package utilities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import jdk.jfr.Category;
import objects.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

public class GraphBuilder {

    public static XYChart.Series<String, Number> budgetReport(ObservableList<UserStory> userStories, Project p) {
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        ArrayList<LocalDate> days = new ArrayList<>();
        try {
            days = DateHandler.getBusinessDaysBetween(p.getCreatedDate(), p.getEndDate());
        } catch (Exception e) {

        }
        // days.sort(LocalDate::compareTo);
        for (LocalDate l : days) {
            int budgetUsed = 0;
            for (UserStory u : userStories) {
                if (u.getState() == UserStoryState.DONE && l.isAfter(u.getDoneDate())) {
                    //Just nu blir det inget för vi sätter inga timmar
                    budgetUsed += u.getHours();
                }
            }
            data.getData().add(new XYChart.Data<String, Number>
                    (l.format(DateHandler.format()), budgetUsed));
        }
        data.setName("Budget Used");
        return data;
    }

    public static XYChart.Series<String, Number> budgetForecast(ObservableList<UserStory> userStories, Project p) {
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        int budget = p.getBudget();
        ArrayList<LocalDate> days = new ArrayList<>();
        try {
            days = DateHandler.getBusinessDaysBetween(p.getCreatedDate(), p.getEndDate());
        } catch (Exception e) {
        }
        int b = budget / days.size();
        // days.sort(LocalDate::compareTo);
        int budgetUsed = 0;
        for (LocalDate l : days) {

            budgetUsed += b;
            data.getData().add(new XYChart.Data<String, Number>
                    (l.format(DateHandler.format()), budgetUsed));
        }
        data.setName("Budget Forecast");

        return data;
    }

    public static XYChart.Series<String, Number> burnDownChart(ObservableList<UserStory> userStories, Project p) {
        int storyPointsLeft = 0;
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        ArrayList<LocalDate> days = new ArrayList<>();
        try {
            days = DateHandler.getBusinessDaysBetween(p.getCreatedDate(), p.getEndDate());
        } catch (Exception e) {

        }
        // days.sort(LocalDate::compareTo);
        for (LocalDate l : days) {
            storyPointsLeft = 0;
            for (UserStory u : userStories) {

                //    System.out.println(l + " " + u.getCreatedDate() +" "+ u.getDoneDate());
                if (l.isAfter(u.getCreatedDate())) {
                    storyPointsLeft += u.getPoints();
                }
                if (u.getState() == UserStoryState.DONE && l.isAfter(u.getDoneDate())) {
                    storyPointsLeft -= u.getPoints();
                }
            }
            data.getData().add(new XYChart.Data<String, Number>
                    (l.format(DateHandler.format()), storyPointsLeft));
        }
        data.setName("Burn Down Chart");

        return data;
    }

    public static XYChart.Series<String, Number> burnDownForecast(ObservableList<UserStory> userStories, Project p) {
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        int storyPointsLeft = 0;
        ArrayList<LocalDate> days = new ArrayList<>();
            days = DateHandler.getBusinessDaysBetween(p.getCreatedDate(), p.getEndDate());
        for (UserStory u : userStories) {
            storyPointsLeft += u.getPoints();
        }
        int burnDown = storyPointsLeft / days.size();

        // days.sort(LocalDate::compareTo);
        for (LocalDate l : days) {
            data.getData().add(new XYChart.Data<String, Number>
                    (l.format(DateHandler.format()), storyPointsLeft));
            storyPointsLeft -= burnDown;
        }
        data.setName("Burn Down Forecast");
        return data;
    }

    public static StackedBarChart<Number, String> ganttChart(Project p) {
        CategoryAxis yAxis = new CategoryAxis();
        ArrayList<Activity> activities = p.getActivities();

        yAxis.setCategories(FXCollections.observableArrayList(Arrays.asList
                ("Africa", "America", "Asia", "Europe", "Oceania")));
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Dates");

        StackedBarChart<Number, String> stackedBarChart = new StackedBarChart<Number, String>(xAxis, yAxis);
        stackedBarChart.setTitle("Gantt");
        XYChart.Series<Number, String> series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<Number, String>());
        XYChart.Series<Number, String> series2 = new XYChart.Series<>();
        series2.getData().add(new XYChart.Data<Number, String>());

       /* for (Activity a : activities) {
            DateHandler.getBusinessDaysBetween(a.getStartDate(),a.getMilestone().getMilestoneDate());
            series1.getData().add(new XYChart.Data<Number, String>( DateHandler.getBusinessDaysBetween(a.getStartDate(),a.getMilestone().getMilestoneDate()).size(), a.getName()));
        }




        for (Activity a: activities) {
            series2.getData().add(new XYChart.Data<Number, String>(DateHandler.getBusinessDaysBetween(p.getCreatedDate(),a.getStartDate()).size(), a.getName()));
        }

        list.add(series1);
        list.add(series2);

        */
        stackedBarChart.getData().addAll(series1,series2);


        return stackedBarChart;
    }

}
