// Name        : Tyler S.  Zouchav
// Class       : 1620-002
// Program #   : 6
// Due Date    : 11/30/2015
//
// Honor Pledge: On my honor as a student of the University
//               of Nebraska at Omaha, I have neither given nor received
//               unauthorized help on this homework assignment.
//
// NAME: Tyler S. Zoucha
// NU ID: 405
// EMAIL: tzoucha@unomaha.edu

// Partners: NONE

// This is the driver for the binary calculator frame

import javax.swing.JFrame;

public class BinaryCalculatorDriver {

	public static void main(String[] args)
	{
		BinaryCalculatorFrame calcFrame = new BinaryCalculatorFrame();
		calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcFrame.setSize(400, 100);
		calcFrame.setResizable(false);
		calcFrame.setVisible(true);
	}

}
