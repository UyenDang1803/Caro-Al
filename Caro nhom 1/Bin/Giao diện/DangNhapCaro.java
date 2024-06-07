import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DangNhapCaro extends JFrame implements ActionListener {

    private MainFrame parentFrame; // Thêm tham chiếu tới MainFrame
    private GameBackground gameBackground; // Thêm tham chiếu tới GameBackground
    private JTextField tenDangNhap;
    private JPasswordField matKhau;
    private JButton btnDangNhap;
    private JLabel lblThongBao;

    public DangNhapCaro() {
        this.parentFrame = parentFrame; // Lưu tham chiếu tới MainFrame
        this.gameBackground = gameBackground; // Lưu tham chiếu tới GameBackground
        setTitle("Đăng nhập Cờ Caro");
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
        JLabel lblTitle = new JLabel("Game Caro nhóm 1", SwingConstants.CENTER);
        lblTitle.setFont(font);
        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.gridx = 0;
        gbcTitle.gridy = 0;
        gbcTitle.gridwidth = 2;
        gbcTitle.insets = new Insets(20, 0, 20, 0);
        panel.add(lblTitle, gbcTitle);

        tenDangNhap = new JTextField();
        tenDangNhap.setColumns(30);
        matKhau = new JPasswordField();
        matKhau.setColumns(30);
        btnDangNhap = new JButton("Đăng nhập");
        lblThongBao = new JLabel();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        panel.add(new JLabel("Tên đăng nhập:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(tenDangNhap, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Mật khẩu:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(matKhau, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnDangNhap, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(lblThongBao, gbc);

        btnDangNhap.addActionListener(this);

        // Thêm nút "Đăng ký" và xử lý sự kiện trong constructor của lớp DangNhapCaro
        JButton btnDangKy = new JButton("Đăng ký");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnDangKy, gbc);

        // Xử lý sự kiện chuyển đến màn hình đăng ký
        btnDangKy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangKy dangKy = new DangKy();
                dangKy.setVisible(true);
                setVisible(false); // Ẩn màn hình đăng nhập
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tenDangNhapText = tenDangNhap.getText();
        String matKhauText = String.valueOf(matKhau.getPassword());

        // Xử lý logic đăng nhập (kiểm tra với database, v.v.)
        if (tenDangNhapText.equals("admin") && matKhauText.equals("123456")) {
            lblThongBao.setText("Đăng nhập thành công!");
            parentFrame.loginSuccess(); // Gọi phương thức loginSuccess() của MainFrame
            gameBackground.getBackground(); // Hiển thị lại GameBackground
            dispose(); // Đóng màn hình đăng nhập
        } else {
            lblThongBao.setText("Tên đăng nhập hoặc mật khẩu sai!");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DangNhapCaro().setVisible(true));
    }

    Object getBtnDangKy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
