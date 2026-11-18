class Solution {
    public int minChanges(String str) {
        int n = str.length();

        int count = 0;

        for(int i=0; i<n; i+=2){
            if(str.charAt(i) != str.charAt(i + 1)){
                count++;
            }

        }

        return count;

        // int[] zero = new int[n];
        // int[] one  = new int[n];

        // int ztotal = 0;
        // int ototal = 0;

        // for(int i=0; i<n; i++){
        //     char ch = str.charAt(i);

        //     if(ch == '1'){
        //         ototal++;
        //     }
        //     else if(ch == '0'){
        //         ztotal++;
        //     }

        //     if(i > 0){
        //         // if(ch == '1'){
        //             one[i] = one[i-1] + 1; 

        //         // }
        //         // else{
        //             zero[i] = zero[i - 1] + 1;
        //         // }
        //     }
        // }

        // int min = Integer.MAX_VALUE;

        // for(int i=1; i<n; i+=2){
        //     int onel = one[i];
        //     int zerol = zero[i];

        //     int oner = ototal - onel;
        //     int zeror = ztotal - zerol;

        //     min = Math.min(min, Math.min(onel + zeror, oner + zerol));
        // }

        // return min;
        
    }
}