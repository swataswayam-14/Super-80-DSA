/*
Problem Statement

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list (also in reverse order).

*/

// l1 = [2 → 4 → 3], l2 = [5 → 6 → 4]  
// Represents: 342 + 465 = 807
// Output: [7 → 0 → 8]

//Intuition 
//think of column wise addision in math
// add digit at corresponding positions
//keep track of carry if sum >= 10.
// traverse both lists from left to right (since they are in reverse order)
//add correspoding digits and carry -> create new nodes for the result

//BRUTE FORCE
/*
 * convert each ll to a number
 * add the numbers
 * convert the result back to a ll
 */

import java.util.Stack;

public class AddNumbersLL {
    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        Stack<Integer> st = new Stack<>();

        while(head1 != null) {
            st.push(head1.val);
            head1 = head1.next;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        int num1 = Integer.parseInt(sb.toString());

        sb = new StringBuilder();

        while(head2 != null) {
            st.push(head2.val);
            head2 = head2.next;
        }
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        int num2 = Integer.parseInt(sb.toString());
        int sum = num1 + num2;
        ListNode sumList = new ListNode(0);
        ListNode curr = sumList;
        do {
            int lastDigit = sum%10;
            curr.next = new ListNode(lastDigit);
            curr = curr.next;
            sum = sum/10;
        } while(sum != 0);
        return sumList.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
        }
        return dummy.next;
    }
}
