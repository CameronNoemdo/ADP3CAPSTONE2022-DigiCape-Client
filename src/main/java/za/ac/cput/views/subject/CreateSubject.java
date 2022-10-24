package za.ac.cput.views.subject;

import za.ac.cput.client.CourseHttpClient;
import za.ac.cput.client.SubjectHttpClient;
import za.ac.cput.entity.Subject;
import za.ac.cput.factory.SubjectFactory;
import za.ac.cput.views.SubjectMenu;
import za.ac.cput.views.subject.CreateSubject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateSubject extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblSubjectId, lblSubjectId1, lblSubjectIName, lblSubjectCredits, lblLecturerId, lblDate, lblDate1;
    private  JTextField  txtSubjectName, txtSubjectCredits, txtLecturerId;
    private JButton btnCreate, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11;

    public CreateSubject()
    {
        super("Create Subject Screen version: 1.0 by Mathew Fortuin");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();

        lblHeading = new JLabel("Create Subject", SwingConstants.CENTER);
        lblSubjectId = new JLabel("Subject ID: ", SwingConstants.RIGHT);
        lblSubjectIName = new JLabel("Subject Name: ", SwingConstants.RIGHT);
        lblSubjectCredits = new JLabel("Subject Credits: ", SwingConstants.RIGHT);
        lblLecturerId = new JLabel("Lecturer ID: ", SwingConstants.RIGHT);
        lblDate = new JLabel("Date: ", SwingConstants.RIGHT);


        lblSubjectId1 = new JLabel("Auto Generated");
        txtSubjectName = new JTextField();
        txtSubjectCredits = new JTextField();
        txtLecturerId = new JTextField();
        lblDate1 = new JLabel("Auto Generated");

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
        emptySpace9 = new JLabel();
        emptySpace10 = new JLabel();
        emptySpace11 = new JLabel();
    }

    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(7,3));
        southPanel.setLayout(new GridLayout(2,2));

        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblSubjectId.setFont(ftTextBold);
        lblSubjectIName.setFont(ftTextBold);
        lblSubjectCredits.setFont(ftTextBold);
        lblLecturerId.setFont(ftTextBold);
        lblDate.setFont(ftTextBold);
        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        lblSubjectId1.setFont(ftText);
        lblDate1.setFont(ftText);
        txtSubjectName.setFont(ftText);
        txtSubjectCredits.setFont(ftText);
        txtLecturerId.setFont(ftText);

        //Formatting buttons
       /* btnCreate.setBackground(Color.BLACK);
        btnCreate.setForeground(Color.WHITE);

        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);*/

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblSubjectId);
        centerPanel.add(lblSubjectId1);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblSubjectIName);
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
        southPanel.add(btnCreate);
        southPanel.add(btnExit);
        //southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnCreate.addActionListener(this);
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

        if(e.getActionCommand().equals("Create"))
        {
            String subjectName =(txtSubjectName.getText().trim());
            Integer subjectCredits = Integer.parseInt(txtSubjectCredits.getText().trim());
            String lecturerId = (txtLecturerId.getText().trim());


            if(subjectName.equals("")|| subjectCredits.equals("")|| lecturerId.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a record.");
            }
            else{
                Subject createSubject = SubjectFactory.createSubject(subjectName,subjectCredits,lecturerId);

                Subject result = SubjectHttpClient.create(createSubject);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "You have successfully created a Subject !");

                    txtSubjectName.setText("");
                    txtSubjectCredits.setText("");
                    txtLecturerId.setText("");
                    lblDate1.setText("");

                    txtSubjectName.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "There was an error creating a new Subject...");
                }
            }
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new SubjectMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new CreateSubject().setGui();
    }
}
