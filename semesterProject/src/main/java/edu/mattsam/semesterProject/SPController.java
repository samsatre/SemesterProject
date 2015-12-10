package edu.mattsam.semesterProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

public class SPController {

	static final String DB_URL = "jdbc:derby:db/Grades;create=true";
	private int id;
	Connection conn = null;
	private Statement stmt = null;
	private ArrayList<Assignment> grades = new ArrayList<Assignment>();
	private Course Science = new Course();
	private Course Language = new Course();
	private Course Math = new Course();
	private Course Computer = new Course();

	@FXML
	private Label scienceGradeDisp;
	@FXML
	private Label languageGradeDisp;
	@FXML
	private Label computerGradeDisp;
	@FXML
	private Label mathGradeDisp;

	@FXML
	private RadioButton radioQuizL;

	@FXML
	private RadioButton radioTestL;

	

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
	private TextField mathNametf;

	@FXML
	private TextField computerNametf;

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

	// @FXML
	// private Button graphButton;

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
	private Tab scienceTab;

	@FXML
	private TextField earnedComputer;

	@FXML
	private RadioButton radioHomeworkC;

	@FXML
	private RadioButton radioOtherL;

//	@FXML
//	private TextArea studentID;

	@FXML
	private StackedBarChart<String, Number> sbc;
	
	@FXML
	private Tab languageTab;

	

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
	private CategoryAxis classesAxis; 
	@FXML
	private NumberAxis averageAxis;
	
	@FXML
	public void showGraph(){
		XYChart.Series<String, Number> ScienceTest = new XYChart.Series<>();
		XYChart.Series<String, Number> ScienceQuiz = new XYChart.Series<>();
		XYChart.Series<String, Number> ScienceHomework = new XYChart.Series<>();
		XYChart.Series<String, Number> ScienceLab = new XYChart.Series<>();
		
		XYChart.Series<String, Number> ComputerTest = new XYChart.Series<>();
		XYChart.Series<String, Number> ComputerQuiz = new XYChart.Series<>();
		XYChart.Series<String, Number> ComputerHomework = new XYChart.Series<>();
		XYChart.Series<String, Number> ComputerLab = new XYChart.Series<>();
		
		XYChart.Series<String, Number> MathTest = new XYChart.Series<>();
		XYChart.Series<String, Number> MathQuiz = new XYChart.Series<>();
		XYChart.Series<String, Number> MathHomework = new XYChart.Series<>();
		XYChart.Series<String, Number> MathLab = new XYChart.Series<>();
		
		XYChart.Series<String, Number> LanguageTest = new XYChart.Series<>();
		XYChart.Series<String, Number> LanguageQuiz = new XYChart.Series<>();
		XYChart.Series<String, Number> LanguageHomework = new XYChart.Series<>();
		XYChart.Series<String, Number> LanguageLab = new XYChart.Series<>();
		
		
		final  String science = "Science";
		final  String language = "Language Arts";
		final  String computer = "Computer";
		final  String math = "Math";
		final  String homework = "Homework";
		
		classesAxis.setLabel("Classes");
		classesAxis.setCategories(
				FXCollections.<String> observableArrayList(Arrays.asList(science, language, computer, math)));
		averageAxis.setLabel("Average Score");
		
		//ScienceTest.setName("Test");
		ScienceTest.getData().add(new XYChart.Data<>(science, Science.getTestAverage()));
		ScienceLab.getData().add(new XYChart.Data<>(science, Science.getLabAverage()));
		ScienceQuiz.getData().add(new XYChart.Data<>(science,  Science.getQuizAverage()));
		ScienceHomework.getData().add(new XYChart.Data<>(science,  Science.getHomework()));
		
//		ScienceTest.setName("Lab");
		ComputerTest.getData().add(new XYChart.Data<>(computer, Computer.getTestAverage()));
		ComputerLab.getData().add(new XYChart.Data<>(computer, Computer.getLabAverage()));
		ComputerQuiz.getData().add(new XYChart.Data<>(computer, Computer.getQuizAverage()));
		ComputerHomework.getData().add(new XYChart.Data<>(computer, Computer.getHomework()));
//
//		assignment3.setName("Homework");
		MathTest.getData().add(new XYChart.Data<>(math, Math.getTestAverage()));
		MathLab.getData().add(new XYChart.Data<>(math, Math.getLabAverage()));
		MathQuiz.getData().add(new XYChart.Data<>(math, Math.getQuizAverage()));
		MathHomework.getData().add(new XYChart.Data<>(math, Math.getHomework()));
		
//		assignment4.setName("Quiz");
		LanguageTest.getData().add(new XYChart.Data<>(language, Language.getTestAverage()));
		LanguageLab.getData().add(new XYChart.Data<>(language, Language.getLabAverage()));
		LanguageQuiz.getData().add(new XYChart.Data<>(computer, Language.getQuizAverage()));
		LanguageHomework.getData().add(new XYChart.Data<>(math, Language.getHomework()));
		
		sbc.getData().addAll(ScienceTest,ScienceQuiz, ScienceLab,ScienceHomework);
		sbc.getData().addAll(ComputerTest,ComputerQuiz, ComputerLab,ComputerHomework);
		sbc.getData().addAll(MathTest,MathQuiz, MathLab,MathHomework);
		sbc.getData().addAll(LanguageTest,LanguageQuiz, LanguageLab,LanguageHomework);
	}

	@FXML
	void checkGradesButton(ActionEvent event) throws Exception {
		updateGrades();
	}

	
	
	@FXML
	void scienceSaveButton() {
		try {
			StringTokenizer tokens = new StringTokenizer(earnedScience.getText(), ",/ ");
			
			String type = assignment.getSelectedToggle().toString();
			String insertStudent = String.format("insert into semesterGrades("
					+ " class, name, type, earnedPoints, maxPoints)"
					+ " values ('Science', '%s', '%s', %f, %f)", scienceNametf
					.getText(), type.substring(type.lastIndexOf(']') + 2,
					type.length() - 1), Double.parseDouble(tokens.nextToken())
					, Double.parseDouble(tokens.nextToken()));
			stmt.execute(insertStudent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void mathSaveButton() {
		try {
			StringTokenizer tokens = new StringTokenizer(earnedMath.getText(), ",/ ");
			String type = assignment.getSelectedToggle().toString();
			String insertStudent = String.format("insert into semesterGrades("
					+ " class, name, type, earnedPoints, maxPoints)"
					+ " values ('Math', '%s', '%s', %f, %f)",

			mathNametf.getText(), type.substring(type.lastIndexOf(']') + 2,
					type.length() - 1),
					Double.parseDouble(earnedMath.getText()),

					mathNametf.getText(), type.substring(
							type.lastIndexOf(']') + 2, type.length() - 1),
							Double.parseDouble(tokens.nextToken())
							, Double.parseDouble(tokens.nextToken()));
			stmt.execute(insertStudent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	@FXML
	void languageSaveButton() {
		try {
			StringTokenizer tokens = new StringTokenizer(earnedLanguage.getText(), ",/ ");
			String type = assignment.getSelectedToggle().toString();
			String insertStudent = String.format("insert into semesterGrades("
					+ " class, name, type, earnedPoints, maxPoints)"
					+ " values ('Language', '%s', '%s', %f, %f)",

			languageNametf.getText(), type.substring(type.lastIndexOf(']') + 2,
					type.length() - 1), Double.parseDouble(earnedLanguage
					.getText()),

			languageNametf.getText(), type.substring(type.lastIndexOf(']') + 2,
					type.length() - 1), Double.parseDouble(tokens.nextToken())
					, Double.parseDouble(tokens.nextToken()));
			stmt.execute(insertStudent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void computerSaveButton() {
		try {
			StringTokenizer tokens = new StringTokenizer(earnedComputer.getText(), ",/ ");
			String type = assignment.getSelectedToggle().toString();
			String insertStudent = String.format("insert into semesterGrades("
					+ " class, name, type, earnedPoints, maxPoints)"

					+ " values ('Computer', '%s', '%s', %f, %f)",

			computerNametf.getText(), type.substring(type.lastIndexOf(']') + 2,
					type.length() - 1), Double.parseDouble(tokens.nextToken())
					, Double.parseDouble(tokens.nextToken()));
			stmt.execute(insertStudent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateGrades() throws Exception {
		Science.clearAssignments();
		Language.clearAssignments();
		Math.clearAssignments();
		Computer.clearAssignments();
		Assignment tmpAssign = null;

		ArrayList<Assignment> newGrades = new ArrayList<Assignment>();
		String select = "select ID, class, name, type, earnedPoints, maxPoints from semesterGrades";
		ResultSet results = stmt.executeQuery(select);
		while (results.next()) {
			String classe = results.getString("class");
			switch (results.getString("type")) {
			case ("Test"):
				tmpAssign = new Test(results.getString("name"),
						results.getDouble("maxPoints"),
						results.getDouble("earnedPoints"));
				break;
			case ("Homework"):
				tmpAssign = new Homework(results.getString("name"),
						results.getDouble("maxPoints"),
						results.getDouble("earnedPoints"));
				break;
			case ("Quiz"):
				tmpAssign = new Quiz(results.getString("name"),
						results.getDouble("maxPoints"),
						results.getDouble("earnedPoints"));
				break;
			case ("Lab"):
				tmpAssign = new Lab(results.getString("name"),
						results.getDouble("maxPoints"),
						results.getDouble("earnedPoints"));
				break;
			case ("Other"):
				tmpAssign = new Assignment(results.getString("name"),
						results.getDouble("maxPoints"),
						results.getDouble("earnedPoints"));
				break;
			}
// REQ #10 .addAssignment is saved to an arrayList of Assignment in the course class, but the subclasses test, homework,
//lab and other are put in this arraylist.
			if (classe.equals("Science")) {
				Science.addAssignment(tmpAssign);
			} else if (classe.equals("Language")) {
				Language.addAssignment(tmpAssign);
			} else if (classe.equals("Math")) {
				Math.addAssignment(tmpAssign);
			} else if (classe.equals("Computer")) {
				Computer.addAssignment(tmpAssign);
			} else {
				System.out
						.println("Does not have class in row. should not get here.");
				throw new Exception();
			}

		}
		scienceGradeDisp.setText(Science.getLetterGrade());
		languageGradeDisp.setText(Language.getLetterGrade());
		computerGradeDisp.setText(Computer.getLetterGrade());
		;
		mathGradeDisp.setText(Math.getLetterGrade());

	}

	@FXML
	void initialize() throws Exception {
		try {
			conn = DriverManager.getConnection(DB_URL);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		updateGrades();
	}

	
}
