public class KokoEatingBananas {

    public static int findMax(int[] arr){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    public static int calculateHours(int[] arr, int hourly){
        int totalHours = 0;
        for(int i = 0; i < arr.length; i++){
            totalHours += Math.ceil((double)(arr[i]) / (double)(hourly));
        }
        return totalHours;
    }
    public static int minimumRateToEatBananas(int []v, int h) {
        int low = 0, high = findMax(v);
        while(low <= high){
            int mid = (low + high) / 2;
            int totalHours = calculateHours(v, mid);
            if(totalHours <= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }
}
