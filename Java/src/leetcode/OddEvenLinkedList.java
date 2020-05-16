package leetcode;

import leetcode.utils.ListNode;

/**
 * Created by tanmays on 16/5/20.
 * Prob statement: https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/
 */

class OddEvenLinkedList {

    ListNode oddEvenList(ListNode head) {
        ListNode oddLast = null;
        ListNode evenLast = null;
        ListNode evenHead = null;
        ListNode tempNode = head;

        while (null != tempNode) {
            if (tempNode == head) {
                evenHead = tempNode.getNext();
                evenLast = evenHead;
                oddLast = head;
            } else {
                if (evenLast != null)
                    evenLast.setNext(tempNode.getNext());
                if (null != tempNode.getNext())
                    evenLast = tempNode.getNext();
            }
            tempNode.setNext(null == evenLast? null: evenLast.getNext());
            if (tempNode.getNext() != null)
                oddLast = tempNode.getNext();
            tempNode = tempNode.getNext();
        }
        if (null != oddLast)
            oddLast.setNext(evenHead);
        return head;
    }
}
