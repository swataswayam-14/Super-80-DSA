// Linked List Cycle Detection
// Given:
// A singly linked list.

// Goal:
// Return true if the list contains a cycle, otherwise false.

// Intuition
// A cycle means that at least one node’s next pointer connects back to a previous node, causing infinite traversal.

/* 
| Approach    | Description                                   | Time | Space |
| ----------- | --------------------------------------------- | ---- | ----- |
| Brute Force | Use a `HashSet` to track visited nodes        | O(n) | O(n)  |
| Optimized   | Use Floyd’s Cycle Detection (Tortoise & Hare) | O(n) | O(1)  |
*/

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class CycleDetectLL {
    public static boolean detectCycleBrute(ListNode head) {
        if(head == null || head.next == null) return false;
        Set<ListNode> hash = new HashSet<>();

        ListNode temp = head;
        while(temp != null) {
            if(hash.contains(temp)) return true;
            hash.add(temp);
            temp = temp.next;
        }
        return false;
    }

    //optimised : slow moves 1 step , fast moves 2 steps , they will meet at some point if there is a cycle , if no then fast will be null
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
