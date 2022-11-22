class Solution:
    
    dp = [0]

    def numSquares(self, n: int) -> int:

        dp = self.dp
        
        perfectSq = [pow(i,2) for i in range(1, int(sqrt(n))+1)]
        
        while len(dp) < n+1:
            
            dpI = inf
            
            for ps in perfectSq:
                if len(dp)<ps: break
                dpI = min(dpI,1+dp[-ps])
            
            dp.append(dpI)
        
        return dp[n]