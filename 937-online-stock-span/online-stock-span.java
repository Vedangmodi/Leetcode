class StockSpanner {

    Stack<int[]> stack = new Stack<>();
    public int count = 0;

    public StockSpanner() {
        
    }
    
    public int next(int price) {

        count++;
        
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            stack.pop();
        }
        int span;
        if(stack.isEmpty()){
            span = count;  
        }
        else{
            span = count - stack.peek()[1];
        }
        
        stack.push(new int[] {price,count});

        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
