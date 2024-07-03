import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CloneLinkedListWithNextAndRandomPointers {

    // Brute Force

    // public Node copyRandomList(Node head) {
    //     HashMap<Node, Node> mpp = new HashMap<>();
        
    //     Node temp = head;

    //     while(temp != null){
    //         Node newNode = new Node(temp.val);
    //         mpp.put(temp, newNode);
    //         temp = temp.next;
    //     }

    //     temp = head;

    //     while(temp != null){
    //         Node node = mpp.get(temp);
    //         node.next = (temp.next != null) ? mpp.get(temp.next):null;
    //         node.random = (temp.random != null) ? mpp.get(temp.random):null;

    //         temp = temp.next;
    //     }

    //     return mpp.get(head);
    // }

    // Optimal Solution

    public Node copyRandomList(Node head){
        Node temp = head;

        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;

            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }

            temp = temp.next.next;
        }

        Node dummy = new Node(0);
        temp = head;
        Node res = dummy;
        
        while(temp != null){
            res.next = temp.next;
            temp.next = temp.next.next;

            res = res.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
