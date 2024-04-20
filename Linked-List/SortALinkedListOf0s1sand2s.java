class Node {
    public int data;
    public Node next;
   
    Node()
    {
        this.data = 0;
        this.next = null;
    }
   
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
   
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

public class SortALinkedListOf0s1sand2s {

    // Brute Force

    // public static Node sortList(Node head){
    //     Node temp = head;
    //     int cnt0 = 0, cnt1 = 0, cnt2 = 0;

    //     while(temp != null){
    //         if(temp.data == 0) cnt0++;
    //         else if(temp.data == 1) cnt1++;
    //         else cnt2++;

    //         temp = temp.next;
    //     }

    //     temp = head;

    //     while(temp != null){
    //         if(cnt0 != 0){
    //             temp.data = 0;
    //             cnt0 --;
    //         }
    //         else if(cnt1 != 0){
    //             temp.data = 1;
    //             cnt1--;
    //         }
    //         else{
    //             temp.data = 2;
    //             cnt2--;
    //         }

    //         temp = temp.next;
    //     }

    //     return head;
    // }


    // Optimal Solution

    public static Node sortList(Node head){
        Node zeroHead = new Node(-1), zero = zeroHead;
        Node oneHead = new Node(-1), one = oneHead;
        Node twoHead = new Node(-1), two = twoHead;

        Node temp = head;

        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = temp;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = temp;
            }
            else{
                two.next = temp;
                two = temp;
            }

            temp = temp.next;
        }

        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }
}
