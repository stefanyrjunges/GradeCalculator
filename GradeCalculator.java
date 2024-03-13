/* 
 * GradeCalculator.java
 * @author: Stefany R Junges
 * 02/02/2024
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;

public class GradeCalculator extends JFrame implements ActionListener {
    
    JLabel title, resultTitle, grade, weight, percent_one, percent_two, finalGrade;
    JTextField firstInput, secondInput, result;
    JButton calculate, reset;    

    public GradeCalculator() {
        
        JFrame frame = new JFrame();
        
        grade = new JLabel("Grade:");
        percent_one = new JLabel("%");
        percent_two = new JLabel("%");
        weight = new JLabel("Weight:");
        resultTitle = new JLabel("Result:");
        finalGrade = new JLabel("of your final grade");

        firstInput = new JTextField(10);
        secondInput = new JTextField(10);
        result = new JTextField(10);

        calculate = new JButton("Calculate");
        reset = new JButton("Reset");

        JPanel panel = new JPanel();        
        panel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
        panel.setLayout(new GridLayout(4, 0, 0, 10));

        panel.add(grade);
        panel.add(firstInput);
        panel.add(percent_one);    
        panel.add(weight);
        panel.add(secondInput);
        panel.add(percent_two);
        panel.add(calculate);
        panel.add(reset);
        
        calculate.addActionListener(this);
        reset.addActionListener(this);
        
        panel.add(Box.createHorizontalStrut(0));
        panel.add(resultTitle);
        panel.add(result);
        panel.add(finalGrade);
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Final grade calculator");
        frame.pack();
        frame.setVisible(true);

    }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == calculate) {
                try {
                    String gradeString = firstInput.getText();
                    String weightString = secondInput.getText();
                    
                    gradeString = gradeString.replace(',', '.');
                    weightString = weightString.replace(',', '.');

                    double grade = Double.parseDouble(gradeString);
                    double weight = Double.parseDouble(weightString);
                    double finalGrade = (grade * weight) / 100;

                    result.setText(String.valueOf(finalGrade + "%"));
                    
                } catch (NumberFormatException nfe) {
                    showMessageDialog(null, "Please enter a number");
                }
            } else if (e.getSource() == reset) {
                firstInput.setText("");
                secondInput.setText("");
                result.setText("");}
        }

    public static void main(String[] args) {
        new GradeCalculator();
    }
}
