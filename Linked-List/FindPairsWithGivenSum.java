class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
    }
}

public class FindPairsWithGivenSum {
    public static boolean findPair(Node<Integer> head, int k) {
        Node<Integer> temp1 = head;

        while(temp1 != null){
            Node<Integer> temp2 = temp1.next;

            while(temp2 != null){
                if(temp1.data + temp2.data == k && temp1.data + temp2.data < k){
                    return true;
                }

                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        return false;
    }
}
