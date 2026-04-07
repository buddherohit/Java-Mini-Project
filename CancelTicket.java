import javax.swing.*;
import java.awt.*;
import java.io.*;

public class CancelTicket extends JFrame {

    public CancelTicket(){

        setTitle("Cancel Ticket");
        setSize(300,200);
        setLocationRelativeTo(null);

        JButton cancel = new JButton("Cancel Last Ticket");
        cancel.setBackground(new Color(220,38,38));
        cancel.setForeground(Color.WHITE);

        add(cancel);

        cancel.addActionListener(e -> cancelTicket());

        setVisible(true);
    }

    void cancelTicket(){

        try{

            File file = new File("booking.txt");

            if(!file.exists()){
                JOptionPane.showMessageDialog(null,"No Booking Found");
                return;
            }

            PrintWriter pw = new PrintWriter(file);
            pw.close();

            JOptionPane.showMessageDialog(null,"Last Booking Cancelled");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}