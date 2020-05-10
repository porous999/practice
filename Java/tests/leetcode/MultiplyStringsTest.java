package leetcode;

import org.junit.Test;

import static leetcode.MultiplyStrings.multiply;
import static org.junit.Assert.*;

/**
 * Created by tanmays on 10/5/20.
 */
public class MultiplyStringsTest {
    @Test
    public void testMultiply() throws Exception {

        assertTrue(assertProduct(1, 2));
        assertTrue(assertProduct(0, 2));
        assertTrue(assertProduct(100, 2));
        assertTrue(assertProduct(99999, 9999));
    }

    private boolean assertProduct(int num1, int num2) {

        String num1Str = String.valueOf(num1);
        String num2Str = String.valueOf(num2);

        String calculatedVal = multiply(num1Str, num2Str);
        String expectedValue = String.valueOf(num1 * num2);
        System.out.printf("%s * %s => Expected: %s ; Calculated: %s\n", num1, num2, expectedValue, calculatedVal);
        return calculatedVal.equals(expectedValue);
    }

}