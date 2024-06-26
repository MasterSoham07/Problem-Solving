import java.util.ArrayList;

public class MedianOfTwoSortedArrays {

    // // Brute Force
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int n = nums1.length;
    //     int m = nums2.length;

    //     ArrayList<Integer> arr = new ArrayList<>();
        
    //     int i = 0, j = 0;

    //     while(i < n && j < m){
    //         if(nums1[i] < nums2[j]) arr.add(nums1[i++]);
    //         else arr.add(nums2[j++]);
    //     }

    //     while(i < n) arr.add(nums1[i++]);
    //     while(j < m) arr.add(nums1[j++]);

    //     int size = m + n;

    //     if(size % 2 == 1) return (double) arr.get(size / 2);

    //     double median = ((double) arr.get(size / 2) + (double) arr.get((size / 2) - 1)) / 2.0;

    //     return median;
    // }

    // Better Solution 

    // public double findMedianSortedArrays(int[] nums1, int[] nums2){
    //     int n1 = nums1.length;
    //     int n2 = nums2.length;

    //     int n = n1 + n2;

    //     int ind2 = n / 2;
    //     int ind1 = ind2 - 1;

    //     int ind1el = -1, ind2el = -1;

    //     int cnt = 0;

    //     int i = 0, j = 0;

    //     while(i < n1 && j < n2){
    //         if(nums1[i] < nums2[j]){
    //             if(cnt == ind1) ind1el = nums1[i];
    //             if(cnt == ind2) ind2el = nums1[i];

    //             cnt++;
    //             i++;
    //         }

    //         else{
    //             if(cnt == ind1) ind1el = nums2[j];
    //             if(cnt == ind2) ind2el = nums2[j];

    //             cnt++;
    //             j++;
    //         }
    //     }

    //     while(i < n1){
    //         if(cnt == ind1) ind1el = nums1[i];
    //         if(cnt == ind2) ind2el = nums1[i];

    //         cnt++;
    //         i++;
    //     }

    //     while(j < n2){
    //         if(cnt == ind1) ind1el = nums2[j];
    //         if(cnt == ind2) ind2el = nums2[j];

    //         cnt++;
    //         j++;
    //     }

    //     if(n % 2 == 1) return ind2el;

    //     return (double) ((double) (ind1el + ind2el)) / 2.0;
    // }

    // Optimal Solution

    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;
        int n = n1 + n2;

        while(low <= high){
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 1) return Integer.max(l1, l2);
                return ((double)(Integer.max(l1, l2) + Integer.min(r1, r2))) / 2.0;
            }

            else if(l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }

        return 0;
    }
}
