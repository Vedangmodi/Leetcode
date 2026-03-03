class Solution {
    // public char findKthBit(int n, int k) {
    //     String str = fun("", n, 0);

    //     return str.charAt(k + 1);
        
    // }

    // public String fun(String str, int n, int x){
    //     if(x == n){
    //         return str;
    //     }

    //     if(str.isEmpty()){
    //         str = "0";
    //         return fun(str, n, x+1);

    //     }
        
    //     else{
    //         int mid = 0 + (str.length() - 1)/2;
    //         StringBuilder sb = new StringBuilder(str);
            
    //         if(sb.charAt(mid) == '1'){
    //             sb.setCharAt(mid, '0');
    //         }
    //         else{
    //             sb.setCharAt(mid, '1');
    //         }

    //         String s = str + '1' + sb.toString();

    //         return fun(s, n, x+1);

    //     }

    // }

    
    public char findKthBit(int n, int k) {
        // Base case: if n is 1, the sequence is just "0"
        if (n == 1) {
            return '0';
        }

        // Length of the sequence at level n: 2^n - 1
        int length = (1 << n) - 1;

        // If k is in the first half, recurse on the first half
        if (k < Math.ceil(length / 2.0)) {
            return findKthBit(n - 1, k);
        } 
        // If k is the middle bit, return '1'
        else if (k == Math.ceil(length / 2.0)) {
            return '1';
        } 
        // Otherwise, recurse on the mirrored second half
        else {
            char ch = findKthBit(n - 1, length - (k - 1)); // handle reversed
            return (ch == '0') ? '1' : '0'; // handle flipped bit
        }
    }

}

// 0         1
// 0 1 1      3
// 011 1 001.  7
// 0111001 1 0110001.  15


//. 779   3307