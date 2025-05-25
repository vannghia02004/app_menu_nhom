package cong_tru_nhanh_chia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 14);
    
    public MainMenu() {
        setTitle("Chọn chức năng");
        setSize(400, 500);  // Reduced size for better fit on smaller screens
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create a panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Make buttons more responsive
        JButton btnBac1Bac2 = new JButton("Thực hiện phép trừ hai số");
        JButton btnCongTruNhanhChia = new JButton("Thực hiện phép cộng hai số");
        JButton btnUCLN_BCNN = new JButton("Kiểm tra chia hết");
        JButton btnTinhDienTichHinhTron = new JButton("Tính diện tích hình tròn");
        JButton btnTinhThanhTien = new JButton("Tính thành tiền");
        JButton btnRectangleArea = new JButton("Tính diện tích hình chữ nhật");

        // Set font for all buttons
        btnBac1Bac2.setFont(DEFAULT_FONT);
        btnCongTruNhanhChia.setFont(DEFAULT_FONT);
        btnUCLN_BCNN.setFont(DEFAULT_FONT);
        btnTinhDienTichHinhTron.setFont(DEFAULT_FONT);
        btnTinhThanhTien.setFont(DEFAULT_FONT);
        btnRectangleArea.setFont(DEFAULT_FONT);

        // Set preferred size for buttons
        Dimension buttonSize = new Dimension(300, 50);
        btnBac1Bac2.setPreferredSize(buttonSize);
        btnCongTruNhanhChia.setPreferredSize(buttonSize);
        btnUCLN_BCNN.setPreferredSize(buttonSize);
        btnTinhDienTichHinhTron.setPreferredSize(buttonSize);
        btnTinhThanhTien.setPreferredSize(buttonSize);
        btnRectangleArea.setPreferredSize(buttonSize);

        // Add window close listener
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                    MainMenu.this,
                    "Bạn có chắc muốn thoát chương trình?",
                    "Xác nhận thoát",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

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

        mainPanel.add(btnBac1Bac2);
        mainPanel.add(btnCongTruNhanhChia);
        mainPanel.add(btnUCLN_BCNN);
        mainPanel.add(btnTinhDienTichHinhTron);
        mainPanel.add(btnTinhThanhTien);
        mainPanel.add(btnRectangleArea);
        
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
