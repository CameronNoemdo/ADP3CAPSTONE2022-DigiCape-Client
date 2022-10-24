package za.ac.cput.views;

import za.ac.cput.views.course.GetAllCourse;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class UserLogin extends JFrame implements ActionListener {

    //Attributes

    private static JLabel password1, label;
    private static JTextField username;
    private static JButton button;
    private static JPasswordField Password;
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel picLabel;

   public UserLogin(){

       super("User Login v1.0");

       panel = new JPanel();


       frame = new JFrame();


       //Username label
       label = new JLabel("Username:",SwingConstants.CENTER);


     //Username Textbox
      username = new JTextField(SwingConstants.CENTER);


       //Password label
       password1 = new JLabel("Password",SwingConstants.CENTER);


       //Password Textbox
       Password = new JPasswordField(SwingConstants.CENTER);



       //Login Button
       button = new JButton("Login");


      //Picture Label
       picLabel = new JLabel(new ImageIcon("Lockicon.jpg"));


   }

   public void setGUI()
   {
       button.setBounds(100, 110, 90, 25);
       button.setForeground(Color.WHITE);
       button.setBackground(Color.BLACK);
       button.addActionListener(this);
       panel.add(button);
       panel.add(Password);
       Password.setBounds(100,75,193,28);
       password1.setBounds(100,55,70,20);
       panel.add(password1);
       username.setBounds(100,27,193,28);
       panel.add(username);
       label.setBounds(100,8,70,20);
       panel.add(label);
       panel.setLayout(null);
       panel.add(picLabel);


       frame.setTitle("Login");
       frame.setLocation(new Point(500,300));
       frame.setSize(new Dimension(400,200));
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.add(panel);
       frame.setVisible(true);
       setLocationRelativeTo(null);

   }
public void actionPerformed(ActionEvent e) {

       String Username = username.getText();
       String Password1 = Password.getText();

if(e.getActionCommand().equals("Login")) {

    if (Username.equals("Admin") && Password1.equals("Admin123")){
        JOptionPane.showMessageDialog(null, "Login Successful!");
        frame.dispose();
        new AdminMenu().setGui();

    }

    else
        JOptionPane.showMessageDialog(frame,
                "Credentials entered are incorrect...",
                "Access Denied",
                JOptionPane.ERROR_MESSAGE);
}
}

    public static void main(String[] args) {
        new UserLogin().setGUI();
    }

}
