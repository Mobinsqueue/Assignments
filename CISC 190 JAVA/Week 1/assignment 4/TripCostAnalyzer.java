import java.util.Scanner;

public class TripCostAnalyzer {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Your code goes here

        final int MINUTES_PER_HOUR = 60;

//here are all the inputs from user stored in double instead of int to be able to calculate decimals

        System.out.println("Enter trip distance in miles: ");
        double distance = input.nextDouble();

        System.out.println("Enter vehicle miles per gallon: ");
        double milesPerGallon = input.nextDouble();

        System.out.println("Enter fuel price per gallon: ");
        double pricePerGallon = input.nextDouble();

        System.out.println("Enter average driving speed: ");
        double averageSpeed = input.nextDouble();

        System.out.println("Enter number of travelers: ");
        double numberOfTravelers = input.nextDouble();
        //can also use int as number of travelers because they are a whole number

        System.out.println("Enter Additional cost: ");
        double additionalCost = input.nextDouble();

//all the calculation and logic are defined here

        double gallonsNeeded = distance / milesPerGallon;
        double fuelCost = gallonsNeeded * pricePerGallon;
        double travelHours = distance / averageSpeed;

        int wholeHours = (int) travelHours;
        double fractionalHour = travelHours - wholeHours;
        int remainingMinutes = (int) (fractionalHour * MINUTES_PER_HOUR);

        double totalTripCost = fuelCost + additionalCost;
        double costPerTraveler = totalTripCost / numberOfTravelers
                ;


//finally all the outputs calculated based on input get printed out here

        System.out.println("Gallons needed: " + gallonsNeeded);
        System.out.println("Fuel cost: $" + fuelCost);
        System.out.println("Travel time: " + travelHours + " hours");
        System.out.println("Estimated drive: " +wholeHours + "hours and " + remainingMinutes + " minutes");
        System.out.println("total cost per traveler: $" + costPerTraveler);
        System.out.println("total trip cost: $" + totalTripCost);






    }
}