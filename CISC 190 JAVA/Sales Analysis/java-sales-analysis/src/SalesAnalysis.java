
//SalesAnalysis

//Analyzes monthly sales-change data and finds the consecutive period of
//months with the highest combined sales change.

//The month names and sales values are stored in parallel arrays, so the
//same index refers to the same month in both arrays.

public class SalesAnalysis {

    public static void main(String[] args) {
        // Parallel arrays: months[i] goes with salesChange[i]
        String[] months = {
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        double[] salesChange = {
                12, -8, 15, 18, -22, 10,
                14, -5, 20, 8, -25, 6
        };

        int[] bestPeriod = findBestPeriod(salesChange);
        int startIndex = bestPeriod[0];
        int endIndex = bestPeriod[1];

        printResults(months, salesChange, startIndex, endIndex);
    }


      //Examines every consecutive period of months and finds the one with the
      //highest total. If two periods tie, the first one found is kept.


    public static int[] findBestPeriod(double[] salesChange) {
        // Start with the first month as the best so far. This also makes
        // the all-negative case work without any special handling.
        double bestTotal = salesChange[0];
        int bestStart = 0;
        int bestEnd = 0;

        // Outer loop: choose each possible starting month
        for (int start = 0; start < salesChange.length; start++) {
            double currentTotal = 0;

            // Inner loop: extend the period one month at a time
            for (int end = start; end < salesChange.length; end++) {
                currentTotal += salesChange[end];

                // Strictly greater, so a tie keeps the earlier period
                if (currentTotal > bestTotal) {
                    bestTotal = currentTotal;
                    bestStart = start;
                    bestEnd = end;
                }
            }
        }

        return new int[] {bestStart, bestEnd};
    }


    //Adds up the sales values from start through end (inclusive).

    public static double calculatePeriodTotal(double[] salesChange, int start, int end) {
        double total = 0;
        for (int i = start; i <= end; i++) {
            total += salesChange[i];
        }
        return total;
    }


    //Prints the start month, end month, and total for the best period.

    public static void printResults(String[] months, double[] salesChange, int start, int end) {
        double total = calculatePeriodTotal(salesChange, start, end);

        System.out.println("Sales Analysis");
        System.out.println("-------------------------");
        System.out.println("Start Month: " + months[start]);
        System.out.println("End Month:   " + months[end]);
        System.out.println("Total Sales Change: " + total + " million");
    }
}