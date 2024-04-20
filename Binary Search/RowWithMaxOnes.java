import java.util.ArrayList;

public class RowWithMaxOnes {

    // // Brute Force
    // public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
    //     int ind = -1;
    //     int maxCount = -1;

    //     for (int i = 0; i < n; i++) {
    //         int cntRow = 0;
    //         for (int j = 0; j < m; j++) {
    //             cntRow += matrix.get(i).get(j);
    //         }

    //         if (cntRow > maxCount) {
    //             maxCount = cntRow;
    //             ind = i;
    //         }
    //     }

    //     return ind;
    // }

    // Optimal Solution

    public static int lowerBound(ArrayList<Integer> arr, int size, int x){
        int low = 0, high = size - 1;
        int ans = size;

        while(low <= high){
            int mid = (low + high) / 2;
            
            if(arr.get(mid) >= x){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int  m){
        int ind = -1;
        int maxCount = -1;

        for(int i = 0; i < n; i++){
            int cntOnes = m - lowerBound(matrix.get(i), m, 1);
            if(cntOnes > maxCount){
                maxCount = cntOnes;
                ind = i;
            }
        }

        return ind;
    }
}
