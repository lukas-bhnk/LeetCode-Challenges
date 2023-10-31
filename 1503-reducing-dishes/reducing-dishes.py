class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        sortedList = satisfaction.sort()
        if 0 == satisfaction[len(satisfaction) - 1]:
            return 0
        curMax = 0
        curSumPlus = 0
        curSumMinus = 0
        for i in range(len(satisfaction)):
            if satisfaction[len(satisfaction) - i - 1] >= 0:
                curSumPlus += satisfaction[len(satisfaction) - i - 1]
                curMax += curSumPlus
            else:
                if -(curSumMinus + satisfaction[len(satisfaction) - i - 1]) >= curSumPlus:
                    return curMax
                else:
                    curSumMinus += satisfaction[len(satisfaction) - i - 1]
                    curMax = curMax + curSumPlus + curSumMinus
        return max(curMax, 0)
