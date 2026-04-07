package UserModule;
import javax.swing.*;

import java.awt.*;
import java.io.*;

public class Dashboard extends JFrame {

    JComboBox<String> movieBox;
    JComboBox<String> timeBox;
    JTextArea bookingArea;

    public Dashboard(String user){

        UIManager.put("ComboBox.background", new Color(30,41,59));
        UIManager.put("ComboBox.foreground", Color.WHITE);
        UIManager.put("ComboBox.selectionBackground", new Color(37,99,235));
        UIManager.put("ComboBox.selectionForeground", Color.WHITE);
        UIManager.put("ComboBox.buttonBackground", new Color(30,41,59));
        UIManager.put("ComboBox.buttonDarkShadow", new Color(30,41,59));

        setTitle("Dashboard");
        setSize(500,660);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(15,23,42));

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(70,20,350,570);
        card.setBackground(new Color(30,41,59));
        add(card);

        JButton back = new JButton("Back");
        back.setBounds(20,20,70,30);
        back.setBackground(new Color(37,99,235));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        card.add(back);

        back.addActionListener(e -> {
            dispose();
            new Login();
        });

        JLabel title = new JLabel("Movie Booking", SwingConstants.CENTER);
        title.setBounds(100,20,200,30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI",Font.BOLD,22));
        card.add(title);

        JLabel welcome = new JLabel("Welcome " + user, SwingConstants.CENTER);
        welcome.setBounds(100,50,200,30);
        welcome.setForeground(Color.LIGHT_GRAY);
        card.add(welcome);

        JLabel movieLabel = new JLabel("Select Movie");
        movieLabel.setBounds(30,90,150,25);
        movieLabel.setForeground(Color.WHITE);
        card.add(movieLabel);

        String movies[] = {"Avengers","Pushpa","KGF","Pathaan"};
        movieBox = new JComboBox<>(movies);
        movieBox.setBounds(30,115,280,35);
        movieBox.setBackground(new Color(30,41,59));
        movieBox.setForeground(Color.WHITE);
        movieBox.setFocusable(false);
        movieBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        movieBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
        
                JLabel label = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus);
        
                label.setOpaque(true);
        
                if (isSelected) {
                    label.setBackground(new Color(37,99,235));
                    label.setForeground(Color.WHITE);
                } else {
                    label.setBackground(new Color(30,41,59));
                    label.setForeground(Color.WHITE);
                }
        
                return label;
            }
        });
        card.add(movieBox);

        JLabel timeLabel = new JLabel("Select Time");
        timeLabel.setBounds(30,160,150,25);
        timeLabel.setForeground(Color.WHITE);
        card.add(timeLabel);

        String times[] = {"10 AM","2 PM","6 PM","9 PM"};
        timeBox = new JComboBox<>(times);
        timeBox.setBounds(30,185,280,35);
        timeBox.setBackground(new Color(30,41,59));
        timeBox.setForeground(Color.WHITE);
        timeBox.setFocusable(false);
        timeBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        timeBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
        
                JLabel label = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus);
        
                label.setOpaque(true);
        
                if (isSelected) {
                    label.setBackground(new Color(37,99,235));
                    label.setForeground(Color.WHITE);
                } else {
                    label.setBackground(new Color(30,41,59));
                    label.setForeground(Color.WHITE);
                }
        
                return label;
            }
        });
        card.add(timeBox);

        JButton book = new JButton("Book Ticket");
        book.setBounds(30,240,130,40);
        book.setBackground(new Color(37,99,235));
        book.setForeground(Color.WHITE);
        book.setFocusPainted(false);
        book.setBorderPainted(false);
        book.setFont(new Font("Segoe UI",Font.BOLD,14));
        book.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card.add(book);

        JButton cancel = new JButton("Cancel Ticket");
        cancel.setBounds(180,240,130,40);
        cancel.setBackground(new Color(220,38,38));
        cancel.setForeground(Color.WHITE);
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        cancel.setFont(new Font("Segoe UI",Font.BOLD,14));
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card.add(cancel);

        JPanel movieCard = new JPanel();
        movieCard.setBounds(30,295,120,160);
        movieCard.setBackground(new Color(30,41,59));
        movieCard.setLayout(null);

        ImageIcon img = new ImageIcon("poster.jpg");
        Image scaledImg = img.getImage().getScaledInstance(100, 120, Image.SCALE_SMOOTH);
        JLabel poster = new JLabel(new ImageIcon(scaledImg));
        poster.setBounds(10,10,100,120);
        movieCard.add(poster);

        JLabel titlePoster = new JLabel("Avengers");
        titlePoster.setBounds(20,135,100,20);
        titlePoster.setForeground(Color.WHITE);
        movieCard.add(titlePoster);

        card.add(movieCard);

        JLabel bookingLabel = new JLabel("My Bookings");
        bookingLabel.setBounds(160,290,150,25);
        bookingLabel.setForeground(Color.LIGHT_GRAY);
        card.add(bookingLabel);

        bookingArea = new JTextArea();
        bookingArea.setEditable(false);
        bookingArea.setBackground(new Color(30,41,59));
        bookingArea.setForeground(Color.WHITE);
        bookingArea.setBorder(null);
        bookingArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JScrollPane scroll = new JScrollPane(bookingArea);
        scroll.setBounds(160,315,160,140);
        scroll.setBorder(null);
        card.add(scroll);

        loadBookings(user);

        JPanel recommendPanel = new JPanel();
        recommendPanel.setLayout(null);
        recommendPanel.setBounds(30,470,290,70);
        recommendPanel.setBackground(new Color(30,41,59));
        recommendPanel.setBorder(BorderFactory.createLineBorder(new Color(51,65,85),1));
        card.add(recommendPanel);

        JLabel recommendTitle = new JLabel("Recommended Movies");
        recommendTitle.setBounds(15,10,200,20);
        recommendTitle.setForeground(Color.WHITE);
        recommendTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        recommendPanel.add(recommendTitle);

        JLabel moviesList = new JLabel("Jawan | Leo | Animal");
        moviesList.setBounds(15,35,250,20);
        moviesList.setForeground(new Color(56,189,248));
        moviesList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        recommendPanel.add(moviesList);

        book.addActionListener(e -> {
            new SeatLayout(
                    user,
                    movieBox.getSelectedItem().toString(),
                    timeBox.getSelectedItem().toString()
            );
            dispose();
        });

        cancel.addActionListener(e -> new CancelTicket());

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void loadBookings(String user){
        try{
            File file = new File("booking.txt");
            if(file.exists()){
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while((line = br.readLine()) != null){
                    if(line.contains(user)){
                        bookingArea.append(line+"\n");
                    }
                }
                br.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}