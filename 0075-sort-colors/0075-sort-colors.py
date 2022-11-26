class Solution:
    def sortColors(self, nums: List[int]) -> None:
        nulls = 0
        ones = 0
        twos = 0
        """
        Do not return anything, modify nums in-place instead.
        """
        for i in range(len(nums)):
            if nums[i] == 0:
                nulls += 1
            if nums[i] == 1:
                ones += 1
            if nums[i] == 2:               
                twos += 1
        for i in range(len(nums)):
            if nulls > 0:
                nums[i] = 0
                nulls -= 1
                continue
            if nulls == 0 and ones != 0:
                nums[i] = 1
                ones -= 1
                continue
            if nulls == 0 and ones == 0:
                nums[i] = 2
                twos -= 1
                continue
        