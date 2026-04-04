class Solution {
    public String decodeCiphertext(String str, int rows) {
        if(1 == rows){
            return str;
        }

        int m = rows;
        int n = str.length()/rows;

        int x = 0;

        
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int y = x;

            for(int j=0; j<m; j++){
                if(i + j + y < str.length()){
                    sb.append(str.charAt(i + j + y));
                    y = y + n;

                }
                else{
                    continue;
                }
                

            }
            // x++;

            
        }
        return sb.toString().stripTrailing();  
    }
}