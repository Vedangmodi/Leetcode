class Solution {
    public String smallestPalindrome(String str) {
        // int[] arr = new int[26];

        // for(int i=0; i<str.length(); i++){
        //     char ch = str.charAt(i);
        //     arr['a' + ch]++; 
        // }

        // boolean flag = false;

        // char c;

        // StringBuilder sb = new StringBuilder();

        // for(int i=0; i<arr.length; i++){
        //     int num = arr[i] / 2;

        //     if(num % 2 != 0){
        //         c = 'a' + i;
                
        //     }
            

        // }

        int half = str.length()/2;
        char[] arr = str.toCharArray();

        Arrays.sort(arr, 0, half);

        int i = 0;
        int j = str.length() - 1;

        while(i < half){
            arr[j] = arr[i];
            i++;
            j--;
        }

        return new String(arr);

        
    }
}