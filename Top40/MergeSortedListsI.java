// Problem: Merge Two Sorted Lists
// Given:
// Two sorted singly linked lists l1 and l2.

// l1: 1 → 3 → 5
// l2: 2 → 4 → 6

// Output: 1 → 2 → 3 → 4 → 5 → 6

//intuition : 
// use a dummy node to start the result list
//keep comparing the current nodes of both lists
//append the smaller node to the result list
//move that list's pointer ahead
//when one lost ends , append the remaining part of the other

class ListNode {
    int val;
    ListNode next;
    ListNode (int val) {
        this.val = val;
    }
}

public class MergeSortedListsI {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        //attach the remaining
        current.next = (l1 != null)? l1: l2;
        return dummy.next;
    }
}
