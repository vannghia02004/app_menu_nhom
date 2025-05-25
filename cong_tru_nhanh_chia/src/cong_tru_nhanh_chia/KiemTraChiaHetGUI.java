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

public class KiemTraChiaHetGUI extends JFrame implements ActionListener {

    private JTextField txtA, txtB;
    private JLabel lblA, lblB, lblKetQua;
    private JButton btnKiemTra;
    private JButton btnQuayLai;
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 14);

    public KiemTraChiaHetGUI() {
        setTitle("Kiểm tra chia hết");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Set font for all components
        lblA = new JLabel("Nhập số a:");
        lblA.setFont(DEFAULT_FONT);
        txtA = new JTextField(10);
        txtA.setFont(DEFAULT_FONT);
        lblB = new JLabel("Nhập số b:");
        lblB.setFont(DEFAULT_FONT);
        txtB = new JTextField(10);
        txtB.setFont(DEFAULT_FONT);
        btnKiemTra = new JButton("Kiểm tra");
        btnKiemTra.setFont(DEFAULT_FONT);
        btnQuayLai = new JButton("Quay lại");
        btnQuayLai.setFont(DEFAULT_FONT);
        lblKetQua = new JLabel("Kết quả:");
        lblKetQua.setFont(DEFAULT_FONT);

        btnKiemTra.addActionListener(this);
        btnQuayLai.addActionListener(this);

        // Add window close listener
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                    KiemTraChiaHetGUI.this,
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

        add(lblA);
        add(txtA);
        add(lblB);
        add(txtB);
        add(btnKiemTra);
        add(btnQuayLai);
        add(lblKetQua);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnKiemTra) {
            try {
                int a = Integer.parseInt(txtA.getText());
                int b = Integer.parseInt(txtB.getText());

                if (b == 0) {
                    JOptionPane.showMessageDialog(this,
                        "Không thể chia cho 0!\nVui lòng nhập số b khác 0.",
                        "Lỗi chia cho 0",
                        JOptionPane.ERROR_MESSAGE);
                    lblKetQua.setText("Kết quả: Không thể chia cho 0");
                    txtB.requestFocus();
                    return;
                }

                if (a % b == 0) {
                    lblKetQua.setText(a + " chia hết cho " + b + ".");
                } else {
                    lblKetQua.setText(a + " không chia hết cho " + b + ".");
                }
            } catch (NumberFormatException ex) {
                lblKetQua.setText("Lỗi: Vui lòng nhập số nguyên hợp lệ.");
            }
        } else if (e.getSource() == btnQuayLai) {
            dispose();
            new MainMenu().setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KiemTraChiaHetGUI::new);
    }
}
