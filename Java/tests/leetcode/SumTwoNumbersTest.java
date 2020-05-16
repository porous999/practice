package leetcode;

import leetcode.utils.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tanmays on 10/5/20.
 */
public class SumTwoNumbersTest {

    private SumTwoNumbers testSumTwoNumbers = new SumTwoNumbers();
    private ListNode listNode = new ListNode();

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

    private boolean assertCorrectSum(int num1, int num2) {
        ListNode sumList = testSumTwoNumbers.addTwoNumbers(listNode.createNumberList(num1),
                listNode.createNumberList(num2));
        System.out.printf("%d + %d => Expected: %d ; Calculated: %d\n",
                num1, num2, num1 + num2, listNode.listToInt(sumList, 1));
        return listNode.assertNumberList(listNode.createNumberList(num1 + num2), sumList);
    }

    @Test
    public void testAssetNumberList() {
        assertTrue(listNode.assertNumberList(listNode.createNumberList(1234),
                listNode.createNumberList(1234)));

        assertFalse(listNode.assertNumberList(listNode.createNumberList(1234),
                listNode.createNumberList(12304)));

        assertFalse(listNode.assertNumberList(listNode.createNumberList(1234),
                listNode.createNumberList(1034)));
    }

}