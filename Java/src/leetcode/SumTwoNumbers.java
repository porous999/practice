package leetcode;

/**
 * Created by tanmays on 10/5/20.
 *
 * Prob statement: https://leetcode.com/problems/add-two-numbers/
 */


public class SumTwoNumbers {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return loopedBruteSolution(l1, l2);
    }

    private static ListNode loopedBruteSolution(ListNode l1, ListNode l2) {

        ListNode sumHeadNode = null;
        ListNode traversingNode = null;
        ListNode tempNode;
        int sum;
        int carry = 0;

        while (l1 != null && l2 != null) {

            sum = l1.val + l2.val + carry;
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

            l1 = l1.next;
            l2 = l2.next;
        }

        if (null != l1 || null != l2) {
            tempNode = l1 != null ? l1 : l2;
            if (null == sumHeadNode)
                sumHeadNode = tempNode;
            else {
                tempNode.val = tempNode.val + carry;
                traversingNode.next = tempNode;
            }
        } else if (carry != 0) {
            traversingNode.next = new ListNode(carry);
        }


        return sumHeadNode;
    }
}
