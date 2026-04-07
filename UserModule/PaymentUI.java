package UserModule;
import javax.swing.*;

import java.awt.*;

public class PaymentUI extends JFrame {

    public PaymentUI(String user,String movie,String time,String seat){

        setTitle("Payment");
        setSize(400,400);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(15,23,42));

        JLabel title = new JLabel("Payment", SwingConstants.CENTER);
        title.setBounds(100,20,200,30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(title);

        JLabel amount = new JLabel("Amount : \u20B9200", SwingConstants.CENTER);
        amount.setBounds(100,80,200,30);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(amount);

        JProgressBar bar = new JProgressBar();
        bar.setBounds(100,200,200,20);
        add(bar);

        JButton pay = new JButton("Pay Now");
        pay.setBounds(120,130,150,40);
        pay.setBackground(new Color(37,99,235));
        pay.setForeground(Color.WHITE);
        pay.setFocusPainted(false);
        pay.setBorderPainted(false);
        pay.setFont(new Font("Segoe UI",Font.BOLD,14));
        pay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(pay);

        Timer timer = new Timer(30,null);
        timer.addActionListener(e -> {
            int value = bar.getValue();
            if(value < 100){
                bar.setValue(value+2);
            }
            else{
                ((Timer)e.getSource()).stop();
                new Booking(user,movie,time,seat);
                JOptionPane.showMessageDialog(null,"Payment Successful");
                dispose();
                new Dashboard(user);
            }
        });

        pay.addActionListener(e -> {
            pay.setEnabled(false);
            timer.start();
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
