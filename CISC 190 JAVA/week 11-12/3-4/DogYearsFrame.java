import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DogYearsFrame extends JFrame implements ChangeListener {
    private JSpinner dogYearsSpinner;   // Triggers human age calculation
    private JTextField humanAgeField;   // Displays dog's age in human years
    private JLabel dogYearsLabel;       // Label for dog years
    private JLabel humanAgeLabel;       // Label for human years

    /* Constructor creates GUI components and adds GUI components
       using a GridBagLayout. */
    DogYearsFrame() {
        double initYear;    // Spinner initial value display
        double minYear;     // Spinner min value
        double maxYear;     // Spinner max value
        double stepVal;     // Spinner step

        initYear = 0.0;
        minYear = 0.0;
        maxYear = 30.0;
        stepVal = 0.5;

        // Used to specify GUI component layout
        GridBagConstraints layoutConst = null;

        // Specifies the types of values displayed in spinner
        SpinnerNumberModel spinnerModel = null;

        // Set frame's title
        setTitle("Dog's age in human years");

        // Create labels
        dogYearsLabel = new JLabel("Select dog's age (years):");
        humanAgeLabel = new JLabel("Age (human years):");

        // Create a spinner model (doubles, so values are Double), the spinner,
        // and set the change listener
        spinnerModel = new SpinnerNumberModel(initYear, minYear, maxYear, stepVal);
        dogYearsSpinner = new JSpinner(spinnerModel);
        dogYearsSpinner.addChangeListener(this);

        // Create field
        humanAgeField = new JTextField(15);
        humanAgeField.setEditable(false);
        humanAgeField.setText("0 - 15");

        // Use a GridBagLayout
        setLayout(new GridBagLayout());

        // Specify component's grid location
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        add(dogYearsLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(dogYearsSpinner, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        add(humanAgeLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        add(humanAgeField, layoutConst);
    }

    @Override
    public void stateChanged(ChangeEvent event) {
        Double dogAgeYears;     // Dog age input (Double since step is 0.5)
        int halfYearSteps;      // Dog age in half-year steps (switch needs an integral type)

        dogAgeYears = (Double) dogYearsSpinner.getValue();
        halfYearSteps = (int) Math.round(dogAgeYears * 2.0);

        // Choose output based on dog's age (each case is one half year).
        // Half-year values are the average of the surrounding whole-year values.
        switch (halfYearSteps) {
            case 0:     // 0.0
                humanAgeField.setText("0 - 15");
                break;

            case 1:     // 0.5
                humanAgeField.setText("7.5");
                break;

            case 2:     // 1.0
                humanAgeField.setText("15");
                break;

            case 3:     // 1.5
                humanAgeField.setText("19.5");
                break;

            case 4:     // 2.0
                humanAgeField.setText("24");
                break;

            case 5:     // 2.5
                humanAgeField.setText("26");
                break;

            case 6:     // 3.0
                humanAgeField.setText("28");
                break;

            case 7:     // 3.5
                humanAgeField.setText("30");
                break;

            case 8:     // 4.0
                humanAgeField.setText("32");
                break;

            case 9:     // 4.5
                humanAgeField.setText("34.5");
                break;

            case 10:    // 5.0
                humanAgeField.setText("37");
                break;

            case 11:    // 5.5
                humanAgeField.setText("39.5");
                break;

            case 12:    // 6.0
                humanAgeField.setText("42");
                break;

            case 13:    // 6.5
                humanAgeField.setText("44.5");
                break;

            case 14:    // 7.0
                humanAgeField.setText("47");
                break;

            case 15:    // 7.5
                humanAgeField.setText("49.5");
                break;

            case 16:    // 8.0
                humanAgeField.setText("52");
                break;

            case 17:    // 8.5
                humanAgeField.setText("54.5");
                break;

            case 18:    // 9.0
                humanAgeField.setText("57");
                break;

            case 19:    // 9.5
                humanAgeField.setText("59.5");
                break;

            case 20:    // 10.0
                humanAgeField.setText("62");
                break;

            case 21:    // 10.5
                humanAgeField.setText("64.5");
                break;

            case 22:    // 11.0
                humanAgeField.setText("67");
                break;

            case 23:    // 11.5
                humanAgeField.setText("69.5");
                break;

            case 24:    // 12.0
                humanAgeField.setText("72");
                break;

            case 25:    // 12.5
                humanAgeField.setText("74.5");
                break;

            case 26:    // 13.0
                humanAgeField.setText("77");
                break;

            case 27:    // 13.5
                humanAgeField.setText("79.5");
                break;

            case 28:    // 14.0
                humanAgeField.setText("82");
                break;

            default:
                humanAgeField.setText("That's a long life!");
        }
    }

    /* Creates a DogYearsFrame and makes it visible */
    public static void main(String[] args) {
        // Creates DogYearsFrame and its components
        DogYearsFrame myFrame = new DogYearsFrame();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}