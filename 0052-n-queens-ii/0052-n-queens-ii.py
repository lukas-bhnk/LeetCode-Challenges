class Solution:
    def totalNQueens(self, n: int) -> int:
        field = [["0" for i in range(n)] for j in range(n)]
        return self.helper(field, 0, 0)
        

    def check(self, field, curQueenX, curQueenY):
        for i in range(1, len(field)):
            if field[curQueenX][(curQueenY + i) % len(field)] == "1":
                print("a")
                return False
            if field[(curQueenX + i) % len(field)][curQueenY] == "1":
                print("b")
                return False
        for i in range(1, len(field)):
            print(curQueenX - i, curQueenY - i)
            print(curQueenX - i, curQueenY + i)
            if curQueenX - i >= 0 and curQueenY - i >= 0:
                if field[curQueenX - i][curQueenY - i] == "1":
                    print("c")
                    return False
            if curQueenX - i >= 0 and curQueenY + i < len(field):
                if field[curQueenX - i][curQueenY + i] == "1":
                    print("d")
                    return False
            if curQueenX - i < 0 and curQueenY - i < 0 and curQueenY + i >= len(field):
                return True

    def helper(self, field, curQueen, curQueenY):
        if curQueen > 0 and self.check(field, curQueen - 1, curQueenY) == False:
            return 0

        if curQueen == len(field):
            return 1
        
        score = 0
        for i in range(0, len(field)):
            field[curQueen][i] = "1"
            score += self.helper(field, curQueen + 1, i)
            field[curQueen][i] = "0"
        return score

        
