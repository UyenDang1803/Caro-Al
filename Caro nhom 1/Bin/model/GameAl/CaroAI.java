package model.GameAl;

public class CaroAI {
    private int[][] board;
    private int size;
    private int depth;
    private int nextX, nextY;

    public CaroAI(int depth) {
        this.depth = depth;
    }

    public void initialize(int size) {
        this.size = size;
        board = new int[size][size];
    }

    public void update(int x, int y, int player) {
        board[x][y] = player;
    }

    public boolean isClickable(int x, int y) {
        return board[x][y] == 0;
    }

    public int getNextX() {
        return nextX;
    }

    public int getNextY() {
        return nextY;
    }

    public boolean checkWinner(int player) {
        // Kiểm tra hàng ngang
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 4; j++) {
                if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player && board[i][j + 3] == player && board[i][j + 4] == player) {
                    return true;
                }
            }
        }
        // Kiểm tra hàng dọc
        for (int i = 0; i < size - 4; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player && board[i + 3][j] == player && board[i + 4][j] == player) {
                    return true;
                }
            }
        }
        // Kiểm tra đường chéo từ trái sang phải
        for (int i = 0; i < size - 4; i++) {
            for (int j = 0; j < size - 4; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player && board[i + 4][j + 4] == player) {
                    return true;
                }
            }
        }
        // Kiểm tra đường chéo từ phải sang trái
        for (int i = 0; i < size - 4; i++) {
            for (int j = 4; j < size; j++) {
                if (board[i][j] == player && board[i + 1][j - 1] == player && board[i + 2][j - 2] == player && board[i + 3][j - 3] == player && board[i + 4][j - 4] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isOver() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void nextStep() {
        minimax(depth, Integer.MIN_VALUE, Integer.MAX_VALUE, 2);
        update(nextX, nextY, 2);
    }

    private int minimax(int depth, int alpha, int beta, int player) {
        if (checkWinner(1)) return -1000;
        if (checkWinner(2)) return 1000;
        if (isOver()) return 0;
        if (depth == 0) return evaluate();

        if (player == 2) {
            int maxEval = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = player;
                        int eval = minimax(depth - 1, alpha, beta, 1);
                        board[i][j] = 0;
                        if (eval > maxEval) {
                            maxEval = eval;
                            if (depth == this.depth) {
                                nextX = i;
                                nextY = j;
                            }
                        }
                        alpha = Math.max(alpha, eval);
                        if (beta <= alpha) return maxEval;
                    }
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = player;
                        int eval = minimax(depth - 1, alpha, beta, 2);
                        board[i][j] = 0;
                        if (eval < minEval) {
                            minEval = eval;
                        }
                        beta = Math.min(beta, eval);
                        if (beta <= alpha) return minEval;
                    }
                }
            }
            return minEval;
        }
    }

    private int evaluate() {
        int score = 0;
        // Đánh giá điểm số cho các hàng ngang, hàng dọc và đường chéo
        // (Chưa triển khai chi tiết. Bạn cần triển khai logic đánh giá riêng)
        return score;
    }
}
