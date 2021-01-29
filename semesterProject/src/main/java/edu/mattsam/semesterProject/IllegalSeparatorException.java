package edu.mattsam.semesterProject;
//REQ #12
public class IllegalSeparatorException extends Exception{

	public IllegalSeparatorException(){
		super(String.format("Please use a comma or forward slash to separate the "
				+ "earned and maximum points." ));
	}
	
}
