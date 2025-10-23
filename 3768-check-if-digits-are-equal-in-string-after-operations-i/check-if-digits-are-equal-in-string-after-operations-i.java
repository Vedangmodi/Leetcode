class Solution {
    public boolean hasSameDigits(String str) {

        if(str.length() == 2 && str.charAt(0) == str.charAt(1)){
            return true;
        }

        if(str.length() == 2){
            return false;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length() - 1; i++){
            int a = str.charAt(i) - '0';
            int b = str.charAt(i + 1) - '0';
            int x = (a+b) % 10;

            sb.append(x);
        }
        
        return hasSameDigits(sb.toString());  
    }

    
}