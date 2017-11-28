// Name        : Tyler S.  Zoucha
// Class       : 1620-002
// Program #   : Program 5
// Due Date    : 11/16/2015
//
// Honor Pledge: On my honor as a student of the University
//               of Nebraska at Omaha, I have neither given nor received
//               unauthorized help on this homework assignment.
//
// NAME: Tyler S. Zoucha
// NU ID: 405
// EMAIL: tzoucha@unomaha.edu

// Partners: NONE

// This is the InfixtoPostfix class. It converts each infix expression to postfix.

import java.util.Scanner;
import ListPkg.Stack;
import ExceptionPkg.EmptyListException;

public class InfixToPostfix {
	
	// Method Name: 	convertToPostfix
    // Parameters : 	NONE
    // Return values: 	StringBuffer
    // Partners: 		NONE
    // Description: 	Converts the expression given to PostFix
	public StringBuffer convertToPostfix() {
		Stack<Character> myStack = new Stack<Character>();
		StringBuffer postfix = new StringBuffer();
		boolean check = true;
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter an expression in infix notation for evaluation\n");
		String myString = input.nextLine();
		StringBuffer strBuffer = new StringBuffer(myString);

		myStack.push('(');
		strBuffer.append(')');;
		
		int pos = 0;
		
		while (pos != strBuffer.length() && check == true) {
			char value = strBuffer.charAt(pos);
			if (Character.isDigit(value)) {
				postfix.append(value);
				postfix.append(' ');
			} else if (value == ' ') {
					// do nothing
			} else if (value == '(') {
				myStack.push(value);
			} else if (value == ')') {
				while (!myStack.isEmpty() && myStack.peek() != '(') {
					postfix.append(myStack.pop());
				} if (!myStack.isEmpty()) {
					myStack.pop();
				} else {
					System.out.println("*** Unmatched Parenthesis in expression ***");
					check = false;
					postfix = null;
				}
			} else if(value == '+' || value == '-' || value == '/' || value == '*' || value == '^') {
				if (hasPrecedence(value, myStack.peek())) {
					myStack.push(value);
				} else {
					postfix.append(myStack.pop());
					myStack.push(value);
				}
			} else {
				myStack.push(value);
				System.out.println("*** Invalid operator: use + - * / ^ only ***\n*** Aborting expression evaluation ***\n");
				check = false;
				postfix = null;
			}
			pos++;
		}
		
		if (!myStack.isEmpty()) {
			if (postfix != null) {
				System.out.println("*** Unmatched Parenthesis in expression ***");
				check = false;
				postfix = null;
			}
		} 
		
		if (check) {
			System.out.print("\nYour expression in postfix notation is: ");
			System.out.println(postfix);
		}
		return postfix;
	}
	
	// Method Name: 	evaluatePostfix
    // Parameters : 	StringBuffer
    // Return values: 	boolean
    // Partners: 		NONE
    // Description: 	Evaluates postfix expression, then returns a boolean if was completed
    public boolean evaluatePostfix(StringBuffer postfix)
    {
        Stack<Double> doubleStack  = new Stack<Double>();
        double result = 0;
        int pos = 0;
        int digits = 0;
        int operators = 0;
        boolean check = true;
        Double operR = (double) 0;
        Double operL = (double) 0;
        while(pos < postfix.length() && check ==  true)
        {
            char oper = postfix.charAt(pos);
            pos++;
            if(oper == ' ') {
            	// do nothing
            } else if(Character.isDigit(oper)) {
                Double value = (double) Character.digit(oper, 10);
                doubleStack.push(value);
                digits++;
            } else {
                operators++;
                try {
                    switch(oper) {
                        case'+':
                            operR = doubleStack.pop();
                            operL = doubleStack.pop();
                            doubleStack.push(operL + operR);
                            break;
                        case'-':
                            operR = doubleStack.pop();
                            operL = doubleStack.pop();
                            doubleStack.push(operL - operR);
                            break;
                        case'*':
                            operR = doubleStack.pop();
                            operL = doubleStack.pop();
                            doubleStack.push(operL * operR);
                            break;
                        case'/':
                            operR = doubleStack.pop();
                            operL = doubleStack.pop();
                            if(operR == 0) {
                                throw new ArithmeticException();
                            }
                            doubleStack.push(operL / operR);
                            break;
                        case'^':
                            operR = doubleStack.pop();
                            operL = doubleStack.pop();
                            doubleStack.push(Math.pow(operL,operR));
                            break;
                        default: 
                            check = false;
                            break;
                    }
                }
                catch(ArithmeticException AE) {
                    System.out.println("*** Divide by zero attempted ***\n*** Aborting expression evaluation ***\n");
                    check = false;
                    return check;
                }
                catch(EmptyListException ELE){
                }
            }
        }
        try {
            result = doubleStack.pop();
        }
        catch(EmptyListException Em) {
            System.out.println("*** Error in Expression: Invalid number of operators in input ***\n*** Aborting expression evaluation ***\n");
            check = false;
        }
        try {
            double goodday = doubleStack.peek();
            if(check != false) {
                System.out.println("*** Error in Expression: Invalid number of operators in input ***\n*** Aborting expression evaluation ***\n");
                check = false;
            }
        }
        catch(EmptyListException Em) {
            if(check != false) {
                System.out.print("==================================");
                System.out.printf("\n\n\nResult =  %.2f\n\n\n", result);
                System.out.println("==================================");
            }
        }
        return check;
    }
	
    // Method Name: 	hasPrecedence
    // Parameters : 	op1 char, op2
    // Return values: 	Boolean
    // Partners: 		NONE
    // Description: 	Assigns a value to each operator then compares to see which ones has precedence
    private boolean hasPrecedence(char op1, char op2) {
        int char1 = 0;
        int char2 = 0;
        boolean checker = false;

        switch(op1)  { 
            case '-':
                char1 = 1;
                break;
            case '+':
                char1 = 1;
                break;
            case '*':
                char1 = 2;
                break; 
            case '/':
                char1 = 2;
                break;
            case'^':
                char1 = 3;
                break;
            default:
                char1 = 0;
        }
        switch(op2) { 
            case '-':
                char2 = 1;
                break;
            case '+':
                char2 = 1;
                break;
            case '*':
                char2 = 2;
                break; 
            case '/':
                char2 = 2;
                break;
            case'^':
                char2 = 3;
                break;
            default:
                char2 = 0;
        }
        if(char1 > char2) {
            checker = true;
        }
        return checker;

    }
}