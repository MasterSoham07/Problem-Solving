/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // // Brute Force
    // public ListNode detectCycle(ListNode head) {
    //     HashMap<ListNode, Integer> mpp = new HashMap<>();

    //     ListNode temp = head;

    //     while(temp != null){
    //         if(mpp.containsKey(temp)){
    //             return temp;
    //         }
    //         else{
    //             mpp.put(temp, 1);
    //         }

    //         temp = temp.next;
    //     }

    //     return null;
    // }

    // Optimal Solution

    public ListNode detectCycle(ListNode head){

        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head, entry = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                while(entry != slow){
                    slow = slow.next;
                    entry = entry.next;
                }

                return entry;
            }
        }

        return null;
    }
}