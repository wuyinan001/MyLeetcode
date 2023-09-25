class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int a=tops[0], b=bottoms[0];
        
        int n=tops.length;
        
        // minA: min rotations to make one row equal to a
        // minB: min rotations to make one row equal to b
        int i=0, minA=0, minB=0;
        
        // a1: min rotations to make top row equal to a
        // a2: min rotations to make bottom row equal to a
        int a1=0,a2=0;
        
        while(i<n)
        {
            if(tops[i]!=a&&bottoms[i]!=a)
                break;
            else if(tops[i]!=a&&bottoms[i]==a)
                a1++;
            else if(tops[i]==a&&bottoms[i]!=a)
                a2++;
            
            i++;
        }
        
        if(i<n)
            minA=Integer.MAX_VALUE;
        else
            minA=Math.min(a1,a2);
        
        // b1: min rotations to make top row equal to b
        // b2: min rotations to make bottom row equal to b
        int b1=0,b2=0;
        
        i=0;
        
        while(i<n)
        {
            if(tops[i]!=b&&bottoms[i]!=b)
                break;
            else if(tops[i]!=b&&bottoms[i]==b)
                b1++;
            else if(tops[i]==b&&bottoms[i]!=b)
                b2++;
            
            i++;
        }
        
        if(i<n)
            minB=Integer.MAX_VALUE;
        else
            minB=Math.min(b1,b2);
        
        int ans=Math.min(minA,minB);
        
        return ans==Integer.MAX_VALUE ? -1 : ans;
        
    }
}