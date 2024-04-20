public class SplitLargestArraySum {

    public static int countSubArrays(int nums[], int sum){
        int subArrays = 1, subarraySum = 0;

        for(int i = 0; i < nums.length; i++){
            if(subarraySum + nums[i] <= sum){
                subarraySum += nums[i];
            }
            else{
                subArrays++;
                subarraySum = nums[i];
            }
        }

        return subArrays;
    } 

    public static int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > low) low = nums[i];
            high += nums[i];
        }

        while(low <= high){
            int mid = (low + high) / 2;

            if(countSubArrays(nums, mid) <= k){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }
}
