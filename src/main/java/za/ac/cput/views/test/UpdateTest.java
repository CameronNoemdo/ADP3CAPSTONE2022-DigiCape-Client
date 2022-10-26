package za.ac.cput.views.test;

import za.ac.cput.client.TestHttpClient;
import za.ac.cput.entity.TestModel;
import za.ac.cput.factory.TestFactory;
import za.ac.cput.views.TestMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateTest extends JFrame implements ActionListener
{
    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading,   lblTestId, lblSubjectId, lblTestName, lblTestDate, lblDuration, lblResultsInPercent;
    private  JTextField   txtTestId,txtSubjectId, txtTestName, txtTestDate, txtDuration, txtResultsInPercent;
    private JButton btnRead, btnCreate, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    public UpdateTest()
    {
        super("Update Test Screen version: 1.0 by Themba");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();


        lblHeading = new JLabel("Update Test", SwingConstants.CENTER);
        lblTestId = new JLabel("TestModel ID: ", SwingConstants.RIGHT);
        lblSubjectId = new JLabel("SubjectID: ", SwingConstants.RIGHT);
        lblTestName = new JLabel("TestName: ", SwingConstants.RIGHT);
        lblTestDate = new JLabel("TestDate: ", SwingConstants.RIGHT);
        lblDuration = new JLabel("Duration: ", SwingConstants.RIGHT);
        lblResultsInPercent = new JLabel("ResultsInPercent: ", SwingConstants.RIGHT);

        txtTestId = new JTextField();
        txtSubjectId = new JTextField();
        txtTestName= new JTextField();
        txtTestDate= new JTextField();
        txtDuration = new JTextField();
        txtResultsInPercent = new JTextField();




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

        //setTextFieldToUneditable(); //Set all fields to not be editable
    }


    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(8,3));
        southPanel.setLayout(new GridLayout(2,4));
        radioPanel.setLayout(new GridLayout(1,2));

        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblTestId.setFont(ftTextBold);
        lblSubjectId.setFont(ftTextBold);
        lblTestName.setFont(ftTextBold);
        lblTestDate.setFont(ftTextBold);
        lblDuration.setFont(ftTextBold);
        lblResultsInPercent.setFont(ftTextBold);

        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtTestId.setFont(ftText);
        txtSubjectId.setFont(ftText);
        txtTestName.setFont(ftText);
        txtTestDate.setFont(ftText);
        txtDuration.setFont(ftText);
        txtResultsInPercent.setFont(ftText);


        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblTestId);
        centerPanel.add(txtTestId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblSubjectId);
        centerPanel.add(txtSubjectId);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblTestName);
        centerPanel.add(txtTestName);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblTestDate);
        centerPanel.add(txtTestDate);
        centerPanel.add(emptySpace4);


        centerPanel.add(lblDuration);
        centerPanel.add(txtDuration);
        centerPanel.add(emptySpace5);

        centerPanel.add(lblResultsInPercent);
        centerPanel.add(txtResultsInPercent);
        centerPanel.add(emptySpace6);

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
        this.setSize(640, 420);
        this.setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Read"))
        {
            String studentId = String.format(txtTestId.getText().trim().toString());

            if(studentId.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{

                TestModel oldTest = TestHttpClient.read(studentId);

                if(oldTest != null)
                {
                    JOptionPane.showMessageDialog(null, "Test exist with ID of: " + studentId);

                    txtSubjectId.setText(oldTest.getSubjectId());
                    txtTestName.setText(String.valueOf(oldTest.getTestName()));
                    txtTestDate.setText(oldTest.getTestDate());
                    txtDuration.setText(oldTest.getDuration());
                    txtResultsInPercent.setText(String.valueOf(oldTest.getResultInPercent()));

                    setTextFieldToEditable(); //Set all fields to editable
                    txtTestId.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Test exists with ID of: " + studentId);
                }
            }
        }
        else if(e.getActionCommand().equals("Update"))
        {
            String testId = String.format(txtTestId.getText().trim().toString());
            String subjectId = txtSubjectId.getText().trim().toString();
            String testName = txtTestName.getText().trim().toString();
            String testDate = txtTestDate.getText().trim().toString();
            String duration = txtDuration.getText().trim().toString();
            int resultsInPercent= Integer.parseInt(txtResultsInPercent.getText().trim().toString());

            if(subjectId.isEmpty() || testName.isEmpty() || testDate.isEmpty() || duration.isEmpty()
                    || resultsInPercent < 0)
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a Test.");
            }
            else {
                TestModel updateTest = TestFactory.updateTest(testId,subjectId,testName,testDate,duration,resultsInPercent);

                TestModel result = TestHttpClient.update(updateTest);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated your profile.");

                    txtTestId.setText("");
                    txtSubjectId.setText("");
                    txtTestName.setText("");
                    txtTestDate.setText("");
                    txtDuration.setText("");
                    txtResultsInPercent.setText("");

                    txtTestId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating your profile.");
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtTestId.setText("");
            txtSubjectId.setText("");
            txtTestName.setText("");
            txtTestDate.setText("");
            txtDuration.setText("");
            txtResultsInPercent.setText("");

            txtTestId.requestFocus();
            setTextFieldToUneditable();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new TestMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable()
    {
        txtTestId.setEnabled(true);
        txtSubjectId.setEnabled(false);
        txtTestName.setEnabled(false);
        txtTestDate.setEnabled(false);
        txtDuration.setEnabled(false);
        txtResultsInPercent.setEnabled(false);

    }

    public void setTextFieldToEditable()
    {


        txtTestId.setEnabled(false);
        txtSubjectId.setEnabled(true);
        txtTestName.setEnabled(true);
        txtTestDate.setEnabled(true);
        txtDuration.setEnabled(true);
        txtResultsInPercent.setEnabled(true);
    }


    public static void main(String[] args)
    {
        new za.ac.cput.views.test.UpdateTest().setGui();
    }
}


