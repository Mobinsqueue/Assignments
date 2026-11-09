import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SeatReservationFrame extends JFrame implements ActionListener {
    private JTextField firstNameField;             // Holds first name
    private JTextField lastNameField;              // Holds last name
    private JFormattedTextField seatNumField;      // Holds seat number
    private JFormattedTextField amountPaidField;   // Holds ticket cost
    private JLabel tableLabel;                     // Label for table display
    private JLabel seatNumLabel;                   // Label for seat number
    private JLabel firstNameLabel;                 // Label for first name
    private JLabel lastNameLabel;                  // Label for last name
    private JLabel amountPaidLabel;                // Label for amount paid
    private JButton reserveButton;                 // Triggers seat reservation
    private JButton deleteButton;                  // Triggers deletion of a reservation
    private JButton quitButton;                    // Triggers termination of GUI
    private JTable seatStatusTable;                // Table tracks seat reservations
    private final static int NUM_SEATS = 5;        // Number of seat in reservation system
    private static ArrayList<SeatInfo> seatResArr; // ArrayList of Seat objects

    /* Constructor creates GUI components and adds GUI components
       using a GridBagLayout. */
    SeatReservationFrame() {
        Object[][] tableVals = new Object[5][4];                // Seat reservation table
        String[] columnHeadings = {"Seat Number", "First Name", // Column headings for reservation table
                "Last Name", "Amount Paid"};
        GridBagConstraints layoutConst = null;                  // GUI component layout
        NumberFormat currencyFormat = null;                     // Format for amount paid

        // Set frame's title
        setTitle("Seat reservation");

        // Add 5 seat objects to ArrayList
        seatResArr = new ArrayList<SeatInfo>();
        seatsAddElements(seatResArr, NUM_SEATS);

        // Make all seats empty
        seatsMakeEmpty(seatResArr);

        // Create seat reservation table
        tableLabel = new JLabel("Seat reservation status:");
        seatNumLabel = new JLabel("Seat Number:");
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        amountPaidLabel = new JLabel("Amount Paid:");

        seatNumField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        seatNumField.setEditable(true);
        seatNumField.setValue(0);

        firstNameField = new JTextField(20);
        firstNameField.setEditable(true);
        firstNameField.setText("John");

        lastNameField = new JTextField(20);
        lastNameField.setEditable(true);
        lastNameField.setText("Doe");

        currencyFormat = NumberFormat.getCurrencyInstance();
        currencyFormat.setMaximumFractionDigits(0);
        amountPaidField = new JFormattedTextField(currencyFormat);
        amountPaidField.setEditable(true);
        amountPaidField.setValue(0.0);

        reserveButton = new JButton("Reserve");
        reserveButton.addActionListener(this);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);

        // Initialize table
        seatStatusTable = new JTable(tableVals, columnHeadings);
        seatStatusTable.setEnabled(false); // Prevent user input via table

        // Add components using GridBagLayout
        setLayout(new GridBagLayout());

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        add(tableLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 0, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.gridwidth = 4;
        add(seatStatusTable.getTableHeader(), layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.gridwidth = 4;
        add(seatStatusTable, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        add(seatNumLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        add(seatNumField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        add(firstNameLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        add(firstNameField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 3;
        add(lastNameLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 4;
        add(lastNameField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 3;
        layoutConst.gridy = 3;
        add(amountPaidLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 3;
        layoutConst.gridy = 4;
        add(amountPaidField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 4;
        layoutConst.gridy = 4;
        add(reserveButton, layoutConst);

        // Delete button sits between Reserve and Quit
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 5, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 5;
        layoutConst.gridy = 4;
        add(deleteButton, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 5, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 6;
        layoutConst.gridy = 4;
        add(quitButton, layoutConst);
    }

    /* Called when any button is pressed. */
    @Override
    public void actionPerformed(ActionEvent event) {
        SeatInfo seatElement;  // Seat information
        String firstName;      // First name
        String lastName;       // Last name
        int seatNum;           // Seat number
        int amtPaid;           // Amount paid

        // Get source of event (3 buttons in GUI)
        JButton sourceEvent = (JButton) event.getSource();

        // User pressed the reserve button
        if (sourceEvent == reserveButton) {
            seatNum = ((Number) seatNumField.getValue()).intValue();

            // User tried to reserve non-existing seat
            if (seatNum >= NUM_SEATS) {
                // Show failure dialog
                JOptionPane.showMessageDialog(this, "Seat doesn't exist!");
            }
            // User tried to reserve a non-empty seat
            else if (!(seatResArr.get(seatNum).isEmpty())) {
                // Show failure dialog
                JOptionPane.showMessageDialog(this, "Seat is not empty!");
            }
            // Reserve the specified seat
            else {
                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                amtPaid = ((Number) amountPaidField.getValue()).intValue();

                seatElement = new SeatInfo();         // Create new Seat object
                seatElement.reserveSeat(firstName, lastName, amtPaid);
                seatResArr.set(seatNum, seatElement); // Add seat to ArrayList

                updateTable();                        // Synchronize table with sts ArrayList

                // Show success dialog
                JOptionPane.showMessageDialog(this, "Seat reservation completed.");
            }
        }
        // User pressed the delete button
        else if (sourceEvent == deleteButton) {
            handleDeleteRequest();
        }
        else if (sourceEvent == quitButton) {
            dispose();                               // Terminate program
        }
    }

    /* Handles a delete request: identifies the reservation from the seat
       number field, deletes it, refreshes the table, and reports the result. */
    private void handleDeleteRequest() {
        Object seatNumValue = seatNumField.getValue(); // Seat number entered by user
        int seatNum;                                   // Seat whose reservation is deleted
        String deletedFirstName;                       // Name of deleted reservation (for message)
        String deletedLastName;

        // No (valid) seat number was identified
        if (seatNumValue == null) {
            JOptionPane.showMessageDialog(this, "Enter the seat number of the reservation to delete.");
            return;
        }

        seatNum = ((Number) seatNumValue).intValue();

        // Seat number does not exist
        if (!isValidSeatNum(seatNum)) {
            JOptionPane.showMessageDialog(this, "Seat doesn't exist!");
        }
        // Seat exists but has no reservation to delete
        else if (seatResArr.get(seatNum).isEmpty()) {
            JOptionPane.showMessageDialog(this, "No reservation exists for seat " + seatNum + ".");
        }
        else {
            // Remember who was deleted before the data is cleared
            deletedFirstName = seatResArr.get(seatNum).getFirstName();
            deletedLastName = seatResArr.get(seatNum).getLastName();

            if (deleteReservation(seatNum)) {
                updateTable(); // Refresh table using the existing update method

                // Confirmation appears only after deletion succeeded
                JOptionPane.showMessageDialog(this, "User deleted successfully: "
                        + deletedFirstName + " " + deletedLastName + " (seat " + seatNum + ").");
            }
        }
    }

    /* Deletes the reservation for the given seat. Returns true if a reservation
       was removed, false if the seat doesn't exist or was already empty.
       Contains no GUI code. */
    public static boolean deleteReservation(int seatNum) {
        boolean wasDeleted = false; // Result of the delete

        if (isValidSeatNum(seatNum) && !seatResArr.get(seatNum).isEmpty()) {
            seatResArr.get(seatNum).makeEmpty(); // Same "empty" state used at startup
            wasDeleted = true;
        }

        return wasDeleted;
    }

    /* Returns true if the seat number refers to an existing seat */
    private static boolean isValidSeatNum(int seatNum) {
        return seatNum >= 0 && seatNum < NUM_SEATS && seatNum < seatResArr.size();
    }

    /* Updates the reservation information displayed by the table */
    public void updateTable() {
        final int seatNumCol = 0;   // Col num for seat numbers
        final int firstNameCol = 1; // Col num for first names
        final int lastNameCol = 2;  // Col num for last names
        final int paidCol = 3;      // Col num for amount paid
        int i;                      // Loop index

        for (i = 0; i < NUM_SEATS && i < seatResArr.size(); ++i) {
            if (seatResArr.get(i).isEmpty()) { // Clear table entries
                seatStatusTable.setValueAt(null, i, seatNumCol);
                seatStatusTable.setValueAt(null, i, firstNameCol);
                seatStatusTable.setValueAt(null, i, lastNameCol);
                seatStatusTable.setValueAt(null, i, paidCol);
            }
            else {                             // Update table with content in the seatResArr ArrayList
                seatStatusTable.setValueAt(i, i, seatNumCol);
                seatStatusTable.setValueAt(seatResArr.get(i).getFirstName(), i, firstNameCol);
                seatStatusTable.setValueAt(seatResArr.get(i).getLastName(), i, lastNameCol);
                seatStatusTable.setValueAt(seatResArr.get(i).getAmountPaid(), i, paidCol);
            }
        }
    }

    /* Makes seats empty */
    public static void seatsMakeEmpty(ArrayList<SeatInfo> seatsRes) {
        int i;      // Loop index

        for (i = 0; i < seatsRes.size(); ++i) {
            seatsRes.get(i).makeEmpty();
        }
    }

    /* Adds empty seats to ArrayList */
    public static void seatsAddElements(ArrayList<SeatInfo> seatsRes, int numSeats) {
        int i;     // Loop index

        for (i = 0; i < numSeats; ++i) {
            seatsRes.add(new SeatInfo());
        }
    }

    /* Creates a SeatReservationFrame and makes it visible */
    public static void main(String[] args) {
        // Creates SeatReservationFrame and its components
        SeatReservationFrame myFrame = new SeatReservationFrame();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}