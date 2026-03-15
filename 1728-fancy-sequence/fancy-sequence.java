class Fancy {

    public long M = 1_000_000_000 + 7;

    List<Long> list = new ArrayList<>();
    long add = 0;
    long mult = 1;

    // Binary Exponentiation for Ferat's Little Theorem -> power();

    long power(long a, long b) {
        if (b == 0)
            return 1;

        long half   = power(a, b / 2);
        long result = (half * half) % M;

        if (b % 2 == 1) {
            result = (result * a) % M;
        }

        return result;
    }


    public Fancy() {
        
    }
    
    public void append(int val) {
        long x = ((val - add) % M + M) * power(mult, M - 2) % M;

        list.add(x);
        
    }
    
    public void addAll(int inc) {
        add = (add + inc) % M;
        
    }
    
    public void multAll(int m) {
        mult = (mult * m) % M;
        add = (add * m) % M;
        
    }
    
    public int getIndex(int idx) {

        if(idx >= list.size()){
            return -1;
        }

        return (int)((list.get(idx) * mult + add) % M);
        
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */







// ["Fancy", "append", "addAll", "append", "multAll",  

//  "getIndex", "addAll", 
//  "append", 
//  "multAll", "getIndex", "getIndex", "getIndex"]
// [[], [2], [3], [7], [2],   [0], [3], 
// [10], 
// [2], 
// [0], [1], [2]]


//  26 34 20



