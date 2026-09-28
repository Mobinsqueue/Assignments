import java.util.Scanner;

public class AssessmentAnalyzer {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Part 1
        double[] scores = new double[10];
        for (int i = 0; i < scores.length; i++) {
            double value;
            while (true) {
                System.out.print("Enter score #" + (i + 1) + " (0-100): ");
                value = scan.nextDouble();
                if (value >= 0 && value <= 100) {
                    break;
                }
                System.out.println("Invalid score. Please enter a value between 0 and 100.");
            }
            scores[i] = value;
        }


        System.out.println("\n Scores Entered ");
        printScores(scores);

        double average = calculateAverage(scores);
        double minimum = findMinimum(scores);
        double maximum = findMaximum(scores);
        int aboveAverage = countAboveAverage(scores, average);


        System.out.print("\nEnter a score to locate: ");
        double target = scan.nextDouble();
        int foundIndex = linearSearch(scores, target);
        if (foundIndex != -1) {
            System.out.println("Score " + target + " found at index " + foundIndex + ".");
        } else {
            System.out.println("Score " + target + " was not found in the array.");
        }


        double[] copy = copyArray(scores);
        copy[0] = copy[0] + 1000;
        System.out.println("\n Independent Copy Demonstration");
        System.out.println("Original scores[0]: " + scores[0]);
        System.out.println("Modified copy[0]:   " + copy[0]);
        //original remains unchanged


        double[] second = scores;
        double originalFirst = scores[0];
        second[0] = 0;
        System.out.println("\n Reference Investigation ");
        System.out.println("scores[0] after 'second[0] = 0': " + scores[0]);
      //both point to same array so changing an element modifies the only array that exist in memory
        scores[0] = originalFirst;


        System.out.println("\n Circular Left Shift ");
        System.out.println("Before shift:");
        printScores(scores);
        shiftLeft(scores);
        System.out.println("After shift:");
        printScores(scores);

        average = calculateAverage(scores);
        minimum = findMinimum(scores);
        maximum = findMaximum(scores);
        aboveAverage = countAboveAverage(scores, average);

        // Part 9
        System.out.println("\n Final Report ");
        System.out.println("Number of scores: " + scores.length);
        System.out.printf("Average: %.2f%n", average);
        System.out.printf("Minimum: %.2f%n", minimum);
        System.out.printf("Maximum: %.2f%n", maximum);
        System.out.println("Above average: " + aboveAverage);

        scan.close();
    }

    // Part 2
    public static void printScores(double[] scores) {
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Index %d -> %.2f%n", i, scores[i]);
        }
    }

    // Part 3
    public static double calculateAverage(double[] scores) {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    // Part 4
    public static double findMinimum(double[] scores) {
        double min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }

    public static double findMaximum(double[] scores) {
        double max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    // Part 5
    public static int countAboveAverage(double[] scores, double average) {
        int count = 0;
        for (double score : scores) {
            if (score > average) {
                count++;
            }
        }
        return count;
    }

    // Part 6
    public static int linearSearch(double[] scores, double target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Part 7
    public static double[] copyArray(double[] source) {
        double[] result = new double[source.length];
        for (int i = 0; i < source.length; i++) {
            result[i] = source[i];
        }
        return result;
    }

    // Part 8
    public static void shiftLeft(double[] scores) {
        double first = scores[0];
        for (int i = 0; i < scores.length - 1; i++) {
            scores[i] = scores[i + 1];
        }
        scores[scores.length - 1] = first;
    }
}