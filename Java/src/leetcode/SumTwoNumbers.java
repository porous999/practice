package leetcode;

import leetcode.utils.ListNode;

/**
 * Created by tanmays on 10/5/20.
 *
 * Prob statement: https://leetcode.com/problems/add-two-numbers/
 */


class SumTwoNumbers {

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // return loopedSolution(l1, l2);
        return recursiveSolution(l1, l2, 0);
    }

    private ListNode recursiveSolution(ListNode numlist1, ListNode numlist2, int carry) {

        if (null == numlist1 && null == numlist2)
            return carry != 0? new ListNode(carry): null;
        else {
            int sum = (null == numlist1? 0 : numlist1.getVal()) + (null == numlist2? 0 : numlist2.getVal()) + carry;
            carry = sum / 10;
            ListNode tempNode = new ListNode(sum % 10);
            if (numlist1 != null && numlist2 != null)
                tempNode.setNext(recursiveSolution(numlist1.getNext(), numlist2.getNext(), carry));
            else if(numlist1 == null)
                tempNode.setNext(recursiveSolution(null, numlist2.getNext(), carry));
            else
                tempNode.setNext(recursiveSolution(numlist1.getNext(), null, carry));

            return tempNode;
        }
    }

    private static ListNode loopedSolution(ListNode l1, ListNode l2) {

        ListNode sumHeadNode = null;
        ListNode traversingNode = null;
        ListNode tempNode;
        int sum;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            sum = (null == l1? 0 : l1.getVal()) + (null == l2? 0 : l2.getVal()) + carry;
            carry = sum / 10;
            tempNode = new ListNode(sum % 10);

            if (null != traversingNode) {
                traversingNode.setNext(tempNode);
                traversingNode = tempNode;
            }

            if (null == sumHeadNode) {
                sumHeadNode = tempNode;
                traversingNode = tempNode;
            }

            if (null != l1)
                l1 = l1.getNext();
            if (null != l2)
                l2 = l2.getNext();
        }

        return sumHeadNode;
    }
}
