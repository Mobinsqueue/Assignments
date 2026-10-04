//part 13 and 14
public class ExamScoreAnalyzer {

    public static void main(String[] args) {

        double[][][] scores = new double[4][3][2];

        // Fill with test values
        for (int student = 0; student < scores.length; student++) {
            for (int exam = 0; exam < scores[student].length; exam++) {
                for (int component = 0; component < scores[student][exam].length; component++) {
                    scores[student][exam][component] = 10 * (student + 1) + 2 * exam + component;
                }
            }
        }

        // Total per student using three nested loops
        for (int student = 0; student < scores.length; student++) {
            double total = 0;
            for (int exam = 0; exam < scores[student].length; exam++) {
                for (int component = 0; component < scores[student][exam].length; component++) {
                    total += scores[student][exam][component];
                }
            }
            System.out.printf("Student %d total: %.1f%n", student + 1, total);
        }

        // Part 14
        System.out.println();
        for (int student = 0; student < scores.length; student++) {
            System.out.printf("Student %d total (method): %.1f%n", student + 1, studentTotal(scores, student));
        }
    }

    // Part 14
    public static double studentTotal(double[][][] scores, int student) {
        double total = 0;
        for (int exam = 0; exam < scores[student].length; exam++) {
            for (int component = 0; component < scores[student][exam].length; component++) {
                total += scores[student][exam][component];
            }
        }
        return total;
    }
}