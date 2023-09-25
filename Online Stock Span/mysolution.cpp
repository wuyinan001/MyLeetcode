class StockSpanner {
public:
    vector<pair<int,int>> stack{{0,-1}};
    int day;
    
    StockSpanner() {
        day=0;
    }
    
    int next(int price) {
        int ans=0;
        day++;
        while(stack.back().first!=0&&stack.back().second<=price)
            stack.pop_back();
        ans+=day-stack.back().first;
        stack.push_back({day,price});
        
        return ans;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */