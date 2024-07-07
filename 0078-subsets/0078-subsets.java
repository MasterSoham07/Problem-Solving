class Solution {
    public void backtrack(int[] nums, int start, List<Integer> arr, List<List<Integer>> result){
        if(start >= nums.length){
            result.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[start]);
        backtrack(nums, start + 1, arr, result);
        arr.remove(arr.size() - 1);
        backtrack(nums, start + 1, arr, result);
    }


    public List<List<Integer>> subsets(int nums[]){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
}