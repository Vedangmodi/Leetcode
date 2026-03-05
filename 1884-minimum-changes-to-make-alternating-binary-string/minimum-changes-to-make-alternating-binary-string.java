class Solution {
    public int minOperations(String str) {

        int c1 = 0;
        int c2 = 0;

        if(str.length() == 1){
            return 0;
        }

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            //even - 1
            if(i % 2 == 0){
                if(ch != '1'){
                    c1++;
                
                }
            }
            else{
                if(ch != '0'){
                    c1++;
                }
            }


            if(i % 2 == 0){
                if(ch != '0'){
                    c2++;
                
                }
            }
            else{
                if(ch != '1'){
                    c2++;
                }
            }

            
        }

        return Math.min(c1, c2);
        
    }
}

