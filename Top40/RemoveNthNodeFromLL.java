//Given the head of a linked list, remove the nth node from the end and return the head.

//You can’t directly access the nth node from the end in a singly linked list. But if you use two pointers, and keep a gap of n nodes between them, then when the first pointer hits the end, the second will be right before the node to be deleted.

//brute force
/*
1. Traverse the entire list to count the length
2. calculate position l-n from the start
3. traverse again and delete that node
 */
public class RemoveNthNodeFromLL {
    public static ListNode deleteNthNode(ListNode head, int n) { // O(n) T.C and O(1) S.C
        ListNode curr = head;
        int length = 0;
        while (curr!= null) {
            length += 1;
            curr = curr.next;
        }
        if(length == n) { //delete head
            head = head.next;
        }
        int deletePos = length - n;
        curr = head;
        int i = 0;
        while(curr!= null && i < deletePos - 1) {
            curr = curr.next;
            i++;
        } 
        curr.next = curr.next.next;
        return head;
    }
    /*
    optimised approach
    -> Use a dummy node to handle edge cases cleanly.
    -> move the first pointer n+1 steps ahead (including dummy)
    -> move both pointers until the first hits the end
    -> now the second pointer is just before the node to delete
     */

    public static ListNode deleteNthNodeOptimised(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode first = newHead;
        ListNode last = newHead;

        int f = 0;
        int l = 0;
        while(last != null) {
            if(l- f== n+1) {
                f++;
                l++;
                first = first.next;
                last = last.next;
            } else {
                l++;
                last = last.next;
            }
        }
        first.next = first.next.next;
        return newHead.next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode last = dummy;

        for(int i=0; i<=n ; i++) {
            last = last.next;
        }
        while(last != null) {
            first = first.next;
            last = last.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
