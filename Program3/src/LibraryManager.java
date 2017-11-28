// Name        : Tyler S. Zoucha
// Class       : 1620-002
// Program #   : 3
// Due Date    : 11/4/2015
//
// Honor Pledge: On my honor as a student of the University
//               of Nebraska at Omaha, I have neither given nor received
//               unauthorized help on this homework assignment.
//
// NAME: Tyler S. Zoucha
// NU ID: 405
// EMAIL: tzoucha@unomaha.edu

// Partners: None 
// This program uses the custom MyArrayList generic class to store information

import java.util.Scanner;
import java.util.InputMismatchException;

public class LibraryManager
{
    public static void main(String[] args)
    {
        // Declare and instantiate the library lists
        MyArrayList<Book> onLoanBooks; // List of books owned by the library
        try {
            onLoanBooks = new MyArrayList<Book>(5);     // List of books available for checkout
        }
        catch (Exception e) {
            System.out.println ("Size of list is invalid - Creating default list");
            onLoanBooks = new MyArrayList<Book>();
        }

        MyArrayList<Book> availBooks;
        try {
            availBooks = new MyArrayList<Book>(10);     // List of books available for checkout
        }
        catch (Exception e) {
            System.out.println ("Size of list is invalid - Creating default list");
            availBooks = new MyArrayList<Book>();
        }
        MyArrayList<Member> members;
        try {
            members = new MyArrayList<Member>(5);// List of all members of the library
        }
        catch (Exception e) {
            System.out.println ("Size of list is invalid - Creating default list");
            members = new MyArrayList<Member>();
        }

        //Declare input Scanner object for user input
        Scanner input = new Scanner (System.in);

        // initialize the lists with sample values to facilliate testing
        initializeBooks(availBooks);
        initializeMembers(members);

        // Print the list of all books, all books on loan (none) and all members
        System.out.println ("---------------------------------------------------------");
        System.out.println ("All Available Books: \n\n" + availBooks);
        System.out.println ("---------------------------------------------------------");
        System.out.println ("All Books on Loan: \n" + onLoanBooks);
        System.out.println ("---------------------------------------------------------");
        System.out.println ("All Members: \n\n" + members);
        System.out.println ("---------------------------------------------------------");

        // Create the array of Strings containing the main menu options (Quit - option 0)
        // Create the mainMenu object
        String opts[] = {"Quit","Check Out Book", "Return Book", "List All Available Books", 
            "List All Books Checked Out"};
        Menu mainMenu = new Menu(opts);

        // create various temporary variables - Add any other variables you might need
        int isbn, memNum;   // variables to hold user inputs
        Book theBook = null;       // temporary object for a book found in a list
        Member libMem = null;      // temporary object for a member found in the list
        boolean goodInput;  // for use in allowing the user to correct invalid inputs

        // while user wants to continue
        //   run the menu
        //   process the user's requested option
        int opt = 0;
        do {
            opt = mainMenu.runMenu();
            switch (opt) {
                case 1:
                	boolean checkOut = false;
                	goodInput = false;
                	
                	if(availBooks.isEmpty() == true){
                		System.out.println("There are no available books to be checked out.");
                	}
                	else{
                		System.out.print("All Members: \n\n" + members);
                		while(goodInput == false){
                			try{
                				System.out.print("Enter a member number: ");
                				memNum = input.nextInt();
                				libMem = members.findItemByKey(memNum);
                				if(libMem != null)
                					goodInput = true;
                				else{
                					System.out.println("Invalid member number chosen - Try Again");
                					input.nextLine();
                				}
                			}
                			catch(InputMismatchException IME){
                				System.out.println("Invalid member number - Try again");
                				input.nextLine();
                			}
                			catch(NullPointerException E){
                				System.out.println("Invalid member number - Try again");
                				input.nextLine();
                			}
                		}
                		goodInput = false;
                		System.out.println("Choose a book for checkout:\nAll Books\n" + availBooks);
                		
                		while(goodInput == false){
                			try{
                				System.out.print("Enter the ISBN for the desired book: ");
                				isbn = input.nextInt();
                				theBook = availBooks.findItemByKey(isbn);
                				if(theBook != null){
                					checkOut = libMem.checkOut(theBook, availBooks, onLoanBooks);
                					if(checkOut == false)
                						System.out.println("Unable to check out book - too many books on loan");
                					else{
                						System.out.println("Book Checked Out Successfully");
                						System.out.println(libMem);
                					}
                					goodInput = true;
                				}
                				else{
                					System.out.println("Sorry that isn't a valid ISBN");
                					input.nextLine();
                				}
                			}
                			catch(InputMismatchException E){
                				System.out.println("Sorry that isn't a valid ISBN.");
                				input.nextLine();
                			}
                			catch(NullPointerException E){
                				System.out.println("Sorry that isn't a balid ISBN.");
                				input.nextLine();
                			}
                		}
                	}
                	//PROVIDED CODE COMMENTS:
                	//check out book
                    // if no books available 
                    //    inform the user
                    // else
                    //    display all current members
                    //    get a member number from the user
                    //    - allow user to correct input if value input is not an integer
                    // find the member in the member list
                    // display all books available for checkout
                    // read user's choice for book to check out
                    //    - allow user to correct input if value input is not an integer
                    // if the desired book is available
                    //           checkout the book 
                    //           if unable to check out the book report an error
                    break;
                case 2:
                	boolean returnBook = false;
                	goodInput = false;
                	System.out.println("All Members: \n\n" + members);
                	while(goodInput == false){
                		try{
                			System.out.print("Enter a member number: ");
                			memNum = input.nextInt();
                			libMem = members.findItemByKey(memNum);
                			if(libMem != null){
                				goodInput = true;
                				System.out.printf("Choose a book to return:\nAll Books On Loan to this Member:\n\n%s", libMem);
                			}
                			else{
                				System.out.println("Invalid member number chosen - Try Again");
                				input.nextLine();
                			}
                		}
                		catch(InputMismatchException IME){
                			System.out.println("Invalid member number - Try again");
                			input.nextLine();
                		}
                		catch(NullPointerException E){
                			System.out.println("Invalid member number - Try again");
                			input.nextLine();
                		}
                	}
                	goodInput = false;
                	while(goodInput == false){
                		try{
                			System.out.print("Enter the ISBN for the book to return: ");
                			isbn = input.nextInt();
                			theBook = onLoanBooks.findItemByKey(isbn);
                			if(theBook != null){
                				returnBook = libMem.returnBook(theBook, availBooks, onLoanBooks);
                				if(returnBook == false)
                					System.out.println("This member has no books on loan");
                					else{
                						System.out.println("Book returned successfully");
                					}
                				goodInput = true;
                			}
                			else{
                				System.out.println("Sorry that isn't a valid ISBN");
                				input.nextLine();
                			}
                		}
                		catch(InputMismatchException IME){
                			System.out.println("Sorry that isn't a valid ISBN");
                			input.nextLine();
                		}
                		catch(NullPointerException E){
                			System.out.println("Sorry that isn't a valid ISBN");
                			input.nextLine();
                		}
                	}
                    break;
                    // PROVIDED CODE COMMENTS:
                    // return book
                    // display all current members
                    // ask the user for a member number
                    //    - allow user to correct input if value input is not an integer
                    // find the member in the member list
                    // display all books checked out by this member
                    // prompt for and read user's choice for book to return
                    //    - allow user to correct input if value input is not an integer
                    // find the book in the books-on-loan list
                    // if the desired book is found in the books-on-loan list
                    //      return the book
                    //      if unable to return the book report an error
                case 3:
                	System.out.printf("All Books in Stock: \n%s\nThere is/are %d available\n", availBooks, availBooks.lengthIs());
                	//List all available books and the total number of books available
                    break;
                case 4:
                	System.out.printf("All Books Checked out by Members: \n\n%sThere is/are %d on loan\n", onLoanBooks, onLoanBooks.lengthIs());
                	// List all books checked out and the total number of books on loan
                    break;
               default:
                    System.out.println ("Thank you - Have a nice day!");
            }
        } while (opt > 0);

    }
    // The following two methods are provided to facilliate testing
    // NO CHANGES ARE NEEDED TO THIS METHOD
    // Method: initialzieBooks
    // Method to initialize the books in stock and the books owned
    // Initially all books are in stock for lending
    public static void initializeBooks(MyArrayList<Book> availBooks){
        //Populate books and stock MyArrayLists
        try{
            availBooks.addItem(new Book("Ender's Game", "Card, Orson Scott", 1000));
            availBooks.addItem(new Book("Breakfast of Champions", "Vonnegut, Kurt", 2000));
            availBooks.addItem(new Book("The Alphabet of Manliness", "Maddox", 3000));
            availBooks.addItem(new Book("A Condeferacy of Dunces", "Toole, John Kennedy", 4000));
            availBooks.addItem(new Book("Dune", "Herbert, Frank", 5000));
            availBooks.addItem(new Book("History of Western Philosophy", "Russell, Bertrand", 6000));
            availBooks.addItem(new Book("Choke", "Palahniuk, Chuck", 7000));
            availBooks.addItem(new Book("Me Talk Pretty One Day", "Sedaris, David", 8000));
            availBooks.addItem(new Book("House of Leaves", "Danielewski, Mark", 9000));
            availBooks.addItem(new Book("Eats, Shoots, & Leaves", "Truss, Lynne", 10000));
        }
        catch (Exception e) {
            System.out.println ("Error Creating Book: " + e);
        }
    }
    // NO CHANGES ARE NEEDED TO THIS METHOD
    // Method: initializeMembers (MyArrayList<Member> members)
    // Populate members MyArrayList
    public static void initializeMembers(MyArrayList<Member> members){
        try {
            members.addItem(new Member(11111,"Parker", "Peter"));
            members.addItem(new Member(22222,"Spector", "Marc"));
            members.addItem(new Member(33333,"Curry", "Arthur"));
            members.addItem(new Member(44444,"Stark", "Tony"));
            members.addItem(new Member(55555,"Queen", "Oliver"));

            // Adding this member will cause the 'enlarge' method to be called
            members.addItem(new Member(66666,"Smith", "Mary"));
        }
        catch (Exception e) {
            System.out.println ("Error creating member: " + e);
        }
    }//end main
}//end class
