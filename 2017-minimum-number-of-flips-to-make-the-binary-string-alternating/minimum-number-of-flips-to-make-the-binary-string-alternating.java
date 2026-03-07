class Solution {
    public int minFlips(String s) {
        String str = s + s;

        int c1  = 0;
        int flip1 = Integer.MAX_VALUE;
        int j = 0;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            char c = str.charAt(j);
           

            // 101010101

            if(i % 2 == 0){
                if(ch == '0'){
                    c1++;
                }
            }
            else{
                if(ch == '1'){
                    c1++;
                }
            }

            if(i - j + 1 > s.length()){
                if(j % 2 == 0){
                    if(c == '0'){
                        c1--;
                    }
                }
                else{
                    if(c == '1'){
                        c1--;
                    }
                } 

                j++;  

            }

            if(i - j + 1 == s.length()){
                flip1 = Math.min(flip1, c1);

            }
            

        }

        int c2  = 0;
        int flip2 = Integer.MAX_VALUE;
        int k = 0;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            char c = str.charAt(k);

            // 01010101

            if(i % 2 == 0){
                if(ch == '1'){
                    c2++;
                }
            }
            else{
                if(ch == '0'){
                    c2++;
                }
            }

            if(i - k + 1 > s.length()){
                if(k % 2 == 0){
                    if(c == '1'){
                        c2--;
                    }
                }
                else{
                    if(c == '0'){
                        c2--;
                    }
            
                }
                k++;
            } 

            if(i - k + 1 == s.length()){
                flip2 = Math.min(flip2, c2);
            }  


        }

        return Math.min(flip1, flip2);
        
    }
}





// 0 1 0 0 1 0 0 1 1 0 1
// 1 0 0 1 0 0 1 1 0 1 1