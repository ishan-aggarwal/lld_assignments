package others;

public class Main {
    public static void main(String[] args) {
        // Create a Grid object with default settings (10x10 grid with 25 bombs)
        Grid grid = new Grid();

        // Retrieve and print the bombGrid
        boolean[][] bombGrid = grid.getBombGrid();
        System.out.println("Bomb Grid:");
        for (int i = 0; i < grid.getNumRows(); i++) {
            for (int j = 0; j < grid.getNumColumns(); j++) {
                System.out.print(bombGrid[i][j] ? "B " : ". ");
            }
            System.out.println();
        }

        // Retrieve and print the countGrid
        int[][] countGrid = grid.getCountGrid();
        System.out.println("\nCount Grid:");
        for (int i = 0; i < grid.getNumRows(); i++) {
            for (int j = 0; j < grid.getNumColumns(); j++) {
                System.out.print(countGrid[i][j] + " ");
            }
            System.out.println();
        }

        // Test the isBombAtLocation method
        int testRow = 3;
        int testCol = 4;
        System.out.println("\nIs there a bomb at location (" + testRow + "," + testCol + ")? " +
                           grid.isBombAtLocation(testRow, testCol));

        // Test the getCountAtLocation method
        System.out.println("Count of bombs around location (" + testRow + "," + testCol + "): " +
                           grid.getCountAtLocation(testRow, testCol));
    }
}
