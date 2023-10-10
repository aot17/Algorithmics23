package week03;

import week03.tools.SimpleFileWriter;

public class ThreeSum {

    public static void main(String[] args) {
        for (int i = 1; i < 5001; i++) {
            int length = 100 * i;
            int[] numbers = new int[length];

            // Fill it with integers from -(length/2) to (length/2)-1
            int negativeInts = -1 * (length / 2);
            for (int j = 0; j < length; j++) {
                numbers[j] = negativeInts++;
            }

            double start1 = System.currentTimeMillis();
            int count1 = COUNT_ZERO_SUM_TRIPPLES(numbers);
            double benchmark1 = (System.currentTimeMillis() - start1) / 1000;

            double start2 = System.currentTimeMillis();
            int count2 = COUNT_ZERO_SUM_TRIPPLES_FAST(numbers);
            double benchmark2 = (System.currentTimeMillis() - start2) / 1000;

            SimpleFileWriter fileWriter = new SimpleFileWriter("./output.txt");
            fileWriter.append(length + "," + benchmark1 + "," + benchmark2 + "\n");
        }
    }

    public static int COUNT_ZERO_SUM_TRIPPLES(int[] numbers) {
        int count = 0;
        final int N = numbers.length;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    // Please check, possibility of being wrong -Sam
    public static int COUNT_ZERO_SUM_TRIPPLES_FAST(int[] numbers) {
        int count = 0;
        final int N = numbers.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int k = -1 * (numbers[i] + numbers[j]);

                int result = BinarySearch.binarySearch(numbers, k);
                /*
                 If binary search returns -1, then no such element is found
                 and if we also take into account indexes smaller than j,
                 we would count the same trio of numbers more than once.
                */
                if (result != -1 && result > j) {
                    count++;
                }
            }
        }
        return count;
    }
}
