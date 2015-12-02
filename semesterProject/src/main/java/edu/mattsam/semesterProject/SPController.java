package edu.mattsam.semesterProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SPController {

	static final String DB_URL = "jdbc:derby:db/Grades;create=true";
	private int id;
	Connection conn = null;
	private Statement stmt= null;
	private ArrayList<Assignment> grades = new ArrayList<Assignment>();
	
	@FXML
    private RadioButton radioQuizL;

    @FXML
    private RadioButton radioTestL;

    @FXML
    private TextField maxMath;

    @FXML
    private RadioButton radioQuizM;

    @FXML
    private TextField earnedScience;

    @FXML
    private TextField earnedMath;

    @FXML
    private TextField earnedLanguage;

    @FXML
    private RadioButton radioTestC;

    @FXML
    private TextField scienceNametf;

    @FXML
    private Button saveComputer;

    @FXML
    private Tab mathTab;

    @FXML
    private Tab personalTab;

    @FXML
    private RadioButton radioQuizC;

    @FXML
    private Label LanguangeLetterGrade;

    @FXML
    private RadioButton radioLabC;

    @FXML
    private Button saveMath;

    @FXML
    private Button saveScience;

    @FXML
    private Label scienceLetterGrade;

    @FXML
    private RadioButton radioLabM;

    @FXML
    private RadioButton radioLabL;

    @FXML
    private Button personalInfoSave;

    @FXML
    private Label ComputerLetterGrade;

    @FXML
    private TextField scienceType;

    @FXML
    private Button languageSave;

    @FXML
    private Tab computerTab;

    @FXML
    private TextField maxLanguage;

    @FXML
    private TextField maxScience;

    @FXML
    private Tab scienceTab;

    @FXML
    private TextField earnedComputer;

    @FXML
    private TextArea studentID;

    @FXML
    private RadioButton radioECL;

    @FXML
    private Tab languageTab;

    @FXML
    private TextField maxComputer;

    @FXML
    private RadioButton radioECM;

    @FXML
    private Label MathLetterGrade;

    @FXML
    private RadioButton radioTestM;

    @FXML
    void saveSciencebtn() {
    	try {
			String insertStudent = String.format("insert into semesterGrades("
    		+ " class, name, type, earnedPoints, maxPoints)"
					+ " values ('Science', '%s', '%s', %f, %f)", scienceNametf.getText(), scienceType.getText() , Double.parseDouble(earnedScience.getText()), Double.parseDouble(maxScience.getText()));
			stmt.execute(insertStudent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	
    @FXML
    void languageSavebtn() {

    }

    @FXML
    void saveComputerbtn() {

    }

    @FXML
    void saveMathbtn() {

    }
    
    public void updateGrades() throws SQLException
    {
    	
    	ArrayList<Assignment> newGrades = new ArrayList<Assignment>();
    	String select = "select ID, class, name, type, earnedPoints, maxPoints from semesterGrades";
		ResultSet results = stmt.executeQuery(select);
		while(results.next()){
			switch(results.getString("type"))
			{
			case("Test"):
				break;
			case("Homework"):
				break;
			case("Quiz"):
				break;
			case("Lab"):
				break;
			case("Other"):
				break;
			}
			
		}
    }
    
    @FXML
    void initialize()
    {
    	try {
			conn = DriverManager.getConnection(DB_URL);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
