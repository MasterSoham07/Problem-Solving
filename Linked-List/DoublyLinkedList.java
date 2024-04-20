class Node{
    public int data;
    public Node next;
    public Node back;

    Node(){
        this.data = 0;
        this.next = null;
        this.back = null;
    }

    Node(int data){
        this.data = data;
        this.next = null;
        this.back = null;
    }

    Node(int data, Node next, Node back){
        this.data = data;
        this.next = next;
        this.back = back;
    }
}

public class DoublyLinkedList {

    public static Node convert2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;

        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    public static void print(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node deleteHead(Node head){
        if(head == null || head.next == null) return null;

        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;

        return head;
    }

    public static Node deleteTail(Node head){
        if(head == null || head.next == null) return null;

        Node tail = head;

        while(tail.next != null){
            tail = tail.next;
        }

        Node prev = tail.back;
        prev.next = null;
        tail.back = null;

        return head;
    }

    public static Node deleteK(Node head, int k){

        if(head == null) return null;
        Node temp = head;
        int cnt = 0;

        while(temp != null){
            cnt++;
            if(cnt == k) break;

            temp = temp.next;
        }

        Node prev = temp.back;
        Node front = temp.next;

        if(prev == null && front == null){
            return null;
        }

        if(prev == null){
            return deleteHead(head);
        }

        if(front == null){
            return deleteTail(head);
        }

        prev.next = front;
        front.back = prev;

        temp.back = null;
        temp.next = null;

        return head;
    }

    public static void deleteNode(Node temp){
        Node prev = temp.back;
        Node front = temp.next;

        if(front == null){
            prev.next = null;
            temp.back = null;

            return;
        }

        prev.next = front;
        front.back = prev;

        temp.back = null;
        temp.next = null;
    }

    public static Node insertHead(Node head, int val){
        Node temp = new Node(val, head, null);
        head.back = temp;

        return temp;
    }

    public static Node insertTail(Node head, int val){

        if(head.next == null){
            return insertHead(head, val);
        }
        Node tail = head;

        while(tail.next != null){
            tail = tail.next;
        }

        Node prev = tail.back;

        Node newNode = new Node(val, tail, prev);

        prev.next = newNode;
        tail.back = newNode;

        return head;
    }

    public static Node insertK(Node head, int k, int val){
        if(k == 1){
            return insertHead(head, val);
        }

        Node temp = head;
        int cnt = 0;

        while(temp != null){
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }

        Node prev = temp.back;

        Node newNode = new Node(val, temp, prev);
        prev.next = newNode;
        temp.back = newNode;

        return head;
    }

    public static void insertNode(Node node, int val){
        Node prev = node.back;

        Node newNode = new Node(val, node, prev);
        prev.next = newNode;
        node.back = newNode;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 10};

        Node head = convert2DLL(arr);   
        print(head);

        System.out.println();

        insertNode(head.next.next.next.next, 16);
        print(head);
    }
}
