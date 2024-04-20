import java.util.Stack;

class Node{
    int data;
    Node next;
    Node back;

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

public class ReverseDLL {

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

    // Brute Force

    // public static Node reverseDLL(Node head){
    //     Stack<Integer> st = new Stack<>();

    //     Node temp = head;

    //     while(temp != null){
    //         st.push(temp.data);
    //         temp = temp.next;
    //     }

    //     temp = head;

    //     while(temp != null){
    //         temp.data = st.pop();
    //         temp = temp.next;
    //     }

    //     return head;
    // }

    // Optimal Solution

    public static Node reverseDLL(Node head){

        if(head == null || head.next == null){
            return head;
        }
        Node last = null, current = head;

        while(current != null){
            last = current.back;
            current.back = current.next;
            current.next = last;

            current = current.back;
        }

        return last.back;
    }
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 1, 23, 89};

        Node head = convert2DLL(arr);
        print(head);

        System.out.println();

        head = reverseDLL(head);
        print(head);
    }
}
