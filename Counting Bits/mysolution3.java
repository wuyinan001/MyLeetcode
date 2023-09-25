class Solution {
    public int[] countBits(int num) {
        
        int[] ans=new int[num+1];
        
        int power=1;
        
        ans[0]=0;
        
        for(int i=1;i<=num;i++)
        {
            //System.out.println((int)Math.pow(2,power));
            
            if(i%2!=0)
                ans[i]=ans[i-1]+1;
            else
            {
                if((int)Math.pow(2,power)==i)
                {
                    ans[i]=1;
                    power++;
                }
                else
                {
                    ans[i]=1+ans[i-(int)Math.pow(2,power-1)];
                }
            }
        }
        
        return ans;
    }
}