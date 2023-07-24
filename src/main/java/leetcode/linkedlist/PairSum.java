package leetcode.linkedlist;

public class PairSum {
    public int pairSum(ListNode head) {
        ListNode half = head;
        ListNode end = head;
        while(end.next != null && end.next.next != null) {
            half = half.next;
            end = end.next.next;
        }
        ListNode rev = reverseLinkedList(half);
        int result = 0;
        while(rev != null && head != null) {
            result = Math.max(result, rev.val + head.val);
            rev = rev.next;
            head = head.next;
        }
        return result;
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
