class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        int n=numbers.length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(numbers[i]+numbers[j]==target)
                {
                    result[0]=i+1;
                    result[1]=j+1;
                    return result;
                }
                
                if(numbers[i]+numbers[j]>target)
                    break;
            }
        }
        
        return result;
    }
}