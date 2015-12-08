package edu.mattsam.semesterProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	static final String DB_URL = "jdbc:derby:db/Grades;create=true";
	@Override
	public void start(Stage stage) throws Exception {
		//Load the FXML file
		Parent parent = FXMLLoader.load(getClass().getResource("SemesterProject.fxml"));
		
		//Set up a scene using the FXML file
		Scene scene = new Scene(parent);
		
		//Set up our stage using the scene
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) throws SQLException {
		
		Connection conn = DriverManager.getConnection(DB_URL);

		Statement stmt = conn.createStatement();
		
		try {
			String sqlCreateTable = "create table semesterGrades("
					+ " ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ " class VARCHAR(70),"
					+ " name VARCHAR(70),"
					+ " type VARCHAR(70),"
					+ " earnedPoints float, "
					+ " maxPoints float, "
					+ " primary key(ID)"
					+ ")";
			
			
			stmt.execute(sqlCreateTable);
		} catch (Exception e) {
			//table already exists
		}
		
		try {
			String sqlStatement = "SELECT * FROM semesterGrades";
			ResultSet result = stmt.executeQuery(sqlStatement);
			while (result.next()){
				System.out.println(result.getString("name") + " " +result.getString("class") + " " +result.getString("type"));
				
			}
		}catch (Exception e){
			System.out.println("The data could not print correctly.");
			e.printStackTrace();
		}
		
		
		conn.close();
		launch(args);
	}

}