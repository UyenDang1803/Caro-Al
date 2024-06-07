import java.awt.*;
import javax.swing.*;

public class Background extends JPanel {
    private JButton playWithFriendButton;
    private JButton playWithAIButton;
    private JButton playOnlineButton;
    private JButton settingsButton;
    private JButton noticeButton;
    private JButton messageButton;
    private JFrame parentFrame;

    public void Background(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setPreferredSize(new Dimension(800, 600)); // Kích thước điều chỉnh
        setBackground(new Color(78, 52, 104)); // Màu nền tím đậm

        // Tạo label tiêu đề với nền gradient và chữ màu trắng
        JLabel titleLabel = new JLabel("Game Caro - Nhóm 1", JLabel.CENTER);
        titleLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 60));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(97, 67, 133)); // Nền gradient màu tím
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Thêm đệm

        // Tạo panel mới để chứa các nút và đám mây
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false); // Làm cho nền trong suốt

        // Tạo và thêm nút "Chơi với bạn"
        playWithFriendButton = new JButton("Chơi với bạn");
        customizeButton(playWithFriendButton); // Tùy chỉnh kiểu dáng

        // Tạo và thêm nút "Chơi với máy"
        playWithAIButton = new JButton("Chơi với máy");
        customizeButton(playWithAIButton); // Tùy chỉnh kiểu dáng

        // Tạo và thêm nút "Chơi qua mạng"
        playOnlineButton = new JButton("Chơi qua mạng");
        customizeButton(playOnlineButton); // Tùy chỉnh kiểu dáng

        // Cấu hình vị trí của các nút trong panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Khoảng cách giữa các nút
        gbc.anchor = GridBagConstraints.CENTER;

        // Thêm nút "Chơi với bạn" vào panel
        buttonPanel.add(playWithFriendButton, gbc);

        gbc.gridy = 1; // Di chuyển xuống hàng thứ hai
        buttonPanel.add(playWithAIButton, gbc); // Thêm nút "Chơi với máy" vào panel

        gbc.gridy = 2; // Di chuyển xuống hàng thứ ba
        buttonPanel.add(playOnlineButton, gbc); // Thêm nút "Chơi qua mạng" vào panel

        // Tạo panel mới để chứa các nút bên trái
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false); // Làm cho nền trong suốt
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10)); // Thêm đệm

        // Tạo và thêm nút "Setting"
        settingsButton = new JButton("Setting");
        customizeButtonWithIcon(settingsButton, "settings.png");
        leftPanel.add(settingsButton);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Thêm khoảng cách giữa các nút

        // Tạo và thêm nút "Notice"
        noticeButton = new JButton("Notice");
        customizeButtonWithIcon(noticeButton, "notice.png");
        leftPanel.add(noticeButton);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Thêm khoảng cách giữa các nút

        // Tạo và thêm nút "Message"
        messageButton = new JButton("Message");
        customizeButtonWithIcon(messageButton, "message.png");
        leftPanel.add(messageButton);

        // Sử dụng BorderLayout để sắp xếp các thành phần trong panel chính
        setLayout(new BorderLayout());

        // Thêm label tiêu đề vào panel
        add(titleLabel, BorderLayout.NORTH);

        // Thêm panel chứa các nút bên trái vào panel chính
        add(leftPanel, BorderLayout.WEST);

        // Thêm panel chứa nút vào panel chính và đặt vào giữa khung hình
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Tùy chỉnh kiểu dáng của nút button
    private void customizeButton(JButton button) {
        button.setPreferredSize(new Dimension(200, 50));
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(155, 89, 182)); // Màu tím của nút
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(232, 126, 4), 2), // Viền màu cam
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Thêm đệm
        ));
        button.setFocusPainted(false); // Loại bỏ viền khi focus
    }

    // Tùy chỉnh kiểu dáng của nút button kèm theo icon
    private void customizeButtonWithIcon(JButton button, String iconPath) {
        customizeButton(button);
        button.setIcon(new ImageIcon(iconPath)); // Đặt icon cho nút
    }

    // Vẽ đám mây
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Vẽ các đám mây
        drawCloud(g2d, 100, 300, 70);
        drawCloud(g2d, 300, 200, 80);
        drawCloud(g2d, 500, 300, 90);
        drawCloud(g2d, 200, 400, 70);
    }

    // Vẽ một đám mây
    private void drawCloud(Graphics2D g2d, int x, int y, int size) {
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y, size, size / 2);
        g2d.fillOval(x + size / 4, y - size / 4, size, size / 2);
        g2d.fillOval(x + size / 2, y, size, size / 2);
        g2d.fillOval(x + size, y - size / 4, size, size / 2);
        g2d.fillOval(x + size * 3 / 4, y, size, size / 2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(" Background");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            GameBackground gameBackground = new GameBackground(frame);
            frame.getContentPane().add(gameBackground);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
