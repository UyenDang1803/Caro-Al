import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaroBoard extends JPanel {
    private boolean isPlayerX = true; // Biến để kiểm tra lượt của người chơi X
    private JButton[][] buttons; // Mảng lưu trữ các button
    private int currentSize = 5; // Kích thước hiện tại của bàn cờ
    private JFrame parentFrame; // Tham chiếu đến JFrame cha

    public CaroBoard(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        String[] sizes = {"5x5", "7x7", "11x11"};
        JComboBox<String> sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSize = (String) sizeComboBox.getSelectedItem();
                int size = Integer.parseInt(selectedSize.substring(0, selectedSize.indexOf('x')));
                currentSize = size;
                changeBoardSize(size);
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(sizeComboBox, BorderLayout.WEST);

        JButton resetButton = new JButton("Quay lại");
        resetButton.setBackground(new Color(128, 0, 128)); // Đặt màu nền là màu tím
        resetButton.setForeground(Color.WHITE); // Đặt màu chữ là màu trắng
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.getContentPane().removeAll();
                GameBackground gameBackground = new GameBackground(parentFrame);
                parentFrame.setContentPane(gameBackground);
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });
        topPanel.add(resetButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel();
        boardPanel.setBackground(Color.PINK); // Thiết lập màu nền cho bàn cờ là màu hồng
        add(boardPanel, BorderLayout.CENTER);

        drawBoard(boardPanel, 5); // Vẽ bàn cờ mặc định là 5x5
    }

    private void changeBoardSize(int size) {
        JPanel boardPanel = (JPanel) getComponent(1); // Lấy panel chứa bàn cờ

        // Xóa bàn cờ hiện tại và vẽ lại bàn cờ mới
        drawBoard(boardPanel, size);

        // Cập nhật lại giao diện
        revalidate();
        repaint();
    }

    private void resetBoard() {
        for (int i = 0; i < currentSize; i++) {
            for (int j = 0; j < currentSize; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        isPlayerX = true; // Reset lượt về cho người chơi X
    }

    private void drawBoard(JPanel boardPanel, int size) {
        Color boardColor;
        if (size == 5) {
            boardColor = new Color(30, 144, 255); // Màu xanh nước biển
        } else if (size == 7) {
            boardColor = Color.PINK; // Màu hồng
        } else {
            boardColor = Color.GREEN; // Màu xanh lá cây
        }

        boardPanel.removeAll();
        boardPanel.setLayout(new GridLayout(size, size));

        int caroCellSize = 15; // Kích thước của ô Caro

        buttons = new JButton[size][size]; // Mảng lưu trữ các button

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(caroCellSize, caroCellSize)); // Sử dụng kích thước của ô Caro cho các button
                int row = i, col = j; // Lưu lại vị trí hàng và cột của button
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = (JButton) e.getSource();
                        if (clickedButton.getText().isEmpty()) {
                            if (isPlayerX) {
                                clickedButton.setText("X"); // Đánh dấu ô bằng "X"
                                clickedButton.setForeground(Color.BLUE); // Thiết lập màu chữ cho X là màu xanh
                            } else {
                                clickedButton.setText("O"); // Đánh dấu ô bằng "O"
                                clickedButton.setForeground(Color.RED); // Thiết lập màu chữ cho O là màu đỏ
                            }
                            isPlayerX = !isPlayerX; // Đổi lượt cho người chơi tiếp theo
                            if (checkWin(buttons, row, col, size)) {
                                String winner = isPlayerX ? "O" : "X";
                                JOptionPane.showMessageDialog(null, "Người chơi " + winner + " chiến thắng!");
                                // Thực hiện các hành động sau khi có người chiến thắng
                                resetBoard(); // Làm sạch bàn cờ
                            }
                        }
                    }
                });
                buttons[i][j] = button; // Thêm button vào mảng
                boardPanel.add(button);
            }
        }

        boardPanel.setBackground(boardColor); // Thiết lập màu nền cho bàn cờ
        boardPanel.revalidate();
        boardPanel.repaint();
    }

    private boolean checkWin(JButton[][] buttons, int row, int col, int size) {
        String symbol = buttons[row][col].getText();

        // Kiểm tra hàng ngang
        int count = 1;
        for (int i = col - 1; i >= 0 && buttons[row][i].getText().equals(symbol); i--) count++;
        for (int i = col + 1; i < size && buttons[row][i].getText().equals(symbol); i++) count++;
        if (count >= 5) return true;

        // Kiểm tra hàng dọc
        count = 1;
        for (int i = row - 1; i >= 0 && buttons[i][col].getText().equals(symbol); i--) count++;
        for (int i = row + 1; i < size && buttons[i][col].getText().equals(symbol); i++) count++;
        if (count >= 5) return true;

        // Kiểm tra đường chéo chính (\)
        count = 1;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 && buttons[i][j].getText().equals(symbol); i--, j--) count++;
        for (int i = row + 1, j = col + 1; i < size && j < size && buttons[i][j].getText().equals(symbol); i++, j++) count++;
        if (count >= 5) return true;

        // Kiểm tra đường chéo phụ (/)
        count = 1;
        for (int i = row - 1, j = col + 1; i >= 0 && j < size && buttons[i][j].getText().equals(symbol); i--, j++) count++;
        for (int i = row + 1, j = col - 1; i < size && j >= 0 && buttons[i][j].getText().equals(symbol); i++, j--) count++;
        return count >= 5;
    }
}
