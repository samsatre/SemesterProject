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
		
		//Req #9
		Parent parent = FXMLLoader.load(getClass().getResource("SemesterProject.fxml"));
		
		//Set up a scene using the FXML file
		Scene scene = new Scene(parent);
		
		//Set up our stage using the scene
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) throws SQLException {
		//REQ#1
		System.out.println("Sam Satre and Matt Vanderveer");
		Connection conn = DriverManager.getConnection(DB_URL);

		Statement stmt = conn.createStatement();
		
//		try {
//			String dropTable = "drop table semesterGrades";
//			stmt.execute(dropTable);
//			System.out.println("Semester Grades table dropped.");
//		} catch (SQLException e) {
//			System.out.println("Semester Grades table does not exist.");
//			e.printStackTrace();
//		}
		
		
		//REQ#7
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
		
		//REQ #8
		try {
			String sqlStatement = "SELECT * FROM semesterGrades";
			ResultSet result = stmt.executeQuery(sqlStatement);
			while (result.next()){
				System.out.println(result.getString("name") + " " +result.getString("class") + " " 
			+result.getString("type") + " " + result.getString("earnedPoints")+ " " + result.getString("maxPoints"));
				
			}
			
			//REQ#11
		}catch (Exception e){
			
			System.out.println("The data could not print correctly.");
			e.printStackTrace();
		}
		
		
		conn.close();
		launch(args);
	}

}
