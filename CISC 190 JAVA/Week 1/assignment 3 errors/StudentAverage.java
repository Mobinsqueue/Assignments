public class StudentAverage {

    public static void main(String[] args) {

        String studentName = "Jordan";
        double score1 = 80;
        double score2 = 90;

        double average = (score1 + score2) / 2;      //add () for order of operation correction

        System.out.println("Student: " + studentName);   //missing semicolon
        System.out.println("Average: " + average);
    }
}