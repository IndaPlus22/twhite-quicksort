import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int ARRAY_SIZE = 1000000;
    private static final int RANDOM_SEED = 42;

    public static void main(String[] args) {
        Random rand = new Random(RANDOM_SEED);
        int[] arr = rand.ints(ARRAY_SIZE).toArray();

        // Sort the array using quicksort
        QuickSort.sort(arr);

        // Verify that the array is sorted
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        if (Arrays.equals(arr, sortedArr)) {
            System.out.println("The array is sorted correctly.");
        } else {
            System.out.println("The array is not sorted correctly.");
        }
    }
}



