/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // brute force
    // public boolean isPalindrome(ListNode head) {
    //     Stack<Integer> st = new Stack<>();

    //     ListNode temp = head;

    //     while(temp != null){
    //         st.push(temp.val);
    //         temp = temp.next;
    //     }

    //     temp = head;

    //     while(temp != null){
    //         if(temp.val != st.pop()) return false;
    //         temp = temp.next;
    //     }

    //     return true;
    // }

    // Optimal Solution

    public ListNode reverse(ListNode head){
        ListNode temp = head, prev = null;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head){
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow.next);

        ListNode first = head, second = newHead;

        while(second != null){
            if(first.val != second.val){
                reverse(newHead);
                return false;
            }

            first = first.next;
            second = second.next;
        }

        reverse(newHead);
        return true;
    }

}