import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DangKy extends JFrame implements ActionListener {

    private JTextField hoTen;
    private JTextField tenDangNhap;
    private JPasswordField matKhau;
    private JPasswordField xacNhanMatKhau;
    private JTextField hocTai;
    private JButton btnDangKy;
    private JLabel lblThongBao;

    public DangKy() {
        setTitle("Đăng ký Cờ Caro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.PINK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        Font font = new Font("Comic Sans MS", Font.BOLD, 30);
        JLabel lblTitle = new JLabel("Đăng ký Cờ Caro", SwingConstants.CENTER);
        lblTitle.setFont(font);
        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.gridx = 0;
        gbcTitle.gridy = 0;
        gbcTitle.gridwidth = 2;
        gbcTitle.insets = new Insets(20, 0, 20, 0);
        panel.add(lblTitle, gbcTitle);

        hoTen = new JTextField();
        hoTen.setColumns(30);
        tenDangNhap = new JTextField();
        tenDangNhap.setColumns(30);
        matKhau = new JPasswordField();
        matKhau.setColumns(30);
        xacNhanMatKhau = new JPasswordField();
        xacNhanMatKhau.setColumns(30);
        hocTai = new JTextField();
        hocTai.setColumns(30);
        btnDangKy = new JButton("Đăng ký");
        lblThongBao = new JLabel();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        panel.add(new JLabel("Họ và tên:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(hoTen, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Tên đăng nhập:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(tenDangNhap, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Mật khẩu:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(matKhau, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Xác nhận mật khẩu:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(xacNhanMatKhau, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Học tại:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(hocTai, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnDangKy, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(lblThongBao, gbc);

        btnDangKy.addActionListener(this);

        // Thêm nút "Quay lại" và xử lý sự kiện trong constructor của lớp DangKy
        JButton btnQuayLai = new JButton("Quay lại");
        gbc.gridx = 0;
        gbc.gridy = 8; // Thay đổi vị trí y để không ghi đè lên lblThongBao
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnQuayLai, gbc);

        // Xử lý sự kiện quay lại màn hình đăng nhập
        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangNhapCaro dangNhapCaro = new DangNhapCaro();
                dangNhapCaro.setVisible(true);
                setVisible(false); // Ẩn màn hình đăng ký
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String hoTenText = hoTen.getText();
        String tenDangNhapText = tenDangNhap.getText();
        String matKhauText = String.valueOf(matKhau.getPassword());
        String xacNhanMatKhauText = String.valueOf(xacNhanMatKhau.getPassword());
        String hocTaiText = hocTai.getText();

        if (!hoTenText.isEmpty() && !tenDangNhapText.isEmpty() && !matKhauText.isEmpty() && !hocTaiText.isEmpty()) {
            if (matKhauText.equals(xacNhanMatKhauText)) {
                lblThongBao.setText("Đăng ký thành công!");
            } else {
                lblThongBao.setText("Mật khẩu không khớp!");
            }
        } else {
            lblThongBao.setText("Vui lòng điền đầy đủ thông tin!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DangKy().setVisible(true));
    }

    public AbstractButton getBtnQuayLai() {
        throw new UnsupportedOperationException("Unimplemented method 'getBtnQuayLai'");
    }
}
