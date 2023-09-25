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
        
        int lo=1, hi=n;
        int ans=lo+(hi-lo)/2;
        
        while(lo<=hi)
        {
            //System.out.println("ans: "+ans);
            
            if(guess(ans)==0)
                return ans;
            else if(guess(ans)==1)
            {
                lo=ans+1;
                ans=lo+(hi-lo)/2;
            }
            else
            {
                hi=ans-1;
                ans=lo+(hi-lo)/2;
            }
        }
        
        return -1;
    }
}