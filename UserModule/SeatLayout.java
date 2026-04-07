package UserModule;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SeatLayout extends JFrame {

    JButton seats[][] = new JButton[5][8];
    JButton confirm;

    String username;
    String movie;
    String time;

    public SeatLayout(String username, String movie,String time){

        this.username = username;
        this.movie = movie;
        this.time = time;

        setTitle("Seat Layout");
        setSize(600,600);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(15,23,42));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,8,10,10));
        panel.setBounds(50,80,500,350);
        panel.setBackground(new Color(15,23,42));
        add(panel);

        JLabel screen = new JLabel("SCREEN",SwingConstants.CENTER);
        screen.setBounds(100,30,400,30);
        screen.setForeground(Color.WHITE);
        screen.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(screen);

        for(int i=0;i<5;i++){
            for(int j=0;j<8;j++){

                seats[i][j] = new JButton("S"+(i+1)+(j+1));
                seats[i][j].setBackground(new Color(37,99,235));
                seats[i][j].setForeground(Color.WHITE);
                seats[i][j].setFocusPainted(false);
                seats[i][j].setBorderPainted(false);
                seats[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));

                seats[i][j].addActionListener(new SeatHandler());

                panel.add(seats[i][j]);
            }
        }

        confirm = new JButton("Confirm Booking");
        confirm.setBounds(200,460,200,45);
        confirm.setBackground(new Color(16,185,129));
        confirm.setForeground(Color.WHITE);
        confirm.setFocusPainted(false);
        confirm.setBorderPainted(false);
        confirm.setFont(new Font("Segoe UI",Font.BOLD,14));
        confirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(confirm);

        confirm.addActionListener(e -> {
            String selectedSeat = "Selected Seat";
            
            new PaymentUI(username,movie,time,selectedSeat);

            dispose();
        });

        setVisible(true);
    }

    class SeatHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){

            JButton btn = (JButton)e.getSource();

            btn.setBackground(Color.GREEN);
            btn.setEnabled(false);
        }
    }
}