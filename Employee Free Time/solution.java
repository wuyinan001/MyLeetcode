/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        List<Interval> list=new ArrayList();
        
        for(List<Interval> l:schedule)
        {
            for(Interval i:l)
            {
                list.add(i);
            }
        }
        
        Collections.sort(list, new Comparator<Interval>(){
            
            public int compare(Interval a1, Interval a2)
            {
                return a1.start-a2.start;
            }
            
        });
        
        int n=list.size();
        
        LinkedList<Interval> list2=new LinkedList();
        
        // lastEnd: the max end in previous intervals
        int lastEnd=list.get(0).end;
        
        for(int i=1;i<n;i++)
        {
            if(lastEnd<list.get(i).start)
                list2.add(new Interval(lastEnd,list.get(i).start));
            
            lastEnd=Math.max(lastEnd,list.get(i).end);
        }
        
        return list2;
    }
}