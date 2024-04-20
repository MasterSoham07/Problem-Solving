import java.util.Arrays;

public class AggressiveCows {

    // Brute Force..................

    // public static boolean canWePlace(int arr[], int dist, int cows){
    //     int cntCows = 1;
    //     int last = arr[0];
    //     for(int i = 1; i < arr.length; i++){
    //         if(arr[i] - last >= dist){
    //             cntCows++;
    //             last = arr[i];
    //         }
    //     }

    //     if(cntCows >= cows) return true;

    //     return false;
    // }


    // public static int aggressiveCows(int []stalls, int k) {
    //     Arrays.sort(stalls);
        
    //     int n = stalls.length;

    //     int min = stalls[0] , max = stalls[n-1];

    //     for(int i = 0; i <= max - min; i++){
    //         if(canWePlace(stalls, i, k) == true) continue;
    //         else{
    //             return i-1;
    //         }
    //     }

    //     return max-min;
    // }

    // Optimal Approach using Binary Search............

    public static boolean canWePlace(int stalls[], int dist, int cows){
        int cntCows = 1;
        int last = stalls[0];

        for(int i = 0; i < stalls.length; i++){
            if(stalls[i] - last >= dist){
                cntCows++;
                last = stalls[i];
            }
        }

        if(cntCows >= cows) return true;

        return false;
    }

    public static int aggressiveCows(int stalls[], int k){
        Arrays.sort(stalls);

        int low = 1, high = stalls[stalls.length - 1] - stalls[0];

        while(low <= high){
            int mid = (low + high) / 2;

            if(canWePlace(stalls, mid, k) == true){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return high;
    }
}
