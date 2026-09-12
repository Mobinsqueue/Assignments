import java.util.Scanner;

public class FixedScoreAnalyzer {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double total = 0.0;

        System.out.println("Enter 5 scores.");

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter score " + i + ": ");
            double score = input.nextDouble();
            total += score;
        }

        double average = total / 5;

        System.out.println();
        System.out.println("Total:" +total);
        System.out.println("Average:" +average);

        input.close();
    }
}