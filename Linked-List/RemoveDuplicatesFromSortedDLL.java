class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class RemoveDuplicatesFromSortedDLL {
    public static Node uniqueSortedList(Node head) {
        Node temp = head;

        while(temp != null && temp.next != null){
            Node nextNode = temp.next;

            while(nextNode != null){
                if(temp.data == nextNode.data){
                    nextNode = nextNode.next;
                }
            }

            temp.next = nextNode;
            if(nextNode != null) nextNode.prev = temp;

            temp = temp.next;
        }

        return head;
    }
}
