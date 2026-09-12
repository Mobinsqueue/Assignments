public class BreakChallenge {

    public static void main(String[] args) {

        int result = 0;

        for (int i = 1; i <= 100; i++) {
            if (i > 20 && i % 4 == 0 && i % 7 == 0) {
                result = i;
                break;
            }
        }

        if (result != 0) {
            System.out.println("First number greater than 20 divisible by both 4 and 7: " + result);
        }
        else {
            System.out.println("No such number was found.");
        }
    }
}