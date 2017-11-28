// Name        : Tyler S.  Zouchav
// Class       : 1620-001
// Program #   : 1
// Due Date    : October 5, 2015
//
// Honor Pledge: On my honor as a student of the University
//               of Nebraska at Omaha, I have neither given nor received
//               unauthorized help on this homework assignment.
//
// NAME: Tyler S. Zoucha
// NU ID: 405
// EMAIL: tzoucha@unomaha.edu

// Partners: None

// This employee class sets up a basic employee and extends throughout all employees
import java.util.Scanner;

public abstract class Employee {
	private String firstName;		// Creates first name String
	private String lastName;		// Creates last name String
	private char middleInitial;		// Creates middle initial char
	private boolean fulltime;		// Creates boolean that checks fulltime
	private char gender;			// Creates char for gender
	private int employeeNum;		// Creates employee number int
	
	// Method Name: 	Employee (Constructor)
	// Parameters:		fn and ln, both Strings; m and g, both chars,; empNum, int; ft, boolean
	// Return values: 	None
	// Partners:		None
	// Description:		Constructor initializes private data members, sets gender, and gets
	//					employee number
	public Employee(String fn, String ln, char m, char g, int empNum, boolean ft){
		setFirstName(fn);			// Calls setFirstName method passing fn argument
		setLastName(ln);			// Calls setLastName method passing ln argument
		setMiddle(m);				// Calls setMiddle method passing m argument
		setGender(g);				// Calls setGender method passing g argument
		setEmployeeNumber(empNum);	// Calls setEmployeeNumber method passing empNum argument
		this.fulltime = ft;			// Sets private data member fulltime to ft
	}
	
	// Method Name:		getEmployeeNumber
	// Parameters:		None
	// Return values:	Employee Number, an int
	// Partners:		None
	// Description:		Returns the employee number
	public int getEmployeeNumber(){
		return employeeNum;
	}
	
	// Method Name: 	setEmployeeNumber
	// Parameters: 		empNum, int
	// Return values:	None
	// Partners:		None
	// Description:		Validates the employee number range then sets private employeeNum
	//					to empNum
	public void setEmployeeNumber(int empNum){
		Scanner in = new Scanner(System.in);	// Scanner object for user input
		
		// Do-while loop to validate user input. If input is wrong, user is notified to try again
		do{
			if (empNum < 10000 || empNum > 99999){
				System.out.print("\nEmployee number needs to be between 10000 and 99999.");
				System.out.print("\nPlease enter a new employee number:  ");
				empNum = in.nextInt();
			}
		} while (empNum < 10000 || empNum > 99999);
		
		this.employeeNum = empNum;		// Sets private employeeNum to empNum
	}
	
	// Method Name:		getFirstName
	// Parameters:		None
	// Return values:	First Name, String
	// Partners:		None
	// Description: 	Returns first name
	public String getFirstName(){
		return firstName;
	}
	
	// Method Name:		getLastName
	// Parameters:		None
	// Return Values:	Last Name, String
	// Partners:		None
	// Description:		Returns last name
	public String getLastName(){
		return lastName;
	}
	
	// Method Name:		setFirstName
	// Parameters:		fn, String
	// Return values:	None
	// Partners:		None
	// Description:		Sets private data member firstName to fn
	public void setFirstName(String fn){
		this.firstName = fn;
		
	}
	
	// Method Name:		setLastName
	// Parameters:		ln, String
	// Return values:	None
	// Partners:		None
	// Description:		Sets private data member lastName to ln
	public void setLastName(String ln){
		this.lastName = ln;
		
	}

	// Method Name:		setMiddle
	// Parameters:		m, char
	// Return values:	None
	// Partners:		None
	// Description:		Sets private data member middleIntial to m	
	public void setMiddle(char m){
		this.middleInitial = m;
	}

	// Method Name:		setGender
	// Parameters:		g, char
	// Return values:	None
	// Partners:		None
	// Description:		Sets private data member gender to g
	public void setGender(char g){
		this.gender = g;
		
		// Switch gender, if upper/lower case m/f aren't entered it defaults to F
		switch (gender){
			case 'm' : case 'M' :
				gender = 'M';
				break;
			case 'f' : case 'F' :
				gender= 'F';
				break;
			default :
				gender = 'F';
				break;
		} // End switch statement
	}

    // Method Name:    equals
    // Parameters:     e2, Object
    // Return Values:  true or false, boolean
    // Partners:       None
    // Description:    Returns boolean to compare employees
	@Override
	public boolean equals(Object e2){
		if (this.getEmployeeNumber() == ((Employee)e2).getEmployeeNumber()){
			return true;
		}
		else {
			return false;
		}
	}

    // Method Name:     toString
    // Parameters:      None
    // Return Values:   String format of employee info
    // Partners:        None
    // Description:     Checks full time or part time and returns string of employee information.	
	@Override
	public String toString(){
		// If fulltime is true then it formats a string with full time
		if (fulltime == true) {
			return String.format("%d\n%s, %s %c.\nGender: %c\nStatus: Full Time", employeeNum, lastName, firstName, middleInitial, gender);
		}
		// If fulltime is false then it prints out a string with part time
		else {
			return String.format("%d\n%s, %s %c.\nGender: %c\nStatus: Part Time", employeeNum, lastName, firstName, middleInitial, gender);
		} // End if/else
	}
	
    // Method Name:      calculateWeeklyPay
    // Parameters:       None
    // Return Values:    Weekly Pay, double
    // Partners:         None
    // Description:      Abstract method for override 	
	public abstract double calculateWeeklyPay();
	
    // Method Name:      annualRaise
    // Parameters:       None
    // Return Values:    None
    // Partners:         None
    // Description:      Abstract method for override	
	public abstract void annualRaise();
	
    // Method Name:      holidayBonus
    // Parameters:       None
    // Return values:    holiday bonus, double
    // Partners:         None
    // Description:      Abstract method for override	
	public abstract double holidayBonus();
	
    // Method Name:      resetWeek
    // Parameters:       None
    // Return Values     none
    // Partners:         None
    // Description:      Abstract method for override	
	public abstract void resetWeek();
}
