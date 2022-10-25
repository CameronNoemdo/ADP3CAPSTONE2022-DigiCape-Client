package za.ac.cput.views.systemAdmin;
import za.ac.cput.client.SystemAdminHttpClient;
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.factory.SystemAdminFactory;
import za.ac.cput.views.SystemAdminMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateSystemAdmin extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblAdminId, lblAdminId1, lblName, lblEmailAddress;
    private  JTextField  txtName,  txtEmailAddress;
    private JButton btnCreate, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11;

    public CreateSystemAdmin()
    {
        super("Create System Admin Screen ");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();


        lblHeading = new JLabel("Create System Admin", SwingConstants.CENTER);
        lblAdminId = new JLabel("System Admin ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Admin Name: ", SwingConstants.RIGHT);
        lblEmailAddress = new JLabel("Admin Email Address: ", SwingConstants.RIGHT);


        lblAdminId1 = new JLabel("Auto is Generated...");
        txtName = new JTextField();
        txtEmailAddress = new JTextField();


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
        centerPanel.setLayout(new GridLayout(4,6));
        southPanel.setLayout(new GridLayout(2,2));


        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblAdminId.setFont(ftTextBold);
        lblName.setFont(ftTextBold);
        lblEmailAddress.setFont(ftTextBold);


        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        lblAdminId1.setFont(ftText);
        txtName.setFont(ftText);

        txtEmailAddress.setFont(ftText);


        //Add components to panels
        northPanel.add(lblHeading);


        centerPanel.add(lblAdminId);
        centerPanel.add(lblAdminId1);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblName);
        centerPanel.add(txtName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblEmailAddress);
        centerPanel.add(txtEmailAddress);
        centerPanel.add(emptySpace3);



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
        this.setSize(640, 280);
        this.setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create")) {
            String name = txtName.getText().trim().toString();
            String emailAddress = txtEmailAddress.getText().trim().toString();


            if (name.isEmpty() ||  emailAddress.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a profile.");
            }

            else {

                SystemAdmin createSystemAdmin = SystemAdminFactory.createSystemAdmin(name, emailAddress);

                SystemAdmin result = SystemAdminHttpClient.create(createSystemAdmin);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully created your profile!.");

                    txtName.setText("");
                    txtEmailAddress.setText("");


                    txtName.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error creating a profile.");
                }
            }
        }

        else if(e.getActionCommand().equals("Exit"))
        {
            new SystemAdminMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new CreateSystemAdmin().setGui();
    }
}