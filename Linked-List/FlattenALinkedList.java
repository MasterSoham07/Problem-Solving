import java.util.ArrayList;
import java.util.Collections;

class Node {
    public int data;
    public Node next;
    public Node child;

    Node() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }

    Node(int data, Node next, Node child) {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}

public class FlattenALinkedList {

    // // Brute Force

    // public static Node convertToLL(ArrayList<Integer> arr){
    //     Node head = new Node(arr.get(0));

    //     Node temp = head;

    //     for(int i = 1; i < arr.size(); i++){
    //         Node newNode = new Node(arr.get(i));
    //         temp.child = newNode;
    //         temp = temp.child;
    //     }

    //     return head;
    // }

    // public static Node flattenLinkedList(Node head) {
    //     Node temp = head;

    //     ArrayList<Integer> arr = new ArrayList<>();

    //     while (temp != null) {
    //         Node t2 = temp;
    //         while (t2 != null) {
    //             arr.add(t2.data);
    //             t2 = t2.child;
    //         }
    //         temp = temp.next;
    //     }

    //     Collections.sort(arr);

    //     head = convertToLL(arr);

    //     return head;
    // }

    // Optimal Solution using Recursion and Backtracking

    public static Node merge(Node head1, Node head2){
        Node temp1 = head1, temp2 = head2;

        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while(temp1 != null && temp2 != null){
            if(temp1.data < temp2.data){
                temp.child = temp1;
                temp1 = temp1.child;
            }
            else{
                temp.child = temp2;
                temp2 = temp2.child;
            }

            temp = temp.child;
        }

        if(temp1 != null){
            temp.child = temp1;
        }
        else{
            temp.child = temp2; 
        }

        return dummyNode.next;
    }

    public static Node flattenLinkedList(Node head){

        if(head == null || head.next == null) return head;

        Node mergerdList = flattenLinkedList(head.next);

        head = merge(head, mergerdList);

        return head;
    }
}
