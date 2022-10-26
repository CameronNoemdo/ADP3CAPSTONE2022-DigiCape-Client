package za.ac.cput.views.systemAdmin;

import za.ac.cput.client.SystemAdminHttpClient;
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.views.SystemAdminMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class GetAllSystemAdmins extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading;
    private Font ftHeading, ftText, ftTextBold;
    private JButton btnExit;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    private JTable table;
    private DefaultTableModel model;
    private JScrollPane sPane;
    String[] adminAttributes = {"Id", "Name", "Email"};
    SystemAdmin[] adminList;


    public GetAllSystemAdmins()
    {
        super("Get All System Admins ");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Get All System Admins", SwingConstants.CENTER);

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

        //Add table data and columns to table
        table = new JTable();
        model = (DefaultTableModel) table.getModel();

        Set<SystemAdmin> systemAdminSet = SystemAdminHttpClient.getAll();

        for (String column : adminAttributes) {
            model.addColumn(column);
        }

        adminList = SystemAdminHttpClient.rows();

        Object[] rows = new Object[100];

        for (int i = 0; i < adminList.length; i++) //Create object array to add each row of data to the table
        {
            {
                for (int k = 0; k < adminList.length; k++) {
                    rows[k] = adminList[i].getAdminId();
                    rows[++k] = adminList[i].getAdminName();
                    rows[++k] = adminList[i].getAdminEmail();


                }
                model.addRow(rows);
            }



        }

        table.getColumnModel().getColumn(0).setPreferredWidth(500);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);

        sPane = new JScrollPane(table);
    }

    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(1,1));
        southPanel.setLayout(new GridLayout(2,3));

        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));
        btnExit.setFont(ftTextBold);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(sPane);
        //centerPanel.setBackground(Color.decode("#CECECE"));

        southPanel.add(emptySpace10);
        southPanel.add(emptySpace11);
        southPanel.add(emptySpace12);
        southPanel.add(emptySpace13);
        southPanel.add(btnExit);
        southPanel.add(emptySpace14);
        //southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnExit.addActionListener(this);

        //Frame
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(860, 440);
        this.setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Exit"))
        {
            new SystemAdminMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new GetAllSystemAdmins().setGui();
    }
}
