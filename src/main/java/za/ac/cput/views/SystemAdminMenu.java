package za.ac.cput.views;

//import za.ac.cput.views.systemAdmin.CreateSystemAdmin;
//import za.ac.cput.views.systemAdmin.DeleteSystemAdmin;
import za.ac.cput.views.systemAdmin.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemAdminMenu extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading;
    private JButton btnCreate, btnRead, btnUpdate, btnDelete, btnGetAll, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11,emptySpace12, emptySpace13, emptySpace14, emptySpace15;

    public SystemAdminMenu()
    {
        super("SystemAdmin Menu Screen ");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("System Admin Menu", SwingConstants.CENTER);

        btnCreate = new JButton("Create");
        btnRead = new JButton("Read");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnGetAll = new JButton("Get All");
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
        emptySpace15 = new JLabel();
    }

    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(5,3));
        southPanel.setLayout(new GridLayout(2,3));


        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        btnGetAll.setFont(ftTextBold);
        btnDelete.setFont(ftTextBold);
        btnUpdate.setFont(ftTextBold);
        btnRead.setFont(ftTextBold);
        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        //Add components to panels
        northPanel.add(lblHeading);


        centerPanel.add(emptySpace1);
        centerPanel.add(btnCreate);
        centerPanel.add(emptySpace2);

        centerPanel.add(emptySpace3);
        centerPanel.add(btnRead);
        centerPanel.add(emptySpace4);

        centerPanel.add(emptySpace5);
        centerPanel.add(btnUpdate);
        centerPanel.add(emptySpace6);

        centerPanel.add(emptySpace7);
        centerPanel.add(btnDelete);
        centerPanel.add(emptySpace8);

        centerPanel.add(emptySpace9);
        centerPanel.add(btnGetAll);
        centerPanel.add(emptySpace10);

        southPanel.add(emptySpace11);
        southPanel.add(emptySpace12);
        southPanel.add(emptySpace13);
        southPanel.add(emptySpace14);
        southPanel.add(btnExit);
        southPanel.add(emptySpace15);


        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnCreate.addActionListener(this);
        btnRead.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnGetAll.addActionListener(this);
        btnExit.addActionListener(this);

        //Frame
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 280);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Create"))
        {
            new CreateSystemAdmin().setGui();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Read"))
        {
            new ReadSystemAdmin().setGui();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Update"))
        {
            new UpdateSystemAdmin().setGui();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Delete"))
        {
            new DeleteSystemAdmin().setGui();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Get All"))
        {
            new GetAllSystemAdmins().setGui();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new SystemAdminMenu().setGui();
    }
}

