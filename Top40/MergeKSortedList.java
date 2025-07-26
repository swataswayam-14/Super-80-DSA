//Problem: Merge k Sorted Linked Lists
// Given: An array of k sorted linked lists.

// Goal: Merge them into a single sorted linked list.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKSortedList {
    //brute : collect all values , sort and rebuild a new list -> O(nlogn)
    //optimised 1: use min heap (priority queue) -> O(nlogk)    
    //optimised 2: use divide and conquer (like merge sort) -> O(nlogk)

    //input: [[1,5,6], [2,4,5], [1,3,7]]
    //output: [1,1,2,3,4,5,5,6,7]
    public static ListNode mergeKListsBrute(ListNode[] lists) {
        List<Integer> allValues = new ArrayList<>();
        for(ListNode node: lists) {
            while(node != null) {
                allValues.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(allValues);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for(int val: allValues) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
    public static ListNode mergeKListsHeap(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> a.val - b.val 
        );
        for(ListNode node: lists) {
            if(node != null) pq.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            tail = tail.next;
            if(smallest.next != null) {
                pq.add(smallest.next);
            }
        }
        return dummy.next;
    }
    public static ListNode mergeKListsDivide(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeRange(lists, 0, lists.length - 1);
    }
    private static ListNode mergeRange(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = mergeRange(lists, left, mid);
        ListNode l2 = mergeRange(lists, mid+1, right);
        return mergeTwoLists(l1,l2);
    }
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 !=null) ? l1 : l2;
        return dummy.next;
    }
}
