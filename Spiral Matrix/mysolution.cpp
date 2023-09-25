class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int n=matrix.size(), m=matrix[0].size();
        
        int count=0;
        int row=0, col=-1;
        vector<vector<int>> dirs{{0,1},{1,0},{0,-1},{-1,0}};
        vector<int> ans;
        int direction=0;
        int hstep=m, vstep=n-1;
        
        while(count<n*m)
        {
            if(direction==0||direction==2)
            {
                for(int i=0;i<hstep;i++)
                {
                    row+=dirs[direction][0];
                    col+=dirs[direction][1];
                    ans.push_back(matrix[row][col]);
                    count+=1;
                }
                hstep-=1;
            }
            else
            {
                for(int i=0;i<vstep;i++)
                {
                    row+=dirs[direction][0];
                    col+=dirs[direction][1];
                    ans.push_back(matrix[row][col]);
                    count+=1;
                }
                vstep-=1;
            }
            
            direction=(direction+1)%4;
        }
        
        return ans;
    }
};