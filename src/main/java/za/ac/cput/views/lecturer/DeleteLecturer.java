package za.ac.cput.views.lecturer;

/*
Student name: Cameron Henry Noemdo
Student number: 219115443
DigiCape-Client
 */

import za.ac.cput.client.LecturerHttpClient;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.views.LecturerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteLecturer extends JFrame implements ActionListener {

    private final JPanel northPanel;
    private final JPanel centerPanel;
    private final JPanel southPanel;
    private final JLabel lblHeading;
    private final JLabel lblLecturerId;
    private final JLabel lblFirstName;
    private final JLabel lblMiddleName;
    private final JLabel lblLastName;
    private final JLabel lblLecturerEmail;
    private final JLabel lblDepartmentId;
    private final JLabel lblViewFirstName;
    private final JLabel lblViewMiddleName;
    private final JLabel lblViewLastName;
    private final JLabel lblViewLecturerEmail;
    private final JLabel lblViewDepartmentId;
    private final JTextField txtLecturerId;
    private final JButton btnRead;
    private final JButton btnDelete;
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

    public DeleteLecturer() {
        super("Delete Lecturer");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Delete Lecturer", SwingConstants.CENTER);
        lblLecturerId = new JLabel("Lecturer ID: ", SwingConstants.RIGHT);
        lblFirstName = new JLabel("First name: ", SwingConstants.RIGHT);
        lblMiddleName = new JLabel("Middle name: ", SwingConstants.RIGHT);
        lblLastName = new JLabel("Last name: ", SwingConstants.RIGHT);
        lblLecturerEmail = new JLabel("Email address: ", SwingConstants.RIGHT);
        lblDepartmentId = new JLabel("Department ID: ", SwingConstants.RIGHT);

        txtLecturerId = new JTextField();
        lblViewFirstName = new JLabel("");
        lblViewMiddleName = new JLabel("");
        lblViewLastName = new JLabel("");
        lblViewLecturerEmail = new JLabel("");
        lblViewDepartmentId = new JLabel("");

        btnRead = new JButton("Read");
        btnDelete = new JButton("Delete");
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
    }

    public void setGui() {
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(7, 3));
        southPanel.setLayout(new GridLayout(1, 4));

        lblHeading.setFont(ftHeading);

        lblLecturerId.setFont(ftTextBold);
        lblFirstName.setFont(ftTextBold);
        lblMiddleName.setFont(ftTextBold);
        lblLastName.setFont(ftTextBold);
        lblLecturerEmail.setFont(ftTextBold);
        lblDepartmentId.setFont(ftTextBold);

        btnRead.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtLecturerId.setFont(ftText);
        lblViewFirstName.setFont(ftText);
        lblViewMiddleName.setFont(ftText);
        lblViewLastName.setFont(ftText);
        lblViewLecturerEmail.setFont(ftText);
        lblViewDepartmentId.setFont(ftText);

        northPanel.add(lblHeading);

        centerPanel.add(lblLecturerId);
        centerPanel.add(txtLecturerId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblFirstName);
        centerPanel.add(lblViewFirstName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblMiddleName);
        centerPanel.add(lblViewMiddleName);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblLastName);
        centerPanel.add(lblViewLastName);
        centerPanel.add(emptySpace4);

        centerPanel.add(lblLecturerEmail);
        centerPanel.add(lblViewLecturerEmail);
        centerPanel.add(emptySpace5);

        centerPanel.add(lblDepartmentId);
        centerPanel.add(lblViewDepartmentId);
        centerPanel.add(emptySpace6);

        southPanel.add(btnRead);
        southPanel.add(btnDelete);
        southPanel.add(btnClear);
        southPanel.add(btnExit);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        btnRead.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 320);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Read")) {
            String lecturerId = txtLecturerId.getText().trim();

            if (lecturerId.isEmpty() || lecturerId == null) {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID");
            } else {
                Lecturer result = LecturerHttpClient.read(lecturerId);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "Lecturer exist with ID of: " + lecturerId);

                    txtLecturerId.setEnabled(false);
                    lblViewFirstName.setText(result.getFirstName());
                    lblViewMiddleName.setText(result.getMiddleName());
                    lblViewLastName.setText(result.getLastName());
                    lblViewLecturerEmail.setText(result.getLecturerEmail());
                    lblViewDepartmentId.setText(result.getDepartmentId());

                } else {
                    JOptionPane.showMessageDialog(null, "No lecturer exists with ID of: " + lecturerId);
                }
            }
        } else if (e.getActionCommand().equals("Delete")) {
            String lecturerId = txtLecturerId.getText().trim();

            LecturerHttpClient.delete(lecturerId);

            JOptionPane.showMessageDialog(null, "The lecturer with ID of: " + lecturerId + " was deleted.");

            txtLecturerId.setText("");
            lblViewFirstName.setText("");
            lblViewMiddleName.setText("");
            lblViewLastName.setText("");
            lblViewLecturerEmail.setText("");
            lblViewDepartmentId.setText("");

            txtLecturerId.setEnabled(true);
            txtLecturerId.requestFocus();
        } else if (e.getActionCommand().equals("Clear")) {
            txtLecturerId.setText("");
            lblViewFirstName.setText("");
            lblViewMiddleName.setText("");
            lblViewLastName.setText("");
            lblViewLecturerEmail.setText("");
            lblViewDepartmentId.setText("");

            txtLecturerId.setEnabled(true);
            txtLecturerId.requestFocus();
        } else if (e.getActionCommand().equals("Exit")) {
            new LecturerMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new DeleteLecturer().setGui();
    }
}
