public class Grid {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private final Piece[][] grid = new Piece[HEIGHT][WIDTH];

    public Grid() {
        for (int i = 0; i < WIDTH; i++){
            for (int j = 0; j < HEIGHT; j++){
                grid[i][j] = Piece.WATER;
            }
        }
    }

    public boolean canPlace(Coordinate c, int size, boolean isDown) {
        boolean canPlace = true;
        int row = c.getRow();
        int column = c.getColumn();
        if (isDown){
            for (int i = 0; i < size; i++){
                canPlace &= grid[row][column + i].equals(Piece.WATER);
            }
        } else {
            for (int i = 0; i < size; i++){
                canPlace &= grid[row + i][column].equals(Piece.WATER);
            }
        }
        return canPlace;
    }

    public void placeShip(Coordinate c, int size, boolean isDown) {
        assert (canPlace(c, size, isDown));
        int row = c.getRow();
        int column = c.getColumn();
        if (isDown){
            for (int i = 0; i < size; i++){
                grid[row + i][column] = Piece.SHIP;
            }
        } else {
            for (int i = 0; i < size; i++){
                grid[row][column + i] = Piece.SHIP;
            }
        }
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
