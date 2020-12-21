package utilities;

import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import objects.Project;
import objects.UserStory;
import objects.UserStoryState;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

public class GraphBuilder {



    public static XYChart.Series<String, Number> burnDownChart(ObservableList<UserStory> userStories, Project p){
        int storyPointsLeft=0;
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        ArrayList<LocalDate> days = new ArrayList<>();
        for (UserStory u : userStories) {
            if (!days.contains(u.getCreatedDate())) {
                    days.add(u.getCreatedDate());

            }
            if (u.getState()==UserStoryState.DONE && !days.contains(u.getDoneDate())) {
                days.add(u.getDoneDate());
            }
            storyPointsLeft= storyPointsLeft + u.getPoints();

        }
        data.getData().add(new XYChart.Data<String, Number>
                (p.getCreatedDate().format(DateHandler.format()), storyPointsLeft));
        days.sort(LocalDate::compareTo);
        for (LocalDate l: days ) {
            for (UserStory u : userStories) {
               //if(l == u.getCreatedDate()){
              //     storyPointsLeft = storyPointsLeft + u.getPoints();
              // }
               if ( u.getState()==UserStoryState.DONE && u.getDoneDate() == l) {
                     storyPointsLeft = storyPointsLeft - u.getPoints();
               }
            }
            System.out.println(storyPointsLeft);
            data.getData().add(new XYChart.Data<String, Number>
                    (l.format(DateHandler.format()), storyPointsLeft));
         }
        return data;
    }
}
