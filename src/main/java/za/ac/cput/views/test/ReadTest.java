package za.ac.cput.views.test;
import za.ac.cput.client.StudentHttpClient;
import za.ac.cput.entity.Student;
import za.ac.cput.views.StudentMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadTest extends JFrame implements ActionListener
{

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblStudentId, lblFirstName, lblMiddleName, lblLastName, lblStudentEmail, lblCourseID;
    private JLabel lblFirstName1, lblMiddleName1, lblLastName1, lblStudentEmail1, lblCourseID1;
    private JTextField txtStudentId;
    private JButton btnRead, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12;

    public ReadTest()
    {
        super("Read Student Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Read Student", SwingConstants.CENTER);
        lblStudentId = new JLabel("Student ID: ", SwingConstants.RIGHT);
        lblFirstName = new JLabel("FirstName: ", SwingConstants.RIGHT);
        lblMiddleName = new JLabel("MiddleName: ", SwingConstants.RIGHT);
        lblLastName = new JLabel("LastName: ", SwingConstants.RIGHT);
        lblStudentEmail = new JLabel("StudentEmail: ", SwingConstants.RIGHT);
        lblCourseID = new JLabel("CourseID : ", SwingConstants.RIGHT);

        txtStudentId = new JTextField();
        lblFirstName1 = new JLabel("");
        lblMiddleName1 = new JLabel("");
        lblLastName1 = new JLabel("");
        lblStudentEmail1 = new JLabel("");
        lblCourseID1 = new JLabel("");

        btnRead = new JButton("Read");
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
    }

    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(8,3));
        southPanel.setLayout(new GridLayout(2,3));

        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblStudentId.setFont(ftTextBold);
        lblFirstName.setFont(ftTextBold);
        lblMiddleName.setFont(ftTextBold);
        lblLastName.setFont(ftTextBold);
        lblStudentEmail.setFont(ftTextBold);
        lblCourseID.setFont(ftTextBold);

        btnRead.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtStudentId.setFont(ftText);
        lblFirstName1.setFont(ftText);
        lblMiddleName1.setFont(ftText);
        lblLastName1.setFont(ftText);
        lblStudentEmail1.setFont(ftText);
        lblCourseID1.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblStudentId);
        centerPanel.add(txtStudentId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblFirstName);
        centerPanel.add(lblFirstName1);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblMiddleName);
        centerPanel.add(lblMiddleName1);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblLastName);
        centerPanel.add(lblLastName1);
        centerPanel.add(emptySpace4);

        centerPanel.add(lblStudentEmail);
        centerPanel.add(lblStudentEmail1);
        centerPanel.add(emptySpace5);

        centerPanel.add(lblCourseID);
        centerPanel.add(lblCourseID1);
        centerPanel.add(emptySpace6);

        //centerPanel.setBackground(Color.decode("#CECECE"));

        southPanel.add(emptySpace10);
        southPanel.add(emptySpace11);
        southPanel.add(emptySpace12);
        southPanel.add(btnRead);
        southPanel.add(btnClear);
        southPanel.add(btnExit);
        //southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnRead.addActionListener(this);
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

            if(studentId.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{
                Student result = StudentHttpClient.read(studentId);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "Student exist with ID of: " + studentId);

                    lblFirstName1.setText(result.getFirstName());
                    lblMiddleName1.setText(result.getMiddleName());
                    lblLastName1.setText(result.getLastName());
                    lblStudentEmail1.setText(result.getStudentEmail());
                    lblCourseID1.setText(String.valueOf(result.getCourseID()));
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Student exists with ID of: " + studentId);
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtStudentId.setText("");
            lblFirstName1.setText("");
            lblMiddleName1.setText("");
            lblLastName1.setText("");
            lblStudentEmail1.setText("");
            lblCourseID1.setText("");

            txtStudentId.requestFocus();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new StudentMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new za.ac.cput.views.student.ReadStudent().setGui();
    }
}
