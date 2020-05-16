package leetcode.utils;

/**
 * Created by tanmays on 16/5/20.
 */
public class ListNode {

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    private int val;
    private ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    private ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     *
     * @param num   Input number
     * @return      Inverted list of numbers
     */

    public ListNode createNumberList(int num) {
        if (num == 0)
            return null;
        return new ListNode(num % 10, createNumberList(num/10));
    }

    public boolean assertNumberList(ListNode numberList1, ListNode numberList2) {
        return (null == numberList1) ||
                (numberList1.val == numberList2.val
                        && assertNumberList(numberList1.next, numberList2.next));
    }

    public int listToInt(ListNode listNode, int multiplier) {
        if (null == listNode)
            return 0;

        if (null == listNode.next)
            return (listNode.val * multiplier);
        return (listNode.val * multiplier) + listToInt(listNode.next, multiplier * 10);
    }

    /**
     * Returns a cloned list of a given list
     * @param oldList   Original list to clone
     * @return          A cloned ListNode
     */
    ListNode cloneList(ListNode oldList) {
        ListNode newList = null;
        ListNode traversingNode = null;

        while (null != oldList) {
            ListNode tempNode = new ListNode(oldList.val);
            if (newList == null)
                newList = tempNode;
            else
                traversingNode.next = tempNode;
            traversingNode = tempNode;
            oldList = oldList.next;
        }
        return newList;
    }
}
