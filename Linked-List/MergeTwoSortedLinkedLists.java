import java.util.ArrayList;
import java.util.Collections;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class MergeTwoSortedLinkedLists {

    // Brute Force

    // public static LinkedListNode<Integer> convertToLL(ArrayList<Integer> arr){
    //     LinkedListNode head = new LinkedListNode(arr.get(0));
    //     LinkedListNode<Integer> temp = head;

    //     for(int i = 1; i < arr.size(); i++){
    //         LinkedListNode newNode = new LinkedListNode(arr.get(i));
    //         temp.next = newNode;
    //         temp = temp.next;
    //     }

    //     return head;

    // }
    // public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
	// 	LinkedListNode<Integer> temp1 = first, temp2 = second;

    //     ArrayList<Integer> arr = new ArrayList<>();

    //     while(temp1 != null){
    //         arr.add(temp1.data);
    //         temp1 = temp1.next;
    //     }

    //     while(temp2 != null){
    //         arr.add(temp2.data);
    //         temp2 = temp2.next;
    //     }

    //     Collections.sort(arr);

    //     LinkedListNode<Integer> temp = convertToLL(arr);
        
    //     return temp;
	// }

    // Optimal Approach using 2 pointer

    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second){
        LinkedListNode<Integer> t1 = first, t2 = second;

        LinkedListNode<Integer> dummyNode = new LinkedListNode(-1);

        LinkedListNode<Integer> temp = dummyNode;

        while(t1 != null && t2 != null){
            if(t1.data < t2.data){
                temp.next = t1;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                t2 = t2.next;
            }

            temp = temp.next;
        }

        if(t1 != null){
            temp.next = t1;
            temp = temp.next;
        }

        if(t2 != null){
            temp.next = t2;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}
