package cong_tru_nhanh_chia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tcong2so extends JFrame {
    private JTextField firstNumberField, secondNumberField;
    private JButton addButton;
    private JTextArea resultArea;

    public tcong2so() {
        setTitle("Add Two Numbers");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        panel.add(new JLabel("First Number:"));
        firstNumberField = new JTextField();
        panel.add(firstNumberField);

        panel.add(new JLabel("Second Number:"));
        secondNumberField = new JTextField();
        panel.add(secondNumberField);

        addButton = new JButton("Add");
        panel.add(addButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        panel.add(new JScrollPane(resultArea));

        add(panel);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNumbers();
            }
        });
    }

    private void addNumbers() {
        try {
            double firstNumber = Double.parseDouble(firstNumberField.getText());
            double secondNumber = Double.parseDouble(secondNumberField.getText());
            double sum = firstNumber + secondNumber;
            resultArea.setText("Result: " + sum);
        } catch (NumberFormatException ex) {
            resultArea.setText("Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new tcong2so().setVisible(true));
    }
}