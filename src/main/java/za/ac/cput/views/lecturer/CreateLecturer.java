package za.ac.cput.views.lecturer;

import za.ac.cput.client.LecturerHttpClient;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.factory.LecturerFactory;
import za.ac.cput.views.LecturerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateLecturer extends JFrame implements ActionListener {

    private final JPanel northPanel, centerPanel, southPanel;
    private final JLabel lblHeading, lblLecturerId, lblLecturerIdGenerated, lblFirstName, lblMiddleName, lblLastName, lblLecturerEmail, lblDepartmentId;
    private final JTextField txtFirstName, txtMiddleName, txtLastName, txtLecturerEmail, txtDepartmentId;
    private final JButton btnCreate, btnExit;
    private final Font ftHeading, ftText, ftTextBold;
    private final JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8;

    public CreateLecturer() {
        super("Create Lecturer");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();


        lblHeading = new JLabel("Create Lecturer", SwingConstants.CENTER);
        lblLecturerId = new JLabel("Lecturer ID: ", SwingConstants.RIGHT);
        lblFirstName = new JLabel("First Name: ", SwingConstants.RIGHT);
        lblMiddleName = new JLabel("Middle Name: ", SwingConstants.RIGHT);
        lblLastName = new JLabel("Last Name: ", SwingConstants.RIGHT);
        lblLecturerEmail = new JLabel("Email address: ", SwingConstants.RIGHT);
        lblDepartmentId = new JLabel("Department ID: ", SwingConstants.RIGHT);

        lblLecturerIdGenerated = new JLabel("Auto Generated...");
        txtFirstName = new JTextField();
        txtMiddleName = new JTextField();
        txtLastName = new JTextField();
        txtLecturerEmail = new JTextField();
        txtDepartmentId = new JTextField();

        btnCreate = new JButton("Create");
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
        emptySpace7 = new JLabel();
        emptySpace8 = new JLabel();
    }

    public void setGui() {
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(8, 3));
        southPanel.setLayout(new GridLayout(2, 2));

        lblHeading.setFont(ftHeading);

        lblLecturerId.setFont(ftTextBold);
        lblFirstName.setFont(ftTextBold);
        lblMiddleName.setFont(ftTextBold);
        lblLastName.setFont(ftTextBold);
        lblLecturerEmail.setFont(ftTextBold);
        lblDepartmentId.setFont(ftTextBold);

        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        lblLecturerIdGenerated.setFont(ftText);
        txtFirstName.setFont(ftText);
        txtMiddleName.setFont(ftText);
        txtLastName.setFont(ftText);
        txtLecturerEmail.setFont(ftText);
        txtDepartmentId.setFont(ftText);

        northPanel.add(lblHeading);

        centerPanel.add(lblLecturerId);
        centerPanel.add(lblLecturerIdGenerated);
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

        southPanel.add(emptySpace7);
        southPanel.add(emptySpace8);
        southPanel.add(btnCreate);
        southPanel.add(btnExit);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        btnCreate.addActionListener(this);
        btnExit.addActionListener(this);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 420);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create")) {
            String firstName = txtFirstName.getText().trim();
            String middleName = txtMiddleName.getText().trim();
            String lastName = txtLastName.getText().trim();
            String lecturerEmail = txtLecturerEmail.getText().trim();
            String departmentId = txtDepartmentId.getText().trim();

            if (firstName.isEmpty() || lastName.isEmpty() || lecturerEmail.isEmpty() || departmentId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a profile.");
            } else {
                Lecturer createLecturer = LecturerFactory.createLecturer(firstName, middleName, lastName, lecturerEmail, departmentId);
                Lecturer result = LecturerHttpClient.create(createLecturer);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "Lecturer successfully created");

                    txtFirstName.setText("");
                    txtMiddleName.setText("");
                    txtLastName.setText("");
                    txtLecturerEmail.setText("");
                    txtDepartmentId.setText("");

                    txtFirstName.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Error creating lecturer");
                }
            }
        } else if (e.getActionCommand().equals("Exit")) {
            new LecturerMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new CreateLecturer().setGui();
    }
}
