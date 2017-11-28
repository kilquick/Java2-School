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

//Class Name: Member
//Parameters : NONE
//Return values: NONE
//Partners: NONE
//Description: What every Library member will be
public class Member implements IntKeyed {
	private final int MAX_BOOKS = 3;
	private int memId;
	private String firstName;
	private String lastName;
	private MyArrayList<Book> checkedOut;
	
	//Method Name: Member (throws exception)
    //Parameters : id, last, first
    //Return values: NONE
    //Partners: NONE
    //Description: Creates a member
	public Member(int id, String last, String first) throws Exception{
		checkedOut = new MyArrayList<Book> (MAX_BOOKS);
		if(id < 0){
			throw new Exception("Member ID must be a positive value");
		}
		else{
			memId = id;
		}
		setLastName(last);
		setFirstName(first);
	}
	
	//Method Name: getLastname
    //Parameters : NONE
    //Return values: String lastName
    //Partners: NONE
    //Description: Returns the last name of the member
	public String getLastName(){
		return lastName;
	}
	
	//Method Name: setLastName
    //Parameters : l
    //Return values: NONE
    //Partners: NONE
    //Description: Sets the last name equal to the parameter
	public void setLastName(String l){
		this.lastName = l;
	}
	
	//Method Name: getFirstName
    //Parameters : NONE
    //Return values: String firstName
    //Partners: NONE
    //Description: Returns the first name of the member
	public String getFirstName(){
		return firstName;
	}
	
	//Method Name: setFirstName
    //Parameters : f
    //Return values: NONE
    //Partners: NONE
    //Description: sets the first name equal to the parameter
	public void setFirstName(String f){
		this.firstName = f;
	}
	
	//Method Name: getKey
    //Parameters : NONE
    //Return values: int memID
    //Partners: NONE
    //Description: Returns the members id
	public int getKey(){
		return memId;
	}
	//Method Name: setKeye
    //Parameters : key
    //Return values: boolean
    //Partners: NONE
    //Description: Returns a boolean to see if we were able to set the id
	public boolean setKey(int key){
		boolean set = false;
		if(key < 0)
			set = false;
		else{
			memId = key;
			set = true;
		}
		return set;
	}
	
	//Method Name: checkOut
    //Parameters : book, availBooks, onLoanBooks
    //Return values: boolean
    //Partners: NONE
    //Description: Returns a boolean if we were able to checkout a book
	public boolean checkOut(Book book, MyArrayList<Book> availBooks, MyArrayList<Book> onLoanBooks){
		boolean check = false;
		if(checkedOut.lengthIs() == MAX_BOOKS)
			check = false;
		else{
			checkedOut.addItem(book);
			availBooks.removeItem(book);
			onLoanBooks.addItem(book);
			check = true;
		}
		return check;
	}
	
	//Class Name: returnBook
    //Parameters : book, availBooks, onLoanBooks
    //Return values: boolean
    //Partners: NONE
    //Description: Returns a boolean if we were able to return books
	public boolean returnBook(Book book, MyArrayList<Book> availBooks, MyArrayList<Book> onLoanBooks){
		boolean returned = false;
		if(checkedOut.findItem(book) == false){
			checkedOut.removeItem(book);
			availBooks.addItem(book);
			onLoanBooks.removeItem(book);
			returned = true;
		}
		else{
			System.out.println("Not in checked out list");
		}
		return returned;
	}
	
	//Method Name: printCheckedOut
    //Parameters : NONE
    //Return values: NONE
    //Partners: NONE
    //Description: Prints off all checked out books
	public void printCheckedOut(){
		if(checkedOut.lengthIs() == 0)
			System.out.println("*** No Items***");
		else{
			System.out.println("");
			System.out.println(checkedOut);
		}
	}
	
	//Method Name: equals
    //Parameters : mem
    //Return values: boolean
    //Partners: NONE
    //Description: Returns a boolean to see if the memebers are equal to each other
	@Override
	public boolean equals(Object mem){
		boolean equals = false;
		Member m;
		if(mem instanceof Member){
			m = (Member) mem;
			if(mem == null)
				equals = false;
			else if(mem.equals(mem))
				equals = true;
			if(lastName.equals(m.lastName) && firstName.equals(m.lastName))
				equals = true;
		}
		return equals;
	}
	
	//Method Name: toString
    //Parameters : NONE
    //Return values: String
    //Partners: NONE
    //Description: Returns the members id, first name, last name, and the books they have checked out
	@Override
	public String toString(){
		return String.format("Member Number: %s\tMember Name: %s, %s\t\n\tBooks on Loan:\n%s", memId, lastName, firstName, checkedOut);
	}
}
