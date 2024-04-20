class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class SegregateEvenAndOddNodes {
    public static Node segregateEvenOdd(Node head) {
        if (head == null || head.next == null)
            return head;
        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;

        Node temp = head;

        while (temp != null) {
            if (temp.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = temp;
                    evenTail = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = temp;
                }
            }

            else if (temp.data % 2 == 1) {
                if (oddHead == null) {
                    oddHead = temp;
                    oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = temp;
                }
            }

            temp = temp.next;
        }

        if (evenHead != null) {
            evenTail.next = oddHead;
            if (oddTail != null)
                oddTail.next = null;
            return evenHead;
        }

        return oddHead;

    }
}
