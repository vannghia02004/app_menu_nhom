package cong_tru_nhanh_chia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectangleAreaCalculato extends JFrame implements ActionListener {
    private JTextField txtLength, txtWidth, txtResult;
    private JButton btnCalculate;

    public RectangleAreaCalculato() {
        setTitle("Tính Diện Tích Hình Chữ Nhật");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Canh giữa màn hình

        // Panel chứa các thành phần
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        // Các thành phần giao diện
        panel.add(new JLabel("Chiều dài:"));
        txtLength = new JTextField();
        panel.add(txtLength);

        panel.add(new JLabel("Chiều rộng:"));
        txtWidth = new JTextField();
        panel.add(txtWidth);

        panel.add(new JLabel("Diện tích:"));
        txtResult = new JTextField();
        txtResult.setEditable(false); // Không cho sửa
        panel.add(txtResult);

        btnCalculate = new JButton("Tính");
        btnCalculate.addActionListener(this);
        panel.add(btnCalculate);

        // Thêm panel vào frame
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double length = Double.parseDouble(txtLength.getText());
            double width = Double.parseDouble(txtWidth.getText());
            double area = length * width;
            txtResult.setText(String.valueOf(area));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RectangleAreaCalculato().setVisible(true);
        });
    }
}
