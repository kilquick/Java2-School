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

// Partners: None 
// Initializes the pre-determined mazes to the maze choice and solves it using recursion
public class Maze {

    // Sample maze 1
    final int MAZE1_ROWS = 12;
    final int MAZE1_COLS = 12;
    final int MAZE1_ENTERROW = 4;
    final int MAZE1_EXITROW = 8;
    final char[][] MAZE1 = {
        {'#','#','#','#','#','#','#','#','#','#','#','#'},
        {'#','.','.','.','#','.','.','.','.','.','.','#'},
        {'#','.','#','.','#','.','#','#','#','#','.','#'},
        {'#','.','#','.','#','.','.','.','.','#','.','#'},
        {'.','.','#','.','.','#','#','#','.','#','.','#'},
        {'#','#','#','#','.','#','.','.','.','#','.','#'},
        {'#','.','.','#','.','.','.','#','#','#','.','#'},
        {'#','#','.','#','.','#','#','#','.','#','.','#'},
        {'#','.','.','.','.','.','.','.','.','#','.','.'},
        {'#','#','#','#','#','#','.','#','#','#','.','#'},
        {'#','.','.','.','.','.','.','#','.','.','.','#'},
        {'#','#','#','#','#','#','#','#','#','#','#','#'}};


    // Sample maze 2
    final int MAZE2_ROWS = 8;
    final int MAZE2_COLS = 12;
    final int MAZE2_ENTERROW = 6;
    final int MAZE2_EXITROW = 1;
    final char[][] MAZE2 = {
        {'#','#','#','#','#','#','#','#','#','#','#','#'},
        {'#','.','.','.','#','.','.','.','#','#','.','.'},
        {'#','.','#','.','.','.','#','.','.','.','.','#'},
        {'#','.','#','#','#','#','.','#','.','#','.','#'},
        {'#','.','.','.','#','#','.','.','.','.','.','#'},
        {'#','#','#','.','#','#','#','#','.','#','.','#'},
        {'.','.','.','.','.','.','.','.','.','.','#','#'},
        {'#','#','#','#','#','#','#','#','#','#','#','#'}};

    // Sample maze 3
    final int MAZE3_ROWS = 9;
    final int MAZE3_COLS = 9;
    final int MAZE3_ENTERROW = 4;
    final int MAZE3_EXITROW = 3;
    final char[][] MAZE3 = {
        {'#','#','#','#','#','#','#','#','#'},
        {'#','.','#','.','#','.','.','.','#'},
        {'#','.','.','.','#','.','#','#','#'},
        {'#','#','#','.','#','.','#','.','.'},
        {'.','.','.','.','.','.','#','.','#'},
        {'#','#','.','#','.','#','#','.','#'},
        {'#','.','.','#','.','#','.','.','#'},
        {'#','#','.','#','.','#','.','.','#'},
        {'#','#','#','#','#','#','#','#','#'}};

      // Sample maze 4
      final int MAZE4_ROWS = 12;
      final int MAZE4_COLS = 12;
      final int MAZE4_ENTERROW = 2;
      final int MAZE4_EXITROW = 4;
      final char[][] MAZE4 = {
          {'#','#','#','#','#','#','#','#','#','#','#','#'},
          {'#','.','.','.','#','.','.','.','.','.','.','#'},
          {'.','.','#','.','#','.','#','#','#','#','.','#'},
          {'#','#','#','.','#','.','.','.','.','#','.','#'},
          {'#','.','.','.','.','#','#','#','.','#','.','.'},
          {'#','#','#','#','.','#','.','#','.','#','.','#'},
          {'#','.','.','#','.','#','.','#','.','#','.','#'},
          {'#','#','.','#','.','#','.','#','.','#','.','#'},
          {'#','.','.','.','.','.','.','.','.','#','.','#'},
          {'#','#','#','#','#','#','.','#','#','#','.','#'},
          {'#','.','.','.','.','.','.','#','.','.','.','#'},
          {'#','#','#','#','#','#','#','#','#','#','#','#'}};

    // Private data members for processing maze
    private char maze [][]; // the maze array to traverse
    private int rows;       // the number of rows in this maze
    private int cols;       // the number of columns in this maze
    private int enterRow;   // the entry row for this maze; start column is 0
    private int exitRow;    // the exit row for this maze; end column is cols-1
    private int steps;      // number of steps in the solvable path
    
    // Method Name: Maze (Constructor)
    // Parameters : mazeNum, int
    // Return Values: None
    // Partners: None
    // Description: Assigns the maze, rows, cols, enterRow, exitRow according to the mazeNum parameter value
    public Maze (int mazeNum) {
    	// Switch statement that sets the maze to be traversed based in mazeNum
    	switch (mazeNum) {
    	case 1 :
    		maze = MAZE1;
    		rows = MAZE1_ROWS;
    		cols = MAZE1_COLS;
    		enterRow = MAZE1_ENTERROW;
    		exitRow = MAZE1_EXITROW;
    		break;
    	case 2 :
    		maze = MAZE2;
    		rows = MAZE2_ROWS;
    		cols = MAZE2_COLS;
    		enterRow = MAZE2_ENTERROW;
    		exitRow = MAZE2_EXITROW;
    		break;
    	case 3 :
    		maze = MAZE3;
    		rows = MAZE3_ROWS;
    		cols = MAZE3_COLS;
    		enterRow = MAZE3_ENTERROW;
    		exitRow = MAZE3_EXITROW;
    		break;
    	case 4 :
    		maze = MAZE4;
    		rows = MAZE4_ROWS;
    		cols = MAZE4_COLS;
    		enterRow = MAZE4_ENTERROW;
    		exitRow = MAZE4_EXITROW;
    		break;
    	default :	// Default case just to fulfil switch statement
    		break;
    	}
    }
    
    // Method name: printMaze
    // Parameters: None
    // Return Values: None
    // Partners: None
    // Description: Prints the maze
    public void printMaze() {
    	String Maze = ""; //Creates a String for the maze to print
    	
    	System.out.printf("\nThis maze is size: %d x %d\n\n", rows, cols);
    	
    	// Sets the array as a string and creates a new line after each row
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++){
                Maze += maze[i][j];
            }
            Maze += "\n";
        }
        
        System.out.print(Maze);  // Prints out the maze in String format
    }
    
    // Method name: traverseMaze
    // Parameters: None
    // Return Values: None
    // Partners: None
    // Description: Non-recursive method to begin the maze traversal
    public void traverseMaze() {
    	boolean solved = findPath(enterRow, 0); // Begins traversal of the maze
    	
    	// If/else that indicate if findPath returns true or false
    	if (solved == true) {
    		System.out.println("\n***Solved***\n");
    		System.out.println("AFTER TRAVERSAL:");
    		printMaze(); // Prints the solved maze
    		System.out.printf("Steps in Path: %d\n",steps);
    	} else{
    		System.out.println("***NOT SOLVED***");
    	}
    }
    
    // Method name: findPath
    // Parameters: row, int; col, int
    // Return Values: boolean
    // Partners: None
    // Description: Goes through the maze by using recursion to attempt to find out of there's a path out
    private boolean findPath (int row, int col) {
    	maze[row][col] = 'O'; // Puts an 'O' at the start point
    	int size = maze[0].length - 1; // Length of the columns
        
        //If the point is equal to the end point then the maze is solved
        //Adds to count and returns true
        if (row == exitRow && col == size) {
            steps++;
            return true;
        }

        //Checks to see if the next step can go left
        //Adds to count and returns true
        if (col-1 >= 0 && maze[row][col-1] == '.' && findPath(row, col-1)){
            steps++;
            return true;
        }

        //Checks to see if the next step can go up
        //Adds to count and returns true
        if (maze[row][col+1] == '.' && findPath(row, col+1)) {
            steps++;
            return true;
        }

        //Checks to see if the next step can go down
        //Adds to count and returns true
        if (row-1 >= 0 && maze[row-1][col] == '.' && findPath(row-1, col)) {
            steps++;
            return true;
        }

        //Checks to see if the next can go right
        //Adds to count and returns true
        if (maze[row+1][col] == '.' && findPath(row+1, col)) {
            steps++;
            return true;
        }
        maze[row][col]='.';  //If false this sets the point testing to '.'
        return false; //Returns false
    } // end findPath
}
