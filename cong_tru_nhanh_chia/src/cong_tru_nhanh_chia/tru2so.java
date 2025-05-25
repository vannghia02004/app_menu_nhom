package cong_tru_nhanh_chia;
import javax.swing.*;
import java.awt.event.*;

public class tru2so extends JFrame {
    private JTextField txtNumber1, txtNumber2, txtResult;
    private JButton btnSubtract;

    public tru2so() {
        setTitle("Phép trừ hai số");
        setSize(350, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNumber1 = new JLabel("Số thứ nhất:");
        lblNumber1.setBounds(20, 20, 80, 25);
        add(lblNumber1);

        txtNumber1 = new JTextField();
        txtNumber1.setBounds(110, 20, 200, 25);
        add(txtNumber1);

        JLabel lblNumber2 = new JLabel("Số thứ hai:");
        lblNumber2.setBounds(20, 55, 80, 25);
        add(lblNumber2);

        txtNumber2 = new JTextField();
        txtNumber2.setBounds(110, 55, 200, 25);
        add(txtNumber2);

        btnSubtract = new JButton("Trừ");
        btnSubtract.setBounds(110, 90, 80, 25);
        add(btnSubtract);

        JLabel lblResult = new JLabel("Kết quả:");
        lblResult.setBounds(20, 125, 80, 25);
        add(lblResult);

        txtResult = new JTextField();
        txtResult.setBounds(110, 125, 200, 25);
        txtResult.setEditable(false);
        add(txtResult);

        btnSubtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(txtNumber1.getText());
                    double num2 = Double.parseDouble(txtNumber2.getText());
                    double result = num1 - num2;
                    txtResult.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new tru2so().setVisible(true);
        });
    }
}