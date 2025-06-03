import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class NetworkInfoApp {
    private JFrame frame;
    private JLabel infoLabel;
    private String userName;

    public NetworkInfoApp(String name) {
        this.userName = name;

        // Create the main window
        frame = new JFrame("Welcome " + userName);
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        infoLabel = new JLabel();
        infoLabel.setPreferredSize(new Dimension(350, 60));
        infoLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JButton showButton = new JButton("Show Network");
        JButton closeButton = new JButton("Close Network");
        JButton logoutButton = new JButton("Logout");

        // Action for Show Network button
        showButton.addActionListener(e -> {
            try {
                InetAddress localHost = InetAddress.getLocalHost();
                String info = "Local IP: " + localHost.getHostAddress() +
                              " / " + localHost.getHostName();
                infoLabel.setText(info);
            } catch (Exception ex) {
                infoLabel.setText("Network Error");
            }
        });

        // Action for Close Network button
        closeButton.addActionListener(e -> infoLabel.setText(""));

        // Logout / Exit button
        logoutButton.addActionListener(e -> System.exit(0));

        // Add components to frame
        frame.add(infoLabel);
        frame.add(showButton);
        frame.add(closeButton);
        frame.add(logoutButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your last name:");
        if (name != null && !name.trim().isEmpty()) {
            new NetworkInfoApp(name);
        }
    }
}
