class Solution {
    public int numSteps(String str) {
        int count = 0;
        StringBuilder sb = new StringBuilder(str);

        while(sb.length() != 1){
            if(sb.charAt(sb.length() - 1) == '0'){
                // sb = sb.substring(0, sb.length() - 1);  -- error
                sb.deleteCharAt(sb.length() - 1);
                count++;
            }
            else if(sb.charAt(sb.length() - 1) == '1'){
                for(int i = sb.length() - 1; i>=0; i--){
                    if(sb.charAt(i) == '0'){
                        sb.setCharAt(i, '1');
                        break;
                    }
                    else{
                        sb.setCharAt(i, '0');
                    }

                }
                count++;
            }
        }

        if(sb.charAt(0) == '0'){
            return count + 1;
        }
        
        return count;
    }
}