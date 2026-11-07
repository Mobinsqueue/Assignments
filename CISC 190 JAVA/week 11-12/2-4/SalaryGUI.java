import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryGUI {
    public static void main(String[] args) {
        JFrame topFrame = new JFrame("Salary");
        topFrame.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel wageLabel = new JLabel("Hourly wage:");
        JLabel salaryLabel = new JLabel("Yearly salary:");
        JTextField wageField = new JTextField(15);
        JTextField salaryField = new JTextField(15);
        salaryField.setEditable(false);
        JButton calculateButton = new JButton("Calculate");
        JButton resetButton = new JButton("Reset");

        // Calculate: hourly wage * 40 hours * 50 weeks
        calculateButton.addActionListener(e -> {
            double hourlyWage = Double.parseDouble(wageField.getText());
            salaryField.setText("$" + (hourlyWage * 40 * 50));
        });

        // Reset: clear both fields
        resetButton.addActionListener(e -> {
            wageField.setText("");
            salaryField.setText("");
        });

        topFrame.add(wageLabel);
        topFrame.add(wageField);
        topFrame.add(salaryLabel);
        topFrame.add(salaryField);
        topFrame.add(calculateButton);
        topFrame.add(resetButton);

        topFrame.pack();
        topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topFrame.setVisible(true);
    }
}