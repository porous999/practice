package leetcode;

import org.junit.Ignore;
import org.junit.Test;

import static leetcode.MultiplyStrings.getSimpleProduct;
import static leetcode.MultiplyStrings.getSimpleSum;
import static leetcode.MultiplyStrings.multiply;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tanmays on 10/5/20.
 */
public class MultiplyStringsTest {

    @Test
    public void testMultiply() throws Exception {

        assertTrue(assertProduct(1, 2, false));
        assertTrue(assertProduct(0, 2, false));
        assertTrue(assertProduct(999, 9, false));
        assertTrue(assertProduct(200010, 109, false));
        assertTrue(assertProduct(100, 2, false));
        assertTrue(assertProduct(99999, 9999, false));
        assertTrue(assertProduct(123, 456, false));
        assertTrue(assertProduct(123, 0, false));
        assertTrue(assertProduct(0, 123, false));
        assertEquals("111932631112635269", multiply("123456789","987654321"));
    }

    @Test
    public void testGetSimpleProduct() throws Exception {

        assertTrue(assertProduct(1, 2, true));
        assertTrue(assertProduct(0, 2, true));
        assertTrue(assertProduct(0, 20, true));
        assertTrue(assertProduct(100, 0, true));
        assertTrue(assertProduct(999, 9, true));
    }

    @Test
    public void testGetSum() {
        assertTrue(assertSum(1, 2));
        assertTrue(assertSum(22, 33));
        assertTrue(assertSum(22, 3300));
    }

    private boolean assertSum(int num1, int num2) {
        String num1Str = String.valueOf(num1);
        String num2Str = String.valueOf(num2);

        String calculatedVal = getSimpleSum(num1Str, num2Str, 0);
        String expectedValue = String.valueOf(num1 + num2);
        System.out.printf("%s * %s => Expected: %s ; Calculated: %s\n", num1, num2, expectedValue, calculatedVal);
        return calculatedVal.equals(expectedValue);
    }

    private boolean assertProduct(int num1, int num2, boolean simpleProd) {

        String num1Str = String.valueOf(num1);
        String num2Str = String.valueOf(num2);

        String calculatedVal;
        if (simpleProd)
            calculatedVal = getSimpleProduct(num1Str, num2, 0);
        else
            calculatedVal = multiply(num1Str, num2Str);
        String expectedValue = String.valueOf(num1 * num2);
        return assertionResult(num1Str, num2Str, expectedValue, calculatedVal);
    }

    private boolean assertionResult(String num1, String num2, String expectedValue, String calculatedVal) {
        System.out.printf("%s * %s => Expected: %s ; Calculated: %s\n", num1, num2, expectedValue, calculatedVal);
        return calculatedVal.equals(expectedValue);
    }

    @Test
    public void testRemovalOfChar() {
        assertEquals("abcd", "abcde".subSequence(0, 5-1));
    }

}