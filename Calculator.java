import javax.swing.*;
import java.awt.*;

public class Calculator {
    // Declare instance variables for GUI components
    private JFrame frame; 
    private JLabel label1, label2, label3;
    private JTextField textField1, textField2; 
    private JButton addButton, subButton; 

    public Calculator() {
        // Create and configure the GUI components (Setting Labels + textField size)
        label1 = new JLabel("Enter number 1: ");
        textField1 = new JTextField(5);

        label2 = new JLabel("Enter number 2: ");
        textField2 = new JTextField(5);

        addButton = new JButton("Add");
        subButton = new JButton("Subtract");

        label3 = new JLabel("Result: ");

        // Add event listeners to the buttons using lambda functions. If the button is clicked, call a function
        addButton.addActionListener(e -> performAddition()); 
        subButton.addActionListener(e -> performSubtraction()); 

        // Create the panel and add all the GUI elements to the panel
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(addButton);
        panel.add(subButton);

        // Create and configure the frame 
        frame = new JFrame("Simple Calculator");
        frame.setSize(250, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add the panel to the center of the frame
        frame.add(panel, BorderLayout.CENTER); 
        // add the result label to the bottom of the frame
        frame.add(label3, BorderLayout.SOUTH); 
        frame.setVisible(true);
    }

    //Method to add 2 numbers
    private void performAddition() {
        // Get text from both input fields and trim them to remove any whitespace
        String input1 = textField1.getText().trim(); 
        String input2 = textField2.getText().trim();

        // If both inputs are valid, convert both input fields to double. To check if they are valid, call the isValidInput function
        if (isValidInput(input1) && isValidInput(input2)) { 
            double num1 = Double.parseDouble(input1); 
            double num2 = Double.parseDouble(input2);
            double result = num1 + num2; 
            // Format the result to 2 decimal places
            label3.setText("Result: " + String.format("%.2f", result)); 
        } else { 
            // If either input is invalid, call the Error Message Function
            errorMessage(); 
        }
    }

    // Method to subtract 2 numbers
    private void performSubtraction() {
        // Get text from both input fields and trim them to remove any whitespace
        String input1 = textField1.getText().trim();
        String input2 = textField2.getText().trim(); 

        // If both inputs are valid, convert both input fields to double. To check if they are valid, call the isValidInput function
        if (isValidInput(input1) && isValidInput(input2)) { 
            double num1 = Double.parseDouble(input1); 
            double num2 = Double.parseDouble(input2); 
            double result = num1 - num2; 
            // Format the result to 2 decimal places
            label3.setText("Result: " + String.format("%.2f", result));
        } else { 
            // If either input is invalid, call the Error Message Function
            errorMessage();
        }
    }

 //Method to check if input is valid
private boolean isValidInput(String input) {
    // \d+ represents one or more digit 
    // \.\d+ represnts a decimal point followed by a one or more digits. 
    // If it does not have this format, return false
    return input.matches("\\d+(\\.\\d+)?");
}

// This method displays an error message if the user input is not valid.
private void errorMessage() {
    // Pop up to tell user to enter a valid number
    JOptionPane.showMessageDialog(frame, "Please enter valid numbers!");

    // Resetting all the textFields
    textField1.setText("");
    textField2.setText("");
    label3.setText("Result: ");
}

// When the program is run, the main method is executed first.
public static void main(String[] args) {
    Calculator calculator = new Calculator();
}

}