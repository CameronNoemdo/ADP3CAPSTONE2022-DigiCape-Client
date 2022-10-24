package za.ac.cput.views;


import za.ac.cput.views.subject.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectMenu extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading;
    private JButton btnCreate, btnRead, btnUpdate, btnDelete, btnGetAll, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11,emptySpace12, emptySpace13, emptySpace14, emptySpace15;

    public SubjectMenu()
    {
        super("Subject Menu Screen version: 1.0 by Mathew Fortuin");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Subject Menu", SwingConstants.CENTER);

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

        //Button Formatting
      /*  btnGetAll.setBackground(Color.BLACK);
        btnDelete.setBackground(Color.BLACK);
        btnUpdate.setBackground(Color.BLACK);
        btnRead.setBackground(Color.BLACK);
        btnCreate.setBackground(Color.BLACK);
        btnExit.setBackground(Color.BLACK);

        btnGetAll.setForeground(Color.WHITE);
        btnDelete.setForeground(Color.WHITE);
        btnUpdate.setForeground(Color.WHITE);
        btnRead.setForeground(Color.WHITE);
        btnCreate.setForeground(Color.WHITE);
        btnExit.setForeground(Color.WHITE);*/

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

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
        //centerPanel.setBackground(Color.decode("#CECECE"));

        southPanel.add(emptySpace11);
        southPanel.add(emptySpace12);
        southPanel.add(emptySpace13);
        southPanel.add(emptySpace14);
        southPanel.add(btnExit);
        southPanel.add(emptySpace15);
        //southPanel.setBackground(Color.decode("#CECECE"));

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
        setLocationRelativeTo(null); //Centers GUI upon open
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Create"))
        {
            new CreateSubject().setGui();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Read"))
        {
            new ReadSubject().setGui();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Update"))
        {
            new UpdateSubject().setGui();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Delete"))
        {
            new DeleteSubject().setGui();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Get All"))
        {
            new GetAllSubject().setGui();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new SubjectMenu().setGui();
    }
}
