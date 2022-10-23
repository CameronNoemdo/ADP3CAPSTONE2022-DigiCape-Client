package za.ac.cput.views.test;

import za.ac.cput.client.TestHttpClient;
import za.ac.cput.entity.Student;
import za.ac.cput.entity.TestModel;
import za.ac.cput.factory.StudentFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import za.ac.cput.factory.TestFactory;
import za.ac.cput.views.StudentMenu;


public class CreateTest extends JFrame implements ActionListener
{

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblTestId, lblTestId1, lblSubjectId, lblTestName, lblLTestDate,
            lblDuratin, lblResultsInPercentage;
    private  JTextField  txtSubjectId, txtTestName, txtTestDate, txtDuration, txtResultsInPercent;
    private JButton btnCreate, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11;

    public CreateTest()
    {
        super("Create Student Screen version: 1.0 by Themba");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();


        lblHeading = new JLabel("Create Test", SwingConstants.CENTER);
        lblTestId = new JLabel("TestModel ID: ", SwingConstants.RIGHT);
        lblSubjectId = new JLabel("SubjectID: ", SwingConstants.RIGHT);
        lblTestName = new JLabel("TestName: ", SwingConstants.RIGHT);
        lblLTestDate = new JLabel("TestDate: ", SwingConstants.RIGHT);
        lblDuratin = new JLabel("Duration: ", SwingConstants.RIGHT);
        lblResultsInPercentage = new JLabel("WeightPercentage: ", SwingConstants.RIGHT);

        lblTestId1 = new JLabel("Auto Generated...");
        txtSubjectId = new JTextField();
        txtTestName= new JTextField();
        txtTestDate= new JTextField();
        txtDuration = new JTextField();
        txtResultsInPercent = new JTextField();

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
        centerPanel.setLayout(new GridLayout(8,3));
        southPanel.setLayout(new GridLayout(2,2));


        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblTestId.setFont(ftTextBold);
        lblSubjectId.setFont(ftTextBold);
        lblTestName.setFont(ftTextBold);
        lblLTestDate.setFont(ftTextBold);
        lblDuratin.setFont(ftTextBold);
        lblResultsInPercentage.setFont(ftTextBold);

        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        lblTestId1.setFont(ftText);
        txtSubjectId.setFont(ftText);
        txtTestName.setFont(ftText);
        txtTestDate.setFont(ftText);
        txtDuration.setFont(ftText);
        txtResultsInPercent.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblTestId);
        centerPanel.add(lblTestId1);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblSubjectId);
        centerPanel.add(txtSubjectId);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblTestName);
        centerPanel.add(txtTestName);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblLTestDate);
        centerPanel.add(txtTestDate);
        centerPanel.add(emptySpace4);

        centerPanel.add(lblDuratin);
        centerPanel.add(txtDuration);
        centerPanel.add(emptySpace5);

        centerPanel.add(lblResultsInPercentage);
        centerPanel.add(txtResultsInPercent);
        centerPanel.add(emptySpace7);

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
        this.setSize(640, 420);
        this.setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Create")) {
            String subjectId = txtSubjectId.getText().trim().toString();
            String testName = txtTestName.getText().trim().toString();
            String testDate = txtTestDate.getText().trim().toString();
            String duration = txtDuration.getText().trim().toString();


            if (subjectId.isEmpty() || testName.isEmpty() || testDate.isEmpty() || duration.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a student profile.");
            }

            else {
                    JOptionPane.showMessageDialog(null, "There was an error creating a student profile.");
                }
            }
        }



    public static void main(String[] args) {
        new za.ac.cput.views.test.CreateTest().setGui();
    }
}

