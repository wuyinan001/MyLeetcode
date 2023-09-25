/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        for(int i=0;i<n;i++)
        {
            int incoming=0,outgoing=0;
            
            for(int j=0;j<n;j++)
            {
                if(j!=i)
                {
                    if(knows(j,i))
                        incoming++;
                    
                    if(knows(i,j))
                    {
                        outgoing++;
                        break;
                    }
                }
            }
            
            if(incoming==n-1&&outgoing==0)
                return i;
        }
        
        return -1;
    }
}