package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tanmays on 10/5/20.
 */
public class TwoSumsTest {

    TwoSums testTwoSums = new TwoSums();

    private boolean assertTwoSum(int i, int j, int[] result) {
        return (i == result[0] && j == result[1]);
    }
    @Test
    public void twoSum() throws Exception {
        assertTrue(assertTwoSum(0, 1, testTwoSums.twoSum(new int[]{2, 7, 11, 15}, 9)));
        assertTrue(assertTwoSum(2, 3, testTwoSums.twoSum(new int[]{2, 7, 11, 15}, 26)));
        assertTrue(assertTwoSum(1, 2, testTwoSums.twoSum(new int[]{6, 2, 4}, 6)));
        assertTrue(assertTwoSum(0, 1, testTwoSums.twoSum(new int[]{3, 3}, 6)));
    }

}