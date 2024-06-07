import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private boolean isPlayerX = true; // Biến để kiểm tra lượt của người chơi X

    public MainFrame() {
        setTitle("Game Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel chứa các nút điều hướng
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton playNowButton = new JButton("Chơi Ngay");
        JButton loginButton = new JButton("Đăng Nhập");

        // Thêm sự kiện cho nút "Chơi Ngay"
        playNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mở màn hình đăng nhập
                openLoginScreen();
            }
        });

        // Thêm sự kiện cho nút "Đăng Nhập"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mở màn hình đăng nhập
                openLoginScreen();
            }
        });

        panel.add(playNowButton);
        panel.add(loginButton);

        add(panel);
    }

    // Mở màn hình đăng nhập
    private void openLoginScreen() {
        DangNhapCaro loginFrame = new DangNhapCaro();
        loginFrame.setVisible(true);
        this.setVisible(false); // Ẩn màn hình hiện tại
    }

    // Hàm này được gọi sau khi đăng nhập thành công
    public void loginSuccess() {
        JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
        this.setVisible(true); // Hiện lại màn hình chính
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
