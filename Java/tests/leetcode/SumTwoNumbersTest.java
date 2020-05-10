package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;
import static leetcode.SumTwoNumbers.ListNode;

/**
 * Created by tanmays on 10/5/20.
 */
public class SumTwoNumbersTest {

    SumTwoNumbers testSumTwoNumbers = new SumTwoNumbers();

    @Test
    public void addUnequalSizedTwoNumbers() throws Exception {

        assertTrue(assertCorrectSum(1234, 12034));
        assertTrue(assertCorrectSum(0, 1949));
        assertTrue(assertCorrectSum(1239, 949));
        assertTrue(assertCorrectSum(5239, 99949));
        assertTrue(assertCorrectSum(5239, 999949));
        assertTrue(assertCorrectSum(5239, 899949));
    }

    @Test
    public void addSameSizedTwoNumbers() throws Exception {
        assertTrue(assertCorrectSum(12, 12));
        assertTrue(assertCorrectSum(1239, 1949));
        assertTrue(assertCorrectSum(0, 1));
        assertTrue(assertCorrectSum(5, 5));
    }

    private int getInt(ListNode listNode, int multiplier) {
        if (null == listNode)
            return 0;

        if (null == listNode.next)
            return (listNode.val * multiplier);
        return (listNode.val * multiplier) + getInt(listNode.next, multiplier * 10);
    }

    private boolean assertCorrectSum(int num1, int num2) {
        ListNode sumList = testSumTwoNumbers.addTwoNumbers(createNumberList(num1), createNumberList(num2));
        System.out.printf("%d + %d => Expected: %d ; Calculated: %d\n", num1, num2, num1 + num2, getInt(sumList, 1));
        return assertNumberList(createNumberList(num1 + num2), sumList);
    }

    private boolean assertNumberList(ListNode numberList1, ListNode numberList2) {
        return (null == numberList1) ||
                (numberList1.val == numberList2.val && assertNumberList(numberList1.next, numberList2.next));
    }

    @Test
    public void testAssetNumberList() {
        assertTrue(assertNumberList(createNumberList(1234), createNumberList(1234)));
        assertFalse(assertNumberList(createNumberList(1234), createNumberList(12304)));
        assertFalse(assertNumberList(createNumberList(1234), createNumberList(1034)));
    }

    private ListNode createNumberList(int i) {
        if (i == 0)
            return null;

        return new ListNode(i % 10, createNumberList(i/10));
    }

}