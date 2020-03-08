import java.util.Arrays;

public class Util {

    private static int letterToIndex(char letter) {
        return -1; // TODO delete this line for Question 1a.
    }

    private static int numberToIndex(char number) {
        return -1; // TODO: delete this line for Question 1b.
    }

    public static Coordinate parseCoordinate(String s) {
        return null; // TODO: delete this line for Question 1c.
    }

    public static Piece hideShip(Piece piece) {
        return null; // TODO: delete this line for Question 1d.
    }

    public static void hideShips(Piece[][] grid) {
        // TODO: Question 1e.
    }

    public static Piece[][] deepClone(Piece[][] input) {
        Piece[][] output = new Piece[input.length][];
        for (int i = 0; i < input.length; i++) {
            output[i] = Arrays.copyOf(input[i], input[i].length);
        }
        return output;
    }
}
