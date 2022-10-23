package za.ac.cput.views.subject;

import za.ac.cput.client.SubjectHttpClient;
import za.ac.cput.entity.Subject;
import za.ac.cput.views.SubjectMenu;
import za.ac.cput.views.subject.DeleteSubject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteSubject extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblSubjectId, lblSubjectName, lblSubjectCredits, lblLecturerId, lblDate;
    private JLabel lblSubjectName1, lblSubjectCredits1, lblLecturerId1, lblDate1;
    private JTextField txtSubjectId;
    private JButton btnRead, btnDelete, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13;

    public DeleteSubject()
    {
        super("Delete Subject Screen version: 1.0 by Mathew Fortuin");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Delete Subject", SwingConstants.CENTER);
        lblSubjectId = new JLabel("Subject ID: ", SwingConstants.RIGHT);
        lblSubjectName = new JLabel("Subject Name: ", SwingConstants.RIGHT);
        lblSubjectCredits = new JLabel("Subject Credits: ", SwingConstants.RIGHT);
        lblLecturerId = new JLabel("Lecturer ID: ", SwingConstants.RIGHT);
        lblDate = new JLabel("Date: ", SwingConstants.RIGHT);

        txtSubjectId = new JTextField();
        lblSubjectName1 = new JLabel("");
        lblSubjectCredits1 = new JLabel("");
        lblLecturerId1 = new JLabel("");
        lblDate1 = new JLabel("");

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
        emptySpace7 = new JLabel();
        emptySpace8 = new JLabel();
        emptySpace9 = new JLabel();
        emptySpace10 = new JLabel();
        emptySpace11 = new JLabel();
        emptySpace12 = new JLabel();
        emptySpace13 = new JLabel();
    }

    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(7,3));
        southPanel.setLayout(new GridLayout(2,4));

        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblSubjectId.setFont(ftTextBold);
        lblSubjectName.setFont(ftTextBold);
        lblSubjectCredits.setFont(ftTextBold);
        lblLecturerId.setFont(ftTextBold);
        lblDate.setFont(ftTextBold);
        btnRead.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtSubjectId.setFont(ftText);
        lblSubjectName1.setFont(ftText);
        lblSubjectCredits1.setFont(ftText);
        lblLecturerId1.setFont(ftText);
        lblDate1.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblSubjectId);
        centerPanel.add(txtSubjectId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblSubjectName);
        centerPanel.add(lblSubjectName1);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblSubjectCredits);
        centerPanel.add(lblSubjectCredits1);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblLecturerId);
        centerPanel.add(lblLecturerId1);
        centerPanel.add(emptySpace4);

        centerPanel.add(lblDate);
        centerPanel.add(lblDate1);
        centerPanel.add(emptySpace5);
        //centerPanel.setBackground(Color.decode("#CECECE"));

        southPanel.add(emptySpace10);
        southPanel.add(emptySpace11);
        southPanel.add(emptySpace12);
        southPanel.add(emptySpace13);
        southPanel.add(btnRead);
        southPanel.add(btnDelete);
        southPanel.add(btnClear);
        southPanel.add(btnExit);
        //southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnRead.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Frame
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 320);
        this.setVisible(true);
        setLocationRelativeTo(null); //Centers GUI upon open
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Read"))
        {
            Integer subjectId = Integer.parseInt(txtSubjectId.getText().trim());

            if(subjectId < 0)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{
                Subject result = SubjectHttpClient.read(subjectId);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "Subject exists with ID of: " + subjectId);

                    txtSubjectId.setEnabled(false);
                    lblSubjectName1.setText(String.valueOf(result.getSubjectName()));
                    lblSubjectCredits1.setText(String.valueOf(result.getSubjectCredit()));
                    lblLecturerId1.setText(String.valueOf(result.getLecturerID()));

                }
                else {
                    JOptionPane.showMessageDialog(null, "No Subject exists with ID of: " + subjectId);
                }
            }
        }
        else if(e.getActionCommand().equals("Delete"))
        {
            Integer subjectId = Integer.parseInt(txtSubjectId.getText().trim());

            SubjectHttpClient.delete(subjectId);
            JOptionPane.showMessageDialog(null, "Subject with ID of: " + subjectId + " was deleted.");

            txtSubjectId.setText("");
            lblSubjectName1.setText("");
            lblSubjectCredits1.setText("");
            lblLecturerId1.setText("");
            lblDate1.setText("");

            txtSubjectId.setEnabled(true);
            txtSubjectId.requestFocus();
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtSubjectId.setText("");
            lblSubjectName1.setText("");
            lblSubjectCredits1.setText("");
            lblLecturerId1.setText("");
            lblDate1.setText("");

            txtSubjectId.setEnabled(true);
            txtSubjectId.requestFocus();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new SubjectMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new DeleteSubject().setGui();
    }
}
