import java.util.ArrayList;

public class PaintersPartition {

    public static int countPainters(ArrayList<Integer> boards, int sum){
        int painters = 1, painterBoards = 0;

        for(int i = 0; i < boards.size(); i++){
            if(painterBoards + boards.get(i) <= sum){
                painterBoards += boards.get(i);
            }
            else{
                painters++;
                painterBoards = boards.get(i);
            }
        }

        return painters;
    }


        public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for(int i = 0; i < boards.size(); i++){
            if(boards.get(i) > low) low = boards.get(i);
            high += boards.get(i);
        }

        while(low <= high){
            int mid = (low + high) / 2;

            if(countPainters(boards, mid) <= k){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }
}
