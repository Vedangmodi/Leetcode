class Solution {
    public String reverseWords(String s) {
        String str = s.trim();

        char[] arr = str.toCharArray();

        reverse(arr, 0, arr.length - 1);

        int n = arr.length;
        int j = 0;

        for(int i=0; i<=n; i++){
            if(i == n || arr[i] == ' '){
                reverse(arr, j, i-1);
                j = i+1;
            }

        }

        StringBuilder sb = new StringBuilder();

        int i=0;
        while(i < n){
            while(i < n && arr[i] == ' '){
                i++;
            }
            if(i>=n){
                break;
            }
            if(sb.length() > 0){
                sb.append(' ');
            }
            while(i < n && arr[i] != ' '){
                sb.append(arr[i]);
                i++;
            }
        }
        return sb.toString();

    }

    public void reverse(char[] arr, int i, int j){
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;

        }
        

    }
}