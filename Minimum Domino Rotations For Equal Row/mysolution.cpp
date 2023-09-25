class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        int n=tops.size();
        int same=0;
        
        int topA=0, topB=0;
        
        for(int i=0;i<n;i++)
            if(tops[i]==bottoms[i])
                same++;
        
        for(int i=0;i<n;i++)
        {
            if(tops[i]!=tops[0]&&bottoms[i]!=tops[0])
            {
                topA=INT_MAX;
                break;
            }
            else if(tops[i]==tops[0])
                continue;
            else
                topA++;
        }
        
        for(int i=0;i<n;i++)
        {
            if(tops[i]!=bottoms[0]&&bottoms[i]!=bottoms[0])
            {
                topB=INT_MAX;
                break;
            }
            else if(tops[i]==bottoms[0])
                continue;
            else
                topB++;
        }
        
        //cout<<topA<<" "<<topB<<endl;
        
        if(topA==INT_MAX&&topB==INT_MAX)
            return -1;
        else if(topA==INT_MAX)
            return min(topB,n-same-topB);
        else if(topB==INT_MAX)
            return min(topA,n-same-topA);
        else
            return min(min(topA,n-same-topA),min(topB,n-same-topB));
            
    }
};