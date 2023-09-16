class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        self.resultSet = []
        numPath = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != -1:
                    numPath += 1
                if grid[i][j] == 1:
                    startPoint = (i,j)
        self.helper(grid, startPoint[0], startPoint[1], [], self.resultSet, numPath)
        print(self.resultSet)
        return len(self.resultSet)
                

    def helper(self, grid, x, y, curPath, resultSet, numPath):
        if (x,y) in curPath or grid[x][y] == -1 or len(curPath) > numPath:
            return None
        curPath = curPath + [(x,y)]
        if len(curPath) == numPath and grid[x][y] == 2:
            self.resultSet.append(curPath)
            return None
        
        # runter
        if x+1 <= len(grid)-1:
            t =self.helper(grid, x+1, y, curPath, self.resultSet, numPath)
        # rechts
        if y+1 <= len(grid[0])-1:
            t = self.helper(grid, x, y+1, curPath, self.resultSet, numPath)

        # links
        if y-1 >= 0:
            t = self.helper(grid, x, y-1, curPath, self.resultSet, numPath)

        # hoch
        if x-1 >= 0:
            t = self.helper(grid, x-1, y , curPath, self.resultSet, numPath)

        return None
        
        