package AdminModule;
import javax.swing.*;

import UserModule.Login;

import java.awt.*;
import java.io.*;

public class AdminPanel extends JFrame {

    JTextArea area;
    JButton refresh;

    public AdminPanel(){

        setTitle("Admin Panel");
        setSize(650,500);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(15,23,42));

        JButton back = new JButton("Back");
        back.setBounds(20,20,80,30);
        back.setBackground(new Color(37,99,235));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        add(back);

        back.addActionListener(e -> {
            dispose();
            new Login();
        });

        JLabel title = new JLabel("Admin Panel - Booking History");
        title.setBounds(200,20,300,30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI",Font.BOLD,18));
        add(title);

        area = new JTextArea();
        area.setEditable(false);
        area.setBackground(new Color(30,41,59));
        area.setForeground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(50,70,550,330);
        add(scroll);

        refresh = new JButton("Refresh");
        refresh.setBounds(250,420,120,35);
        refresh.setBackground(new Color(37,99,235));
        refresh.setForeground(Color.WHITE);
        refresh.setFocusPainted(false);
        refresh.setBorderPainted(false);
        refresh.setFont(new Font("Segoe UI",Font.BOLD,14));

        add(refresh);

        refresh.addActionListener(e -> loadBookings());

        loadBookings();

        setVisible(true);
    }

    void loadBookings(){

        area.setText("");

        try{

            File file = new File("booking.txt");

            if(!file.exists()){
                area.setText("No Bookings Found");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while((line = br.readLine()) != null){
                area.append("User Booking : " + line + "\n");
            }
            br.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}