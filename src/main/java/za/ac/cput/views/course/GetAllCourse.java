package za.ac.cput.views.course;

import za.ac.cput.client.CourseHttpClient;
import za.ac.cput.entity.Course;
import za.ac.cput.views.CourseMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


/*
GetAllCourse.java
Java Swing class for GetAllCourse GUI window
Author: Mathew Fortuin (219069514)
Date: 20/10/2022
 */
public class GetAllCourse extends JFrame implements ActionListener {


    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading;
    private Font ftHeading, ftText, ftTextBold;
    private JButton btnExit;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    private JTable table;
    private DefaultTableModel model;
    private JScrollPane sPane;
    String[] columnNames = {"Course ID", "Course Name", "Course Description", "Department ID"};
    Course[] courseList = new Course[columnNames.length];

    private Set<Course> courseSet;

    public GetAllCourse()
    {
        super("Get All Courses Screen version: 1.0 by Mathew Fortuin");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Read Course", SwingConstants.CENTER);

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

        //Add table data and columns to table
        table = new JTable();
        model = (DefaultTableModel) table.getModel();

        //Get list of Courses
        courseSet = CourseHttpClient.getAll();

        //Add column names to the table
        for (String column : columnNames)
        {
            model.addColumn(column);
        }

        //Add the rows to the table
        courseList = CourseHttpClient.rows(); // Get Course array

        Object[] rows = new Object[100];

        for(int i = 0; i < courseList.length; i++) //Create object array to add each row of data to the table
        {
            for(int k = 0; k < courseList.length - 1; k++) {
                rows[k] = courseList[i].getCourseId();
                rows[++k] = courseList[i].getCourseName();
                rows[++k] = courseList[i].getCourseDescription();
                rows[++k] = courseList[i].getDepartmentId();


                model.addRow(rows);
            }
        }

        //Set column width
        table.getColumnModel().getColumn(0).setPreferredWidth(400);
        table.getColumnModel().getColumn(1).setPreferredWidth(400);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);



        //Add table to scroll pane
        sPane = new JScrollPane(table);
    }

    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(1,1));
        southPanel.setLayout(new GridLayout(2,3));

        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));
        btnExit.setFont(ftTextBold);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(sPane);
        //centerPanel.setBackground(Color.decode("#CECECE"));

        southPanel.add(emptySpace10);
        southPanel.add(emptySpace11);
        southPanel.add(emptySpace12);
        southPanel.add(emptySpace13);
        southPanel.add(btnExit);
        southPanel.add(emptySpace14);
        //southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnExit.addActionListener(this);

        //Frame
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(860, 440);
        this.setVisible(true);
        setLocationRelativeTo(null); //Centers GUI upon open
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Exit"))
        {
            new CourseMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new GetAllCourse().setGui();
    }
}
