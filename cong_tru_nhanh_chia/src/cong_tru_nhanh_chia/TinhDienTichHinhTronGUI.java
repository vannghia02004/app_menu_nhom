package cong_tru_nhanh_chia;
/**
 *
 * @author Tuyen
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TinhDienTichHinhTronGUI extends JFrame implements ActionListener {

    private final JTextField txtBanKinh;
    private final JLabel lblBanKinh;
    private final JLabel lblKetQua;
    private final JButton btnTinh;

    public TinhDienTichHinhTronGUI() {
        setTitle("Tính Diện Tích Hình Tròn");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        lblBanKinh = new JLabel("Nhập bán kính (r):");
        txtBanKinh = new JTextField(10);
        btnTinh = new JButton("Tính Diện Tích");
        lblKetQua = new JLabel("Diện tích:");

        btnTinh.addActionListener(this);

        add(lblBanKinh);
        add(txtBanKinh);
        add(btnTinh);
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
                lblKetQua.setText("Diện tích: " + String.format("%.2f", dienTich)); // Định dạng hiển thị 2 chữ số thập phân
            } catch (NumberFormatException ex) {
                lblKetQua.setText("Lỗi: Vui lòng nhập số hợp lệ.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TinhDienTichHinhTronGUI::new);
    }
}
