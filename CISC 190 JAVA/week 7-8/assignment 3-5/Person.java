// ===== Code from file Person.java =====
public class Person {
    private int ageYears;
    private String lastName;

    public void setName(String userName) {
        lastName = userName;
    }

    public void setAge(int numYears) {
        ageYears = numYears;
    }

    // Other parts omitted

    public void printAll() {
        System.out.print("Name: " + lastName);
        System.out.print(", Age: " + ageYears);
    }
}
// ===== end =====



