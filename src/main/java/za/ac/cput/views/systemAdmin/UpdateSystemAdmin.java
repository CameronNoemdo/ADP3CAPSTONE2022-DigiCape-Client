package za.ac.cput.views.systemAdmin;

import za.ac.cput.client.SystemAdminHttpClient;
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.factory.SystemAdminFactory;
import za.ac.cput.views.SystemAdminMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateSystemAdmin extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblAdminId, lblName, lblEmail;
    private  JTextField  txtAdminId, txtName, txtEmail;
    private JButton btnRead, btnCreate, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    public UpdateSystemAdmin()
    {
        super("Update System Admin");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();

        lblHeading = new JLabel("Update System Admin", SwingConstants.CENTER);
        lblAdminId = new JLabel("Admin ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Name: ", SwingConstants.RIGHT);
        lblEmail = new JLabel("Surname: ", SwingConstants.RIGHT);

        txtAdminId = new JTextField();
        txtName = new JTextField();
        txtEmail = new JTextField();

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
        centerPanel.setLayout(new GridLayout(4,3));
        southPanel.setLayout(new GridLayout(2,4));

        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblAdminId.setFont(ftTextBold);
        lblName.setFont(ftTextBold);
        lblEmail.setFont(ftTextBold);

        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtAdminId.setFont(ftText);
        txtName.setFont(ftText);
        txtEmail.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblAdminId);
        centerPanel.add(txtAdminId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblName);
        centerPanel.add(txtName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblEmail);
        centerPanel.add(txtEmail);
        centerPanel.add(emptySpace3);

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
        this.setSize(640, 280);
        this.setVisible(true);
        setLocationRelativeTo(null);
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

                SystemAdmin former = SystemAdminHttpClient.read(adminId);

                if(former != null)
                {
                    JOptionPane.showMessageDialog(null, "Admin exist with ID of: " + adminId);

                    txtName.setText(former.getAdminName());
                    txtEmail.setText(String.valueOf(former.getAdminEmail()));

                    setTextFieldToEditable(); //Set all fields to editable
                    txtAdminId.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Admin exists with ID of: " + adminId);
                }
            }
        }
        else if(e.getActionCommand().equals("Update"))
        {
            String adminId = txtAdminId.getText().trim();
            String adminName = txtName.getText().trim();
            String AdminEmail = txtEmail.getText().trim();

            if(adminName.isEmpty() || AdminEmail.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a profile.");
            }
            else {
                SystemAdmin updateSystemAdmin = SystemAdminFactory.updateSystemAdmin(adminId, adminName, AdminEmail);

                SystemAdmin result = SystemAdminHttpClient.update(updateSystemAdmin);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated your profile.");

                    txtAdminId.setText("");
                    txtName.setText("");
                    txtEmail.setText("");

                    txtAdminId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating your profile.");
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtAdminId.setText("");
            txtName.setText("");
            txtEmail.setText("");

            txtAdminId.requestFocus();
            setTextFieldToUneditable();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new SystemAdminMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable()
    {
        txtAdminId.setEnabled(true);
        txtName.setEnabled(false);
        txtEmail.setEnabled(false);

    }

    public void setTextFieldToEditable()
    {
        txtAdminId.setEnabled(false);
        txtName.setEnabled(true);
        txtEmail.setEnabled(true);

    }


    public static void main(String[] args) {
        new UpdateSystemAdmin().setGui();
    }
}

