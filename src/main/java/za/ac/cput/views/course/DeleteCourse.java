package za.ac.cput.views.course;
/*
DeleteCourse.java
Java Swing class for Delete Course GUI window
Author: Mathew Fortuin (219069514)
Date: 20/10/2022
 */

import za.ac.cput.client.CourseHttpClient;
import za.ac.cput.entity.Course;
import za.ac.cput.views.CourseMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteCourse extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblCourseId, lblCourseName, lblCourseDescription, lblDepartmentId, lblDate;
    private JLabel lblCourseName1, lblCourseDescription1, lblDepartmentId1, lblDate1;
    private JTextField txtCourseId;
    private JButton btnRead, btnDelete, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13;

    public DeleteCourse()
    {
        super("Delete Course Screen version: 1.0 by Mathew Fortuin");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Delete Course", SwingConstants.CENTER);
        lblCourseId = new JLabel("Course ID: ", SwingConstants.RIGHT);
        lblCourseName = new JLabel("Course Name: ", SwingConstants.RIGHT);
        lblCourseDescription = new JLabel("Course Description: ", SwingConstants.RIGHT);
        lblDepartmentId = new JLabel("Department ID: ", SwingConstants.RIGHT);
        lblDate = new JLabel("Date: ", SwingConstants.RIGHT);

        txtCourseId = new JTextField();
        lblCourseName1 = new JLabel("");
        lblCourseDescription1 = new JLabel("");
        lblDepartmentId1 = new JLabel("");
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

        lblCourseId.setFont(ftTextBold);
        lblCourseName.setFont(ftTextBold);
        lblCourseDescription.setFont(ftTextBold);
        lblDepartmentId.setFont(ftTextBold);
        lblDate.setFont(ftTextBold);
        btnRead.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtCourseId.setFont(ftText);
        lblCourseName1.setFont(ftText);
        lblCourseDescription1.setFont(ftText);
        lblDepartmentId1.setFont(ftText);
        lblDate1.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblCourseId);
        centerPanel.add(txtCourseId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblCourseName);
        centerPanel.add(lblCourseName1);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblCourseDescription);
        centerPanel.add(lblCourseDescription1);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblDepartmentId);
        centerPanel.add(lblDepartmentId1);
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
            Integer courseId = Integer.parseInt(txtCourseId.getText().trim());

            if(courseId < 0)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{
                Course result = CourseHttpClient.read(courseId);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "Course exists with ID of: " + courseId);

                    txtCourseId.setEnabled(false);
                    lblCourseName1.setText(String.valueOf(result.getCourseName()));
                    lblCourseDescription1.setText(String.valueOf(result.getCourseDescription()));
                    lblDepartmentId1.setText(String.valueOf(result.getDepartmentId()));

                }
                else {
                    JOptionPane.showMessageDialog(null, "No Course exists with ID of: " + courseId);
                }
            }
        }
        else if(e.getActionCommand().equals("Delete"))
        {
            Integer courseId = Integer.parseInt(txtCourseId.getText().trim());

            CourseHttpClient.delete(courseId);
            JOptionPane.showMessageDialog(null, "Course with ID of: " + courseId + " was deleted.");

            txtCourseId.setText("");
            lblCourseName1.setText("");
            lblCourseDescription1.setText("");
            lblDepartmentId1.setText("");
            lblDate1.setText("");

            txtCourseId.setEnabled(true);
            txtCourseId.requestFocus();
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtCourseId.setText("");
            lblCourseName1.setText("");
            lblCourseDescription1.setText("");
            lblDepartmentId1.setText("");
            lblDate1.setText("");

            txtCourseId.setEnabled(true);
            txtCourseId.requestFocus();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new CourseMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new DeleteCourse().setGui();
    }
    
}
