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

//Class Name: Book
//Parameters : NONE
//Return values: NONE
//Partners: NONE
//Description: What every book will become in the Library
public class Book implements IntKeyed {
	private int isbn;
	private String title;
	private String author;
	
	//Method Name: Book throws exception
    //Parameters : t, a, i 
    //Return values: NONE
    //Partners: NONE
    //Description: What every book will become in the Library
	public Book(String t, String a, int i) throws Exception{
		title = t;
		author = a;
		if (i < 0)
			throw new Exception("ISBN must be positive.");
		else
			isbn = i;
	}
	
	//Method Name: getTitle
    //Parameters : NONE
    //Return values: String title
    //Partners: NONE
    //Description: Returns the title of the book
	public String getTitle(){
		return title;
	}
	
	//Method Name: setTitlee
    //Parameters : t
    //Return values: NONE
    //Partners: NONE
    //Description: sets the string t equal to title
	public void setTitle(String t){
		this.title = t;
	}
	//Method Name: getAuthor
    //Parameters : NONE
    //Return values: String author
    //Partners: NONE
    //Description: Returns the author of the book
	public String getAuthor(){
		return author;
	}
	
	//Method Name: setAuthor
    //Parameters : s
    //Return values: NONE
    //Partners: NONE
    //Description: sets the a string equal to the author
	public void setAuthor(String s){
		this.author = s;
	}
	
	//Method Name: getKey
    //Parameters : NONE
    //Return values: int isbn
    //Partners: NONE
    //Description: Returns the isbn
	public int getKey(){
		return isbn;
	}
	
	//Method Name: setKey
    //Parameters : key
    //Return values: boolean
    //Partners: NONE
    //Description: Returns a boolean if we can set the key
	public boolean setKey(int key){
		boolean set = false;
		
		if(key< 0 )
			set = false;
		else
			set = true;
		return set;
	}
	
	//Method Name: equals
    //Parameters : bk
    //Return values: boolean
    //Partners: NONE
    //Description: Returns a boolean if the books are equal or not
	@Override
	public boolean equals(Object bk){
		boolean equals = false;
		Book b;
		if(bk instanceof Book){
			b = (Book) bk;
			if(bk == null)
				equals = false;
			else if(bk.equals(bk))
				equals = true;
			if(title.equals(b.title) && author.equals(b.author) && isbn == b.isbn)
				equals = true;
		}
		return equals;
	}
	
	//Method Name: toString
    //Parameters : NONE
    //Return values: string
    //Partners: NONE
    //Description: returns the title, author, and isbn
	@Override
	public String toString(){
		return String.format("\tISBN: %s\tTitle: %-25s\tAuthor: %-25s", isbn, title, author);
	}
}
