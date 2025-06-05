import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ClientExam extends JFrame {
    JTextField number1Field, number2Field;
    JComboBox<String> operatorBox;
    JLabel resultLabel;

    public ClientExam() {
        setTitle("Welcome Silas");
        setLayout(new FlowLayout());

        add(new JLabel("Number 1:"));
        number1Field = new JTextField(10);
        add(number1Field);

        add(new JLabel("Number 2:"));
        number2Field = new JTextField(10);
        add(number2Field);

        operatorBox = new JComboBox<>(new String[]{"+", "-", "*", "/", "%"});
        add(operatorBox);

        JButton sendButton = new JButton("Send Data");
        sendButton.addActionListener(e -> sendData());
        add(sendButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setForeground(Color.BLUE);
        add(resultLabel);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> logout());
        add(logoutButton);

        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void sendData() {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());
            String operator = (String) operatorBox.getSelectedItem();

            Socket socket = new Socket("172.16.10.10", 7655);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(num1);
            out.println(num2);
            out.println(operator);

            String response = in.readLine();
            resultLabel.setText(response);

            socket.close();
        } catch (Exception ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }

    private void logout() {
        dispose(); // Closes the current window
        JOptionPane.showMessageDialog(null, "Logged out. Returning to login window...");
        // Optionally: redirect to a Login window if needed
    }

    public static void main(String[] args) {
        new ClientExam();
    }
}
