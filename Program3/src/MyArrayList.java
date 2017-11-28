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

//Class Name: MyArrayList 
//Parameters : NONE
//Return values: NONE
//Partners: NONE
//Description: What every book and member will be organized into
public class MyArrayList <E extends IntKeyed>{
	private final int DEFCAP = 50;
	private int origCap;
	private int numElements;
	private E list[];
	
    //Method Name: MyArrayList-Default Constructor
    //Parameters : NONE
    //Return values: NONE
    //Partners: NONE
    //Description: What happens to every array list if you don't designate a size
	public MyArrayList(){
		origCap = DEFCAP;
		list = (E[]) new IntKeyed[origCap];
	}
	
    //Method Name: MyArrayList-Constructor
    //Parameters : size
    //Return values: NONE
    //Partners: NONE
    //Description: If the array list is given a size
	public MyArrayList(int size) throws Exception{
		if(size > 0){
			list = (E[]) new IntKeyed[size];
			origCap = size;
		}
		else {
			throw new Exception("Size is invalid");
		}
	}
	
    //Method Name: addItem
    //Parameters : item
    //Return values: NONE
    //Partners: NONE
    //Description: tries to add a item, will enlarge if current list is full
	public void addItem(E item){
		if(list.length == numElements){
			enlarge();
		}
		list[numElements] = item;
		numElements++;
	}
	
    //Method Name: removeItem
    //Parameters : item
    //Return values: boolean
    //Partners: NONE
    //Description: Returns a boolean if can or cannot remove item from list
	public boolean removeItem(E item){
		boolean removed = false;
		int pos = findItemPos(item);
		
		if (pos >= 0){
			E temp = list[numElements - 1];
			list[numElements - 1] = list[pos];
			list[pos] = temp;
			numElements--;
			removed = true;
		}
		else{
			removed = false;
		}
		return removed;
	}
	
    //Method Name: findItem
    //Parameters : item
    //Return values: boolean
    //Partners: NONE
    //Description: Returns a boolean if we can find the item
	public boolean findItem(E item){
		boolean find = equals(item);
		return find;
	}
	
    //Method Name: findItemByKey
    //Parameters : key
    //Return values: E
    //Partners: NONE
    //Description: Returns the item if found, if not found returns null
	public E findItemByKey(int key){
		E item = null;
		
		for(int x = 0; x < numElements; x++){
			if(list[x].getKey() == key){
				return list[x];
			}
			else
				item = null;
		}
		return item;
	}
	
    //Method Name: isEmpty
    //Parameters : NONE
    //Return values: boolean
    //Partners: NONE
    //Description: Checks if the array is empty
	public boolean isEmpty(){
		if (numElements == 0)
			return true;
		else
			return false;
	}
	
	//Method Name: lenthIs
    //Parameters : NONE
    //Return values: int numElements
    //Partners: NONE
    //Description: Returns the list size
	public int lengthIs(){
		return numElements;
	}
	
	//Method Name: clear
    //Parameters : NONE
    //Return values: NONE
    //Partners: NONE
    //Description: Will clear the list by making a new list
	public void clear(){
		numElements = 0;
		list = (E[]) new IntKeyed [origCap];
	}
	
	//Method Name: toString
    //Parameters : NONE
    //Return values: String string
    //Partners: NONE
    //Description: returns the String of whatever the array is
	@Override
	public String toString(){
		String string = "";
		
		if(numElements != 0){
			for(int x =0; x < numElements; x++){
				string += String.format("%s\n", list[x]);
			}
		}
		else
			string = "\t*** No Items ***\n";
		return string;
	}
	
	//Method Name: equals
    //Parameters : otherList
    //Return values: boolean
    //Partners: NONE
    //Description: Checks if the lists are equal or not
	public boolean equals(MyArrayList<E> otherList){
		boolean areEqual = true;
		
		if((otherList == null) || (list.length != otherList.list.length))
			areEqual = false;
		else if (otherList == this)
			areEqual = true;
		else{
			// compare all items in the lists for equality
			int x = 0;
			while (x < list.length && areEqual){
				if(! list[x].equals(otherList.list[x]))
					areEqual = false;
				x++;
			}
		}
		return areEqual;
	}
	
	//Method Name: enlarge
    //Parameters : NONE
    //Return values: NONE
    //Partners: NONE
    //Description: Will enlarge the list
	private void enlarge(){
		E[] larger = (E[]) new  IntKeyed[list.length + origCap];
		for(int x = 0; x < list.length; x++){
			larger[x] = list[x];
		}
		list = larger;
	}
	
	//Method Name: findItemPos
    //Parameters : item
    //Return values: int pos
    //Partners: NONE
    //Description: Returns the postition of the item
	private int findItemPos(E item){
		int position = 0;
		
		for (int x = 0; x < list.length; x++){
			if(list[x].getKey() == item.getKey()){
				position = x;
				break;
			}
			else {
				position = -1;
			}
		}
		return position;
	}
}
