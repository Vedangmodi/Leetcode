class Solution {
    public int maxOperations(String str) {
        int count = 0;
        int max = 0;
        int i = 0;

        while(i < str.length()){
            
            if(str.charAt(i) == '0'){
                max = max + count;
                while(i < str.length() - 1 && str.charAt(i+1) == '0' ){
                    i++;
                }   
            }

            else {
                count++;
                
            }
            i++;

        }

        return max;
        
    }
}

// 1001101

// 1001011
// 1000111
// 0001111