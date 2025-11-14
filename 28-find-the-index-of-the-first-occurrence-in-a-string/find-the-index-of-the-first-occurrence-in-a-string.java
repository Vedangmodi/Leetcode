class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.isEmpty()){
            return 0;
        }
        int index = 0;
        for(int i=0; i<=haystack.length() - needle.length(); i++){
            if(haystack.substring(i,i + needle.length()).equals(needle)){
                return i; 
                // break;

            }
                
        }
        return -1;
        
    }
}