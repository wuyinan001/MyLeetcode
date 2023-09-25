class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        
        if(N==0)
            return cells;
        
        int n=cells.length;
        
		// cells update has a period of 14; i.e., the cells content on day N+14 is the same as day N;
		// There is a special case, which is N%14==0. In this case, the result is not cells on day 0, but cells on day 14,28,42,... any N%14==0 except 0;
		// The reason is from day 0 to day 1 there may be an update on cells[0] or cells[n-1].
        N=N%14+14;
        
        int[] cache=new int[n];
        //int[] day=new int[n];
        //boolean same=false;
        
        int P=0;
        
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<n-1;j++)
            {
                if(cells[j-1]+cells[j+1]==1)
                    cache[j]=0;
                else
                    cache[j]=1;
            }
            
            if(i==1)
                cells[0]=cells[n-1]=0;
            
            //int k=0;
            
            for(int j=1;j<n-1;j++)
                cells[j]=cache[j];
            
            /*
            if(i==1)
                for(int j=0;j<n;j++)
                    day[j]=cache[j];
            else
            {
                k=0;
                for(;k<n;k++)
                    if(day[k]!=cache[k])
                        break;
            }
            
            
            if(k==n)
                same=true;
            
            if(same)
            {
                P=i;
                System.out.println("P"+P);
            }*/
                
            
            /*
            for(int j=0;j<n;j++)
                System.out.print(cells[j]+",");
            System.out.println();*/
        }
        
        return cells;
    }
}