class ListNode {
    int val;
    ListNode next;
    ListNode (int val) {
        this.val = val;
    }
}

public class ReverseLinkedList {
    public static ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public static ListNode reverseRecursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
