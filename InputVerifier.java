import javax.swing.*;
import java.awt.event.*;

public class Testing {
    public static void main(String[] args) {
        // Create components
        JFrame frame = new JFrame("Integer Input Verifier");
        JLabel inputLabel = new JLabel("Enter an integer:");
        JTextField inputField = new JTextField(10);
        JButton verifyButton = new JButton("Verify");
        JButton cancelButton = new JButton("Cancel");
        JLabel resultLabel = new JLabel("");

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(verifyButton);
        panel.add(cancelButton);
        panel.add(resultLabel);
        frame.add(panel);

        // Set frame properties
        frame.setSize(300, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        // Add action listeners
        verifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();

                try {
                    int value = Integer.parseInt(input);
                    resultLabel.setText(input + " is an integer.");
                } catch (NumberFormatException ex) {
                    resultLabel.setText(input + " is not an integer.");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}