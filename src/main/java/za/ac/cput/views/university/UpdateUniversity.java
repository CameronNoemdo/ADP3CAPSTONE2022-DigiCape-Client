package za.ac.cput.views.university;

import za.ac.cput.client.UniversityHttpClient;
import za.ac.cput.entity.University;
import za.ac.cput.factory.UniversityFactory;
import za.ac.cput.views.UniversityMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUniversity extends JFrame implements ActionListener {

    private final JPanel northPanel;
    private final JPanel centerPanel;
    private final JPanel southPanel;
    private final JLabel lblHeading;
    private final JLabel lblUniId;
    private final JLabel lblUniName;
    private final JLabel lblUniEmail;
    private final JTextField txtUniId;
    private final JTextField txtUniName;
    private final JTextField txtUniEmail;
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

    public UpdateUniversity() {
        super("Update University");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Update University", SwingConstants.CENTER);
        lblUniId = new JLabel("University ID: ", SwingConstants.RIGHT);
        lblUniName = new JLabel("University name: ", SwingConstants.RIGHT);
        lblUniEmail = new JLabel("Email address: ", SwingConstants.RIGHT);

        txtUniId = new JTextField();
        txtUniName = new JTextField();
        txtUniEmail = new JTextField();


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

        setTextFieldToUneditable();
    }


    public void setGui() {
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(4, 3));
        southPanel.setLayout(new GridLayout(1, 4));

        lblHeading.setFont(ftHeading);

        lblUniId.setFont(ftTextBold);
        lblUniName.setFont(ftTextBold);
        lblUniEmail.setFont(ftTextBold);

        btnUpdate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtUniId.setFont(ftText);
        txtUniName.setFont(ftText);
        txtUniEmail.setFont(ftText);

        northPanel.add(lblHeading);

        centerPanel.add(lblUniId);
        centerPanel.add(txtUniId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblUniName);
        centerPanel.add(txtUniName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblUniEmail);
        centerPanel.add(txtUniEmail);
        centerPanel.add(emptySpace3);

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
        this.setSize(540, 220);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Read")) {
            String universityId = txtUniId.getText().trim();

            if (universityId.isEmpty() || universityId == null) {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            } else {

                University oldUniversity = UniversityHttpClient.read(universityId);

                if (oldUniversity != null) {
                    JOptionPane.showMessageDialog(null, "University exist with ID of: " + universityId);

                    txtUniId.setEnabled(false);
                    txtUniName.setText(oldUniversity.getUniversityName());
                    txtUniEmail.setText(oldUniversity.getEmail());

                    setTextFieldToEditable(); //Set all fields to editable
                    txtUniId.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "No university exists with ID of: " + universityId);
                }
            }
        } else if (e.getActionCommand().equals("Update")) {
            String universityId = txtUniId.getText().trim();
            String universityName = txtUniName.getText().trim();
            String universityEmail = txtUniEmail.getText().trim();

            if (universityId.isEmpty() || universityName.isEmpty() || universityEmail.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all information to update a university.");
            } else {
                University updateUniversity = UniversityFactory.updateUniversity(universityId, universityName, universityEmail);

                University result = UniversityHttpClient.update(updateUniversity);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated your profile.");

                    txtUniId.setText("");
                    txtUniName.setText("");
                    txtUniEmail.setText("");

                    txtUniId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating your profile.");
                }
            }
        } else if (e.getActionCommand().equals("Clear")) {
            txtUniId.setText("");
            txtUniName.setText("");
            txtUniEmail.setText("");

            txtUniId.requestFocus();
            setTextFieldToUneditable();
        } else if (e.getActionCommand().equals("Exit")) {
            new UniversityMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable() {
        txtUniId.setEnabled(true);
        txtUniName.setEnabled(false);
        txtUniEmail.setEnabled(false);

    }

    public void setTextFieldToEditable() {
        txtUniId.setEnabled(false);
        txtUniName.setEnabled(true);
        txtUniEmail.setEnabled(true);
    }


    public static void main(String[] args) {
        new UpdateUniversity().setGui();
    }
}
