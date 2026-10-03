import java.util.Scanner;

public class StoreSalesAnalyzer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Part 1:
        double[][] sales = new double[4][7];
        for (int row = 0; row < sales.length; row++) {
            for (int column = 0; column < sales[row].length; column++) {
                double value;
                do {
                    System.out.printf("Store %d, Day %d sales: ", row + 1, column + 1);
                    value = input.nextDouble();
                    if (value < 0) {
                        System.out.println("Sales cannot be negative. Try again.");
                    }
                } while (value < 0);
                sales[row][column] = value;
            }
        }

        // Part 8:
        System.out.println(" SALES TABLE ");
        printSales(sales);

        double total = totalSales(sales);
        System.out.printf("%nOverall sales: $%.2f%n", total);
        System.out.printf("Average sale per entry: $%.2f%n", total / countEntries(sales));

        System.out.println("\nStore totals:");
        for (int row = 0; row < sales.length; row++) {
            System.out.printf("  Store %d: $%.2f%n", row + 1, rowTotal(sales, row));
        }

        System.out.println("\nDaily totals:");
        for (int column = 0; column < sales[0].length; column++) {
            System.out.printf("  Day %d: $%.2f%n", column + 1, columnTotal(sales, column));
        }

        System.out.printf("%nBest-performing store: Store %d%n", bestStore(sales) + 1);

        int[] pos = findMaximumPosition(sales);
        System.out.printf("Largest individual sale: $%.2f (Store %d, Day %d)%n",
                findMaximum(sales), pos[0] + 1, pos[1] + 1);

        // Part 9
        double[][] irregularSales = {
                {120.0, 145.0, 160.0},
                {90.0, 105.0},
                {200.0, 210.0, 220.0, 230.0},
                {75.0}
        };
        System.out.println("RAGGED ARRAY ");
        printSales(irregularSales);
        System.out.printf("Ragged total: $%.2f%n", totalSales(irregularSales));


    }

    // Part 2
    public static void printSales(double[][] sales) {
        for (int row = 0; row < sales.length; row++) {
            System.out.printf("Store %d: ", row + 1);
            for (int column = 0; column < sales[row].length; column++) {
                System.out.printf("%10.2f", sales[row][column]);
            }
            System.out.println();
        }
    }

    // Part 3
    public static double totalSales(double[][] sales) {
        double total = 0;
        for (int row = 0; row < sales.length; row++) {
            for (int column = 0; column < sales[row].length; column++) {
                total += sales[row][column];
            }
        }
        return total;
    }

    // Part 4
    public static double rowTotal(double[][] sales, int row) {
        double total = 0;
        for (int column = 0; column < sales[row].length; column++) {
            total += sales[row][column];
        }
        return total;
    }

    // Part 5
    public static double columnTotal(double[][] sales, int column) {
        double total = 0;
        for (int row = 0; row < sales.length; row++) {
            if (column < sales[row].length) { // safe for ragged rows
                total += sales[row][column];
            }
        }
        return total;
    }

    // Part 6
    public static int bestStore(double[][] sales) {
        int best = 0;
        for (int row = 1; row < sales.length; row++) {
            if (rowTotal(sales, row) > rowTotal(sales, best)) {
                best = row;
            }
        }
        return best;
    }

    // Part 7
    public static double findMaximum(double[][] sales) {
        double max = sales[0][0];
        for (int row = 0; row < sales.length; row++) {
            for (int column = 0; column < sales[row].length; column++) {
                if (sales[row][column] > max) {
                    max = sales[row][column];
                }
            }
        }
        return max;
    }

    public static int[] findMaximumPosition(double[][] sales) {
        int[] position = {0, 0}; // index 0 = row, index 1 = column
        for (int row = 0; row < sales.length; row++) {
            for (int column = 0; column < sales[row].length; column++) {
                if (sales[row][column] > sales[position[0]][position[1]]) {
                    position[0] = row;
                    position[1] = column;
                }
            }
        }
        return position;
    }


    public static int countEntries(double[][] sales) {
        int count = 0;
        for (int row = 0; row < sales.length; row++) {
            count += sales[row].length;
        }
        return count;
    }
}



// Part 9 explanation:
// Rows different lengths, so a fixed column count could go out of bounds or skip
// array[row].length uses each row's own length, so it is always safe.
//
// Part 10 answers:
// 1. The inner loop assumes the number of columns equals the number of rows
//    (it uses sales.length, the row count, as the column limit).
// 2. In a non-square matrix (e.g. 4x7) it would stop early (miss columns) or,
//    if rows > columns, go out of bounds and crash.
// 3. Fix: column < sales[row].length
//    for (int row = 0; row < sales.length; row++) {
//        for (int column = 0; column < sales[row].length; column++) {
//            System.out.println(sales[row][column]);
//        }
//    }
//