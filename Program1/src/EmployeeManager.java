// Name        : Tyler S.  Zoucha
// Class       : 1620-001
// Program #   : 1
// Due Date    : February 6, 2013
//
// Honor Pledge: On my honor as a student of the University
//               of Nebraska at Omaha, I have neither given nor received
//               unauthorized help on this homework assignment.
//
// NAME: Tyler S. Zoucha
// NU ID: 405
// EMAIL: tzoucha@unomaha.edu

// Partners: None

// This manager employee manages employees and creates a basic manager employee
import java.util.Scanner;


public class EmployeeManager {
	private Employee[] employees;			// Creates private array of type Employee named employees
	private final int employeeMax = 100;	// Creates private final in employeeMax set to 100
	private int currentEmployees;			// Creates private int currentEmployees
	
    // Method Name:    EmployeeManager (Constructor)
    // Paramaters:     None
    // Return values:  None
    // Partners:       None
    // Description:    Creates new array employees and sets the max number of indexes to employeeMax
	//				   And sets currentEmployees to 0
	public EmployeeManager(){
		employees = new Employee[employeeMax];
		currentEmployees = 0;
	}
	
    // Method Name:    addEmployee
    // Paramaters:     ln and fn, both Strings; g and m, both chars; en and type, both ints; ft, boolean; amount, double
    // Return values:  None
    // Partners:       None
    // Description:    Takes in input type and creates new employee in array corresponding to type
	//			 	   then increments currentEmployees
	public void addEmployee(int type, String fn, String ln, char m, char g, int en, boolean ft, double amount){
        // If type is 1, new HourlyEmployee is created.
        // After creation currentEmployees is incremented
		if (type == 1){
            employees[currentEmployees] = new HourlyEmployee(fn, ln, m, g, en, ft, amount);
            currentEmployees++;
        }
		//  Else if type is 2, new Salary Employee is created
		// After creation currentEmployees is incremented
        else if (type == 2){
            employees[currentEmployees] = new SalaryEmployee(fn, ln, m, g, en, ft, amount);
            currentEmployees++;
        }
		// Else if type is 3, new CommissionEmployee is created
		// After creation currentEmployees is incremented
        else if (type == 3){
            employees[currentEmployees] = new CommissionEmployee(fn, ln, m, g, en, ft, amount);
            currentEmployees++;
        }
	}
	
    // Method Name:    removeEmplyee
    // Paramaters:     index, int
    // Return values:  None
    // Partners:       None
    // Description:    Removes an employee dependent upon the index location in array
	//				   Then decrements currentEmployees
	public void removeEmployee(int index){
		// Works only if the index is greater or equal to zero
		// Iterates through current array and moves all employees left one rewriting the previous employee.
        // Then decrements currentEmployees
		if (index >= 0){
            for (int i = index; i < currentEmployees - 1; i++){
                employees[i] = employees[i+1];
            }

            currentEmployees--;
		}
	}
	

    // Method Name:    listAll
    // Paramaters:     None
    // Return values:  None
    // Partners:       None
    // Description:    Lists all current employees
	public void listAll(){
		// If there are no current employees
		if (currentEmployees == 0){
            System.out.println("There are no current employees.");
        }

		// Iterates through current Array and prints out employees
        for (int i = 0; i < currentEmployees; i++){
                System.out.println(employees[i]);
        }
	}
	
    // Method Name:    listHourly
    // Paramaters:     None
    // Return values:  None
    // Partners:       None
    // Description:    Lists the hourly employees
	public void listHourly(){
		boolean test = false;	// Flag boolean initialized to false

		// Iterates through current array,if there are hourly employees it prints them out one at a time and changes test to true
        for (int i = 0; i < currentEmployees; i++){
            if (employees[i] instanceof HourlyEmployee){
                System.out.print(employees[i] + "\n");
                test = true;
            }
        }
        
        // If test is false that means there are no hourly employees and a statement is printed
        if (test == false){
            System.out.println("There are no Hourly Employees");
        }
	}
	
    // Method Name:    listSalary
    // Paramaters:     None
    // Return values:  None
    // Partners:       None
    // Description:    Lists the salary employees
	public void listSalary(){
		boolean test = false;
		
		 // Iterates through current array,if there are salary employees it prints them out one at a time and changes test to true
        for (int i = 0; i < currentEmployees; i++){
            if (employees[i] instanceof SalaryEmployee){
                System.out.print(employees[i] + "\n");
                test = true;
            }
        }
        
        // If test is false that means there are no salary employees and a statement is printed
        if (test == false){
            System.out.println("There are no Salary Employees");
        }
	}
	
    // Method Name:    listCommission
    // Paramaters:     None
    // Return values:  None
    // Partners:       None
    // Description:    Lists the commission employees
	public void listCommission(){
		boolean test = false;
		
		// Iterates through current array,if there are commission employees it prints them out one at a time and changes test to true
        for (int i = 0; i < currentEmployees; i++){
            if (employees[i] instanceof CommissionEmployee){
                System.out.print(employees[i] + "\n");
                test = true;
            }
        }
        
        // If test is false that means there are no commission employees and a statement is printed
        if (test == false){
            System.out.println("There are no Commission Employees");
        }
	}
	
    // Method Name:    resetWeek
    // Paramaters:     None
    // Return values:  None
    // Partners:       None
    // Description:    Resets the week for all employees
	public void resetWeek(){
		// Iterates through current array and calls each employee's resetWeek method
		for(int i = 0; i < currentEmployees; i++)
        {
            employees[i].resetWeek();
        }
	}
	
    // Method Name:    calculatePayout
    // Paramaters:     None
    // Return values:  payout, double
    // Partners:       None
    // Description:    Calculates total payout
	public double calculatePayout(){
		double payout = 0.0;	// Initialize payout variable to 0.0
		
		// Iterates throughout entire array and adds calls each employee's caclulateWeeklyPay method
        for (int i = 0; i < currentEmployees; i++){
            payout += employees[i].calculateWeeklyPay();
        }

        return payout;		// Returns total payout
	}
	
    // Method Name:    removeRedundancies
    // Paramaters:     None
    // Return values:  None
    // Partners:       None
    // Description:    Removes a second instance of an employee with the same employee Number of an existing employee
	public void removeRedundancies(){
        // Iterates through entire array and checks that variable with another variable that iterates through entire array.
        // If the employee numbers are equal when the indexes are not equal then the removeEmployee method is called and the second instance is removed
		for (int i = 0; i < currentEmployees; i++){
            for (int j = 0; j < currentEmployees; j++){
                if (i != j){
                    if (employees[i].equals(employees[j])){
                        removeEmployee(j);
                        System.out.print("\nError: Employee with the input employee number already exists in the system.\nNew employee not created.");
                    }
                }
            }
        }
	}
	
    // Method Name:    getIndex
    // Paramaters:     empNum, int
    // Return values:  index, int
    // Partners:       None
    // Description:    Finds the index location when empNum is entered
	public int getIndex(int empNum){
		int print = -1;		// Initializes variable that is returned to -1

		// Iterates throughout current array, if empNum entered is equal to an employees actual employee number print is equal to the index
        for (int i = 0; i < currentEmployees; i++){
            if (empNum == employees[i].getEmployeeNumber()){
                print = i;
            }
        }

        return print; //Returns index or -1
	}
	
    // Method Name:    sortNumber
    // Paramaters:     None
    // Return values:  None
    // Partners:       None
    // Description:    Sorts numbers in descending order through bubble sort
	public void sortNumber(){
		// Iterates throughout array twice and compares each object's employee number to the one next to it. And switches the location correspondingly if one's greater than the other
		for (int i = currentEmployees - 1; i > 0; i--){
            for (int j = 0; j < currentEmployees - 1; j++){
                Employee temp1 = employees[j];
                Employee temp2 = employees[j+1];
                if (employees[j].getEmployeeNumber() > employees[j+1].getEmployeeNumber()){
                    employees[j] = temp2;
                    employees[j+1] = temp1;
                }
            }
        }
	}
	
    // Method Name:    sortName
    // Paramaters:     None
    // Return values:  None
    // Partners:       None
    // Description:    Sorts names in descending order using compareTo()
	public void sortName(){
        // Iterates throughout array twice and compares each object's last name to the one next to it. And switches the location correspondingly to sort
		for (int i = currentEmployees - 1; i > 0; i--){
            for (int j = 0; j < currentEmployees - 1; j++){
                Employee temp1 = employees[j];
                Employee temp2 = employees[j+1];
                if (employees[j].getLastName().compareTo(employees[j+1].getLastName()) > 0){
                    employees[j] = temp2;
                    employees[j+1] = temp1;
                }

                // If the last names of the two objects are equal then it compares the first name and switches the location correspondingly to sort alphabetically.
                if (employees[j].getLastName().compareTo(employees[j+1].getLastName()) == 0){
                    if (employees[j].getFirstName().compareTo(employees[j+1].getFirstName()) > 0){
                        employees[j] = temp2;
                        employees[j+1] = temp1;
                    }
                }
            }
        }
	}
	
    // Method Name:    annualRaises
    // Paramaters:     None
    // Return values:  None
    // Partners:       None
    // Description:    Sets annual raises
	public void annualRaises(){
		// Iterates throughout entire array and applies each employees annual raise accordingly
		for (int i = 0; i < currentEmployees; i++)
        {
            employees[i].annualRaise();
        }
	}
	
    // Method Name:    holidayBonuses
    // Paramaters:     None
    // Return values:  bonutTotal, double
    // Partners:       None
    // Description:    Calculates total holiday bonuses
	public double holidayBonuses(){
		double bonus = 0.0; 		// double bonus set to 0.0
		double bonusTotal = 0.0;	// double bonusTotal set to 0.0
		
        // Iterates through array and calculates the bonus for each employee and bonusTotal for all employee
        for (int i = 0; i < currentEmployees; i++){
            bonus = employees[i].holidayBonus();
            bonusTotal += employees[i].holidayBonus();
            System.out.print(employees[i].toString());			// Prints out employee info
            System.out.printf("Bonus Amount: %.2f\n\n", bonus);	// Prints out employee index bonus pay after info
        }
        return bonusTotal; // Returns total bonus payout
	}
	
    // Method Name:    increaseHours
    // Paramaters:     index, int; amount, double
    // Return values:  None
    // Partners:       None
    // Description:    Increases an hourly employees hours
	public void increaseHours(int index, double amount){
        // Sets HourlyEmployee reference of Employee equal to the hourly employee casted to the employee at index location
		HourlyEmployee Employee = (HourlyEmployee)employees[index];

        // Calls hoursWorked method sending amount to corresponding method and class 
        Employee.increaseHours(amount);
	}
	
	public void increaseSales(int index, double amount){
        // Sets CommissionEmployee reference of Employee equal to the commission employee casted to the employee at index location
		CommissionEmployee Employee = (CommissionEmployee)employees[index];

        // Calls increaseSales method sending sales to the corresponding method and class
        Employee.increaseSales(amount); 
	}
}
