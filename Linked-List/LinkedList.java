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

public class LinkedList {
    public static Node ConvertArr2LL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public static int lengthOfLinkedList(Node head) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }

    public static int checkPresent(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val)
                return 1;
            temp = temp.next;
        }

        return -1;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node removesHead(Node head) {
        if (head == null)
            return head;

        head = head.next;
        return head;
    }

    public static Node removeTail(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    public static Node removeK(Node head, int k) {
        if (head == null)
            return head;
        if (k == 1) {
            head = head.next;
            return head;
        }

        int cnt = 0;
        Node temp = head, prev = null;

        while (temp != null) {
            cnt++;
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;

    }

    public static Node removeEl(Node head, int el) {
        if (head == null)
            return head;
        if (head.data == el) {
            head = head.next;
            return head;
        }

        Node temp = head, prev = null;

        while (temp != null) {
            if (temp.data == el) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;

    }

    public static Node insertHead(Node head, int val){
        Node temp = new Node(val, head);

        return temp;
    }

    public static Node insertLast(Node head, int val){
        if(head == null){
            return new Node(val);
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        Node newNode = new Node(val);
        temp.next = newNode;

        return head;
    }

    public static Node insertK(Node head, int el, int k){
        if(head == null){
            if(k == 1) return new Node(el);
            else return null;
        }

        if(k == 1){
            Node temp = new Node(el, head);
            return temp;
        }

        int cnt = 0;
        Node temp = head;

        while(temp != null){
            cnt++;
            if(cnt == k - 1){
                Node x = new Node(el);
                x.next = temp.next;
                temp.next = x;
                break;
            }

            temp = temp.next;
        }

        return head;
    }

    public static Node insertBeforeVal(Node head, int el, int val){
        if(head == null) return null;
        if(head.data == val){
            Node temp = new Node(el, head);
            return temp;
        }

        Node temp = head;

        while(temp != null){
            if(temp.next.data == val){
                Node x = new Node(el);
                x.next = temp.next;
                temp.next = x;
                break;
            }

            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 5, 6, 8 };
        Node head = ConvertArr2LL(arr);
        // System.out.println(head.data);

        // print(head);

        // System.out.println(lengthOfLinkedList(head));

        // System.out.println(checkPresent(head, 4));

        head = insertBeforeVal(head, 7, 6); 
        print(head);
    }

}