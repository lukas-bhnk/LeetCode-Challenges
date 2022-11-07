class Solution {
    public int removeDuplicates(int[] nums) {
        return helper(0,0,nums);
    }
    public int helper(int indexNums, int newIndexNums, int[] nums) {
        if (indexNums >= nums.length) {
            return newIndexNums; 
        }
        while (indexNums < nums.length -1 && nums[indexNums] == nums[indexNums + 1]) {
            indexNums++;
        }
        nums[newIndexNums] = nums[indexNums];
        indexNums++;
        return helper(indexNums, newIndexNums + 1, nums);
    }
    
}