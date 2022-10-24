package za.ac.cput.views.course;

/*
UpdateCourse.java
Java Swing class for Update Course GUI window
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
import java.util.Date;

public class UpdateCourse extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblCourseId, lblCourseName, lblCourseDescription, lblDepartmentId, lblDate, lblDate1;
    private  JTextField  txtCourseId, txtCourseName, txtCourseDescription, txtDepartmentId;
    private JButton btnRead, btnCreate, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    public UpdateCourse()
    {
        super("Update Course Screen version: 1.0 by Mathew Fortuin");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();

        lblHeading = new JLabel("Update Course", SwingConstants.CENTER);
        lblCourseId = new JLabel("Course ID: ", SwingConstants.RIGHT);
        lblCourseName = new JLabel("Course Name: ", SwingConstants.RIGHT);
        lblCourseDescription = new JLabel("Course Description: ", SwingConstants.RIGHT);
        lblDepartmentId = new JLabel("Department ID: ", SwingConstants.RIGHT);
        lblDate = new JLabel("Date: ", SwingConstants.RIGHT);
        //lblDate1 = new JLabel("Date: ", SwingConstants.RIGHT);

        txtCourseId = new JTextField();
        txtCourseName = new JTextField();
        txtCourseDescription = new JTextField();
        txtDepartmentId = new JTextField();
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

        lblCourseId.setFont(ftTextBold);
        lblCourseName.setFont(ftTextBold);
        lblCourseDescription.setFont(ftTextBold);
        lblDepartmentId.setFont(ftTextBold);
        lblDate.setFont(ftTextBold);
        lblDate1.setFont(ftTextBold);

        txtCourseId.setFont(ftText);
        txtCourseName.setFont(ftText);
        txtCourseDescription.setFont(ftText);
        txtDepartmentId.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblCourseId);
        centerPanel.add(txtCourseId);
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
            int courseId = Integer.parseInt(txtCourseId.getText().trim().toString());

            if(courseId < 0)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{

                Course oldCourse = CourseHttpClient.read(courseId);

                if(oldCourse != null)
                {
                    JOptionPane.showMessageDialog(null, "Course exists with ID of: " + courseId);

                    txtCourseName.setText(String.valueOf(oldCourse.getCourseName()));
                    txtCourseDescription.setText(String.valueOf(oldCourse.getCourseDescription()));
                    txtDepartmentId.setText(String.valueOf(oldCourse.getDepartmentId()));


                    setTextFieldToEditable(); //Set all fields to editable
                    txtCourseId.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Course exists with ID of: " + courseId);
                }
            }
        }
        else if(e.getActionCommand().equals("Update"))
        {
            int courseId = Integer.parseInt(txtCourseId.getText().trim().toString());
           String courseName = (txtCourseName.getText().trim().toString());
            String courseDescription= (txtCourseDescription.getText().trim().toString());
           String departmentId = (txtDepartmentId.getText().trim().toString());
            Date date = new Date();

            if(courseName == "" || courseDescription == "" || departmentId == "")
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a record");
            }
            else {
                Course updateCourse = CourseFactory.updateCourse(courseId,courseName,courseDescription,departmentId);

                Course result = CourseHttpClient.update(updateCourse);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated a Course !");

                    txtCourseId.setText("");
                    txtCourseName.setText("");
                    txtCourseDescription.setText("");
                    txtDepartmentId.setText("");
                    lblDate1.setText("");

                    txtCourseId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating the record");
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtCourseId.setText("");
            txtCourseName.setText("");
            txtCourseDescription.setText("");
            txtDepartmentId.setText("");

            txtCourseId.requestFocus();
            setTextFieldToUneditable();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new CourseMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable()
    {
        txtCourseId.setEnabled(true);
        txtCourseName.setEnabled(false);
        txtCourseDescription.setEnabled(false);
        txtDepartmentId.setEnabled(false);

    }

    public void setTextFieldToEditable()
    {
        txtCourseId.setEnabled(false);
        txtCourseName.setEnabled(true);
        txtCourseDescription.setEnabled(true);
        txtDepartmentId.setEnabled(true);

    }

    public static void main(String[] args) {
        new UpdateCourse().setGui();
    }
}
