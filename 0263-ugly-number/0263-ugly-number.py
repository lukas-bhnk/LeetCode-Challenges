class Solution:
    def isUgly(self, n: int) -> bool:
        prime = [2,3,5]
        i = 0
        while n != 1:
            if n < prime[i]:
                return False
            if n / prime[i] == 1:
                return True
            if n % prime[i] != 0:
                if prime[i] == 5:
                    return False
                i += 1
                continue
            if n % prime[i] == 0:
                n = n/prime[i]
        

        return True