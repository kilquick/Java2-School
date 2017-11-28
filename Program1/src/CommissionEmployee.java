// Name        : Tyler S.  Zoucha
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

// This commission employee class inherits from employee and creates a basic commission employee
import java.util.Scanner;

public class CommissionEmployee extends Employee {
	private double sales;	// Creates private double sales
	private double rate;	// Creates private double rate
	
    // Method Name:    CommissionEmployee (Constructor)
    // Paramaters:     fn and ln, both Strings; m and g, both chars; empNum, int; ft, boolean; rate, double
    // Return values:  None
    // Partners:       None
    // Description:    Constructor that calls super data members, sets private rate to rate, sets sales to 0.0
	public CommissionEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double rate){
		super(fn, ln, m, g, empNum, ft);
        sales = 0.0;
        this.rate = rate;
	}
	
    // Method Name:     increaseSales
    // Parameters:      sales, double
    // Return values:   None
    // Partners:        None
    // Description:     Increases the amount of sales
	public void increaseSales(double sales){
		if (sales >= 0){
            this.sales = sales;
        }
        else{
            System.out.println("\nSales cannot be negative!");
        }
	}
	
    // Parameters:      None
    // Return Values:   String format, String
    // Partners:        None
    // Description:     Returns string format of Commission Employee
	@Override
	public String toString(){
		return String.format("%s\nRate: %.2f\nSales: %.2f\n", super.toString(), rate, sales);
	}
	
    // Method Name:     calculateWeeklyPay
    // Parameters:      None
    // Return Values:   weekly pay, double
    // Partners:        None
    // Description:     Calculates weekly pay
	public double calculateWeeklyPay(){
		double weeklyPay = 0.0;

        weeklyPay = rate / 100 * sales;  // Since the rate is stored as a percentage, divide 100 to get accurate integer rate. Them multiply sales
        return weeklyPay;
	}
	
    // Method Name:     annualRaise
    // Parameters:      None
    // Return Values:   None
    // Partners:        None
    // Description:     Calculates annual Raise
	public void annualRaise(){
		rate += 0.02;
	}
	
    // Method Name:     holidayBonus
    // Parameters:      None
    // Return Values:   holiday bonus, double
    // Partners:        None
    // Description:     Returns holiday bonus
	public double holidayBonus(){
		double bonus = 0.0;

        return bonus;
	}
	
    // Method Name:     resetWeek
    // Parameters:      None
    // Return Values:   Noneone
    // Partners:        None
    // Description:     Resets sales to 0.0
	public void resetWeek(){
		sales = 0.0;
	}
	

}
