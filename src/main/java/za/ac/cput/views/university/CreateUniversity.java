package za.ac.cput.views.university;

/*
Student name: Cameron Henry Noemdo
Student number: 219115443
DigiCape-Client
 */

import za.ac.cput.client.UniversityHttpClient;
import za.ac.cput.entity.University;
import za.ac.cput.factory.UniversityFactory;
import za.ac.cput.views.UniversityMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUniversity extends JFrame implements ActionListener {

    private final JPanel northPanel, centerPanel, southPanel;
    private final JLabel lblHeading, lblUniId, lblUniIdGenerated, lblUniName, lblUniEmail;
    private final JTextField txtUniName, txtUniEmail;
    private final JButton btnCreate, btnExit;
    private final Font ftHeading, ftText, ftTextBold;
    private final JLabel emptySpace1, emptySpace2, emptySpace5, emptySpace7, emptySpace8;

    public CreateUniversity() {
        super("Create University");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();


        lblHeading = new JLabel("Create University", SwingConstants.CENTER);
        lblUniId = new JLabel("University ID: ", SwingConstants.RIGHT);
        lblUniName = new JLabel("Name: ", SwingConstants.RIGHT);
        lblUniEmail = new JLabel("Email address: ", SwingConstants.RIGHT);

        lblUniIdGenerated = new JLabel("Auto Generated...");
        txtUniName = new JTextField();
        txtUniEmail = new JTextField();

        btnCreate = new JButton("Create");
        btnExit = new JButton("Exit");

        ftHeading = new Font("Segoe UI Black", Font.PLAIN, 28);
        ftText = new Font("Arial", Font.PLAIN, 12);
        ftTextBold = new Font("Arial", Font.BOLD, 12);

        emptySpace1 = new JLabel();
        emptySpace2 = new JLabel();
        emptySpace5 = new JLabel();
        emptySpace7 = new JLabel();
        emptySpace8 = new JLabel();
    }

    public void setGui() {
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(3, 3));
        southPanel.setLayout(new GridLayout(2, 2));

        lblHeading.setFont(ftHeading);

        lblUniId.setFont(ftTextBold);
        lblUniName.setFont(ftTextBold);
        lblUniEmail.setFont(ftTextBold);

        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        lblUniIdGenerated.setFont(ftText);
        txtUniName.setFont(ftText);
        txtUniEmail.setFont(ftText);

        northPanel.add(lblHeading);

        centerPanel.add(lblUniId);
        centerPanel.add(lblUniIdGenerated);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblUniName);
        centerPanel.add(txtUniName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblUniEmail);
        centerPanel.add(txtUniEmail);
        centerPanel.add(emptySpace5);

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
        this.setSize(540, 220);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create")) {
            String name = txtUniName.getText().trim();
            String email = txtUniEmail.getText().trim();

            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a profile.");
            } else {
                University createUniversity = UniversityFactory.createUniversity(name, email);
                University result = UniversityHttpClient.create(createUniversity);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "University successfully created");

                    txtUniName.setText("");
                    txtUniEmail.setText("");

                    txtUniName.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Error creating university");
                }
            }
        } else if (e.getActionCommand().equals("Exit")) {
            new UniversityMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new CreateUniversity().setGui();
    }
}