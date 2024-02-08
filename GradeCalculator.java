/* 
 * GradeCalculator.java
 * @author: Stefany R Junges
 * 02/02/2024
 */

// Importing necessary packages for the interface
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;

// Main class
public class GradeCalculator extends JFrame implements ActionListener {

    // Declaring the variables outside the constructor so it can be accessed throughout the class
    JLabel title, grade, weight, resultTitle, percent_one, percent_two, finalGrade;
    JTextField firstInput, secondInput, result;
    JButton calculate, reset;    

    // Creating a class constructor for the main class
    public GradeCalculator() {

        // Creating the frame in which the objects will be placed
        JFrame frame = new JFrame();

        // Creating the labels
        grade = new JLabel("Grade:");
        percent_one = new JLabel("%");
        percent_two = new JLabel("%");
        weight = new JLabel("Weight:");
        resultTitle = new JLabel("Result:");
        finalGrade = new JLabel("of your final grade");

        // Creating the fields
        firstInput = new JTextField(10);
        secondInput = new JTextField(10);
        result = new JTextField(10);

        // Creating the buttons
        calculate = new JButton("Calculate");
        reset = new JButton("Reset");

        // Creating a new panel to place the objects
        JPanel panel = new JPanel();
        
        // Changing the window size and layout
        panel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
        panel.setLayout(new GridLayout(4, 0, 0, 10));

        // Adding labels, text fields and buttons to the panel
        panel.add(grade);
        panel.add(firstInput);
        panel.add(percent_one);
        
        panel.add(weight);
        panel.add(secondInput);
        panel.add(percent_two);

        panel.add(calculate);
        panel.add(reset);

        // Adding ActionListener to the buttons
        calculate.addActionListener(this);
        reset.addActionListener(this);

        // Adding space between the objects
        panel.add(Box.createHorizontalStrut(0));

        // Adding the remaining labels and text fields
        panel.add(resultTitle);
        panel.add(result);
        panel.add(finalGrade); 

        // Adding the panel to the frame
        frame.add(panel);

        // Setting what happens when frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the window's title
        frame.setTitle("Final grade calculator");

        // Setting the window to match its components' size
        frame.pack();

        // Setting the window to visible
        frame.setVisible(true);

    }

        // Creating the ActionListener that will be triggered when the buttons are pressed
        @Override
        public void actionPerformed(ActionEvent e) {
            // If "Calculate" button is pressed
            if (e.getSource() == calculate) {
                try {
                    // Storing the first and second inputs in variables that will first hold the inputs as strings
                    String gradeString = firstInput.getText();
                    String weightString = secondInput.getText();

                    // Replacing commas with dots in case the user provides a number with a comma
                    gradeString = gradeString.replace(',', '.');
                    weightString = weightString.replace(',', '.');

                    // Parsing the strings as doubles
                    double grade = Double.parseDouble(gradeString);
                    double weight = Double.parseDouble(weightString);

                    // Calculating the final grade (diving by 100 because the result is in %)
                    double finalGrade = (grade * weight) / 100;
                    
                    // Displaying the final result
                    result.setText(String.valueOf(finalGrade + "%"));
                } catch (NumberFormatException nfe) {
                    // Displaying a message if the numbers provided by the user are in the wrong format or if the text fields are empty
                    showMessageDialog(null, "Please enter a number");

                }
            // If "Reset" button is pressed
            } else if (e.getSource() == reset) {
                // Clearing the text fields
                firstInput.setText("");
                secondInput.setText("");
                result.setText("");}
        }

    public static void main(String[] args) {
        
        // Constructor to initialize the window 
        new GradeCalculator();

    }
}
