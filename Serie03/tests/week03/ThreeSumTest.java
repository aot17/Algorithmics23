package week03;

import org.junit.Test;

public class ThreeSumTest {
    @Test
    public void test() {
        final int N = 10;
        int[] intList = new int [N];
        for (int i = 0; i < N; i++) {
            intList[i] = i - 2;
        }
        assert ThreeSum.COUNT_ZERO_SUM_TRIPPLES(intList) == 3;
        assert ThreeSum.COUNT_ZERO_SUM_TRIPPLES_FAST(intList) == 3;
    }
}
