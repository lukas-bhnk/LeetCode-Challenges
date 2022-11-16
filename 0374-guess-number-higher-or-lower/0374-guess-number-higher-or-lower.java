/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int max = n;
        int min = 0;
        while(true){
            int pick = guess(max - (max - min) / 2);
            if (pick == 0) return max - (max - min) / 2;
            if (pick == 1) {
                min = max - (max - min) / 2 + 1;
                continue;
            }
            if (pick == -1) {
                max = max - (max - min) / 2 -1;
            }
            
        }
    }
}