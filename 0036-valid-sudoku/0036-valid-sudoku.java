class Solution {

    
    public boolean checkValid(char[][] board, int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == board[x][y] && i != x) return false; 
            if (board[x][i] == board[x][y] && i != y) return false;
        }
        for (int i = (x/3) * 3; i <= ((x/3) * 3) + 2; i++) {
            for (int j = (y/3) * 3; j <= ((y/3) * 3) + 2; j++) {
                if (board[i][j] == board[x][y] && (i != x || j != y)) return false; 
            }
        }
        
        return true;
    }
    
    public int[] getNextFields(int x, int y) {
        if(x < 9 && y < 8) {
            int[] arr = { x, y+1};
            return arr;
        }
        else {
            int[] arr = { x + 1, 0};
            return arr;
        }

    }
    public boolean fullfillSudoku(char[][] board, int x, int y) {
        if(x==8 && y==8) return true;
        System.out.println(x + " " + y);
        if (board[x][y] == '.') {
        int[] nextFields = getNextFields(x,y);

        while ((board[nextFields[0]][nextFields[1]] == ('.'))) {
            System.out.println(nextFields[0] + " " + nextFields[1]);
            nextFields = getNextFields(nextFields[0], nextFields[1]);
            if (nextFields[0] == 8 && nextFields[1] == 8) return fullfillSudoku(board, nextFields[0], nextFields[1]);
        } 
            return fullfillSudoku(board, nextFields[0], nextFields[1]);
        }
        else {
        if (!(checkValid(board, x, y))) return false;

        int[] nextFields = getNextFields(x,y);

        while ((board[nextFields[0]][nextFields[1]] == ('.'))) {
            if (nextFields[0] >= 8 && nextFields[1] >= 8) break;
            nextFields = getNextFields(nextFields[0], nextFields[1]);
            System.out.println(nextFields[0] + " " + nextFields[1]);
        }
 
        return fullfillSudoku(board, nextFields[0], nextFields[1]);
    }}
    public boolean isValidSudoku(char[][] board) {
        return fullfillSudoku(board, 0, 0);
    }
}