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
    // Approach 1
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode temp1 = headA, temp2 = headB;
        
    //     HashSet<ListNode> st = new HashSet<>();

    //     while(temp1 != null){
    //         st.add(temp1);
    //         temp1 = temp1.next;
    //     }

    //     while(temp2 != null){
    //         if(st.contains(temp2)){
    //             return temp2;
    //         }

    //         temp2 = temp2.next;
    //     }

    //     return null;
    // }

    // Approach 2

    public ListNode collisionPoint(ListNode t1, ListNode t2, int d){
        while(d != 0){
            d--;
            t2 = t2.next;
        }

        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){

        ListNode temp1 = headA, temp2 = headB;

        int n1 = 0, n2 =0;
        while(temp1 != null){
            n1++;
            temp1 = temp1.next;
        }

        while(temp2 != null){
            n2++;
            temp2 = temp2.next;
        }

        if(n1 < n2) return collisionPoint(headA, headB, n2 - n1);
        else return collisionPoint(headB, headA, n1 - n2);
    }
}