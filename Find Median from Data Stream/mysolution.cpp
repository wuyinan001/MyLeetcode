class MedianFinder {
public:
    priority_queue<int,vector<int>,greater<int>> pq1;
    priority_queue<int,vector<int>> pq2;
    
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if(pq1.size()==pq2.size())
        {
            pq2.push(num);
            pq1.push(pq2.top());
            pq2.pop();
        }
        else
        {
            pq1.push(num);
            pq2.push(pq1.top());
            pq1.pop();
        }
    }
    
    double findMedian() {
        if(pq1.size()==pq2.size())
            return (pq1.top()+pq2.top())/2.0;
        else
            return pq1.top()*1.0;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */