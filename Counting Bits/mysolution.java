class Solution {
    public int[] countBits(int num) {
        int[] result=new int[num+1];
        int max_two_n=2;
        
        for(int i=0;i<=num;i++)
        {
            if(i%2!=0)
                result[i]=result[i-1]+1;
            else if(i==0)
                result[i]=0;
            else if(Math.log(i)/Math.log(2)-Math.floor(Math.log(i)/Math.log(2))==0)
            {
                result[i]=1;
                max_two_n=i;
            }
            else
            {
                result[i]=1+result[i-max_two_n];
            }
            
            //System.out.println("i:"+i+"  max_two_n:"+max_two_n);
        }
        
        return result;
    }
}