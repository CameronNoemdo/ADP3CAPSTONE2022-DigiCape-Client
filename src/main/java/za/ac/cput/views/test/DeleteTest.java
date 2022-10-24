package za.ac.cput.views.test;

import za.ac.cput.client.TestHttpClient;
import za.ac.cput.entity.TestModel;
import za.ac.cput.factory.TestFactory;
import za.ac.cput.views.TestMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTest extends JFrame implements ActionListener

{
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblTestId, lblTestId1, lblSubjectId, lblTestName, lblTestDate,
            lblDuration, lblResultsInPercent;
    private JLabel lblSubjectId1, lblTestName1, lblTestDate1, lblDuration1, lblResultsInPercent1;

    private  JTextField  txtTestId;
    private JButton btnRead, btnDelete, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11;

    public DeleteTest()
    {
        super("Delete Student Screen version: 1.0 by Themba");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();


        lblHeading = new JLabel("Delete Test", SwingConstants.CENTER);
        lblTestId = new JLabel("Test ID: ", SwingConstants.RIGHT);
        lblSubjectId = new JLabel("SubjectID: ", SwingConstants.RIGHT);
        lblTestName = new JLabel("TestName: ", SwingConstants.RIGHT);
        lblTestDate = new JLabel("Test Date: ", SwingConstants.RIGHT);
        lblDuration = new JLabel("Duration: ", SwingConstants.RIGHT);
        lblResultsInPercent = new JLabel("ResultsInPercent: ", SwingConstants.RIGHT);

        txtTestId = new JTextField();
        lblSubjectId1 = new JLabel("");
        lblTestName1 = new JLabel("");
        lblTestDate1 = new JLabel("");
        lblDuration1 = new JLabel("");
        lblResultsInPercent1 = new JLabel("");

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

        btnRead.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);
        lblTestId.setFont(ftTextBold);
        lblSubjectId.setFont(ftTextBold);
        lblTestName.setFont(ftTextBold);
        lblTestDate.setFont(ftTextBold);
        lblDuration.setFont(ftTextBold);
        lblResultsInPercent.setFont(ftTextBold);

        btnRead.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtTestId.setFont(ftText);
        lblSubjectId1.setFont(ftText);
        lblTestName1.setFont(ftText);
        lblTestDate1.setFont(ftText);
        lblDuration1.setFont(ftText);
        lblResultsInPercent1.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblTestId);
        centerPanel.add(txtTestId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblSubjectId);
        centerPanel.add(lblSubjectId1);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblTestName);
        centerPanel.add(lblTestName1);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblTestDate);
        centerPanel.add(lblTestDate1);
        centerPanel.add(emptySpace4);

        centerPanel.add(lblDuration);
        centerPanel.add(lblDuration1);
        centerPanel.add(emptySpace5);

        centerPanel.add(lblResultsInPercent);
        centerPanel.add(lblResultsInPercent1);
        centerPanel.add(emptySpace7);

        //centerPanel.setBackground(Color.decode("#CECECE"));

        southPanel.add(emptySpace10);
        southPanel.add(emptySpace11);
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
        this.setSize(640, 420);
        this.setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Read"))
        {
            String testId = String.format(txtTestId.getText().trim().toString());

            if(testId.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{
                TestModel result = TestHttpClient.read(testId);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "Student exist with ID of: " + testId);

                    txtTestId.setEnabled(false);
                    lblSubjectId1.setText(result.getSubjectId());
                    lblTestName1.setText(result.getTestName());
                    lblTestDate1.setText(result.getTestDate());
                    lblDuration1.setText(result.getDuration());
                    lblResultsInPercent1.setText(String.valueOf(result.getResultInPercent()));

                }
                else {
                    JOptionPane.showMessageDialog(null, "No student exists with ID of: " + testId);
                }
            }
        }
        else if(e.getActionCommand().equals("Delete"))
        {
            String deleteStudentWithId = String.format(txtTestId.getText().trim().toString());

            TestHttpClient.delete(deleteStudentWithId);
            JOptionPane.showMessageDialog(null, "The Student with ID of: " + deleteStudentWithId + " was deleted.");

            txtTestId.setText("");
            lblSubjectId1.setText("");
            lblTestName1.setText("");
            lblTestDate1.setText("");
            lblDuration1.setText("");
            lblResultsInPercent1.setText("");

            txtTestId.setEnabled(true);
            txtTestId.requestFocus();
        }
        else if(e.getActionCommand().equals("Clear")) {
            txtTestId.setText("");
            lblSubjectId1.setText("");
            lblTestName1.setText("");
            lblTestDate1.setText("");
            lblDuration1.setText("");
            lblResultsInPercent1.setText("");

            txtTestId.setEnabled(true);
            txtTestId.requestFocus();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new TestMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new za.ac.cput.views.test.DeleteTest().setGui();
    }
}

