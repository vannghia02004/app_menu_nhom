package cong_tru_nhanh_chia;

/**
 *
 * @author Tuyen
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiemTraChiaHetGUI extends JFrame implements ActionListener {

    private JTextField txtA, txtB;
    private JLabel lblA, lblB, lblKetQua;
    private JButton btnKiemTra;

    public KiemTraChiaHetGUI() {
        setTitle("Kiểm tra chia hết");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        lblA = new JLabel("Nhập số a:");
        txtA = new JTextField(10);
        lblB = new JLabel("Nhập số b:");
        txtB = new JTextField(10);
        btnKiemTra = new JButton("Kiểm tra");
        lblKetQua = new JLabel("Kết quả:");

        btnKiemTra.addActionListener(this);

        add(lblA);
        add(txtA);
        add(lblB);
        add(txtB);
        add(btnKiemTra);
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
                    lblKetQua.setText("Lỗi: Số b không được là 0.");
                } else if (a % b == 0) {
                    lblKetQua.setText(a + " chia hết cho " + b + ".");
                } else {
                    lblKetQua.setText(a + " không chia hết cho " + b + ".");
                }
            } catch (NumberFormatException ex) {
                lblKetQua.setText("Lỗi: Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KiemTraChiaHetGUI::new);
    }
}
