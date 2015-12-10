package edu.mattsam.semesterProject;

import java.io.Serializable;
//	REQ #4 and  REQ #5
public class Assignment implements Serializable, graded{
	private String name;
	private double maxP;
	private double earnedP; 
	private double average;
	private double totalPoints;
	private double totalAssignments;
	public Assignment(String n, double max, double earned)
	{
		this.name = n;
		this.maxP = max;
		this.earnedP = earned;
	}
	
	public double getTotalPoints(){
		return totalPoints;
	}
	
	public void setTotalPoints(){
		
	}
	
	public double getTotalAssignments(){
		return totalAssignments;
	}
	
	public double getAverage(){
		
		return average;
	}
	
	public void setAverage(double average){
		average = totalPoints/totalAssignments;
		this.average= average;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getMaxP() {
		return maxP;
	}
	public void setMaxP(double maxP) {
		this.maxP = maxP;
	}
	
	public double getEarnedP() {
		return earnedP;
	}
	public void setEarnedP(double earnedP) {
		this.earnedP = earnedP;
	}
	
	public double getPercent()
	{
		return (earnedP)/maxP *100;
	}
	
	public String getLetterGrade()
	{
		double percent = this.getPercent();
		if(percent>= 90)
		{
			return "A";
		}
		else if(percent >=87)
		{
			return "B+";
		}
		else if(percent >=80)
		{
			return "B";
		}
		else if(percent >=77)
		{
			return "C+";
		}
		else if(percent >=70)  
		{
			return "C";
		}
		else if(percent >=67)
		{
			return "D+";
		}
		else if(percent >=60)
		{
			return "D";
		}
		else
		{
			return "F";
		}
	}
	
	
}
