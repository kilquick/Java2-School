// Name        : Tyler S. Zoucha
// Class       : 1620-002
// Program #   : 2
// Due Date    : 10/21/2015
//
// Honor Pledge: On my honor as a student of the University
//               of Nebraska at Omaha, I have neither given nor received
//               unauthorized help on this homework assignment.
//
// NAME: Tyler S. Zoucha
// NU ID: 405
// EMAIL: tzoucha@unomaha.edu
//
// Partners: None 
//
// Filename:    Menu.java
// Written By:  Sandra Vlasnik
// Updated:    Tyler Zoucha - 10/21
//
// Displays a list of menu options to the user (0th Array element is Quit and is displayed last)
// Reads and validates user input
import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    String options[];  // array of menu options for display as a menu
    Scanner input = new Scanner (System.in);

    //-----------------------------------------------------------------------------------------
    // Method: Constructor
    // Takes an array of Strings and sets the array 'options' equal to the options provided 
    public Menu (String [] opts) {
        options = new String [opts.length];
        for (int x = 0; x < opts.length; x++)
            options[x] = opts[x];
    }

    //-----------------------------------------------------------------------------------------
    // Method: runMenu
    // Displays the list of menu options
    // Prompts for, reads, validates and returns the user's choice
    public int runMenu () {
        int opt = -1;
        do {

            System.out.println ("\nChoose from the following options: ");
            try {
                for (int x = 1; x < options.length; x++)

                    System.out.printf ("\t%d\t%s\n", x, options[x]);

                System.out.printf ("\t%d\t%s\n",0 , options[0]);
                System.out.printf ("\tOption: ");
                opt = input.nextInt();
                input.nextLine();
                if (opt < 0 || opt >= options.length)
                    System.out.println ("Invalid Menu Option - try again\n");
            }
            // If the user enters a non-numeric value, catch and report the error
           //  and allow the user to try again 
            catch (InputMismatchException inputMismatchException){
                System.out.println ("Invalid Menu Option - try again\n");
                input.nextLine(); // clear the non-numeric value from the input
            }
        }while (opt < 0 || opt >= options.length);
        return opt;
    }
}




