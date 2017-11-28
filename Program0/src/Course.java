// Name        : Tyler S. Zoucha
// Class       : 1620-002
// Program #   : 0
// Due Date    : September 7th, 2015
//
// Honor Pledge: On my honor as a student of the University
//               of Nebraska at Omaha, I have neither given nor received
//               unauthorized help on this homework assignment.
//
// NAME: Tyler S. Zoucha
// NU ID: 405
// EMAIL: tzoucha@unomaha.edu

// Partners: None

// This part of the program prompts the user for course info and calculates the GPA per course.
// It also puts all the course info in a string

import java.util.Scanner;		// Imports scanner to allow user input

public class Course {
	private String crsId;		// Creates String called crsID
	private int crsNum;			// Creates int called crsNum
	private int crsSection;		// Creates int called crsSection
	private float crsHours;		// Creates int called crsHours
	private String crsGrade;	// Creates int called crsGrade
	
    // Method Name: 	getCrsID
    // Parameters: 		None
    // Return values: 	The course ID, a string
    // Partners: 		None
    // Description: 	Returns crsId when called
	public String getCrsId() {
		return crsId;
	}
	
    // Method Name: 	getCrsNum
    // Parameters: 		None
    // Return values: 	The course number, an int
    // Partners: 		None
    // Description: 	Returns crsNum when called 
	public int getCrsNum() {
		return crsNum;
	}
	
    // Method Name: 	getCrsSection
    // Parameters: 		None
    // Return values:	The course section, an int
    // Partners:		None
    // Description:		Returns crsSection when called
	public int getCrsSection() {
		return crsSection;
	}
	
    // Method Name:		getCrsHours
    // Parameters:		None
    // Return values:	The course hours, a float
    // Partners:		None
    // Description:		Returns crsHours when called
	public float getCrsHours() {
		return crsHours;
	}
	
    // Method Name:		getCrsGrade
    // Parameters:		None
    // Return values:	The course grade, a string
    // Partners:		None
    // Description:		Returns crsGrade when called
	public String getCrsGrade() {
		return crsGrade;
	}
	
    // Method Name:		calcGradePoint
    // Parameters:		None
    // Return values:	The calculated GPA of the course, a float
    // Partners:		None
    // Description: 	Calculates the GPA of the course based on letter entered
	//             	 	I also allowed the user to enter lower case letters just in case because the program didn't ask to check for that
	public float calcGradePoint(){
		float gradePoint = 0;
		
		if (crsGrade.equals("A+") || crsGrade.equals("a+")){
			gradePoint += 4.0f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("A") || crsGrade.equals("a")){
			gradePoint += 4.0f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("A-") || crsGrade.equals("a-")){
			gradePoint += 3.67f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("B+") || crsGrade.equals("b+")){
			gradePoint += 3.33f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("B") || crsGrade.equals("b")){
			gradePoint += 3.0f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("B-") || crsGrade.equals("b-")){
			gradePoint += 2.67f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("C+") || crsGrade.equals("c+")){
			gradePoint += 2.33f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("C") || crsGrade.equals("c")){
			gradePoint += 2.0f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("C-") || crsGrade.equals("c-")){
			gradePoint += 1.67f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("D+") || crsGrade.equals("d+")){
			gradePoint += 1.33f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("D") || crsGrade.equals("d")){
			gradePoint += 1.0f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("D-") || crsGrade.equals("d-")){
			gradePoint += 0.67f;
			return gradePoint;
		}
		
		else if (crsGrade.equals("F") || crsGrade.equals("f")){
			gradePoint += 0f;
			return gradePoint;
		}
		return gradePoint;
	}
	
    // Method Name: 	inputerCourseInfo
    // Parameters: 		None
    // Return values: 	None
    // Partners: 		None
    // Description: 	Makes the user input course info and validates inputs
	public void inputCourseInfo(){
		Scanner in = new Scanner(System.in);	// Creates Scanner object
		
		System.out.print("\nEnter the Course ID: ");
		crsId = in.next();						// Stores course ID
		
		do{
			System.out.print("Enter the Course Number: ");
			crsNum = in.nextInt();				// Stores course number input
			
			if (crsNum < 1){
				System.out.print("Invalid course number input - Value must be greater than 0\n");
			}
		}while (crsNum < 1);					// Loop validates user input
		
		do{
			System.out.print("Enter the Course Section Number: ");
			crsSection = in.nextInt();
			
			if (crsSection < 0){
				System.out.print("Invalid course section number input -  Value must be great than or equal to 0\n");
			}
		}while (crsSection < 0);				// Validates user input
		
		do{
			System.out.print("Enter the Course Credit Hours: ");
			crsHours = in.nextFloat();			// Stores course hours input
			
			if (crsHours < 0){
				System.out.print("Invalid number of course hours input - Value must be greater than or equal to 0\n");
			}
		}while (crsHours < 0);					// Validates user input
		
		System.out.print("Enter the Course Letter Grade: ");
		crsGrade = in.next();					// Stores course grade input
	}
	
	// Method Name:		toString
	// Parameters:		None
	// Return values:	All the course info, a string
	// Partners:		None
	// Description:		Returns all the course info in a string
	public String toString(){
		return "Course: " + getCrsId() + " " + getCrsNum() + "-00" + getCrsSection() + " Hours: " + getCrsHours() + " Grade Earned: " + getCrsGrade();
	}
}
