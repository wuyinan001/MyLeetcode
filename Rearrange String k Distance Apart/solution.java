class Solution {
    public String rearrangeString(String s, int k) {
        
        int[] freq=new int[26];
        int n=s.length();
        
        for(int i=0;i<n;i++)
            freq[s.charAt(i)-'a']++;
        
        // PriorityQueue contains a 3-element array.
        // 0: the char index. a:0, b:1, c:2, d:3, ...
        // 1: the freq of that char
        // 2: the location index in the output array/string
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                return a2[1]-a1[1];
            }
            
        });
        
        for(int i=0;i<26;i++)
            if(freq[i]!=0)
                pq.add(new int[]{i,freq[i],0});
        
        // To store the updated array polled from the heap
        Queue<int[]> queue=new LinkedList();
        
        char[] ans=new char[n];
        
        for(int i=0;i<n;i++)
        {
            while(!queue.isEmpty()&&queue.peek()[2]<=i)
                pq.add(queue.remove());
            
            if(pq.isEmpty())
                return "";
            
            int[] next=pq.poll();
            
            ans[i]=(char)(next[0]+'a');
            
            next[1]--;
            
            if(next[1]>0)
            {
                next[2]=i+k;
                queue.add(next);
            }
        }
        
        return new String(ans);
    }
}