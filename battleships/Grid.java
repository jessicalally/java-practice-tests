public class Grid {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private final Piece[][] grid = new Piece[HEIGHT][WIDTH];

    public Grid() {
        // TODO: Question 2a.
    }

    public boolean canPlace(Coordinate c, int size, boolean isDown) {
        return false; // TODO: delete this line for Question 2b.
    }

    public void placeShip(Coordinate c, int size, boolean isDown) {
        // TODO: Question 2c.
    }

    public boolean wouldAttackSucceed(Coordinate c) {
        return false; // TODO: delete this line for Question 3a.
    }

    public void attackCell(Coordinate c) {
        // TODO: Question 3b.
    }

    public boolean areAllSunk() {
        return false; // TODO: delete this line for Question 3c.
    }

    public String toPlayerString() {
        return null; // TODO: delete this line for Question 4.
    }

    @Override
    public String toString() {
        return renderGrid(grid);
    }

    private static String renderGrid(Piece[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 0123456789\n");
        for (int i = 0; i < grid.length; i++) {
            sb.append((char) ('A' + i));
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) {
                    return "!";
                }
                switch (grid[i][j]) {
                case SHIP:
                    sb.append('#');
                    break;
                case DAMAGED_SHIP:
                    sb.append('*');
                    break;
                case MISS:
                    sb.append('o');
                    break;
                case WATER:
                    sb.append('.');
                    break;
                }

            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
