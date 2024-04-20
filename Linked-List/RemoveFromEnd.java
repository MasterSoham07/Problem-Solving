class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveFromEnd {

    // Brute Force

    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode temp = head;

    //     int cnt = 0;

    //     while(temp != null){
    //         cnt++;
    //         temp = temp.next;
    //     }

    //     int res = cnt - n;

    //     if(res == 0){
    //         return head.next;
    //     }

    //     temp = head;

    //     while(temp != null){
    //         res--;
    //         if(res == 0) break;

    //         temp = temp.next;
    //     }

    //     ListNode delNode = temp.next;
    //     temp.next = temp.next.next;

    //     return head;
    // }

    // Optimal Solution

    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode fast = head, slow = head;

        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode delNode  = slow.next;
        slow.next = slow.next.next;

        return head;
    }
}
