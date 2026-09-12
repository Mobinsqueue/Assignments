import java.util.Scanner;

public class ScoreAnalyzer {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int count = 0;
        double total = 0.0;
        double highest = 0.0;
        double lowest = 0.0;
        int passingCount = 0;
        int belowCount = 0;

        System.out.println("Enter your score from 0 t0 100(-1 to finish): ");
        double score = input.nextDouble();


        while (score != -1) {

            // Validate the input
            if (score >= 0 && score <= 100) {

                count++;
                total += score;

                // Track highest and lowest
                if (count == 1) {
                    highest = score;
                    lowest = score;
                } else {
                    if (score > highest) {
                        highest = score;
                    }
                    if (score < lowest) {
                        lowest = score;
                    }
                }

                // Classify the score for passing or not
                if (score >= 60) {
                    passingCount++;
                } else {
                    belowCount++;
                }
            } else {
                System.out.println("Invalid score. Value ignored.");
            }

            System.out.print("Enter a score from 0 to 100 (-1 to finish): ");
            score = input.nextDouble();

        }


        //report sum
        System.out.println();
        System.out.println("----- Score Summary -----");
        System.out.println("Valid scores: " + count);

        if (count == 0) {
            System.out.println("No valid scores were entered.");
        }
        else {
            double average = total / count;
            System.out.println("Average:"+average);
            System.out.println("Highest:"+highest);
            System.out.println("Lowest:"+lowest);
            System.out.println("Passing scores: " + passingCount);
            System.out.println("Below 60: " + belowCount);
        }

        input.close();

    }
}