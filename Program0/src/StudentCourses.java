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

// This part of the program creates a new student info and calls the appropriate methods needed to run the program

class StudentCourses {

	public static void main(String[] args) {
		Student theStudent = new Student();	// Creates new Student object
		theStudent.inputStudentInfo();		// Calls inputStudentInfo()
		theStudent.printStudent();			// Calls printStudent()
		theStudent.calcGPA();				// Calls calcGPA()
	}
}
