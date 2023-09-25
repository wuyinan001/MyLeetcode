class ExamRoom {
    
    PriorityQueue<int[]> pq;
    int n;
    
    public ExamRoom(int n) {
        
        this.n=n;
        
        pq=new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                int d1=0, d2=0;
                int mid1=(a1[0]+a1[1])/2, mid2=(a2[0]+a2[1])/2;
                
                //System.out.println("mid1 "+mid1+" mid2 "+mid2);
                
                if(a1[0]==-1)
                    d1=a1[1];
                else if(a1[1]==n)
                    d1=n-1-a1[0];
                else
                    d1=Math.min(mid1-a1[0],a1[1]-mid1);
                
                if(a2[0]==-1)
                    d2=a2[1];
                else if(a2[1]==n)
                    d2=n-1-a2[0];
                else
                    d2=Math.min(mid2-a2[0],a2[1]-mid2);
                
                if(d1==d2)
                    return a1[0]-a2[0];
                
                return d2-d1;
            }
        });
        
        pq.add(new int[]{-1,n});
    }
    
    public int seat() {
        
        int[] temp=pq.poll();
        
        if(temp[0]==-1)
        {
            pq.add(new int[]{-1,0});
            pq.add(new int[]{0,temp[1]});
            //print();
            return 0;
        }
        else if(temp[1]==n)
        {
            pq.add(new int[]{temp[0],n-1});
            pq.add(new int[]{n-1,n});
            //print();
            return n-1;
        }
        else
        {
            int mid=temp[0]+(temp[1]-temp[0])/2;
            pq.add(new int[]{temp[0],mid});
            pq.add(new int[]{mid,temp[1]});
            //print();
            return mid;
        }
    }
    
    public void leave(int p) {
        
        int lo=-1, hi=-1;
        int[] rm1=null,rm2=null;
        
        for(int[] interval:pq)
        {
            if(interval[1]==p)
            {
                lo=interval[0];
                rm1=interval;
            }
            
            if(interval[0]==p)
            {
                hi=interval[1];
                rm2=interval;
            }
        }
        
        pq.remove(rm1);
        pq.remove(rm2);
        
        pq.add(new int[]{lo,hi});
        
        
        //print();
            
        
        //System.out.println(lo+" : "+hi);
    }
    
    private void print()
    {
        System.out.println("Show pq:");
        List<int[]> list=new ArrayList();
        
        while(!pq.isEmpty())
        {
            int[] temp=pq.poll();
            list.add(temp);
            System.out.println(temp[0]+" : "+temp[1]);
        }
        
        for(int[] interval:list)
            pq.add(interval);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */