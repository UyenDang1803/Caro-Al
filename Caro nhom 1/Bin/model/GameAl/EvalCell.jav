public class EvalCell {
    private Cell cell;
    private int value;

    public EvalCell(Cell cell, int value) {
        this.cell = cell;
        this.value = value;
    }

    public Cell getCell() {
        return cell;
    }

    public int getValue() {
        return value;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
