class Solution {
    public int minOperations(String str) {
        int n = str.length();

        char[] arr = str.toCharArray();

        char[] flag = str.toCharArray();
        Arrays.sort(flag);

        if(Arrays.equals(arr, flag)){
            return 0;
        }

        if(n == 2){
            return -1;
        }

        char max = 'a';
        char min = 'z';

        for(int i=0; i<n; i++){
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
            min = arr[i];
            }
        }

        if(arr[0] == min || arr[n - 1] == max){
            return 1;
        }

        if(arr[0] == max && arr[n - 1] == min){
            for (int i = 1; i < n - 1; i++) {
                if (arr[i] == max || arr[i] == min) {
                    return 2;
                }
            }
            return 3;
        }

        return 2;




    }
}