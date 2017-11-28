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

// This part of the program prompts the user for student info calculates the total and average GPA and prints out the student and course info

import java.util.Scanner;		// Imports Scanner for user input

public class Student {
	final private 				// Initializes private int for max number of courses
		int MAX_COURSES = 10;
	private String studLast;	// Creates string for student last name
	private String studFirst;	// Creates string for student first name
	private int studNumber;		// Creates int for student number
	private int courseCount;	// Creates int for number of courses
	private Course courses [];	// Allocates memory array of courses
	
	// Method Name: 		Student (Constructor)
	// Parameters: 			None
	// Return value(s):		None
	// Partners: 			None
	// Description: 		Creates new array object of courses
	public Student() {
		courses = new Course[MAX_COURSES];
	}
	
    // Method Name:		inputStudentInfo
    // Parameters:		None
    // Return values:	None
    // Partners:		None
    // Description: 	Makes the user input student info and validates inputs
	public void inputStudentInfo() {
		Scanner in = new Scanner(System.in);	// Creates scanner object
		
		System.out.print("\nEnter the Student First Name: ");
		studFirst = in.next();					// Stores first name
		
		System.out.print("Enter the Student Last Name: ");
		studLast = in.next();					// Stores last name
		
		System.out.print("Enter the Student Number: ");
		studNumber = in.nextInt();				// Stores student number
		
		do{
			System.out.print("Enter the number of courses to be input (1-10): ");
			courseCount = in.nextInt();
			if (courseCount < 1 || courseCount > MAX_COURSES){
				System.out.print("Invalid number of courses input - try again\n");
			}
		} while (courseCount < 1 || courseCount > MAX_COURSES);	// Validates user input
		
		/* Creates the amount of courses entered and stores them in array of courses and calls inputCourseInfo() to input course info*/
		for(int i = 0; i < courseCount; i++){
			courses[i] = new Course(); 
			courses[i].inputCourseInfo();
		}
	}
	
	// Method Name:		calcGPA
	// Parameters:		None
	// Return values:	None
	// Partners:		None
	// Description:		Calculates average GPA
	public void calcGPA() {
		float totalCreditHours = 0.0f;	// Initializes float for total credit hours
		float totalGradePoints = 0.0f;	// Initializes float for total grade points
		float averageGradePoint;		// Creates float for average GPA
		
		/* Iterates through array of courses for each course to get total credit hours and total GPA */
		for(int i = 0; i < courseCount; i++){
			totalCreditHours += courses[i].getCrsHours();
			totalGradePoints += courses[i].getCrsHours()*courses[i].calcGradePoint();
		}
		
		averageGradePoint = totalGradePoints / totalCreditHours;	// Calculates average GPA
		
		System.out.printf("\nStudent GPA Average = %.2f\n", averageGradePoint);
		
	}
	
	// Method Name:		printStudent
	// Parameters:		None
	// Return values:	None
	// Partners:		None
	// Description:		Prints out the student info and the course info
	public void printStudent() {
		System.out.println("\nStudent Name: " + studFirst + ", " + studLast + "\nStudent ID: " + studNumber);
		
		/* Calls toString() in Course.Java and prints out course info */
		for(int i = 0; i < courseCount; i++){
			System.out.println(courses[i].toString());
		}
	}
}
