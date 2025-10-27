class Solution {
    public int numberOfBeams(String[] bank) {
        int[] arr = new int[bank.length];
        int x = 0;

        for(String str : bank){
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '1'){
                    arr[x]++;
                }

            }
            x++;
        }

        int count = 0;
        int i=0; 
        int j=1;

        while(j < arr.length){
            if(arr[j] == 0){
                j++;
            }
            else if(arr[i] == 0){
                i++;
            }
            else if(i == j){
                j++;
            }
            else{
                count = count + (arr[i] * arr[j]);
                i = j;
                j++;
            }
        }

        return count;
        
    }
}