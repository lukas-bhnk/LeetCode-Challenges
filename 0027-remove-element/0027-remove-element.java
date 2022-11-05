class Solution {
    public int removeElement(int[] nums, int val) {
        int currentIndex = 0;
        int output = 0;
        for (int i = 0; i < nums.length; i++ ){
           if (nums[i] == val) continue;
            output++;
            nums[currentIndex] = nums[i];
            currentIndex++;
        }
    return output;}
}