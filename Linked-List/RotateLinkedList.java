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

public class RotateLinkedList {

    public ListNode findNewLastNode(ListNode head, int cnt) {
        ListNode temp = head;

        cnt = cnt - 1;

        while (temp != null && cnt > 0) {
            cnt--;
            temp = temp.next;
        }

        return temp;
    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) return null;
        
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        if (k % len == 0)
            return head;
        k = k % len;

        tail.next = head;

        ListNode newLastNode = findNewLastNode(head, len - k);

        head = newLastNode.next;
        newLastNode.next = null;

        return head;
    }
}
