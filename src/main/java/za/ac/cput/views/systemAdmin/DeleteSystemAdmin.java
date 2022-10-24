package za.ac.cput.views.systemAdmin;

import za.ac.cput.client.SystemAdminHttpClient;
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.views.SystemAdminMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteSystemAdmin extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblEmailId, lblName, lblEmail;
    private JLabel lblName1, lblEmail1;
    private JTextField txtAdminId;
    private JButton btnRead, btnDelete, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13;

    public DeleteSystemAdmin()
    {
        super("Delete System Admin");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Delete System Admin", SwingConstants.CENTER);
        lblEmailId = new JLabel("System Admin ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Admin Name: ", SwingConstants.RIGHT);
        lblEmail = new JLabel("Admin Email : ", SwingConstants.RIGHT);


        txtAdminId = new JTextField();
        lblName1 = new JLabel("");
        lblEmail1 = new JLabel("");

        btnRead = new JButton("Read");
        btnDelete = new JButton("Delete");
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
    }

    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(4,3));
        southPanel.setLayout(new GridLayout(2,4));


        lblHeading.setFont(ftHeading);


        lblEmailId.setFont(ftTextBold);
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

        centerPanel.add(lblEmailId);
        centerPanel.add(txtAdminId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblName);
        centerPanel.add(lblName1);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblEmail);
        centerPanel.add(lblEmail1);
        centerPanel.add(emptySpace3);




        southPanel.add(emptySpace10);
        southPanel.add(emptySpace11);
        southPanel.add(emptySpace12);
        southPanel.add(emptySpace13);
        southPanel.add(btnRead);
        southPanel.add(btnDelete);
        southPanel.add(btnClear);
        southPanel.add(btnExit);



        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnRead.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Frame
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 280);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Read"))
        {
            String adminID = txtAdminId.getText().trim().toString();

            if(adminID == null)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{
                SystemAdmin result = SystemAdminHttpClient.read(adminID);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "System Admin exist with ID of: " + adminID);

                    txtAdminId.setEnabled(false);
                    lblName1.setText(result.getAdminName());
                    lblEmail1.setText(result.getAdminEmail());

                }
                else {
                    JOptionPane.showMessageDialog(null, "No System Admin exists with ID of: " + adminID);
                }
            }
        }
        else if(e.getActionCommand().equals("Delete"))
        {
            String delete = txtAdminId.getText().trim().toString();

            SystemAdminHttpClient.delete(delete);
            JOptionPane.showMessageDialog(null, "The staff with ID of: " + delete + " was deleted.");

            txtAdminId.setText("");
            lblName1.setText("");
            lblEmail1.setText("");

            txtAdminId.setEnabled(true);
            txtAdminId.requestFocus();
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtAdminId.setText("");
            lblName1.setText("");
            lblEmail1.setText("");

            txtAdminId.setEnabled(true);
            txtAdminId.requestFocus();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new SystemAdminMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new DeleteSystemAdmin().setGui();
    }
}



