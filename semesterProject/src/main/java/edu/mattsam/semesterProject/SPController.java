package edu.mattsam.semesterProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SPController {

	static final String DB_URL = "jdbc:derby:db/Grades;create=true";
	private int id;
	Connection conn = null;
	private Statement stmt = null;
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
    private Tab totalsTab;

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
    private RadioButton radioHomeworkM;

    @FXML
    private TextField languageNametf;

    @FXML
    private RadioButton radioLabC;

    @FXML
    private Button saveMath;

    @FXML
    private RadioButton radioHomeworkL;

    @FXML
    private Button graphButton;

    @FXML
    private Label scienceLetterGrade;

    @FXML
    private RadioButton radioLabM;

    @FXML
    private RadioButton radioLabL;

    @FXML
    private RadioButton radioHomeworkS;

    @FXML
    private Button personalInfoSave;

    @FXML
    private Button scienceSave;

    @FXML
    private Label ComputerLetterGrade;

    @FXML
    private RadioButton radioOtherM;

    @FXML
    private Button languageSave;

    @FXML
    private Tab computerTab;

    @FXML
    private ToggleGroup assignment;

    @FXML
    private RadioButton radioLabS;

    @FXML
    private RadioButton radioOtherS;

    @FXML
    private TextField maxLanguage;

    @FXML
    private TextField maxScience;

    @FXML
    private Tab scienceTab;

    @FXML
    private TextField earnedComputer;

    @FXML
    private RadioButton radioHomeworkC;

    @FXML
    private RadioButton radioOtherL;

    @FXML
    private TextArea studentID;

    @FXML
    private Tab languageTab;

    @FXML
    private TextField maxComputer;

    @FXML
    private RadioButton radioOtherC;

    @FXML
    private RadioButton radioTestS;

    @FXML
    private Label MathLetterGrade;

    @FXML
    private RadioButton radioQuizS;

    @FXML
    private RadioButton radioTestM;

    @FXML
    void checkGradesButton(ActionEvent event) {

    }

    @FXML
    void saveScienceButton(ActionEvent event) {

    }

    @FXML
    void languageSaveButton(ActionEvent event) {

    }

    @FXML
    void computerSaveButton(ActionEvent event) {

    }

    @FXML
    void mathSaveButton(ActionEvent event) {

    }

	@FXML
	void saveSciencebtn() {
		try {
			String insertStudent = String.format(
					"insert into semesterGrades(" + " class, name, type, earnedPoints, maxPoints)"
							+ " values ('Science', '%s', '%s', %f, %f)",
					scienceNametf.getText(), scienceType.getText(), Double.parseDouble(earnedScience.getText()),
					Double.parseDouble(maxScience.getText()));
			stmt.execute(insertStudent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateGrades() throws SQLException {

		ArrayList<Assignment> newGrades = new ArrayList<Assignment>();
		String select = "select ID, class, name, type, earnedPoints, maxPoints from semesterGrades";
		ResultSet results = stmt.executeQuery(select);
		while (results.next()) {
			switch (results.getString("type")) {
			case ("Test"):
				break;
			case ("Homework"):
				break;
			case ("Quiz"):
				break;
			case ("Lab"):
				break;
			case ("Other"):
				break;
			}

		}
	}

	@FXML
	void initialize() {
		try {
			conn = DriverManager.getConnection(DB_URL);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
