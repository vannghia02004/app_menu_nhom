package cong_tru_nhanh_chia;
/**
 *
 * @author Tuyen
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TinhDienTichHinhTronGUI extends JFrame implements ActionListener {

    private final JTextField txtBanKinh;
    private final JLabel lblBanKinh;
    private final JLabel lblKetQua;
    private final JButton btnTinh;
    private final JButton btnQuayLai;
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 14);

    public TinhDienTichHinhTronGUI() {
        setTitle("Tính Diện Tích Hình Tròn");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Set font for all components
        lblBanKinh = new JLabel("Nhập bán kính (r):");
        lblBanKinh.setFont(DEFAULT_FONT);
        txtBanKinh = new JTextField(10);
        txtBanKinh.setFont(DEFAULT_FONT);
        btnTinh = new JButton("Tính Diện Tích");
        btnTinh.setFont(DEFAULT_FONT);
        btnQuayLai = new JButton("Quay lại");
        btnQuayLai.setFont(DEFAULT_FONT);
        lblKetQua = new JLabel("Diện tích:");
        lblKetQua.setFont(DEFAULT_FONT);

        btnTinh.addActionListener(this);
        btnQuayLai.addActionListener(this);

        // Add window close listener
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                    TinhDienTichHinhTronGUI.this,
                    "Bạn có chắc muốn thoát?",
                    "Xác nhận thoát",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                if (choice == JOptionPane.YES_OPTION) {
                    dispose();
                    new MainMenu().setVisible(true);
                }
            }
        });

        add(lblBanKinh);
        add(txtBanKinh);
        add(btnTinh);
        add(btnQuayLai);
        add(lblKetQua);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTinh) {
            try {
                double banKinh = Double.parseDouble(txtBanKinh.getText());
                if (banKinh < 0) {
                    lblKetQua.setText("Cảnh báo: Bán kính không được âm!");
                    return;
                }
                double dienTich = Math.PI * banKinh * banKinh;
                lblKetQua.setText("Diện tích: " + String.format("%.2f", dienTich));
            } catch (NumberFormatException ex) {
                lblKetQua.setText("Lỗi: Vui lòng nhập số hợp lệ.");
            }
        } else if (e.getSource() == btnQuayLai) {
            dispose();
            new MainMenu().setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TinhDienTichHinhTronGUI::new);
    }
}
