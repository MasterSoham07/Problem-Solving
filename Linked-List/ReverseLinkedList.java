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

public class ReverseLinkedList {

    // Iterative Approach
    // public ListNode reverseList(ListNode head) {
    //     ListNode temp = head, prev = null;
        
    //     while(temp != null){
    //         ListNode front = temp.next;
    //         temp.next = prev;
    //         prev = temp;
    //         temp = front;
    //     }

    //     return prev;
    // }

    // Recursive Approach

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
}
