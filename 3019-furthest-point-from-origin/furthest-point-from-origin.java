class Solution {
    public int furthestDistanceFromOrigin(String str) {
        int r = 0;
        int l = 0;
        int d = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'R') r++;
            else if(str.charAt(i) == 'L') l++;
            else d++;
        }

        if(r == 0 && l == 0){
            return d;
        }
        else if(r >= l){
            return r + d - l;
        }
        
        return l + d - r;
        

        
        
    }
}