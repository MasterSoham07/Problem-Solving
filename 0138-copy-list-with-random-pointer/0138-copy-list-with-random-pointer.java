/*
// Definition for a Node.
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
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> mpp = new HashMap<>();
        
        Node temp = head;

        while(temp != null){
            Node newNode = new Node(temp.val);
            mpp.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            Node node = mpp.get(temp);
            node.next = (temp.next != null) ? mpp.get(temp.next):null;
            node.random = (temp.random != null) ? mpp.get(temp.random):null;

            temp = temp.next;
        }

        return mpp.get(head);
    }
}