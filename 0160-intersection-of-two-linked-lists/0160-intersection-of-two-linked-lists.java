/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;
        
        HashSet<ListNode> st = new HashSet<>();

        while(temp1 != null){
            st.add(temp1);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            if(st.contains(temp2)){
                return temp2;
            }

            temp2 = temp2.next;
        }

        return null;
    }
}