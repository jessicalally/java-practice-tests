import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Grid grid = makeInitialGrid();
        int numAttempts = 0;

        while (!grid.areAllSunk()){
            System.out.println(grid.toPlayerString());
            System.out.println("Enter an attack: ");
            Coordinate attack = Util.parseCoordinate(input.nextLine());
            if (grid.wouldAttackSucceed(attack)){
                System.out.println("Direct Hit!");
            }
            grid.attackCell(attack);
            numAttempts++;
        }
        System.out.println("You took " + numAttempts + " attempts to sink all the ships!");
        System.out.println(grid.toPlayerString());
    }

    private static Grid makeInitialGrid() {
        Grid grid = new Grid();

        String[] coords = { "A7", "B1", "B4", "D3", "F7", "H1", "H4" };
        int[] sizes = { 2, 4, 1, 3, 1, 2, 5 };
        boolean[] isDowns = { false, true, true, false, false, true, false };

        for (int i = 0; i < coords.length; i++) {
            Coordinate c = Util.parseCoordinate(coords[i]);
            grid.placeShip(c, sizes[i], isDowns[i]);
        }

        return grid;
    }
}
