class SnapshotArray {

    Map<Integer,Integer>[] array;
    int size;
    int snaptime;
    
    public SnapshotArray(int length) {
        
        size=length;
        array=new Map[size];
        
        for(int i=0;i<size;i++)
        {
            array[i]=new HashMap();
            array[i].put(0,0);
        }
            
        snaptime=0;
    }
    
    public void set(int index, int val) {
        
        array[index].put(snaptime,val);
    }
    
    public int snap() {
        
        return snaptime++;
    }
    
    public int get(int index, int snap_id) {
        
        if(!array[index].containsKey(snap_id))
        {
            snap_id--;
            while(snap_id>=0)
            {
                if(array[index].containsKey(snap_id))
                    return array[index].get(snap_id);
                
                snap_id--;
            }
        }
        
        return array[index].get(snap_id);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */