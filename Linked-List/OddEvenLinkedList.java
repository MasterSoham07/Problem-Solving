import java.util.ArrayList;

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

public class OddEvenLinkedList {

    // Brute Force
    // public ListNode oddEvenList(ListNode head) {
        
    //     if(head == null || head.next == null) return head;
        
    //     ListNode temp = head;
    //     ArrayList<Integer> arr = new ArrayList<>();
        
    //     while(temp != null && temp.next != null){
    //         arr.add(temp.val);
    //         temp = temp.next.next;
    //     }
    //     if(temp != null) arr.add(temp.val);

    //     temp = head.next;

    //     while(temp != null && temp.next != null){
    //         arr.add(temp.val);
    //         temp = temp.next.next;
    //     }
    //     if(temp != null) arr.add(temp.val);

    //     int i =0;
    //     temp = head;

    //     while(temp != null){
    //         temp.val = arr.get(i);
    //         i++;
    //         temp = temp.next;
    //     }

    //     return head;
    // }

    // Optimal Solution

    public ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode odd = head, even = head.next, evenHead = head.next;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
