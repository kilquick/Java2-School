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

// This salary employee class inherits from employee and creates a basic salary employee
import java.util.Scanner;

public class SalaryEmployee extends Employee {
	private double salary;	// Creates private double salary
	
    // Method Name:    SalaryEmployee (Constructor)
    // Paramaters:     fn and ln, both Strings; m and g, both chars; empNum, int; ft, boolean; salary, double
    // Return values:  None
    // Partners:       None
    // Description:    Constructor that calls super data members
	//                 And sets private class data member salary to salary
	public SalaryEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double salary){
		super(fn, ln, m, g, empNum, ft);
		this.salary = salary;
	}
	
	@Override
	public String toString(){
		return String.format("%s\nSalary: %.2f\n", super.toString(), salary);
	}
	
    // Method Name:     calculateWeeklyPay
    // Parameters:      None
    // Return Values:   weekly pay, double
    // Partners:        None
    // Description:     Caclulates weekly pay
	public double calculateWeeklyPay(){
		double weeklyPay = 0;

        weeklyPay = salary / 52;

        return weeklyPay;
	}
	
    // Method Name:     annualRaise
    // Parameters:      None
    // Return Values:   None
    // Partners:        None
    // Description:     Calculates annual Raise
	public void annualRaise(){
		salary += salary * 0.06;
	}
	
    // Method Name:     holidayBonus
    // Parameters:      None
    // Return Values:   holiday bonus, double
    // Partners:        None
    // Description:     returns holiday bonus
	public double holidayBonus(){
		return salary * 0.03;
	}
	
    // Method Name:     resetWeek
    // Parameters:      None
    // Return Values:   none
    // Partners:        None
    // Description:     Does nothing for salary employee
	public void resetWeek(){
	}

}
