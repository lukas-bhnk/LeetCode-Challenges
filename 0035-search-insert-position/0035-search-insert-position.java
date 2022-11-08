class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[0]>target) return 0;
        helper(nums, 0, nums.length -1, target);
        return nums[0];
    }
    public void helper(int[] nums, int curIndex,int lastIndex, int target) {
        if(nums[curIndex]==target) {
            nums[0]=curIndex;
            return;               
        }
        if(curIndex == lastIndex && nums[curIndex] < target) {
            nums[0] = nums.length;
            return;
        }
        if (nums[curIndex] < target && nums[curIndex+1] > target) { 
            nums[0]=curIndex+1;
            return;                                                   
        }
        
        curIndex++;
        helper (nums, curIndex, lastIndex, target);
        
        
    }
}