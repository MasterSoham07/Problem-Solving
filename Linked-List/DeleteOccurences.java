class Node {
    public int data;
    public Node next;
    public Node prev;

    Node()
    {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    Node(int data, Node next, Node prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class DeleteOccurences {
    public static Node deleteAllOccurrences(Node head, int k) {
        Node temp = head;
        
        while(temp != null){
            if(temp.data == k){
                if(temp == head){
                    head = head.next;
                }

                Node newNode = temp.next;
                Node prevNode = temp.prev;

                if(newNode != null)newNode.prev = prevNode;
                if(prevNode != null)prevNode.next = newNode;

                temp = newNode;
            }

            else{
                temp = temp.next;
            }
        }

        return head;
    }
}
