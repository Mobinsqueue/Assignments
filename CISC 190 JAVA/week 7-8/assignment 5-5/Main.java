import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Book myBook = new Book();
        Encyclopedia myEncyclopedia = new Encyclopedia();

        // First book (base class)
        myBook.setTitle(scnr.nextLine());
        myBook.setAuthor(scnr.nextLine());
        myBook.setPublisher(scnr.nextLine());
        myBook.setPublicationDate(scnr.nextLine());

        // Encyclopedia (derived class)
        myEncyclopedia.setTitle(scnr.nextLine());
        myEncyclopedia.setAuthor(scnr.nextLine());
        myEncyclopedia.setPublisher(scnr.nextLine());
        myEncyclopedia.setPublicationDate(scnr.nextLine());
        myEncyclopedia.setEdition(scnr.nextLine());
        myEncyclopedia.setNumPages(Integer.parseInt(scnr.nextLine().trim()));

        // Output
        myBook.printInfo();
        myEncyclopedia.printInfo();
    }
}