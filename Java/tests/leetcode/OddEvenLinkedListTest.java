package leetcode;

import leetcode.utils.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by tanmays on 16/5/20.
 */
public class OddEvenLinkedListTest {

    private ListNode listNode = new ListNode();
    private OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

    private void assertOddEvenList(int input, int expected) {
        ListNode inputList = listNode.createNumberList(input);
        ListNode expectedList = listNode.createNumberList(expected);
        ListNode actualList = oddEvenLinkedList.oddEvenList(inputList);
        System.out.format("Input: %d Expected: %d; Actual: %d%n", listNode.listToInt(inputList, 1),
                listNode.listToInt(expectedList, 1), listNode.listToInt(actualList, 1));
        assertTrue(listNode.assertNumberList(expectedList, actualList));
    }

    @Test
    public void testOddEvenList() throws Exception {
        assertOddEvenList(123, 213);
        assertOddEvenList(123456, 135246);
        assertOddEvenList(12, 12);

    }

}