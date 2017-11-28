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

// This is the linked list class
// What all linked list objects will have

package ListPkg;
import ExceptionPkg.EmptyListException;

public class LinkedList<T extends Comparable<T>> {
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private int numElements;
	private String name;
	
	// Method Name:		LinkedList (constructor)
	// Parameters:		NONE
	// Return Values:	NONE
	// Partners:		NONE
	// Description:		Sets name to "list", firstNode and lastNode to null
	//					and numElements to 0
	public LinkedList() {
		this("list");
		firstNode = lastNode = null;
		numElements = 0;
	}

	// Method Name:		LinkedList (constructor)
	// Parameters:		listName
	// Return Values:	NONE
	// Partners:		NONE
	// Description:		Sets name to listName, firstNode and lastNode to null
	//					and numElements to 0
	public LinkedList(String listName) {
		name = listName;
		firstNode = lastNode = null;
		numElements = 0;
	}
	
	// Method Name:		insertAtFront
	// Parameters:		item
	// Return Values:	NONE
	// Partners:		NONE
	// Description:		Checks to see if list is empty or not, then inserts item at the front of the list
	//					Then increments numElements
	public void insertAtFront(T item) {
		ListNode<T> newNode;
		if (isEmpty()) {
			newNode = new ListNode<T>(item);
			firstNode = lastNode = newNode;
		} else {
			newNode = new ListNode<T>(item);
			newNode.setNext(firstNode);
			firstNode = newNode;
		}
		numElements++;
	}
	
	// Method Name:		insertAtBack
	// Parameters:		item
	// Return Values:	NONE
	// Partners:		NONE
	// Description:		Checks to see if list is empty or not, then inserts item at the back of the list
	//					Then increments numElements
	public void insertAtBack(T item) {
		ListNode<T> newNode;
		if (isEmpty()) {
			firstNode = lastNode = new ListNode<T>(item);
		} else {
			newNode = new ListNode<T>(item);
			lastNode.setNext(newNode);
			lastNode = newNode;
			}
		numElements++;
	}
	
	// Method Name:		removeFromFrom
	// Parameters:		NONE
	// Return Values:	T
	// Partners:		NONE
	// Description:		Checks to see if list is empty or not, then removes from the front of the list
	//					Then decrements numElements
	public T removeFromFront() throws EmptyListException{
		if (isEmpty()) {
			throw new EmptyListException(name);
		}
		T removedItem = firstNode.getData();
		
		if (firstNode == lastNode) {
			firstNode = lastNode = null;
		} else {
			firstNode = firstNode.getNext();
		}
		numElements--;
		return removedItem;
	}
	
	// Method Name:		removeFromBack
	// Parameters:		NONE
	// Return Values:	T
	// Partners:		NONE
	// Description:		Checks to see if list is empty or not, then removes from the back of the list
	//					Then decrements numElements
	public T removeFromBack() throws EmptyListException{
		if (isEmpty()) {
			throw new EmptyListException(name);
		}
		
		T removedItem = lastNode.getData();
		
		if (firstNode == lastNode) {
			firstNode = lastNode = null;
		} else {
			ListNode<T> current = firstNode;
			while (current.getNext() != lastNode) {
				current = current.getNext();
			}
			lastNode = current;
			current.setNext(null);
		}
		numElements--;
		return removedItem;
	}
	
	// Method Name:		removeItemAt
	// Parameters:		index
	// Return Values:	NONE
	// Partners:		NONE
	// Description:		Checks to see list is empty or not. Then checks to see if the index is in the bounds.
	//					Then calls the appropriate methods to execute the removal if the item is found
	public void removeItemAt(int index) throws EmptyListException, IndexOutOfBoundsException{
		if (isEmpty()) {
			throw new EmptyListException(name);
		} else if (index >= numElements || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			removeFromFront();
		} else if (index == numElements-1) {
			removeFromBack();
		} else {
			T removedItem = getItemAt(index);
			findAndRemove(removedItem);
		}
		
	}
	
	// Method Name:		getItemAt
	// Parameters:		index
	// Return Values:	T
	// Partners:		NONE
	// Description:		Checks to see list is empty or not. Then checks to see if the index is in the bounds.
	//					Then iterates through the list to reach the index and returns the item in the node
	public T getItemAt(int index) throws EmptyListException, IndexOutOfBoundsException{
		int counter = 0;
		ListNode<T> currentNode = firstNode;
		
		if (isEmpty()) {
			throw new EmptyListException(name);
		} else if (index >= numElements || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		while (counter != index && currentNode.getData() != null) {
			currentNode = currentNode.getNext();
			counter++;
		}
		T item = currentNode.getData();
		return item;
		
	}
	
	// Method Name:		findAndRemove
	// Parameters:		item
	// Return Values:	boolean
	// Partners:		NONE
	// Description:		Makes sure that the list isn't empty. Then checks for the item and returns it if found.
	//					If the list is empty then it throws an error
	public boolean findAndRemove(T item) throws EmptyListException{
		boolean found = false;
		if (!isEmpty()){
			if (firstNode.getData().equals(item)) {
				removeFromFront();
				found = true;
			} else {
				ListNode<T> current = firstNode;
				while (current.getNext() != null & !found) {
					if (current.getNext().getData().equals(item)) {
						found = true;
					} else {
						current = current.getNext();
					}
				}
				if (found) {
					if (current.getNext() == lastNode) {
						lastNode = current;
					}
					current.setNext(current.getNext().getNext());
					numElements--;
				}
			}
		} else {
			throw new EmptyListException(name);
		}
		return found;
		
	}
	
	// Method Name:		findItemPos
	// Parameters:		item
	// Return Values:	int
	// Partners:		NONE
	// Description:		Makes sure that the list isn't empty. Then checks for the item and returns it if found.
	//					If the list is empty then it throws an error
	public int findItemPos(T item){
		ListNode<T> currentNode = firstNode;
		boolean found = false;
		int counter = 0;
		if (!isEmpty()) {
			while (currentNode != null && !found) {
				if (currentNode.getData().equals(item)) {
					found = true;
				} else {
					currentNode = currentNode.getNext();
					counter++;
				}
			}
		}
		if (found == false) {
			return -1;
		} else {
			return counter;
		}
	}
	
	// Method Name:		lengthIs
	// Parameters:		NONE
	// Return Values:	int
	// Partners:		NONE
	// Description:		Returns numElements
	public int lengthIs(){
		return numElements;
	}
	
	// Method Name:		clear
	// Parameters:		NONE
	// Return Values:	NONE
	// Partners:		NONE
	// Description:		Clears the list
	public void clear() {
		numElements = 0;
		firstNode = lastNode = null;
	}
	
	// Method Name:		print
	// Parameters:		NONE
	// Return Values:	NONE
	// Partners:		NONE
	// Description:		If the list is empty it states, otherwise the list is printed
	public void print(){
		if (isEmpty()) {
			System.out.printf("The list '%s' is Empty\n", name);
		} else {
			System.out.printf("The list '%s' contains: ", name);
			ListNode<T> currentNode = firstNode;
			while (currentNode != null) {
				System.out.print(currentNode.getData() + " ");
				currentNode = currentNode.getNext();
			}
			System.out.print("\n\n");
		}
	}
	
	// Method Name:		isEmpty
	// Parameters:		NONE
	// Return Values:	Boolean
	// Partners:		NONE
	// Description:		If the list contains objects it returns that true, otherwise returns false to check if empty
	public boolean isEmpty(){
		boolean empty = false;
		if (numElements == 0) {
			empty = true;
		}
		return empty;
	}
}
