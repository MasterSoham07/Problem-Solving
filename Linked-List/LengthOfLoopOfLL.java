import java.util.HashMap;

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
};

public class LengthOfLoopOfLL {

    // Approach 1
    // public static int lengthOfLoop(Node head) {
    // Node temp = head;
    // HashMap<Node, Integer> mpp = new HashMap<>();
    // int cnt = 0;

    // while(temp != null){
    // if(mpp.containsKey(temp)){
    // return cnt - mpp.get(temp);
    // }

    // mpp.put(temp, cnt++);
    // temp = temp.next;
    // }

    // return 0;
    // }

    // Approach 2

    public static int findLength(Node slow, Node fast) {
        int cnt = 1;
        fast = fast.next;
        while (slow != fast) {
            cnt++;
            fast = fast.next;
        }

        return cnt;
    }

    public static int lengthOfLoop(Node head) {
        Node fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return findLength(slow, fast);
            }
        }
        return 0;
    }
}
