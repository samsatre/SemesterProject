package edu.mattsam.semesterProject;

import java.util.ArrayList;
//								 REQ #4
public class Course implements graded{

	private ArrayList<Assignment> assignmentList = new ArrayList<>();

	public void clearAssignments() {
		assignmentList.clear();
	}

	public void addAssignment(Assignment a) {
		assignmentList.add(a);
	}

	public double getPercent() {
		double totalEarned = 0;
		double totalMax = 0;
		for (Assignment a : assignmentList) {
			totalEarned += a.getEarnedP();
			totalMax += a.getMaxP();
		}
		return (totalEarned / totalMax) * 100;
	}

	public double getTestAverage() {
		double totalEarned = 0;
		double totalMax = 0;
		for (Assignment a : assignmentList) {
			if (a instanceof Test) {
				totalEarned += a.getEarnedP();
				totalMax += a.getMaxP();

			}
		}if (totalMax > 0) {
			return (totalEarned / totalMax) * 100;
		} else
			return 0;
	}

	public double getQuizAverage() {
		double totalEarned = 0;
		double totalMax = 0;
		for (Assignment a : assignmentList) {
			if (a instanceof Quiz) {
				totalEarned += a.getEarnedP();
				totalMax += a.getMaxP();

			}
		}if (totalMax > 0) {
			return (totalEarned / totalMax) * 100;
		} else
			return 0;
	}

	public double getLabAverage() {
		double totalEarned = 0;
		double totalMax = 0;
		for (Assignment a : assignmentList) {
			if (a instanceof Test) {
				totalEarned += a.getEarnedP();
				totalMax += a.getMaxP();

			}
		}
		if (totalMax > 0) {
			return (totalEarned / totalMax) * 100;
		} else
			return 0;
	}

	public double getHomework() {
		double totalEarned = 0;
		double totalMax = 0;
		for (Assignment a : assignmentList) {
			if (a instanceof Test) {
				totalEarned += a.getEarnedP();
				totalMax += a.getMaxP();

			}
		}if (totalMax > 0) {
			return (totalEarned / totalMax) * 100;
		} else
			return 0;
	}

	public String getLetterGrade() {
		double grade = getPercent();
		if (grade >= 90) {
			return "A";
		} else if (grade >= 87) {
			return "B+";
		} else if (grade >= 80) {
			return "B";
		} else if (grade >= 77) {
			return "C+";
		} else if (grade >= 70) {
			return "C";
		} else if (grade >= 60) {
			return "D";
		} else {
			return "You are a failure";
		}

	}

}
