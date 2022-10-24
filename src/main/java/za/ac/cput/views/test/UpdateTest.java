package za.ac.cput.views.test;

import za.ac.cput.client.StudentHttpClient;
import za.ac.cput.entity.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.views.StudentMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateTest extends JFrame implements ActionListener
{
    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading,  lblStudentId, lblFirstName, lblMiddleName, lblLastName, lblStudentEmail, lblCourseID;
    private  JTextField  txtStudentId,txtFirstName, txtMiddleName, txtLastName, txtStudentEmail, txtCourseID;
    private JButton btnRead, btnCreate, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    public UpdateTest()
    {
        super("Update Student Screen version: 1.0 by Themba");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();


        lblHeading = new JLabel("Update Student", SwingConstants.CENTER);
        lblStudentId = new JLabel("Student ID: ", SwingConstants.RIGHT);
        lblFirstName = new JLabel("FirstName: ", SwingConstants.RIGHT);
        lblMiddleName = new JLabel("MiddleName: ", SwingConstants.RIGHT);
        lblLastName = new JLabel("LastName: ", SwingConstants.RIGHT);
        lblStudentEmail = new JLabel("StudentEmail: ", SwingConstants.RIGHT);
        lblCourseID = new JLabel("CourseID : ", SwingConstants.RIGHT);


        txtStudentId = new JTextField();
        txtFirstName = new JTextField("");
        txtMiddleName= new JTextField("");
        txtLastName = new JTextField("");
        txtStudentEmail = new JTextField("");
        txtCourseID = new JTextField("");



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

        lblStudentId.setFont(ftTextBold);
        lblFirstName.setFont(ftTextBold);
        lblMiddleName.setFont(ftTextBold);
        lblLastName.setFont(ftTextBold);
        lblStudentEmail.setFont(ftTextBold);
        lblCourseID.setFont(ftTextBold);

        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtStudentId.setFont(ftText);
        txtFirstName.setFont(ftText);
        txtMiddleName.setFont(ftText);
        txtLastName.setFont(ftText);
        txtStudentEmail.setFont(ftText);
        txtCourseID.setFont(ftText);


        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblStudentId);
        centerPanel.add(txtStudentId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblFirstName);
        centerPanel.add(txtFirstName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblMiddleName);
        centerPanel.add(txtMiddleName);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblLastName);
        centerPanel.add(txtLastName);
        centerPanel.add(emptySpace4);


        centerPanel.add(lblStudentEmail);
        centerPanel.add(txtStudentEmail);
        centerPanel.add(emptySpace5);

        centerPanel.add(lblCourseID);
        centerPanel.add(txtCourseID);
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
            String studentId = String.format(txtStudentId.getText().trim().toString());

            if(studentId != "")
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{

                Student oldStudent = StudentHttpClient.read(studentId);

                if(oldStudent != null)
                {
                    JOptionPane.showMessageDialog(null, "Student exist with ID of: " + studentId);

                    txtFirstName.setText(oldStudent.getFirstName());
                    txtMiddleName.setText(String.valueOf(oldStudent.getMiddleName()));
                    txtLastName.setText(oldStudent.getLastName());
                    txtStudentEmail.setText(oldStudent.getStudentEmail());
                    txtCourseID.setText(String.valueOf(oldStudent.getCourseID()));

                    setTextFieldToEditable(); //Set all fields to editable
                    txtStudentId.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Student exists with ID of: " + studentId);
                }
            }
        }
        else if(e.getActionCommand().equals("Update"))
        {
            String studentId = String.format(txtStudentId.getText().trim().toString());
            String firstName = txtFirstName.getText().trim().toString();
            String middleName = txtMiddleName.getText().trim().toString();
            String lastName = txtLastName.getText().trim().toString();
            String studentEmail = txtStudentEmail.getText().trim().toString();
            String courseID= txtCourseID.getText().trim().toString();

            if(firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() || studentEmail.isEmpty()
                    || courseID.isEmpty() )
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a customer.");
            }
            else {
                Student updateStudent = StudentFactory.updateStudent(studentId,firstName,middleName,lastName,studentEmail,courseID);

                Student result = StudentHttpClient.update(updateStudent);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated your profile.");

                    txtStudentId.setText("");
                    txtFirstName.setText("");
                    txtMiddleName.setText("");
                    txtLastName.setText("");
                    txtStudentEmail.setText("");
                    txtCourseID.setText("");

                    txtStudentId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating your profile.");
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtStudentId.setText("");
            txtFirstName.setText("");
            txtMiddleName.setText("");
            txtLastName.setText("");
            txtStudentEmail.setText("");
            txtCourseID.setText("");

            txtStudentId.requestFocus();
            setTextFieldToUneditable();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new StudentMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable()
    {
        txtStudentId.setEnabled(true);
        txtFirstName.setEnabled(false);
        txtMiddleName.setEnabled(false);
        txtLastName.setEnabled(false);
        txtStudentEmail.setEnabled(false);
        txtCourseID.setEnabled(false);

    }

    public void setTextFieldToEditable()
    {
        txtStudentId.setEnabled(false);
        txtFirstName.setEnabled(true);
        txtMiddleName.setEnabled(true);
        txtLastName.setEnabled(true);
        txtStudentEmail.setEnabled(true);
        txtCourseID.setEnabled(true);
    }


    public static void main(String[] args) {
        new za.ac.cput.views.student.UpdateStudent().setGui();
    }
}


