package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JFrame implements ActionListener {

    private JPanel centerPanel;

    private JLabel image;
    private JButton btnDepartment, btnEnrollment, btnFaculty, btnLecture, btnStudent, btnSystemAdmin, btSubject, btnTest, btnExit, btnUniversity, btnCoarse;
    private Font ftText;

    public AdminMenu()  {

        super("Admin Menu");

        centerPanel = new JPanel();

        image = new JLabel(new ImageIcon("Logo.jpg"), SwingConstants.CENTER);

        ftText = new Font("Arial", Font.PLAIN, 18);



        add(centerPanel,BorderLayout.CENTER);

        btnDepartment =new JButton("Department");
        btnEnrollment= new JButton("Enrollment");
        btnFaculty =new JButton("Faculty");
        btnLecture= new JButton("Lecture");
        btnStudent=new JButton("Student");
        btnSystemAdmin = new JButton("System Admin");
        btSubject = new JButton("Subject");
        btnTest= new JButton("Test");
        btnCoarse = new JButton("Course");
        btnUniversity = new JButton("University");
        btnExit = new JButton("Exit");

    }

    public void setGui()
    {

        centerPanel.setLayout(null);


        centerPanel.add(image);

        centerPanel.add(btnStudent);
        centerPanel.add(btnEnrollment);
        centerPanel.add(btSubject);
        centerPanel.add(btnTest);
        centerPanel.add(btnLecture);
        centerPanel.add(btnCoarse);
        centerPanel.add(btnDepartment);
        centerPanel.add(btnFaculty);
        centerPanel.add(btnSystemAdmin);
        centerPanel.add(btnUniversity);
        centerPanel.add(btnExit);

        centerPanel.setBackground(Color.WHITE);
        image.setBounds(220,20,150,150);


        btnStudent.setBounds(55,200,230,30);
        btnEnrollment.setBounds(305,200,230,30);
        btSubject.setBounds(55,250,230,30);
        btnTest.setBounds(305,250,230,30);
        btnLecture.setBounds(55,300,230,30);
        btnCoarse.setBounds(305,300,230,30);
        btnDepartment.setBounds(55,350,230,30);
        btnFaculty.setBounds(305,350,230,30);
        btnSystemAdmin.setBounds(55,400,230,30);
        btnUniversity.setBounds(305,400,230,30);
        btnExit.setBounds(55,450,480,30);


        btnStudent.setFont(ftText);
        btnEnrollment.setFont(ftText);
        btSubject.setFont(ftText);
        btnTest.setFont(ftText);
        btnLecture.setFont(ftText);
        btnCoarse.setFont(ftText);
        btnDepartment.setFont(ftText);
        btnFaculty.setFont(ftText);
        btnSystemAdmin.setFont(ftText);
        btnUniversity.setFont(ftText);
        btnExit.setFont(ftText);

        btnExit.setBackground(Color.RED);





        //Add action listener to buttons | mouse listener to hyperlink
        btnStudent.addActionListener(this);
        btnEnrollment.addActionListener(this);
        btSubject.addActionListener(this);
        btnTest.addActionListener(this);
        btnLecture.addActionListener(this);
        btnCoarse.addActionListener(this);
        btnDepartment.addActionListener(this);
        btnFaculty.addActionListener(this);
        btnSystemAdmin.addActionListener(this);
        btnUniversity.addActionListener(this);
        btnExit.addActionListener(this);

        //Frame
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(600, 550);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStudent)
        {
            new StudentMenu().setGui();
            this.dispose();
        }
        else if(e.getSource() == btnEnrollment)
        {
           // new EnrollmentMenu().setGui();
            this.dispose();
        }
        else if(e.getSource() == btSubject)
        {
            new SubjectMenu().setGui();
            this.dispose();
        }
        else if(e.getSource() == btnTest)
        {
            new TestMenu().setGui();
            this.dispose();
        }
        else if(e.getSource() == btnLecture)
        {
            new LecturerMenu().setGui();
            this.dispose();
        }
        else if(e.getSource() == btnCoarse)
        {
            new CourseMenu().setGui();
            this.dispose();
        }
        else if(e.getSource() == btnDepartment)
        {
          // new DepartmentMenu().setGui();
            this.dispose();
        }

        else if(e.getSource() == btnFaculty)
        {
            //new FacultyMenu().setGui();
            this.dispose();
        }

        else if(e.getSource() == btnSystemAdmin)
        {
            new SystemAdminMenu().setGui();
            this.dispose();
        }
        else if(e.getSource() == btnUniversity)
        {
            new UniversityMenu().setGui();
            this.dispose();
        }
        else if(e.getSource() == btnExit)
        {
           new UserLogin().setGUI();
            this.dispose();
        }




    }

    public static void main(String[] args) {
        new AdminMenu().setGui();
    }
}

