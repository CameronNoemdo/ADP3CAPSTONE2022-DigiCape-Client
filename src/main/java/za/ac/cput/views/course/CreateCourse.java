package za.ac.cput.views.course;

/*
CreateCourse.java
Java Swing class for CreateCourse GUI window
Author: Mathew Fortuin (219069514)
Date: 20/10/2022
 */

import za.ac.cput.client.CourseHttpClient;
import za.ac.cput.entity.Course;
import za.ac.cput.factory.CourseFactory;
import za.ac.cput.views.CourseMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCourse extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblCourseId, lblCourseId1, lblCourseName, lblCourseDescription, lblDepartmentId, lblDate, lblDate1;
    private  JTextField  txtCourseName, txtCourseDescription, txtDepartmentId;
    private JButton btnCreate, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11;

    public CreateCourse()
    {
        super("Create Course Screen version: 1.0 by Mathew Fortuin");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();

        lblHeading = new JLabel("Create Course", SwingConstants.CENTER);
        lblCourseId = new JLabel("Course ID: ", SwingConstants.RIGHT);
        lblCourseName = new JLabel("Course Name: ", SwingConstants.RIGHT);
        lblCourseDescription = new JLabel("Course Description: ", SwingConstants.RIGHT);
        lblDepartmentId = new JLabel("Department ID: ", SwingConstants.RIGHT);
        lblDate = new JLabel("Date: ", SwingConstants.RIGHT);


        lblCourseId1 = new JLabel("Auto Generated");
        txtCourseName = new JTextField();
        txtCourseDescription = new JTextField();
        txtDepartmentId = new JTextField();
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

        lblCourseId.setFont(ftTextBold);
        lblCourseName.setFont(ftTextBold);
        lblCourseDescription.setFont(ftTextBold);
        lblDepartmentId.setFont(ftTextBold);
        lblDate.setFont(ftTextBold);
        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        lblCourseId1.setFont(ftText);
        lblDate1.setFont(ftText);
        txtCourseName.setFont(ftText);
        txtCourseDescription.setFont(ftText);
        txtDepartmentId.setFont(ftText);

      /*  //Formatting buttons
        btnCreate.setBackground(Color.BLACK);
        btnCreate.setForeground(Color.WHITE);

        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);*/

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblCourseId);
        centerPanel.add(lblCourseId1);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblCourseName);
        centerPanel.add(txtCourseName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblCourseDescription);
        centerPanel.add(txtCourseDescription);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblDepartmentId);
        centerPanel.add(txtDepartmentId);
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
            String courseName =(txtCourseName.getText().trim().toString());
            String courseDescription = (txtCourseDescription.getText().trim().toString());
            String departmentId = (txtDepartmentId.getText().trim().toString());


            if(courseName.equals("")|| courseDescription.equals("")|| departmentId.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a record.");
            }
            else{
                Course createCourse = CourseFactory.createCourse(courseName,courseDescription,departmentId);

                Course result = CourseHttpClient.create(createCourse);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "You have successfully created a Course !");

                    txtCourseName.setText("");
                    txtCourseDescription.setText("");
                    txtDepartmentId.setText("");
                    lblDate1.setText("");

                    txtCourseName.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "There was an error creating a new Course...");
                }
            }
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new CourseMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new CreateCourse().setGui();
    }
}
