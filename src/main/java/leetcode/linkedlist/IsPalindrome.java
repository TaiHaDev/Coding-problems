package leetcode.linkedlist;

public class IsPalindrome {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ReverseLinkedList.ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode end = head;
        ListNode half = head;
        while(end != null && end.next != null) {
            end = end.next.next;
            half = half.next;
        }
        ListNode temp = reverse(half);
        while (temp != null && head != null) {
            if (temp.val != head.val) return false;
            temp = temp.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode fst = null;
        ListNode snd = null;
        ListNode cur = head;
        while(cur != null) {
            fst = snd;
            snd = cur;
            cur = cur.next;
            snd.next = fst;
        }
        return snd;
    }
}
