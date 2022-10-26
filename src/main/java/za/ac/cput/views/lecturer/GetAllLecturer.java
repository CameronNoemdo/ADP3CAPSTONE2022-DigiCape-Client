package za.ac.cput.views.lecturer;

/*
Student name: Cameron Henry Noemdo
Student number: 219115443
DigiCape-Client
 */

import za.ac.cput.client.LecturerHttpClient;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.views.LecturerMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class GetAllLecturer extends JFrame implements ActionListener {
    private final JPanel northPanel, centerPanel, southPanel;
    private final Font ftHeading, ftTextBold;
    private final JButton btnExit;
    private final JLabel lblHeading, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    private final JScrollPane sPane;

    String[] columnLecturerAttributes = {"ID", "First name", "Middle name", "Last name", "Email", "Department ID"};
    Lecturer[] lecturerArray;

    public GetAllLecturer() {
        super("Get All Lecturers");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("All Lecturers", SwingConstants.CENTER);

        btnExit = new JButton("Exit");

        ftHeading = new Font("Segoe UI Black", Font.PLAIN, 28);
        ftTextBold = new Font("Arial", Font.BOLD, 12);

        emptySpace10 = new JLabel();
        emptySpace11 = new JLabel();
        emptySpace12 = new JLabel();
        emptySpace13 = new JLabel();
        emptySpace14 = new JLabel();

        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        Set<Lecturer> lecturerSet = LecturerHttpClient.getAll();

        for (String column : columnLecturerAttributes) {
            model.addColumn(column);
        }

        lecturerArray = LecturerHttpClient.rows();

        Object[] rows = new Object[100];

        for (int i = 0; i < lecturerArray.length; i++) //Create object array to add each row of data to the table
        {
            for (int k = 0; k < lecturerArray.length - 1; k++) {
                rows[k] = lecturerArray[i].getLecturerId();
                rows[++k] = lecturerArray[i].getFirstName();
                rows[++k] = lecturerArray[i].getMiddleName();
                rows[++k] = lecturerArray[i].getLastName();
                rows[++k] = lecturerArray[i].getLecturerEmail();
                rows[++k] = lecturerArray[i].getDepartmentId();
            }
            model.addRow(rows);
        }

        table.getColumnModel().getColumn(0).setPreferredWidth(500);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(350);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);

        table.setAutoCreateRowSorter(true);

        sPane = new JScrollPane(table);
    }

    public void setGui() {
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(1, 1));
        southPanel.setLayout(new GridLayout(2, 3));

        lblHeading.setFont(ftHeading);

        btnExit.setFont(ftTextBold);

        northPanel.add(lblHeading);

        centerPanel.add(sPane);

        southPanel.add(emptySpace10);
        southPanel.add(emptySpace11);
        southPanel.add(emptySpace12);
        southPanel.add(emptySpace13);
        southPanel.add(btnExit);
        southPanel.add(emptySpace14);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        btnExit.addActionListener(this);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(900, 440);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            new LecturerMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new GetAllLecturer().setGui();
    }
}
