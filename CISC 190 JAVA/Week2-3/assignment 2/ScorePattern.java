public class ScorePattern {

    public static void main(String[] args) {


        for (int row = 1; row <= 5; row++) {

            // Inner loop prints the values for that row
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}