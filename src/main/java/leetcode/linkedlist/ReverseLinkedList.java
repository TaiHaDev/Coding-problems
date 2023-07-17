package leetcode.linkedlist;

public class ReverseLinkedList {

    /**
     * using two pointer (curr and next) to iteratively reverse the linked list node by node, curr is initial null;
     */
      private class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode curr = null, next = head;
            while (next != null) {
                ListNode tempNext = next.next;
                next.next = curr;
                curr = next;
                next = tempNext;
            }
            return curr;
        }
    }
}
