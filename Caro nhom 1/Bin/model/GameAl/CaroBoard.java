package model.GameAl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaroBoard extends JPanel {
    private boolean isPlayerX = true; // Check if it's player X's turn
    private JButton[][] buttons; // Buttons array
    private int currentSize = 5; // Current board size
    private JFrame parentFrame; // Reference to the parent JFrame
    private CaroAI caroAI; // AI for the Caro game

    public CaroBoard(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.caroAI = new CaroAI(5); // Initialize AI with desired depth
        setLayout(new BorderLayout());

        String[] sizes = {"5x5", "7x7", "11x11"};
        JComboBox<String> sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSize = (String) sizeComboBox.getSelectedItem();
                int size = Integer.parseInt(selectedSize.substring(0, selectedSize.indexOf('x')));
                currentSize = size;
                initializeBoard(size);
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(new Color(128, 0, 128)); // Set background color to purple
        resetButton.setForeground(Color.WHITE); // Set text color to white
    
        
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBoard();
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select board size:"));
        topPanel.add(sizeComboBox);
        topPanel.add(resetButton);

        add(topPanel, BorderLayout.NORTH);
        initializeBoard(currentSize);
    }

    private void initializeBoard(int size) {
        caroAI.initialize(size); // Reinitialize AI for new board size
        buttons = new JButton[size][size];
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(size, size));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
                buttons[i][j].setFocusPainted(false);
                final int x = i;
                final int y = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (buttons[x][y].getText().equals("") && caroAI.isClickable(x, y)) {
                            buttons[x][y].setText("X");
                            caroAI.update(x, y, 1);

                            if (caroAI.checkWinner(1)) {
                                JOptionPane.showMessageDialog(parentFrame, "Player X wins!");
                                resetBoard();
                            } else if (caroAI.isOver()) {
                                JOptionPane.showMessageDialog(parentFrame, "Hòa!");
                                resetBoard();
                            } else {
                                // AI Move
                                caroAI.nextStep();
                                buttons[caroAI.getNextX()][caroAI.getNextY()].setText("O");
                                caroAI.update(caroAI.getNextX(), caroAI.getNextY(), 2);

                                if (caroAI.checkWinner(2)) {
                                    JOptionPane.showMessageDialog(parentFrame, "Player O wins!");
                                    resetBoard();
                                } else if (caroAI.isOver()) {
                                    JOptionPane.showMessageDialog(parentFrame, "Hòa!");
                                    resetBoard();
                                }
                            }
                        }
                    }
                });
                boardPanel.add(buttons[i][j]);
            }
        }

        removeAll();
        add(boardPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void resetBoard() {
        isPlayerX = true;
        initializeBoard(currentSize);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Caro Nhóm 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new CaroBoard(frame));
        frame.setVisible(true);
    }
}
