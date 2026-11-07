import javax.swing.JFrame;
import javax.swing.JTextField;

public class SalaryGUI {
    public static void main(String[] args) {
        int hourlyWage;
        JFrame topFrame = null;        // Application window
        JTextField outputField = null; // Displays output salary

        hourlyWage = 35;

        // Create text field
        outputField = new JTextField();

        // Display program output using the text field
        outputField.setText("An hourly wage of " + hourlyWage + "/hr" +
                " yields $" + (hourlyWage * 30 * 52) + "/yr.");
        //changing these numbers changes how many hours and how many weeks in a year so annual salary changes

        // Prevent user from editing output text
        outputField.setEditable(true);
        //changing to true allows for user to change output, false makes it read only

        // Create window
        topFrame = new JFrame("annual salary calculator");
        //changed the title of page

        // Add text field to window
        topFrame.add(outputField);

        // Resize window to fit components
        topFrame.pack();

        // Set program to terminate when window is closed
        topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //changing will dictate which button closes the application

        // Display window
        topFrame.setVisible(true);
        //setting to false hides the window
    }
}