package model.GameAl;

public class State {
    private int[][] state;

    public State() {
        this.state = new int[11][11]; // Default size
    }

    public State(int[][] state) {
        this.state = state;
    }

    public int[][] getState() {
        return state;
    }

    public void update(int x, int y, int value) {
        state[x][y] = value;
    }

    public boolean checkWinner(int player) {
        // Implement logic to check for winner
        return false;
    }

    public boolean isClickable(int x, int y) {
        return state[x][y] == 0;
    }

    public boolean isOver() {
        // Implement logic to check if the game is over
        return false;
    }
}
