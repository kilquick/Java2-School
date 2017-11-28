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
import java.util.Scanner;

public class TestMaze {
	public static void main(String args[]) {
		System.out.print("\n\t***Select a Maze***");
		String[] menuOpts = {"Quit", "Maze 1", "Maze 2", "Maze 3", "Maze 4"}; // Sets the menu option arguments
		Menu menu = new Menu(menuOpts); // Creates an object of the Menu class
		int number = menu.runMenu(); // Calls runMenu method in the menu class
		
		// While loop that keeps looping until the user quites
		while (number != 0) {
			Maze maze = new Maze(number); // Creates an object of the Maze class using the user input
			maze.printMaze(); // Prints the maze chosen
			maze.traverseMaze(); // Traverses the maze
			number = menu.runMenu(); // Calls runMenu method in the menu class
		}
	
	}
}