package leetcode;

/**
 * Created by tanmays on 10/5/20.
 *
 * Prob statement: https://leetcode.com/problems/add-two-numbers/
 */


class SumTwoNumbers {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return loopedSolution(l1, l2);
    }

    private static ListNode loopedSolution(ListNode l1, ListNode l2) {

        ListNode sumHeadNode = null;
        ListNode traversingNode = null;
        ListNode tempNode;
        int sum;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            sum = (null == l1? 0 : l1.val) + (null == l2? 0 : l2.val) + carry;
            carry = sum / 10;
            tempNode = new ListNode(sum % 10);

            if (null != traversingNode) {
                traversingNode.next = tempNode;
                traversingNode = tempNode;
            }

            if (null == sumHeadNode) {
                sumHeadNode = tempNode;
                traversingNode = tempNode;
            }

            if (null != l1)
                l1 = l1.next;
            if (null != l2)
                l2 = l2.next;
        }

        return sumHeadNode;
    }
}
