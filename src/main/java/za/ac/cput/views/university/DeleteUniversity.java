package za.ac.cput.views.university;

/*
Student name: Cameron Henry Noemdo
Student number: 219115443
DigiCape-Client
 */

import za.ac.cput.client.UniversityHttpClient;
import za.ac.cput.entity.University;
import za.ac.cput.views.UniversityMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUniversity extends JFrame implements ActionListener {
    private final JPanel northPanel, centerPanel, southPanel;
    private final JLabel lblHeading, lblUniId, lblUniName, lblUniEmail;
    private final JLabel lblViewUniName, lblViewUniEmail;
    private final JTextField txtUniId;
    private final JButton btnRead, btnClear, btnExit, btnDelete;
    private final Font ftHeading, ftText, ftTextBold;
    private final JLabel emptySpace5,emptySpace6,emptySpace7;

    public DeleteUniversity() {
        super("Delete University");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Delete University", SwingConstants.CENTER);
        lblUniId = new JLabel("University ID: ", SwingConstants.RIGHT);
        lblUniName = new JLabel("First name: ", SwingConstants.RIGHT);
        lblUniEmail = new JLabel("Email address: ", SwingConstants.RIGHT);

        txtUniId = new JTextField();
        lblViewUniName = new JLabel("");
        lblViewUniEmail = new JLabel("");

        btnRead = new JButton("Read");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
        btnDelete = new JButton("Delete");

        ftHeading = new Font("Segoe UI Black", Font.PLAIN, 28);
        ftText = new Font("Arial", Font.PLAIN, 12);
        ftTextBold = new Font("Arial", Font.BOLD, 12);

        emptySpace5 = new JLabel();
        emptySpace6 = new JLabel();
        emptySpace7 = new JLabel();
    }

    public void setGui() {
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(4,3));
        southPanel.setLayout(new GridLayout(1, 4));

        lblHeading.setFont(ftHeading);

        lblUniId.setFont(ftTextBold);
        lblUniName.setFont(ftTextBold);
        lblUniEmail.setFont(ftTextBold);

        btnRead.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);
        btnDelete.setFont(ftTextBold);
        btnClear.setFont(ftTextBold);

        txtUniId.setFont(ftText);
        lblViewUniName.setFont(ftText);
        lblViewUniEmail.setFont(ftText);

        northPanel.add(lblHeading);

        centerPanel.add(lblUniId);
        centerPanel.add(txtUniId);
        centerPanel.add(emptySpace5);

        centerPanel.add(lblUniName);
        centerPanel.add(lblViewUniName);
        centerPanel.add(emptySpace6);

        centerPanel.add(lblUniEmail);
        centerPanel.add(lblViewUniEmail);
        centerPanel.add(emptySpace7);

        southPanel.add(btnRead);
        southPanel.add(btnDelete);
        southPanel.add(btnClear);
        southPanel.add(btnExit);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        btnRead.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        btnDelete.addActionListener(this);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 220);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Read")) {
            String universityId = txtUniId.getText().trim();

            if (universityId.isEmpty() || universityId == null) {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID");
            } else {
                University result = UniversityHttpClient.read(universityId);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "University exists with ID of: " + universityId);

                    txtUniId.setEnabled(false);
                    lblViewUniName.setText(result.getUniversityName());
                    lblViewUniEmail.setText(result.getEmail());

                } else {
                    JOptionPane.showMessageDialog(null, "No university exists with ID of: " + universityId);
                }
            }
        } else if (e.getActionCommand().equals("Clear")) {
            txtUniId.setText("");
            lblViewUniName.setText("");
            lblViewUniEmail.setText("");

            txtUniId.setEnabled(true);
            txtUniId.requestFocus();
        } else if (e.getActionCommand().equals("Delete")) {
            String universityId = txtUniId.getText().trim();

            UniversityHttpClient.delete(universityId);

            JOptionPane.showMessageDialog(null, "The university with ID of: " + universityId + " was deleted.");

            txtUniId.setText("");
            lblViewUniName.setText("");
            lblViewUniEmail.setText("");

            txtUniId.setEnabled(true);
            txtUniId.requestFocus();
        } else if (e.getActionCommand().equals("Exit")) {
            new UniversityMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new DeleteUniversity().setGui();
    }
}
