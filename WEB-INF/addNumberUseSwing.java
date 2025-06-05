import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class addNumberUseSwing {
    public static void main(String[] args){
    JFrame frame = new JFrame("Add twi number by using swing");
    frame.setSize(400,250);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(4,2));
    JTextField num1 = new JTextField();
    JTextField num2 = new JTextField();
    JTextField result = new JTextField();
    result.setEditable(false);
    JButton addButton = new JButton();
    JButton clearButton = new JButton();

    addButton.addActionListener(e->{
        try{
            int a = Integer.parseInt(num1.getText());
            int b = Integer.parseInt(num2.getText());
            result.setText(String.valueOf(a+b));
        }
        catch(NumberFormatException ex){
            result.setText("Invalid Input");
        }
    });
    clearButton.addActionListener(e->{
        num1.setText("");
        num2.setText("");
        result.setText("");
    });
    frame.add(new JLabel("Number 1:"));
    frame.add(num1);
    frame.add(new JLabel("Number 2:"));
    frame.add(num2);
    frame.add(new JLabel("Result :"));
    frame.add(result);
    frame.add(addButton);
    frame.add(clearButton);
    frame.setVisible(true);
    
}
}