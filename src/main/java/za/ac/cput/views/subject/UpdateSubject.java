package za.ac.cput.views.subject;

import za.ac.cput.client.SubjectHttpClient;
import za.ac.cput.entity.Subject;
import za.ac.cput.factory.SubjectFactory;
import za.ac.cput.views.SubjectMenu;
import za.ac.cput.views.subject.UpdateSubject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class UpdateSubject extends JFrame implements ActionListener {


    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblSubjectId, lblSubjectName, lblSubjectCredits, lblLecturerId, lblDate, lblDate1;
    private  JTextField  txtSubjectId, txtSubjectName, txtSubjectCredits, txtLecturerId;
    private JButton btnRead, btnCreate, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    public UpdateSubject()
    {
        super("Update Subject Screen version: 1.0 by Mathew Fortuin");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();

        lblHeading = new JLabel("Update Subject", SwingConstants.CENTER);
        lblSubjectId = new JLabel("Subject ID: ", SwingConstants.RIGHT);
        lblSubjectName = new JLabel("Subject Name: ", SwingConstants.RIGHT);
        lblSubjectCredits = new JLabel("Subject Credits: ", SwingConstants.RIGHT);
        lblLecturerId = new JLabel("Lecturer ID: ", SwingConstants.RIGHT);
        lblDate = new JLabel("Date: ", SwingConstants.RIGHT);
        //lblDate1 = new JLabel("Date: ", SwingConstants.RIGHT);

        txtSubjectId = new JTextField();
        txtSubjectName = new JTextField();
        txtSubjectCredits = new JTextField();
        txtLecturerId = new JTextField();
        lblDate1 = new JLabel();

        btnRead = new JButton("Read");
        btnCreate = new JButton("Update");
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
        emptySpace14 = new JLabel();

        setTextFieldToUneditable(); //Set all fields to not be editable
    }

    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(5,3));
        southPanel.setLayout(new GridLayout(2,4));

        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblSubjectId.setFont(ftTextBold);
        lblSubjectName.setFont(ftTextBold);
        lblSubjectCredits.setFont(ftTextBold);
        lblLecturerId.setFont(ftTextBold);
        lblDate.setFont(ftTextBold);
        lblDate1.setFont(ftTextBold);

        txtSubjectId.setFont(ftText);
        txtSubjectName.setFont(ftText);
        txtSubjectCredits.setFont(ftText);
        txtLecturerId.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblSubjectId);
        centerPanel.add(txtSubjectId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblSubjectName);
        centerPanel.add(txtSubjectName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblSubjectCredits);
        centerPanel.add(txtSubjectCredits);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblLecturerId);
        centerPanel.add(txtLecturerId);
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
        southPanel.add(btnCreate);
        southPanel.add(btnClear);
        southPanel.add(btnExit);
        //southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnRead.addActionListener(this);
        btnCreate.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Frame
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 340);
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

                Subject oldSubject = SubjectHttpClient.read(subjectId);

                if(oldSubject != null)
                {
                    JOptionPane.showMessageDialog(null, "Subject exists with ID of: " + subjectId);

                    txtSubjectName.setText(String.valueOf(oldSubject.getSubjectName()));
                    txtSubjectCredits.setText(String.valueOf(oldSubject.getSubjectCredit()));
                    txtLecturerId.setText(String.valueOf(oldSubject.getLecturerID()));


                    setTextFieldToEditable(); //Set all fields to editable
                    txtSubjectId.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Subject exists with ID of: " + subjectId);
                }
            }
        }
        else if(e.getActionCommand().equals("Update"))
        {
            Integer subjectId = Integer.parseInt(txtSubjectId.getText().trim());
            String subjectName = (txtSubjectName.getText().trim());
            Integer subjectCredits=Integer.parseInt (txtSubjectCredits.getText().trim());
            String lecturerId = (txtLecturerId.getText().trim());
            Date date = new Date();

            if(subjectName == "" || subjectCredits.equals(null) || lecturerId == "")
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a record");
            }
            else {
                Subject updateSubject = SubjectFactory.updateSubject(subjectId,subjectName,subjectCredits,lecturerId);

                Subject result = SubjectHttpClient.update(updateSubject);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated a Subject !");

                    txtSubjectId.setText("");
                    txtSubjectName.setText("");
                    txtSubjectCredits.setText("");
                    txtLecturerId.setText("");
                    lblDate1.setText("");

                    txtSubjectId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating the record");
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtSubjectId.setText("");
            txtSubjectName.setText("");
            txtSubjectCredits.setText("");
            txtLecturerId.setText("");

            txtSubjectId.requestFocus();
            setTextFieldToUneditable();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new SubjectMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable()
    {
        txtSubjectId.setEnabled(true);
        txtSubjectName.setEnabled(false);
        txtSubjectCredits.setEnabled(false);
        txtLecturerId.setEnabled(false);

    }

    public void setTextFieldToEditable()
    {
        txtSubjectId.setEnabled(false);
        txtSubjectName.setEnabled(true);
        txtSubjectCredits.setEnabled(true);
        txtLecturerId.setEnabled(true);

    }

    public static void main(String[] args) {
        new UpdateSubject().setGui();
    }
}
