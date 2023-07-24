package leetcode.linkedlist;



  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class ReorderList143 {
    public void reorderList(ListNode head) {
        ListNode mid = head;
        ListNode end = head;
        while (end.next != null && end.next.next != null) {
            mid = mid.next;
            end = end.next.next;
        }
        ListNode rev = reverseLinkedList(mid);
        ListNode start = head;
        while (rev != null) {
            ListNode temp = start.next;
            ListNode temp2 = rev.next;
            start.next = rev;
            rev.next = temp;
            start = temp;
            rev = temp2;
        }
    }
    public ListNode reverseLinkedList(ListNode node) {
        ListNode fst = null;
        ListNode snd = null;
        ListNode cur = node;
        while(cur != null) {
            ListNode temp = cur.next;
            fst = snd;
            snd = cur;
            snd.next = fst;
            cur = temp;
        }
        return snd;
    }
}
