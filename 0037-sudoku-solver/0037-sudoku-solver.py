class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        board = self.helper(board, 0, 0)
        return board

    def getBoxStart(self, x, y):
        if y <= 2:
            if x <= 2:
                return ( 0, 0 )
            if x <= 5:
                return ( 3, 0 )
            if x <= 9:
                return ( 6, 0 )
        if y > 2 and y <= 5:
            if x <= 2:
                return ( 0, 3 )
            if x <= 5:
                return ( 3, 3 )
            if x <= 9:
                return ( 6, 3 )    
        if y <= 9:
            if x <= 2:
                return ( 0, 6 )
            if x <= 5:
                return ( 3, 6 )
            if x <= 9:
                return ( 6, 6 )

    def isValid(self,board, x, y):
        boxStartValues = self.getBoxStart(x,y)
        for i in range(9):
            if board[x][y] == board[i][y] and i != x:
                return False
            if board[x][y] == board[x][i] and i != y:
                return False
            xBox = boxStartValues[0] + (i % 3)
            yBox = boxStartValues[1] + (i // 3)
            if board[x][y] == board[xBox][yBox] and xBox != x and yBox != y:
                return False
        return True

    def getNextPossibleField(self, board, x, y):
        
        while y != 9:
            if board[x][y] == ".":
                return (x, y)
            
            x += 1
            
            if x == 9:
                x = 0
                y += 1
        
        return None

            

    def helper(self, board, x, y):
        if x == 8 and y == 8 and self.isValid(board, x, y):
            return board

        nextField = self.getNextPossibleField(board, x, y)

        if nextField is None:
            return board
        for i in range(1, 10):
            board[nextField[0]][nextField[1]] = str(i)
            if self.isValid(board, nextField[0], nextField[1]):
                result = self.helper(board, nextField[0], nextField[1])
                if result is not None:
                    return result
            
        
        board[nextField[0]][nextField[1]] = "."   
        return None
                    

                
        