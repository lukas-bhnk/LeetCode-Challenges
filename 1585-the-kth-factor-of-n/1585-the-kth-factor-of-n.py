class Solution:
    def kthFactor(self, n: int, k: int) -> int:
        return self.helper(n, k, 1, 0)

    
    def helper(self, n, k, curFactor, curK):
        if curFactor == n and curK + 1 != k:
            return -1
        if  n % curFactor == 0:
            curK += 1
            if curK == k:
                return curFactor
        if curFactor + 1 <= int(n / 2):
            curFactor += 1
        else:
            curFactor = n
        return self.helper(n, k, curFactor, curK)