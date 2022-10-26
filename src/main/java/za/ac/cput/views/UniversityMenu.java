package za.ac.cput.views;

import za.ac.cput.views.university.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UniversityMenu extends JFrame implements ActionListener {

    private final JPanel northPanel, centerPanel, southPanel;
    private final JLabel lblHeading;
    private final JButton btnCreate, btnRead, btnUpdate, btnDelete, btnGetAll, btnExit;
    private final Font ftHeading;
    private final Font ftTextBold;
    private final JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11,emptySpace12, emptySpace13, emptySpace14, emptySpace15;


    public UniversityMenu() {
        super("University Menu");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("University Menu", SwingConstants.CENTER);

        btnCreate = new JButton("Create");
        btnRead = new JButton("Read");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnGetAll = new JButton("Get All");
        btnExit = new JButton("Exit");

        ftHeading = new Font("Segoe UI Black", Font.PLAIN, 28);
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

    public void setGui() {
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(5,3));
        southPanel.setLayout(new GridLayout(2,3));

        lblHeading.setFont(ftHeading);

        btnGetAll.setFont(ftTextBold);
        btnDelete.setFont(ftTextBold);
        btnUpdate.setFont(ftTextBold);
        btnRead.setFont(ftTextBold);
        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

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

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        btnCreate.addActionListener(this);
        btnRead.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnGetAll.addActionListener(this);
        btnExit.addActionListener(this);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(440, 280);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create")) {
            new CreateUniversity().setGui();
            this.dispose();
        } else if (e.getActionCommand().equals("Read")) {
            new ReadUniversity().setGui();
            this.dispose();
        } else if (e.getActionCommand().equals("Update")) {
            new UpdateUniversity().setGui();
            this.dispose();
        } else if (e.getActionCommand().equals("Delete")) {
            new DeleteUniversity().setGui();
            this.dispose();
        } else if (e.getActionCommand().equals("Get All")) {
            new GetAllUniversity().setGui();
            this.dispose();
        } else if(e.getActionCommand().equals("Exit")) {
            new AdminMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new UniversityMenu().setGui();
    }
}
