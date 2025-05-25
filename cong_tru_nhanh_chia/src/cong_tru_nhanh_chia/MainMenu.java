package cong_tru_nhanh_chia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Chọn chức năng");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 10, 10));

        JButton btnBac1Bac2 = new JButton("Thực hiện phép trừ hai số");
        JButton btnCongTruNhanhChia = new JButton("Thực hiện phép cộng hai số");
        JButton btnUCLN_BCNN = new JButton("Nhâp hai số (a và b). Kiểm tra a có chia hết cho b hay không");
        JButton btnTinhDienTichHinhTron = new JButton("Tính diện tích hình tròn");
        JButton btnTinhThanhTien = new JButton("Tính thành tiền");
        JButton btnRectangleArea = new JButton("Tính diện tích hình chữ nhật");

        btnBac1Bac2.addActionListener(e -> {
            try {
                new cong_tru_nhanh_chia.tru2so().setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lớp tru2so!");
            }
        });
        btnCongTruNhanhChia.addActionListener(e -> {
            try {
                new cong_tru_nhanh_chia.tcong2so().setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lớp tcong2so!");
            }
        });
        btnUCLN_BCNN.addActionListener(e -> {
            try {
                new cong_tru_nhanh_chia.KiemTraChiaHetGUI().setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lớp KiemTraChiaHetGUI!");
            }
        });
        btnTinhDienTichHinhTron.addActionListener(e -> {
            try {
                new TinhDienTichHinhTronGUI().setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lớp TinhDienTichHinhTronGUI!");
            }
        });
        btnTinhThanhTien.addActionListener(e -> {
            try {
                new nhapsodaydu.TinhThanhTien().setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lớp TinhThanhTien!");
            }
        });
        btnRectangleArea.addActionListener(e -> {
            try {
                new cong_tru_nhanh_chia.RectangleAreaCalculato().setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lớp RectangleAreaCalculator!");
            }
        });

        add(btnBac1Bac2);
        add(btnCongTruNhanhChia);
        add(btnUCLN_BCNN);
        add(btnTinhDienTichHinhTron);
        add(btnTinhThanhTien);
        add(btnRectangleArea);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
