package week03;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void test() {
        // Create a sorted list of integers from 0 to 999;
        int[] intList = new int[1000];
        for (int i = 0; i < 1000; i++) {
            intList[i] = i;
        }

        // Search 2, 4, ..., 512 and so on in the list
        int target = 2;
        for (int i = 0; i < 9; i++) {
            assert BinarySearch.binarySearch(intList, target) == target;
            target = 2 * target;
        }
    }
}
