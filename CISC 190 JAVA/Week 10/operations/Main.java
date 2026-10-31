import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final String PHOTO_SUFFIX = "_photo.jpg";
    private static final String INFO_SUFFIX = "_info.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        String inputFileName = keyboard.nextLine().trim();

        Scanner photoListFile = new Scanner(new File(inputFileName));
        while (photoListFile.hasNextLine()) {
            String photoFileName = photoListFile.nextLine().trim();
            if (photoFileName.endsWith(PHOTO_SUFFIX)) {
                String infoFileName = photoFileName.substring(0, photoFileName.length() - PHOTO_SUFFIX.length()) + INFO_SUFFIX;
                System.out.println(infoFileName);
            }
        }
        photoListFile.close();
    }
}