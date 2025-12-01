class Solution {
    public int[][] merge(int[][] arr) {
        ArrayList<int[]> list = new ArrayList<>();

        swap(arr);

        int start = arr[0][0];
        int end = arr[0][1];

        for(int i=1; i<arr.length; i++){
            if(arr[i][0] <= end){
                // while(i < arr.length && arr[i][0] <= end){
                end = Math.max(end, arr[i][1]);
                       
                // list.add(new int[] {start, end});
                    
            }
            else{
                list.add(new int[] {start, end});
                start = arr[i][0];
                end = arr[i][1];

            }

        }

        list.add(new int[] {start, end});

        int[][] nums = new int[list.size()][2];

        for(int i=0; i<list.size(); i++){
            nums[i] = list.get(i);
        }

        return nums;

        // for(int i=0; i<arr.length-1; i++){
        //     if(arr[i][1] >= arr[i+1][0]){
        //         list.add(new int[] {arr[i][0], arr[i+1][1]});
        //         i++;

        //     }
        //     else{
        //         list.add(arr[i]);
        //     }
        // }

        // int[][] nums = new int[list.size()][2];

        // for(int i=0; i<list.size(); i++){
        //     nums[i] = list.get(i);
        // }

        // return nums;
    }

    public void swap(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length - i - 1; j++){
                if(arr[j][0] > arr[j+1][0]){
                    int[] temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}