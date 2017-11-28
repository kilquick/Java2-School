// Name        : Tyler S.  Zoucha
// Class       : 1620-002
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

// This hourly employee class inherits from employee and sets up a basic hourly employee
import java.util.Scanner;

public class HourlyEmployee extends Employee {
	private double wage;		// Creates private double wage
	private double hoursWorked;	// Creates private double hoursWorked

    // Method Name:		HourlyEmployee (Constructor)
    // Paramaters:		fn and ln, both Strings; m and g, both chars; empNum, int; ft, boolean; wage, double
    // Return values:	None
    // Partners:		None
    // Description:		Constructor that calls super data members, initializes hourWorked
	//					And sets private class variable wage to wage
	public HourlyEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double wage){
		super(fn, ln, m, g, empNum, ft);
		hoursWorked = 0.0;
		this.wage = wage;
	}
	
    // Method Name:    increaseHoursWorked
    // Parameters:     hours, double
    // Return values:  None
    // Partners:       None
    // Description:    Increased the hours worked	
	public void increaseHours(double hours){
		// If/else that checks if hours are negative and changes hours worked
		if (hours >= 0){
			hoursWorked += hours;
		}
		else{
			System.out.println("\nYou need to enter a positive number.");
		} // End if/else
	}
	
    // Method Name:     toString
    // Parameters:      None
    // Return Values:   String format, String
    // Partners:        None
    // Description:     Returns string format of hourly employee
	@Override
	public String toString(){
		return String.format("%s\nWage: %.2f\nHours Worked: %.2f\n", super.toString(), wage, hoursWorked);
	}
	
    // Method Name:     calculateWeeklyPay
    // Parameters:      None
    // Return Values:   weekly pay, double
    // Partners:        None
    // Description:     Caclulates weekly pay
	public double calculateWeeklyPay(){
		double overtimeHours = 0.0;
        double weeklyPay = 0.0;
        double overtimeWage = 2 * wage;

        // If/else accounts for appropriate overtime
        if (hoursWorked > 40){
            overtimeHours = hoursWorked - 40;
            weeklyPay = (wage * 40) + (overtimeWage * overtimeHours);
        }
        else{
            weeklyPay = wage * hoursWorked;
        }

        return weeklyPay;
	}
	
    // Method Name:     annualRaise
    // Parameters:      None
    // Return Values:   None
    // Partners:        None
    // Description:     Calculates annual raise	
	public void annualRaise(){
		wage += wage * 0.05;
	}
	
    // Method Name:     holidayBonus
    // Parameters:      None
    // Return Values:   holiday bonus, double
    // Partners:        None
    // Description:     returns holiday bonus	
	public double holidayBonus(){
		return 40 * wage;
	}

    // Method Name:     resetWeek
    // Parameters:      None
    // Return Values:   none
    // Partners:        None
    // Description:     resets hours worked to 0.0
	public void resetWeek(){
		hoursWorked = 0.0;
	}

}
