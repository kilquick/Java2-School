// Name        : Tyler S.  Zouchav
// Class       : 1620-002
// Program #   : 5
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

// This is the stack class; what every stack will use


package ListPkg;

public class Stack<T extends Comparable<T>> {
	private LinkedList<T> list;

	// Method Name: 	Stack (constructor)
    // Parameters : 	NONE
    // Return values: 	NONE
    // Partners: 		NONE
    // Description: 	Default constructor that calls on another constructor
	public Stack() {
		this(null);
	}

	// Method Name: 	Stack
    // Parameters : 	name
    // Return values: 	NONE
    // Partners: 		NONE
    // Description: 	Other constructor that creates the Stack
	public Stack(String name) {
		list = new LinkedList(name);
	}

	// Method Name: 	push
    // Parameters : 	item
    // Return values: 	NONE
    // Partners: 		NONE
    // Description: 	Pushes a value to the front of the stack
	public void push(T item) {
		list.insertAtFront(item);
	}

	// Method Name: 	pop
    // Parameters : 	NONE
    // Return values: 	T
    // Partners: 		NONE
    // Description: 	Pops a value off the top of the stack
	public T pop() {
		return list.removeFromFront();
	}

	// Method Name: 	lengthIs
    // Parameters :  	NONE
    // Return values:  	int
    // Partners: 		NONE
    // Description: 	returns the length of the linkedlist
	public int lengthIs() {
		return list.lengthIs();
	}

	// Method Name: 	peek
    // Parameters : 	NONE
    // Return values: 	T
    // Partners:		NONE
    // Description: 	Looks at the top of the stack
	public T peek() {
		return list.getItemAt(0);
	}

	// Method Name: 	print
    // Parameters : 	NONE
    // Return values: 	NONE
    // Partners: 		NONE
    // Description: 	Prints the stack
	public void print() {
		list.print();
	}

	// Method Name: 	isEmpty
    // Parameters : 	NONE
    // Return values: 	Boolean
    // Partners: 		NONE
    // Description: 	Checks if the stack is empty or not
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
