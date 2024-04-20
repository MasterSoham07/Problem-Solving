public class mergeSortedArrays2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind1 = m-1;
        int ind2 = n-1;
        int index = m+n-1;

        while(ind2 >= 0){
            if(ind1 >= 0 && nums1[ind1] > nums2[ind2]){
                nums1[index] = nums1[ind1];
                ind1--;
                index--;
            }
            else{
                nums1[index] = nums2[ind2];
                ind2--;
                index--;
            }
        }
    }
}
