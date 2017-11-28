// Name        : Tyler S.  Zoucha
// Class       : 1620-002
// Program #   : Program 4
// Due Date    : 11/9/2015
//
// Honor Pledge: On my honor as a student of the University
//               of Nebraska at Omaha, I have neither given nor received
//               unauthorized help on this homework assignment.
//
// NAME: Tyler S. Zoucha
// NU ID: 405
// EMAIL: tzoucha@unomaha.edu

// Partners: NONE

// This is the list node class
// Each node that each linked list will have inside of it

package ListPkg;

public class ListNode<T extends Comparable<T>> {
	private T data;
	private ListNode<T> nextNode;
	
	// Method Name:		ListNode (constructor)
	// Parameters:		Object
	// Return Values:	NONE
	// Partners:		NONE
	// Description:		Sets data equal to object and the nextNode equal to null
	public ListNode(T object) {
		data = object;
		nextNode = null;
	}
	
	// Method Name:		ListNode (constructor)
	// Parameters:		Object, node
	// Return Values:	NONE
	// Partners:		NONE
	// Description:		Sets data equal to object and the nextNode equal to node that's passed
	public ListNode(T object, ListNode<T> node) {
		data = object;
		nextNode = node;
	}
	
	// Method Name:		setData
	// Parameters:		NONE
	// Return Values:	NONE
	// Partners:		NONE
	// Description:		Sets data equal to object passed
	public void setData(T object) {
		data = object;
	}
	
	// Method Name:		getData
	// Parameters:		NONE
	// Return Values:	T
	// Partners:		NONE
	// Description:		returns data
	public T getData() {
		return data;
	}
	// Method Name:		setNext
	// Parameters:		next
	// Return Values:	NONE
	// Partners:		NONE
	// Description:		Sets nextNode equal to next passed
	public void setNext(ListNode<T> next) {
		nextNode = next;
	}
	
	// Method Name:		getNext
	// Parameters:		NONE
	// Return Values:	ListNode
	// Partners:		NONE
	// Description:		returns the nextNode
	public ListNode<T> getNext() {
		return nextNode;
	}
}
