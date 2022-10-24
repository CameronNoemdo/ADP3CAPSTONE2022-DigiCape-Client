package za.ac.cput.views.lecturer;

import za.ac.cput.client.LecturerHttpClient;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.factory.LecturerFactory;
import za.ac.cput.views.LecturerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateLecturer extends JFrame implements ActionListener {

    private final JPanel northPanel;
    private final JPanel centerPanel;
    private final JPanel southPanel;
    private final JPanel radioPanel;
    private final JLabel lblHeading;
    private final JLabel lblLecturerId;
    private final JLabel lblFirstName;
    private final JLabel lblMiddleName;
    private final JLabel lblLastName;
    private final JLabel lblLecturerEmail;
    private final JLabel lblDepartmentId;
    private final JTextField txtLecturerId;
    private final JTextField txtFirstName;
    private final JTextField txtMiddleName;
    private final JTextField txtLastName;
    private final JTextField txtLecturerEmail;
    private final JTextField txtDepartmentId;
    private final JButton btnRead;
    private final JButton btnUpdate;
    private final JButton btnClear;
    private final JButton btnExit;
    private final Font ftHeading;
    private final Font ftText;
    private final Font ftTextBold;
    private final JLabel emptySpace1;
    private final JLabel emptySpace2;
    private final JLabel emptySpace3;
    private final JLabel emptySpace4;
    private final JLabel emptySpace5;
    private final JLabel emptySpace6;
    private final JLabel emptySpace10;
    private final JLabel emptySpace11;
    private final JLabel emptySpace12;
    private final JLabel emptySpace13;

    public UpdateLecturer() {
        super("Update Lecturer");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();

        lblHeading = new JLabel("Update Lecturer", SwingConstants.CENTER);
        lblLecturerId = new JLabel("Lecturer ID: ", SwingConstants.RIGHT);
        lblFirstName = new JLabel("First name: ", SwingConstants.RIGHT);
        lblMiddleName = new JLabel("Middle name: ", SwingConstants.RIGHT);
        lblLastName = new JLabel("Last name: ", SwingConstants.RIGHT);
        lblLecturerEmail = new JLabel("Email address: ", SwingConstants.RIGHT);
        lblDepartmentId = new JLabel("Department ID: ", SwingConstants.RIGHT);

        txtLecturerId = new JTextField();
        txtFirstName = new JTextField();
        txtMiddleName = new JTextField();
        txtLastName = new JTextField();
        txtLecturerEmail = new JTextField();
        txtDepartmentId = new JTextField();


        btnRead = new JButton("Read");
        btnUpdate = new JButton("Update");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

        ftHeading = new Font("Segoe UI Black", Font.PLAIN, 28);
        ftText = new Font("Arial", Font.PLAIN, 12);
        ftTextBold = new Font("Arial", Font.BOLD, 12);

        emptySpace1 = new JLabel();
        emptySpace2 = new JLabel();
        emptySpace3 = new JLabel();
        emptySpace4 = new JLabel();
        emptySpace5 = new JLabel();
        emptySpace6 = new JLabel();
        emptySpace10 = new JLabel();
        emptySpace11 = new JLabel();
        emptySpace12 = new JLabel();
        emptySpace13 = new JLabel();

        setTextFieldToUneditable();
    }


    public void setGui() {
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(8, 3));
        southPanel.setLayout(new GridLayout(2, 4));
        radioPanel.setLayout(new GridLayout(1, 2));

        lblHeading.setFont(ftHeading);

        lblLecturerId.setFont(ftTextBold);
        lblFirstName.setFont(ftTextBold);
        lblMiddleName.setFont(ftTextBold);
        lblLastName.setFont(ftTextBold);
        lblLecturerEmail.setFont(ftTextBold);
        lblDepartmentId.setFont(ftTextBold);

        btnUpdate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtLecturerId.setFont(ftText);
        txtFirstName.setFont(ftText);
        txtMiddleName.setFont(ftText);
        txtLastName.setFont(ftText);
        txtLecturerEmail.setFont(ftText);
        txtDepartmentId.setFont(ftText);


        northPanel.add(lblHeading);

        centerPanel.add(lblLecturerId);
        centerPanel.add(txtLecturerId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblFirstName);
        centerPanel.add(txtFirstName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblMiddleName);
        centerPanel.add(txtMiddleName);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblLastName);
        centerPanel.add(txtLastName);
        centerPanel.add(emptySpace4);


        centerPanel.add(lblLecturerEmail);
        centerPanel.add(txtLecturerEmail);
        centerPanel.add(emptySpace5);

        centerPanel.add(lblDepartmentId);
        centerPanel.add(txtDepartmentId);
        centerPanel.add(emptySpace6);

        southPanel.add(emptySpace10);
        southPanel.add(emptySpace11);
        southPanel.add(emptySpace12);
        southPanel.add(emptySpace13);
        southPanel.add(btnRead);
        southPanel.add(btnUpdate);
        southPanel.add(btnClear);
        southPanel.add(btnExit);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        btnRead.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 420);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Read")) {
            String lecturerId = txtLecturerId.getText().trim();

            if (lecturerId.isEmpty() || lecturerId == null) {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            } else {

                Lecturer oldLecturer = LecturerHttpClient.read(lecturerId);

                if (oldLecturer != null) {
                    JOptionPane.showMessageDialog(null, "Lecturer exist with ID of: " + lecturerId);

                    txtLecturerId.setEnabled(false);
                    txtFirstName.setText(oldLecturer.getFirstName());
                    txtMiddleName.setText(oldLecturer.getMiddleName());
                    txtLastName.setText(oldLecturer.getLastName());
                    txtLecturerEmail.setText(oldLecturer.getLecturerEmail());
                    txtDepartmentId.setText(oldLecturer.getDepartmentId());

                    setTextFieldToEditable(); //Set all fields to editable
                    txtLecturerId.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "No lecturer exists with ID of: " + lecturerId);
                }
            }
        } else if (e.getActionCommand().equals("Update")) {
            String lecturerId = txtLecturerId.getText().trim();
            String firstName = txtFirstName.getText().trim();
            String middleName = txtMiddleName.getText().trim();
            String lastName = txtLastName.getText().trim();
            String email = txtLecturerEmail.getText().trim();
            String departmentId = txtDepartmentId.getText().trim();

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || departmentId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all information to update a lecturer.");
            } else {
                Lecturer updateLecturer = LecturerFactory.updateLecturer(lecturerId, firstName, middleName, lastName, email, departmentId);

                Lecturer result = LecturerHttpClient.update(updateLecturer);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated your profile.");

                    txtLecturerId.setText("");
                    txtFirstName.setText("");
                    txtMiddleName.setText("");
                    txtLastName.setText("");
                    txtLecturerEmail.setText("");
                    txtDepartmentId.setText("");

                    txtLecturerId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating your profile.");
                }
            }
        } else if (e.getActionCommand().equals("Clear")) {
            txtLecturerId.setText("");
            txtFirstName.setText("");
            txtMiddleName.setText("");
            txtLastName.setText("");
            txtLecturerEmail.setText("");
            txtDepartmentId.setText("");

            txtLecturerId.requestFocus();
            setTextFieldToUneditable();
        } else if (e.getActionCommand().equals("Exit")) {
            new LecturerMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable() {
        txtLecturerId.setEnabled(true);
        txtFirstName.setEnabled(false);
        txtMiddleName.setEnabled(false);
        txtMiddleName.setEnabled(false);
        txtLecturerEmail.setEnabled(false);
        txtDepartmentId.setEnabled(false);

    }

    public void setTextFieldToEditable() {
        txtLecturerId.setEnabled(false);
        txtFirstName.setEnabled(true);
        txtMiddleName.setEnabled(true);
        txtMiddleName.setEnabled(true);
        txtLecturerEmail.setEnabled(true);
        txtDepartmentId.setEnabled(true);
    }


    public static void main(String[] args) {
        new UpdateLecturer().setGui();
    }
}
