package nhapsodaydu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TinhThanhTien extends JFrame implements ActionListener {

    private final JTextField txtSoLuong;

    private final JTextField txtDonGia;
    private final JTextField txtThanhTien;
    private final JLabel lblSoLuong;
    private JLabel lblDonGia, lblThanhTien;
    private final JButton btnTinh;

    public TinhThanhTien() {
        setTitle("Tính Thành Tiền");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        lblSoLuong = new JLabel("Số lượng:");
        txtSoLuong = new JTextField(10);
        lblDonGia = new JLabel("Đơn giá:");
        txtDonGia = new JTextField(10);
        lblThanhTien = new JLabel("Thành tiền:");
        txtThanhTien = new JTextField(10);
        txtThanhTien.setEditable(false); // Không cho phép người dùng chỉnh sửa trường thành tiền
        btnTinh = new JButton("Tính Tiền");

        btnTinh.addActionListener(this);

        add(lblSoLuong);
        add(txtSoLuong);
        add(lblDonGia);
        add(txtDonGia);
        add(btnTinh);
        add(lblThanhTien);
        add(txtThanhTien);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTinh) {
            try {
                int soLuong = Integer.parseInt(txtSoLuong.getText());
                double donGia = Double.parseDouble(txtDonGia.getText());

                if (soLuong < 0 || donGia < 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng và đơn giá không được âm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double thanhTien = soLuong * donGia;
                txtThanhTien.setText(String.format("%.2f", thanhTien)); // Hiển thị thành tiền với 2 chữ số thập phân

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ cho số lượng và đơn giá.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtThanhTien.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TinhThanhTien::new);
    }
}