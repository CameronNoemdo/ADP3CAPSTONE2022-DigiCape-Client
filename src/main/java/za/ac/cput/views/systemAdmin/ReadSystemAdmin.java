package za.ac.cput.views.systemAdmin;

import za.ac.cput.client.SystemAdminHttpClient;
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.views.SystemAdminMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadSystemAdmin extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblAdminId, lblName, lblEmail;
    private JLabel lblName1, lblEmail1;
    private JTextField txtAdminId;
    private JButton btnRead, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12;

    public ReadSystemAdmin()
    {
        super("Read System Admin");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Read System Admin", SwingConstants.CENTER);
        lblAdminId = new JLabel("Admin ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Admin Name: ", SwingConstants.RIGHT);
        lblEmail = new JLabel("Admin Email: ", SwingConstants.RIGHT);

        txtAdminId = new JTextField();
        lblName1 = new JLabel("");
        lblEmail1 = new JLabel("");

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
        centerPanel.setLayout(new GridLayout(3,3));
        southPanel.setLayout(new GridLayout(2,3));

        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblAdminId.setFont(ftTextBold);
        lblName.setFont(ftTextBold);
        lblEmail.setFont(ftTextBold);

        btnRead.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtAdminId.setFont(ftText);
        lblName1.setFont(ftText);
        lblEmail1.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblAdminId);
        centerPanel.add(txtAdminId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblName);
        centerPanel.add(lblName1);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblEmail);
        centerPanel.add(lblEmail1);
        centerPanel.add(emptySpace3);

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
        this.setSize(640, 240);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Read"))
        {
            String adminId = txtAdminId.getText().trim().toString();

            if(adminId == null)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{
                SystemAdmin result = SystemAdminHttpClient.read(adminId);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "System admin exist with ID of: " + adminId);

                    lblName1.setText(result.getAdminName());
                    lblEmail1.setText(result.getAdminEmail());
                }
                else {
                    JOptionPane.showMessageDialog(null, "No System Admin exists with ID of: " + adminId);
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtAdminId.setText("");
            lblName1.setText("");
            lblEmail1.setText("");

            txtAdminId.requestFocus();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new SystemAdminMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new ReadSystemAdmin().setGui();
    }
}


