class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // fmax: the num of occurances of most frequent chars;
        // nmax: the num of most frequent chars;
        int fmax=0,nmax=0;
        int[] freq=new int[26];
        
        for(int i=0;i<tasks.length;i++)
        {
            freq[tasks[i]-'A']++;
        }
        
        for(int i=0;i<26;i++)
        {
            if(fmax<freq[i])
            {
                fmax=freq[i];
                nmax=1;
            }
            else if(fmax==freq[i])
            {
                nmax++;
            }
        }
        
        // Either the interval is fully occupied (tasks.length), or there are idle spaces
        return Math.max(tasks.length, (fmax-1)*(1+n)+nmax);
    }
}