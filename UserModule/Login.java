package UserModule;
import javax.swing.*;

import AdminModule.AdminPanel;

import java.awt.*;
import java.io.*;

public class Login extends JFrame {

    JTextField username;
    JPasswordField password;
    JButton login, register;

    public Login() {

        setTitle("Movie Booking System");
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Background Color
        getContentPane().setBackground(new Color(15,23,42));

        // Card Panel
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(75,70,340,330);
        card.setBackground(new Color(30,41,59));
        card.setBorder(BorderFactory.createLineBorder(new Color(51,65,85),1));
        add(card);

        // Title
        JLabel title = new JLabel("Movie Booking");
        title.setBounds(80,20,200,30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI",Font.BOLD,22));
        card.add(title);

        // Username
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(30,80,100,25);
        userLabel.setForeground(Color.WHITE);
        card.add(userLabel);

        username = new JTextField();
        username.setBounds(30,105,280,35);
        username.setFont(new Font("Segoe UI",Font.PLAIN,14));
        card.add(username);

        // Password
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(30,150,100,25);
        passLabel.setForeground(Color.WHITE);
        card.add(passLabel);

        password = new JPasswordField();
        password.setBounds(30,175,280,35);
        password.setFont(new Font("Segoe UI",Font.PLAIN,14));
        card.add(password);

        // Login Button
        login = new JButton("Login");
        login.setBounds(30,230,130,40);
        login.setBackground(new Color(37,99,235));
        login.setForeground(Color.WHITE);
        login.setFocusPainted(false);
        login.setBorderPainted(false);
        login.setFont(new Font("Segoe UI",Font.BOLD,14));
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card.add(login);

        // Register Button
        register = new JButton("Register");
        register.setBounds(180,230,130,40);
        register.setBackground(new Color(16,185,129));
        register.setForeground(Color.WHITE);
        register.setFocusPainted(false);
        register.setBorderPainted(false);
        register.setFont(new Font("Segoe UI",Font.BOLD,14));
        register.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card.add(register);

        login.addActionListener(e -> loginUser());
        register.addActionListener(e -> registerUser());

        setVisible(true);
    }

    void loginUser(){

        String user = username.getText();
        String pass = password.getText();

        if(user.equals("admin") && pass.equals("admin")){
            new AdminPanel();
            dispose();
            return;
        }

        try{
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            String line;

            while((line = br.readLine()) != null){
                String data[] = line.split(",");

                if(data[0].equals(user) && data[1].equals(pass)){
                    new Dashboard(user);
                    dispose();
                    return;
                }
            }

            JOptionPane.showMessageDialog(this,"Invalid Login");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void registerUser(){

        try{
            FileWriter fw = new FileWriter("users.txt",true);

            fw.write(username.getText()+","+password.getText()+"\n");
            fw.close();

            JOptionPane.showMessageDialog(this,"Registered Successfully");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}