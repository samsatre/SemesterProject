package edu.mattsam.semesterProject;

import java.util.ArrayList;

public class Course {

	private ArrayList<Assignment> assignmentList = new ArrayList<>();
	
	public void clearAssignments()
	{
		assignmentList.clear();
	}
	
	public void addAssignment(Assignment a)
	{
		assignmentList.add(a);
	}
	public double getGrade()
	{
		double totalEarned = 0;
		double totalMax = 0;
		for(Assignment a : assignmentList)
		{
			totalEarned += a.getEarnedP();
			totalMax += a.getMaxP();
		}
		return totalEarned/totalMax;
	}
	
	public String getLetterGrade()
	{
		double grade = getGrade();
		if(grade >=90)
		{
			return "A";
		}
		else if(grade >=87)
		{
			return "B+";
		}
		else if(grade >=80)
		{
			return "B";
		}
		else if(grade >=77)
		{
			return "C+";
		}
		else if(grade >=70)
		{
			return "C";
		}
		else if(grade >=60)
		{
			return "D";
		}
		else
		{
			return "You are a failure";
		}
		
	}
	
}
