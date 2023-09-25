class Solution {
    
    private void addToHeap(int[][] mat, int r, int prev, PriorityQueue<Integer> maxHeap, int k)
    {
        for(int c=0;c<mat[0].length;c++)
        {
            maxHeap.add(prev+mat[r][c]);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
    }
    
    private PriorityQueue<Integer> buildHeap(int[][] mat, int r, PriorityQueue<Integer> maxHeap, int k)
    {
        PriorityQueue<Integer> queue=new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                return a2-a1;
            }
            
        });
        
        while(!maxHeap.isEmpty())
        {
            addToHeap(mat,r,maxHeap.poll(),queue,k);
        }
        
        return queue;
    }
    
    public int kthSmallest(int[][] mat, int k) {
        
        PriorityQueue<Integer> maxHeap=new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                return a2-a1;
            }
            
        });
        
        addToHeap(mat,0,0,maxHeap,k);
        
        // In each iteration, maxHeap contains top k smallest sum from row 0 to row r
        for(int r=1;r<mat.length;r++)
            maxHeap=buildHeap(mat,r,maxHeap,k);
        
        return maxHeap.peek();
    }
}