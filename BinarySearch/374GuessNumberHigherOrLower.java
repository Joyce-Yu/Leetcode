/*
leetcode: https://leetcode-cn.com/problems/guess-number-higher-or-lower/
by Joyce

注意：
1. 🌟mid的计算方法，用int mid = left + (right-left)/ 2; 否则会溢出
2. 如果不用二分查找，会超出时间限制

*/
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 0;
        int right = n;

        while (left <= right){
            int mid = left + (right-left) / 2;
            if (guess(mid) == 0){
                return mid;
            } else if (guess(mid) == 1){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
        
    }
}
