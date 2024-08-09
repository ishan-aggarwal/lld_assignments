package others;

public class Grid {
    private boolean[][] bombGrid;
    private int[][] countGrid;
    private int numRows;
    private int numColumns;
    private int numBombs;

    // Default constructor
    public Grid() {
        this(10, 10, 25); // Default to 10x10 grid with 25 bombs
    }

    // Overloaded constructor with rows and columns
    public Grid(int rows, int columns) {
        this(rows, columns, 25); // Default to 25 bombs
    }

    // Overloaded constructor with rows, columns, and number of bombs
    public Grid(int rows, int columns, int numBombs) {
        this.numRows = rows;
        this.numColumns = columns;
        this.numBombs = numBombs;
        this.bombGrid = new boolean[numRows][numColumns];
        this.countGrid = new int[numRows][numColumns];
        createBombGrid();
        createCountGrid();
    }

    // Getters for numRows, numColumns, and numBombs
    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumBombs() {
        return numBombs;
    }

    // Method to return a copy of bombGrid
    public boolean[][] getBombGrid() {
        boolean[][] copy = new boolean[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                copy[i][j] = bombGrid[i][j];
            }
        }
        return copy;
    }

    // Method to return a copy of countGrid
    public int[][] getCountGrid() {
        int[][] copy = new int[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                copy[i][j] = countGrid[i][j];
            }
        }
        return copy;
    }

    // Method to check if there's a bomb at a specific location
    public boolean isBombAtLocation(int row, int column) {
        return bombGrid[row][column];
    }

    // Method to get the count of bombs around a specific location
    public int getCountAtLocation(int row, int column) {
        return countGrid[row][column];
    }

    private void createBombGrid() {
        int bombsPlaced = 0;
        while (bombsPlaced < numBombs) {
            int row = (int) (Math.random() * numRows);
            int col = (int) (Math.random() * numColumns);

            if (!bombGrid[row][col]) { // Only place a bomb if there's not already one there
                bombGrid[row][col] = true;
                bombsPlaced++;
            }
        }
    }

    private void createCountGrid() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                countGrid[i][j] = calculateBombCount(i, j);
            }
        }
    }
    private int calculateBombCount(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < numRows && j >= 0 && j < numColumns && bombGrid[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

}
