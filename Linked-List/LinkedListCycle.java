import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    // Brute Force
    // public boolean hasCycle(ListNode head) {
    //     ListNode temp = head;
        
    //     HashMap<ListNode, Integer> mpp = new HashMap<>();

    //     while(temp != null){
    //         if(mpp.containsKey(temp)) return true;
    //         else{
    //             mpp.put(temp, 1);
    //         }

    //         temp = temp.next;
    //     }

    //     return false;
    // }

    // Optimal Approach

    public boolean hasCycle(ListNode head){
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }
}
