class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums.length == 1 || nums[0] > target || nums[nums.length-1] < target) {
            if (nums.length == 1 && nums[0] == target) {
            int[] arr = {0,0};
            return arr;
            }
            int[] arr = {-1,-1};
            return arr;
        }
        return searchRange(nums, target, 0, nums.length -1);
    }
    
    public int[] searchRange(int[] nums, int target, int firstIndex, int lastIndex){
        if(firstIndex == lastIndex) {
            if(nums[firstIndex] == target) {
                int[] arr = {firstIndex, firstIndex};
                return arr;
            }
            int[] arr = {-1,-1};
            return arr;
        }
        int[] arr = new int[2];
        int midValue = nums[lastIndex - ((lastIndex - firstIndex) / 2)];
        if( midValue == target){
            int index1 = lastIndex - ((lastIndex - firstIndex) / 2);
            int index2 = index1;
            arr[0] = index1;
            arr[1] = index1;
            if(index1 -1 >= 0 && nums[index1 - 1] == target) {
                index1-=2;
                arr[0]--;
                while (index1 >= 0 && nums[index1] == target){
                    arr[0]--;
                    index1--;
                }
            }
            if(index2 + 1 <= nums.length - 1 && nums[index2 + 1] == target) {
                index2+=2;
                arr[1]++;
                while (index2 <= nums.length - 1 && nums[index2] == target){
                    arr[1]++;
                    index2++;
                }
            }
            return arr;
        }        
        if(midValue > target){
            arr = searchRange(nums, target, firstIndex, lastIndex - ((lastIndex - firstIndex) / 2) - 1);
        }
        if(midValue < target){
            arr = searchRange(nums, target, lastIndex - ((lastIndex - firstIndex) / 2) + 1, lastIndex);
        }
        return arr;
    }
}