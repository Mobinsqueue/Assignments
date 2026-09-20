import java.util.Scanner;

public class StudentGradeToolkit {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String name = readName(input);
        double score1 = readScore(input, "1");
        double score2 = readScore(input, "2");
        double score3 = readScore(input, "3");

        if (!isValidScore(score1) || !isValidScore(score2) || !isValidScore(score3)) {
            System.out.println("Error: All scores must be between 0 and 100.");
        } else {
            double average = calculateAverage(score1, score2, score3);
            char grade = determineGrade(average);
            boolean passing = isPassing(average);
            printReport(name, average, grade, passing);

            double high = highest(score1, score2);
            high = highest(high, score3);
        }

        runPassByValueExperiment();
        runMethodTests();

        input.close();
    }

    // Part 2
    public static boolean isValidScore(double score) {
        return score >= 0 && score <= 100;
    }

    // Part 3
    public static double calculateAverage(double score1, double score2, double score3) {
        return (score1 + score2 + score3) / 3.0;
    }

    // Part 4
    public static char determineGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Part 5
    public static boolean isPassing(double average) {
        return average >= 60;
    }

    // Part 6
    public static void printReport(String name, double average, char grade, boolean passing) {
        System.out.println("----- Student Report -----");
        System.out.println("Name: " + name);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Grade: " + grade);
        System.out.println("Status: " + (passing ? "Passing" : "Failing"));
    }

    // Part 7
    public static String readName(Scanner input) {
        System.out.print("Enter student name: ");
        return input.nextLine();
    }

    public static double readScore(Scanner input, String label) {
        System.out.print("Enter score " + label + ": ");
        return input.nextDouble();
    }

    // Part 8
    public static void addBonus(double score) {
        score += 5;
    }

    public static double addBonusReturn(double score) {
        score += 5;
        return score;
    }

    public static void runPassByValueExperiment() {
        System.out.println("----- Pass-by-Value Experiment -----");

        double testScore = 80;
        addBonus(testScore);
        System.out.println("testScore after addBonus(): " + testScore);

        double updatedScore = addBonusReturn(testScore);
        System.out.println("updatedScore after addBonusReturn(): " + updatedScore);
        //8.1: value displayed is 80
        //8.2 : its local and original doesnt get changed it's the value being called and changed not the variable itself
        //8.3 addbonus return above
    }

    // Part 9
    public static double highest(double a, double b) {
        return (a > b) ? a : b;
    }

    // Part 10
    public static void runMethodTests() {
        System.out.println("----- Method Tests -----");

        System.out.println("isValidScore(-1)  -> " + isValidScore(-1));
        System.out.println("isValidScore(0)   -> " + isValidScore(0));
        System.out.println("isValidScore(100) -> " + isValidScore(100));
        System.out.println("isValidScore(101) -> " + isValidScore(101));

        System.out.println("determineGrade(90) -> " + determineGrade(90));
        System.out.println("determineGrade(80) -> " + determineGrade(80));
        System.out.println("determineGrade(70) -> " + determineGrade(70));
        System.out.println("determineGrade(60) -> " + determineGrade(60));
        System.out.println("determineGrade(59) -> " + determineGrade(59));
    }
    //part 11
    // 11.1 : nothing covers where if statement doesnt run so cant garantuee a value coming back
    //11.2 : when a > b is false it skips the block
    //11.3
    public static int larger(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}