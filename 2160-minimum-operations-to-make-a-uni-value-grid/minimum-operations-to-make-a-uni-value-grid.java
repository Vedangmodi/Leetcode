class Solution {
    public int minOperations(int[][] mat, int x) {
        int a = mat.length;
        int b = mat[0].length;

        int[] arr = new int[a*b];
        int z = 0;

        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                arr[z] = mat[i][j];
                z++;
            }
        }


        Arrays.sort(arr);

        int num = arr[arr.length / 2];

        int count = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] % x != num % x){
                return -1;
            }

            count += Math.abs(num - arr[i])/x;

        }

        return count;
        
    }
}