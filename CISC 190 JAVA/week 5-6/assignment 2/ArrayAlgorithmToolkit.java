import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayAlgorithmToolkit {

    private static final Random RNG = new Random();
    private static final int DEFAULT_SIZE = 20;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    private static int linearComparisons = 0;
    private static int binaryComparisons = 0;

    // Part 1
    public static int[] generateData(int size, int min, int max) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = min + RNG.nextInt(max - min + 1);
        }
        return data;
    }

    // Part 2
    public static void printArray(int[] values) {
        System.out.print("[");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i < values.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Part 3
    public static int[] reverse(int[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[values.length - 1 - i] = values[i];
        }
        return result;
    }

    // Part 4
    public static void selectionSort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < values[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = values[i];
            values[i] = values[minIndex];
            values[minIndex] = temp;
        }
    }

    // Part 5
    public static int linearSearch(int[] values, int key) {
        linearComparisons = 0;
        for (int i = 0; i < values.length; i++) {
            linearComparisons++;
            if (values[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Part 6
    public static int binarySearch(int[] values, int key) {
        binaryComparisons = 0;
        int low = 0;
        int high = values.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            binaryComparisons++;
            if (values[mid] == key) {
                return mid;
            } else if (values[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Part 8
    public static void shuffle(int[] values) {
        for (int i = 0; i < values.length; i++) {
            int j = RNG.nextInt(values.length);
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
    }

    // Part 9
    public static void swapFirstTwo(int[] values) {
        if (values.length < 2) {
            return;
        }
        int temp = values[0];
        values[0] = values[1];
        values[1] = temp;
    }

    // Part 10
    public static double average(int... values) {
        if (values.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return (double) sum / values.length;
    }

    // Part 12
    public static int countOccurrences(int[] values, int key) {
        int count = 0;
        for (int v : values) {
            if (v == key) {
                count++;
            }
        }
        return count;
    }


    public static void reportDuplicates(int[] values) {
        boolean found = false;
        for (int i = 0; i < values.length; i++) {
            boolean alreadyReported = false;
            for (int j = 0; j < i; j++) {
                if (values[j] == values[i]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (!alreadyReported) {
                int count = countOccurrences(values, values[i]);
                if (count > 1) {
                    System.out.println("Value " + values[i] + " occurs " + count + " times");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No duplicate values found.");
        }
    }

    private static boolean isSorted(int[] values) {
        for (int i = 1; i < values.length; i++) {
            if (values[i - 1] > values[i]) {
                return false;
            }
        }
        return true;
    }

    // Part 6
    private static void compareSearches(int[] sorted, int key, String label) {
        int linearIndex = linearSearch(sorted, key);
        int binaryIndex = binarySearch(sorted, key);
        System.out.println(label + " (key " + key + "): linear index = " + linearIndex
                + " in " + linearComparisons + " comparisons, binary index = " + binaryIndex
                + " in " + binaryComparisons + " comparisons");
    }

    // Part 7
    private static void verifyWithJava(int[] original, int[] mySorted, int key) {
        int[] copy = Arrays.copyOf(original, original.length);
        Arrays.sort(copy);
        int javaIndex = Arrays.binarySearch(copy, key);
        int myIndex = binarySearch(mySorted, key);
        System.out.println("Java sorted:  " + Arrays.toString(copy));
        System.out.println("My sorted:    " + Arrays.toString(mySorted));
        System.out.println("Sorted arrays match: " + Arrays.equals(copy, mySorted));
        System.out.println("Arrays.binarySearch(" + key + ") = " + javaIndex
                + ", my binarySearch(" + key + ") = " + myIndex);
        System.out.println("Results agree on found/not found: " + ((javaIndex >= 0) == (myIndex >= 0)));
    }


    private static void runDemo(int size) {

        int[] data = generateData(size, MIN_VALUE, MAX_VALUE);
        System.out.println("Generated " + data.length + " values");


        printArray(data);
        System.out.println(Arrays.toString(data));


        int[] reversed = reverse(data);
        System.out.println("Reversed: " + Arrays.toString(reversed));
        System.out.println("Original unchanged: " + Arrays.toString(data));


        int[] sorted = Arrays.copyOf(data, data.length);
        selectionSort(sorted);
        System.out.println("Selection sorted: " + Arrays.toString(sorted));


        int nearStart = sorted[Math.min(1, sorted.length - 1)];
        int nearEnd = sorted[Math.max(0, sorted.length - 2)];
        int missing = MAX_VALUE + 1;
        compareSearches(sorted, nearStart, "Near beginning");
        compareSearches(sorted, nearEnd, "Near end");
        compareSearches(sorted, missing, "Missing key");
        //answering search comparison question
        // Binary search requires sorted input because each step compares the key with the
        // middle element and discards half of the interval. That decision
        // is only valid when every value to the
        // left of mid is <= mid and every value to the right is >= mid.


        verifyWithJava(data, sorted, nearStart);
        verifyWithJava(data, sorted, missing);


        int[] toShuffle = Arrays.copyOf(sorted, sorted.length);
        System.out.println("Before shuffle: " + Arrays.toString(toShuffle));
        shuffle(toShuffle);
        System.out.println("After shuffle:  " + Arrays.toString(toShuffle));


        int[] swapDemo = Arrays.copyOf(data, data.length);
        System.out.println("Before swapFirstTwo: " + Arrays.toString(swapDemo));
        swapFirstTwo(swapDemo);
        System.out.println("After swapFirstTwo:  " + Arrays.toString(swapDemo));



        System.out.println("average(4, 8, 12) = " + average(4, 8, 12));
        System.out.println("average(10, 20, 30, 40, 50) = " + average(10, 20, 30, 40, 50));
        System.out.println("average() = " + average());


        reportDuplicates(data);
    }


    private static void printMenu() {
        System.out.println();
        System.out.println("1. Display data");
        System.out.println("2. Reverse data");
        System.out.println("3. Sort using selection sort");
        System.out.println("4. Search using linear search");
        System.out.println("5. Search using binary search");
        System.out.println("6. Shuffle data");
        System.out.println("7. Regenerate data");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }


    private static int readInt(Scanner in) {
        while (!in.hasNextInt()) {
            System.out.print("Please enter a whole number: ");
            in.next();
        }
        return in.nextInt();
    }


    private static void displayData(int[] data) {
        printArray(data);
        System.out.println(Arrays.toString(data));
    }


    private static int[] reverseData(int[] data) {
        int[] reversed = reverse(data);
        System.out.println("Reversed data: " + Arrays.toString(reversed));
        return reversed;
    }


    private static void sortData(int[] data) {
        selectionSort(data);
        System.out.println("Sorted: " + Arrays.toString(data));
    }


    private static void searchLinear(int[] data, Scanner in) {
        System.out.print("Key to search for: ");
        int key = readInt(in);
        int index = linearSearch(data, key);
        System.out.println("Index: " + index + " (" + linearComparisons + " comparisons)");
    }


    private static void searchBinary(int[] data, Scanner in) {
        if (!isSorted(data)) {
            System.out.println("Data is not sorted. Sort it first (option 3).");
            return;
        }
        System.out.print("Key to search for: ");
        int key = readInt(in);
        int index = binarySearch(data, key);
        System.out.println("Index: " + index + " (" + binaryComparisons + " comparisons)");
    }


    private static void runMenu(int[] data) {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = readInt(in);
            switch (choice) {
                case 1:
                    displayData(data);
                    break;
                case 2:
                    data = reverseData(data);
                    break;
                case 3:
                    sortData(data);
                    break;
                case 4:
                    searchLinear(data, in);
                    break;
                case 5:
                    searchBinary(data, in);
                    break;
                case 6:
                    shuffle(data);
                    System.out.println("Data shuffled.");
                    break;
                case 7:
                    data = generateData(data.length, MIN_VALUE, MAX_VALUE);
                    System.out.println("Data regenerated.");
                    break;
                case 0:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        in.close();
    }


    private static int parseSize(String[] args) {
        if (args.length == 0) {
            return DEFAULT_SIZE;
        }
        try {
            int size = Integer.parseInt(args[0].trim());
            if (size < 2 || size > 100000) {
                System.out.println("Size must be between 2 and 100000. Using default " + DEFAULT_SIZE + ".");
                return DEFAULT_SIZE;
            }
            return size;
        } catch (NumberFormatException e) {
            System.out.println("Invalid size \"" + args[0] + "\". Using default " + DEFAULT_SIZE + ".");
            return DEFAULT_SIZE;
        }
    }

    public static void main(String[] args) {
        int size = parseSize(args);
        runDemo(size);
        runMenu(generateData(size, MIN_VALUE, MAX_VALUE));
    }
}