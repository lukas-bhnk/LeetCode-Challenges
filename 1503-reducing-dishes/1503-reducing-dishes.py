class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        sortedList = satisfaction.sort()
        print(satisfaction)
        if 0 == satisfaction[len(satisfaction) - 1]:
            return 0
        curMax = 0
        curSumPlus = 0
        curSumMinus = 0
        for i in range(len(satisfaction)):
            print(curMax)
            if satisfaction[len(satisfaction) - i - 1] >= 0:
                curSumPlus += satisfaction[len(satisfaction) - i - 1]
                curMax += curSumPlus
            else:
                if -(curSumMinus + satisfaction[len(satisfaction) - i - 1]) >= curSumPlus:
                    print("if first argument: ", -(curSumMinus + curSumMinus + satisfaction[len(satisfaction) - i - 1]))
                    return curMax
                else:
                    curSumMinus += satisfaction[len(satisfaction) - i - 1]
                    print(curMax, curSumPlus, curSumMinus)
                    curMax = curMax + curSumPlus + curSumMinus
                    print(curMax)
        return max(curMax, 0)
