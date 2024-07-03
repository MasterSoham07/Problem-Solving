class Node {
    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddOneToLinkedList {

    // // Brute Force

    // public static Node reverse(Node head){
    // Node temp = head, prev = null;

    // while(temp != null){
    // Node front = temp.next;
    // temp.next = prev;
    // prev = temp;
    // temp = front;
    // }

    // return prev;
    // }
    // public static Node addOne(Node head) {
    // head = reverse(head);
    // Node temp = head;
    // int carry = 1;

    // while(temp != null){
    // temp.data = temp.data + carry;

    // if(temp.data < 10){
    // carry = 0;
    // break;
    // }
    // else{
    // temp.data = 0;
    // carry = 1;
    // }

    // temp = temp.next;
    // }

    // if(carry == 1){
    // Node newNode = new Node(1);

    // head = reverse(head);
    // newNode.next = head;
    // return newNode;
    // }

    // head = reverse(head);
    // return head;
    // }

    // Optimal Approach using recursion and Backtracking

    public static int helper(Node head) {
        Node temp = head;
        if (temp == null)
            return 1;

        int carry = helper(temp.next);
        temp.data = temp.data + carry;

        if (temp.data < 10)
            return 0;
        temp.data = 0;
        return 1;
    }

    public static Node addOne(Node head) {
        int carry = helper(head);

        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }

        return head;
    }
}
