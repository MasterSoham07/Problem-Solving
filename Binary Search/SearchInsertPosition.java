public class SearchInsertPosition {
    public static int searchInsert(int [] arr, int m){
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;

        while(low <= high){
            int mid = (high + low)/ 2;

            if(arr[mid] >= m){
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
