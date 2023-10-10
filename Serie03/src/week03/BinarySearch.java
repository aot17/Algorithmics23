package week03;

public class BinarySearch {
    public static int binarySearch(int[] numbers, int key) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (lo <= hi) {
            // int mid = (lo + hi) / 2; // Check page 70 of slides
            int mid = lo + (hi - lo) / 2;
            if (key < numbers[mid]) {
                hi = mid - 1;
            } else if (key > numbers[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
