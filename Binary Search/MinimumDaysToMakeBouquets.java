public class MinimumDaysToMakeBouquets {

    public static int findMin(int arr[]){
        int minimum = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            minimum = Math.min(minimum, arr[i]);
        }

        return minimum;
    }

    public static int findMax(int arr[]){
        int maximum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            maximum = Math.max(maximum, arr[i]);
        }

        return maximum;
    }

    public static boolean possible(int arr[], int mid, int r, int b){
        int cnt = 0, noOfBouquets = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= mid){
                cnt++;
            }
            else{
                noOfBouquets += (cnt / r);
                cnt = 0;
            }
        }

        noOfBouquets += (cnt / r);

        if(noOfBouquets >= b) return true;
        return false;
    }

    public static int roseGarden(int[] arr, int r, int b) {
        int low = findMin(arr), high = findMax(arr);
        int ans = -1;

        if(r*b > arr.length) return -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(possible(arr, mid, r, b) == true){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}
