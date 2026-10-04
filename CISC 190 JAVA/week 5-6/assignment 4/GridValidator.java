public class GridValidator {

    private static final int SIZE = 9;
    private static final int REGION_SIZE = 3;

    public static void main(String[] args) {
        // Part 1     change numbers to test
        int[][] grid = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println("Valid grid? " + isValidGrid(grid));
        System.out.println("Diagnosis: " + diagnose(grid));

        // Part 11
        System.out.println("\n--- Mutation tests ---");

        int[][] rowMutation = copyGrid(grid);
        rowMutation[0][1] = rowMutation[0][0];
        report("Row duplicate", !isRowValid(rowMutation, 0), diagnose(rowMutation));

        int[][] columnMutation = copyGrid(grid);
        columnMutation[1][0] = columnMutation[0][0];
        report("Column duplicate", !isColumnValid(columnMutation, 0), diagnose(columnMutation));

        int[][] regionMutation = copyGrid(grid);
        regionMutation[1][1] = regionMutation[0][0];
        report("Region duplicate", !isRegionValid(regionMutation, 0, 0), diagnose(regionMutation));

        int[][] rangeMutation = copyGrid(grid);
        rangeMutation[4][4] = 10;
        report("Out-of-range value", !valuesInRange(rangeMutation), diagnose(rangeMutation));
    }

    // Part 2
    public static boolean valuesInRange(int[][] grid) {
        return findInvalidValue(grid) == null;
    }


    public static int[] findInvalidValue(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] < 1 || grid[row][column] > 9) {
                    return new int[] {row, column};
                }
            }
        }
        return null;
    }


    private static boolean markValue(boolean[] seen, int value) {
        if (value < 1 || value > 9 || seen[value]) {
            return false;
        }
        seen[value] = true;
        return true;
    }

    // Part 3
    public static boolean isRowValid(int[][] grid, int row) {
        boolean[] seen = new boolean[10];
        for (int column = 0; column < SIZE; column++) {
            if (!markValue(seen, grid[row][column])) {
                return false;
            }
        }
        return true;
    }

    // Part 4
    public static boolean areRowsValid(int[][] grid) {
        for (int row = 0; row < SIZE; row++) {
            if (!isRowValid(grid, row)) {
                return false;
            }
        }
        return true;
    }

    // Part 5
    public static boolean isColumnValid(int[][] grid, int column) {
        boolean[] seen = new boolean[10];
        for (int row = 0; row < SIZE; row++) {
            if (!markValue(seen, grid[row][column])) {
                return false;
            }
        }
        return true;
    }

    // Part 6
    public static boolean areColumnsValid(int[][] grid) {
        for (int column = 0; column < SIZE; column++) {
            if (!isColumnValid(grid, column)) {
                return false;
            }
        }
        return true;
    }

    // Part 7
    public static boolean isRegionValid(int[][] grid, int startRow, int startColumn) {
        boolean[] seen = new boolean[10];
        for (int row = startRow; row < startRow + REGION_SIZE; row++) {
            for (int column = startColumn; column < startColumn + REGION_SIZE; column++) {
                if (!markValue(seen, grid[row][column])) {
                    return false;
                }
            }
        }
        return true;
    }

    // Part 8
    public static boolean areRegionsValid(int[][] grid) {
        for (int startRow = 0; startRow < SIZE; startRow += REGION_SIZE) {
            for (int startColumn = 0; startColumn < SIZE; startColumn += REGION_SIZE) {
                if (!isRegionValid(grid, startRow, startColumn)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Part 9
    public static boolean isValidGrid(int[][] grid) {
        return hasValidDimensions(grid)
                && valuesInRange(grid)
                && areRowsValid(grid)
                && areColumnsValid(grid)
                && areRegionsValid(grid);
    }

    public static boolean hasValidDimensions(int[][] grid) {
        if (grid == null || grid.length != SIZE) {
            return false;
        }
        for (int row = 0; row < grid.length; row++) {
            if (grid[row] == null || grid[row].length != SIZE) {
                return false;
            }
        }
        return true;
    }

    // Part 10
    public static String diagnose(int[][] grid) {
        if (!hasValidDimensions(grid)) {
            return "Invalid dimensions: grid must be 9x9";
        }
        int[] invalidValue = findInvalidValue(grid);
        if (invalidValue != null) {
            return "Invalid value at row " + invalidValue[0] + ", column " + invalidValue[1];
        }
        for (int row = 0; row < SIZE; row++) {
            if (!isRowValid(grid, row)) {
                return "Duplicate detected in row " + row;
            }
        }
        for (int column = 0; column < SIZE; column++) {
            if (!isColumnValid(grid, column)) {
                return "Duplicate detected in column " + column;
            }
        }
        for (int startRow = 0; startRow < SIZE; startRow += REGION_SIZE) {
            for (int startColumn = 0; startColumn < SIZE; startColumn += REGION_SIZE) {
                if (!isRegionValid(grid, startRow, startColumn)) {
                    return "Invalid 3x3 region beginning at row " + startRow
                            + ", column " + startColumn;
                }
            }
        }
        return "Grid is valid";
    }

    // Part 11
    public static int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[grid.length][];
        for (int row = 0; row < grid.length; row++) {
            copy[row] = grid[row].clone();
        }
        return copy;
    }

    public static void report(String testName, boolean detected, String diagnosis) {
        System.out.println(testName + ": " + (detected ? "DETECTED" : "MISSED") + " -> " + diagnosis);
    }
}