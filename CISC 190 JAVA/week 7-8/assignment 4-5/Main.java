import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Course myCourse = new Course();
        OfferedCourse myOfferedCourse = new OfferedCourse();

        // First course (base class)
        myCourse.setCourseNumber(scnr.nextLine());
        myCourse.setCourseTitle(scnr.nextLine());

        // Second course (derived class)
        myOfferedCourse.setCourseNumber(scnr.nextLine());
        myOfferedCourse.setCourseTitle(scnr.nextLine());
        myOfferedCourse.setInstructorName(scnr.nextLine());
        myOfferedCourse.setLocation(scnr.nextLine());
        myOfferedCourse.setClassTime(scnr.nextLine());

        // Output
        myCourse.PrintInfo();

        myOfferedCourse.PrintInfo();
        System.out.println("  Instructor Name: " + myOfferedCourse.getInstructorName());
        System.out.println("   Location: " + myOfferedCourse.getLocation());
        System.out.println("  Class Time: " + myOfferedCourse.getClassTime());
    }
}