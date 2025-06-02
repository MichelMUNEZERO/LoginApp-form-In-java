import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LoginApp extends JFrame {
    JLabel userLabel, passLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginButton, closeButton;

    public LoginApp() {
        setTitle("Login Window");
        setLayout(new GridLayout(3, 2, 10, 10));

        // Components
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");

        userField = new JTextField(15);
        passField = new JPasswordField(15);

        loginButton = new JButton("Login");
        closeButton = new JButton("Close");

        // Add components
        add(userLabel); add(userField);
        add(passLabel); add(passField);
        add(loginButton); add(closeButton);

        // Set frame properties
        setSize(400, 200);
        setLocationRelativeTo(null); // center window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Button actions
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkCredentials();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // close application
            }
        });
    }

    public void checkCredentials() {
        String username = userField.getText().trim();
        String password = new String(passField.getPassword()).trim();

        try {
            // File paths
            File userFile = new File("C:\\Desktop\\JavaExam\\username.txt");
            File passFile = new File("C:\\Desktop\\JavaExam\\password.txt");

            Scanner userScanner = new Scanner(userFile);
            Scanner passScanner = new Scanner(passFile);

            boolean matchFound = false;

            while (userScanner.hasNextLine() && passScanner.hasNextLine()) {
                String userLine = userScanner.nextLine().trim();
                String passLine = passScanner.nextLine().trim();

                if (username.equals(userLine) && password.equals(passLine)) {
                    matchFound = true;
                    break;
                }
            }

            userScanner.close();
            passScanner.close();

            if (matchFound) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Login failed! Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "File error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new LoginApp();
    }
}
