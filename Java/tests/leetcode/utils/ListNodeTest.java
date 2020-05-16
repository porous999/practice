package leetcode.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tanmays on 16/5/20.
 */
public class ListNodeTest {

    ListNode thisListNode = new ListNode();

    @Test
    public void testCreateNumberList() throws Exception {
    }

    @Test
    public void testAssertNumberList() throws Exception {
    }

    @Test
    public void testListToInt() throws Exception {
    }

    @Test
    public void testCloneList() throws Exception {
        ListNode numberList = thisListNode.createNumberList(1234);
        ListNode newList = thisListNode.cloneList(numberList);
        numberList = null;
        assertEquals(1234, thisListNode.listToInt(newList, 1));
    }

}