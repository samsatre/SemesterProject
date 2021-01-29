package edu.mattsam.semesterProject;
import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;



public class StackedBarChartSample extends Application {
	
	

	final static String science = "Science";
	final static String language = "Language Arts";
	final static String computer = "Computer";
	final static String math = "Math";
	final static String homework = "Homework";
	final CategoryAxis xAxis = new CategoryAxis();
	final NumberAxis yAxis = new NumberAxis();
	final StackedBarChart<String, Number> sbc = new StackedBarChart<>(xAxis, yAxis);
	final XYChart.Series<String, Number> assignment1 = new XYChart.Series<>();
	final XYChart.Series<String, Number> assignment2 = new XYChart.Series<>();
	final XYChart.Series<String, Number> assignment3 = new XYChart.Series<>();
	final XYChart.Series<String, Number> assignment4 = new XYChart.Series<>();

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {
		stage.setTitle("Student Grades");
		sbc.setTitle("Average Scores");
		xAxis.setLabel("Classes");
		xAxis.setCategories(
				FXCollections.<String> observableArrayList(Arrays.asList(science, language, computer, math)));
		yAxis.setLabel("Average Score");

		// Formulate a math equation to take all the data sets and average them
		// to figure the total
		// percentage points for each section---> this will ensure that they are
		// not higher than 100
		// The following data values are simply hard coded in and need to be
		// formulated with the equation.

		assignment1.setName("Test");
		assignment1.getData().add(new XYChart.Data<>(science, 67.34));
		assignment1.getData().add(new XYChart.Data<>(language, 97.82));
		assignment1.getData().add(new XYChart.Data<>(computer, 55.6));
		assignment1.getData().add(new XYChart.Data<>(math, 78.6));

		assignment2.setName("Quiz");
		assignment2.getData().add(new XYChart.Data<>(science, 34.85));
		assignment2.getData().add(new XYChart.Data<>(language, 54.19));
		assignment2.getData().add(new XYChart.Data<>(computer, 65.37));
		assignment2.getData().add(new XYChart.Data<>(math, 23.16));

		assignment3.setName("Lab");
		assignment3.getData().add(new XYChart.Data<>(science, 45.65));
		assignment3.getData().add(new XYChart.Data<>(language, 44.76));
		assignment3.getData().add(new XYChart.Data<>(computer, 18.18));
		assignment3.getData().add(new XYChart.Data<>(math, 17.31));

		assignment4.setName("Homework");
		assignment4.getData().add(new XYChart.Data<>(science, 60.65));
		assignment4.getData().add(new XYChart.Data<>(language, 76.76));
		assignment4.getData().add(new XYChart.Data<>(computer, 90.18));
		assignment4.getData().add(new XYChart.Data<>(math, 45.31));

		Scene scene = new Scene(sbc, 500, 500);
		sbc.getData().addAll(assignment1, assignment2, assignment3, assignment4);
		stage.setScene(scene);
		stage.show();
	}

	
	
	public static void main(String[] args) {
		launch(args);
		
		
	}
}