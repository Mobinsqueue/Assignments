public class ClosestPointAnalyzer {

    public static void main(String[] args) {
        // Part 12
        double[][] points = {
                {-1, 3},
                {-1, -1},
                {1, 1},
                {2, 0.5},
                {2, -1},
                {3, 3},
                {4, 2},
                {4, -0.5}
        };

        int closestFirst = 0;
        int closestSecond = 1;
        double shortest = distance(points[0], points[1]);

        // comparing pair
        for (int first = 0; first < points.length; first++) {
            for (int second = first + 1; second < points.length; second++) {
                double current = distance(points[first], points[second]);
                if (current < shortest) {
                    shortest = current;
                    closestFirst = first;
                    closestSecond = second;
                }
            }
        }

        System.out.printf("Closest pair: (%.1f, %.1f) and (%.1f, %.1f)%n",
                points[closestFirst][0], points[closestFirst][1],
                points[closestSecond][0], points[closestSecond][1]);
        System.out.printf("Distance: %.4f%n", shortest);
    }

    public static double distance(double[] p1, double[] p2) {
        double xDifference = p1[0] - p2[0];
        double yDifference = p1[1] - p2[1];
        return Math.sqrt(xDifference * xDifference + yDifference * yDifference);
    }
}