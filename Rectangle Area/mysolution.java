class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
       
        int[][] X={{A,C},{E,G}}, Y={{B,D},{F,H}};
        int overlap=0;
        
        Arrays.sort(X,new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                if(a1[0]==a2[0])
                {
                    if(a1[1]<a2[1])
                        return -1;
                    else if(a1[1]>a2[1])
                        return 1;
                    else
                        return 0;
                }
                
                if(a1[0]<a2[0])
                    return -1;
                
                return 1;
            }
            
        });
        
        
        Arrays.sort(Y,new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                if(a1[0]==a2[0])
                {
                    if(a1[1]<a2[1])
                        return -1;
                    else if(a1[1]>a2[1])
                        return 1;
                    else
                        return 0;
                }
                
                if(a1[0]<a2[0])
                    return -1;
                
                return 1;
            }
            
        });
        
        if(X[0][1]>X[1][0]&&Y[0][1]>Y[1][0])
            overlap=(Math.min(X[0][1],X[1][1])-X[1][0])*(Math.min(Y[0][1],Y[1][1])-Y[1][0]);
        
        return (C-A)*(D-B)+(G-E)*(H-F)-overlap;
    }
}