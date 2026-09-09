import java.util.Scanner;

public class CourseRegistrationAdvisor {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your score: ");
        int score = input.nextInt();
        //asking for score input


        boolean validScore = score >= 0 && score <= 100;

        if (!validScore) {
            System.out.println("Invalid placement score.");
            return;
            // validate the score
        }

        System.out.println("prerequisitie completed?: (True,False) ");
        boolean prerequisite = input.nextBoolean();


        //recording the program type
        System.out.println("Program type:");
        System.out.println("1 - Computer Science");
        System.out.println("2 - Data Science");
        System.out.println("3 - Information Systems");
        System.out.println("4 - Other");
        System.out.print("Enter choice: ");
        int programType = input.nextInt();

        //number of college units input
        System.out.print("Completed college units: ");
        int units = input.nextInt();


        //Classifying levels for each score
        String level;
        if (score >= 90) {
            level = "Advanced";
        }
        else if (score >= 75) {
            level = "Ready";
        }
        else if (score >= 60) {
            level = "Developing";
        }
        else {
            level = "Needs Preparation";
        }


        //minimum score for prereq part 5
        boolean Eligible = score >= 75 && prerequisite;
        String registrationStatus;
        if (Eligible) {
            registrationStatus = "Eligible";
        }
        else {
            registrationStatus = "Advisor review required";
        }
        System.out.println();
        System.out.println("Registration status: " + registrationStatus);

        //part 6
        if (!Eligible) {
            if (!prerequisite) {
                System.out.println("Complete the prerequisite course first.");
            }
            else if (score < 75) {
                System.out.println("Additional preparation is recommended.");
            }
        }


        //confirming pathway
        String programMessage;
        switch (programType) {

            case 1:
                programMessage = "Computer Science pathway";
                break;

            case 2:
                programMessage = "Data Science pathway";
                break;

            case 3:
                programMessage = "Information Systems pathway";
                break;

            case 4:
                programMessage = "General elective pathway";
                break;

            default:
                programMessage = "Invalid program type";
        }

        System.out.println(programMessage);



        //checking student status
        String studentStatus =
                (units < 12) ? "New Student" : "Continuing Student";
        System.out.println("Student status: " + studentStatus);


        //checking for early priority
        boolean earlyRegistrationPriority =
                (units >= 30 && Eligible)
                        || (units >= 60 && prerequisite);



        //final report as for part 9
        System.out.println("----- Course Registration Advisor -----");
        System.out.println("Placement score: " + score);
        System.out.println("Preparation level: " + level);
        System.out.println("Prerequisite completed: " + prerequisite);
        System.out.println("Registration status: " + registrationStatus);
        System.out.println("Program: " + programMessage);
        System.out.println("Student status: " + studentStatus);
        System.out.println("Early registration priority: " + earlyRegistrationPriority);

        input.close();


        //please do note that all earlier steps are also all in this code so part 5 and 6
        //which are registration eligibility and nested decision get printed also when running
        //the code, I can remove the print statement from them and only have part 9
        //but im including them so you can see my steps7



        //part 11
        //1) prints D
        //2) has to print "A" but it will never reach since first if statement satisfies it
        //3) new order will be if (score >= 90) {
        //    System.out.println("A");
        //}
        //else if (score >= 80) {
        //    System.out.println("B");
        //}
        //else if (score >= 70) {
        //    System.out.println("C");
        //}
        //else if (score >= 60) {
        //    System.out.println("D");
        //}



        //part 12
        //yes it will print but the semi collon after if statement terminates the if statement
        //its hard to detect because it still compiles and runs/ finding will be hard



        //part13
        // tested the code, works
    }
}