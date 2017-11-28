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

// This is a simple binary calculator that will calculate binary numbers and convert from binary to decimal.


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BinaryCalculatorFrame extends JFrame {
	private JTextField txtDisplay;
	private JRadioButton rdoBinary;
	private JRadioButton rdoDecimal;
	private ButtonGroup buttonGroup;
	private JButton btnZero;
	private JButton btnOne;
	private JComboBox<String> cboOperators;
	private JButton btnCompute;
	private JButton btnClear;
	
	private String operator;
	private int operand1;
	private int operand2;
	private final String[] CHOICES = {"OP", "+", "-", "*", "/", "%"};
	
    // Method Name: 	BinaryCalculatorFrame <<constructor>>
    // Parameters : 	NONE
    // Return values: 	NONE
    // Partners: 		NONE
    // Description: 	Creates and initializes everything that the frame will have
	public BinaryCalculatorFrame() {
		super();	// Calls superclass constructor for the frame
		setLayout(new FlowLayout());
		txtDisplay = new JTextField("0", 20);
		txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
		txtDisplay.setEditable(false);
		add(txtDisplay);
		
		rdoBinary = new JRadioButton("Binary", true);
		rdoDecimal= new JRadioButton("Decimal", false);
		add(rdoBinary);
		add(rdoDecimal);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoBinary);
		buttonGroup.add(rdoDecimal);
		
		rdoBinary.addItemListener(new RadioListener());
		rdoDecimal.addItemListener(new RadioListener());
		
		btnZero = new JButton("0");
		btnOne = new JButton("1");
		
		add(btnZero);
		add(btnOne);
		btnZero.addActionListener(new ButtonListener());
		btnOne.addActionListener(new ButtonListener());
		
		cboOperators = new JComboBox<String>(CHOICES);
		cboOperators.setMaximumRowCount(6);
		add(cboOperators);
		cboOperators.addItemListener(new ComboListener());
		
		btnCompute = new JButton("Compute");
		btnClear = new JButton("Clear");
		
		add(btnCompute);
		add(btnClear);
		btnCompute.addActionListener(new ButtonListener());
		btnClear.addActionListener(new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener {
		
	    // Method Name: 	actionPerformed
	    // Parameters : 	e ActionEvent
	    // Return values: 	NONE
	    // Partners: 		NONE
	    // Description: 	Overrides ActionListener method and listens for a button being pressed.
		//					Depending on the button that was pressed, the appropriate code is executed.
		@Override
		public void actionPerformed(ActionEvent e) {
			String old = txtDisplay.getText();
			String out = "";
			int value = 0;
			if (e.getSource() == btnZero) {
				out = String.format(old + "0");
				txtDisplay.setText(out);
			} else if (e.getSource() == btnOne) {
				out = String.format(old + "1");
				txtDisplay.setText(out);
			} else if (e.getSource() == btnCompute) {
				if (rdoBinary.isSelected()) {
					operand2 = Integer.parseInt(txtDisplay.getText(), 2);
				} else if (rdoDecimal.isSelected()) {
					operand2 = Integer.parseInt(txtDisplay.getText());
				}
				
				if (operator == "OP" || operator == null) {
					JOptionPane.showMessageDialog(null, "Input First Binary Number - Select an Operator - " +
							"Input Second Binary Number - Click Compute",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				if (operator == "+") {
					value = operand1 + operand2;
				} else if (operator == "-") {
					value = operand1 - operand2;
				} else if (operator == "*") {
					value = operand1 * operand2;
				} else if (operator == "/") {
					value = operand1 / operand2;
				} else if (operator == "%") {
					value = operand1 % operand2;
				}
				
				if (rdoBinary.isSelected()) {
					out = String.format(Integer.toBinaryString(value));
				} else if (rdoDecimal.isSelected()) {
					out = String.format(Integer.toString(value));
				}

				cboOperators.setSelectedIndex(0);
				txtDisplay.setText(out);
				
			} else if (e.getSource() == btnClear) {
				operand1 = 0;
				operand2 = 0;
				txtDisplay.setText("0");
				cboOperators.setSelectedIndex(0);
			}
		} // end actionPerformed
	}
	
	private class ComboListener implements ItemListener {

	    // Method Name: 	itemStateChanged
	    // Parameters : 	e ItemEvent
	    // Return values: 	NONE
	    // Partners: 		NONE
	    // Description: 	Overrides ItemListener method and listens for the JComboBox state change
		//					Prepares the appropriate operator to compute calculations
		@Override
		public void itemStateChanged(ItemEvent e) {
			operator = CHOICES[cboOperators.getSelectedIndex()];
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (operator == "OP" && operand2 == 0) {
					JOptionPane.showMessageDialog(null, "Input First Binary Number - Select an Operator - " +
													"Input Second Binary Number - Click Compute",
													"ERROR", JOptionPane.ERROR_MESSAGE);
				} else if (operand2 == 0) {
					operand1 = Integer.parseInt(txtDisplay.getText(), 2);
					operand2 = 0;
					txtDisplay.setText(Integer.toString(operand2));
				} else if (operand2 != 0 && !(rdoDecimal.isSelected())) {
					operand1 = Integer.parseInt(txtDisplay.getText(), 2);
					txtDisplay.setText("0");
				}
			}
		} // end itemStateChanged
		
	}
	
	private class RadioListener implements ItemListener {
	    // Method Name: 	itemStateChanged
	    // Parameters : 	e ItemEvent
	    // Return values: 	NONE
	    // Partners: 		NONE
	    // Description: 	Overrides ItemListener method and listens for radio button state change.
		//					Prepares the calculation if operand2 is a string or binary value
		@Override
		public void itemStateChanged(ItemEvent e) {
			JRadioButton button = (JRadioButton) e.getSource();
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (button.getText().equals("Binary")) {
					operand2 = Integer.parseInt(txtDisplay.getText());
					txtDisplay.setText(Integer.toBinaryString(operand2));
				} else if (button.getText().equals("Decimal")) {
					operand2 = Integer.parseInt(txtDisplay.getText(), 2);
					txtDisplay.setText(Integer.toString(operand2));
				}
			} // end itemStateChanged
		}
	}
}