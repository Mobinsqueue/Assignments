import java.util.Scanner;
public class part11 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter total trip in minutes: ");
        int totalMinutes = input.nextInt();

        int hours = totalMinutes / 60;
        int remainingMinutes = totalMinutes % 60;

        System.out.println(hours + " hours and " + remainingMinutes + " minutes");
    }
}