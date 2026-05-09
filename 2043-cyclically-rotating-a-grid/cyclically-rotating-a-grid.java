class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int a = 0;
        int b = 0;
        int c = n - 1;
        int d = m - 1;

        int divide = 1;

        for(int j = 0; j < Math.min(m,n)/2; j++){
            List<Integer> list = new ArrayList<>();

            int left = a;
            int top = b;
            int right = c;
            int down = d;

            for(int i=left; i <= right; i++){
                list.add(grid[top][i]);   
            }
            top++;
            for(int i=top; i<=down; i++){
                list.add(grid[i][right]);
            }
            right--;

            for(int i=right; i>=left; i--){
                list.add(grid[down][i]);
            }
            down--;

            for(int i=down; i>=top; i--){
                list.add(grid[i][left]);
            }
            left++;

            int x = k % list.size();
            
            rev(list, 0, x);
            rev(list, x, list.size());
            rev(list, 0, list.size());

            int left1 = a;
            int top1 = b;
            int right1 = c;
            int down1 = d;

            int idx = 0;

            for(int i=left1; i <= right1; i++){
                grid[top1][i] = list.get(idx); 
                idx++;  
            }
            top1++;
            for(int i=top1; i<=down1; i++){
                grid[i][right1] = list.get(idx); 
                idx++;
            }
            right1--;

            for(int i=right1; i>=left1; i--){
                grid[down1][i] = list.get(idx); 
                idx++;
            }
            down1--;

            for(int i=down1; i>=top1; i--){
                grid[i][left1] = list.get(idx); 
                idx++;
            }
            left1++;

            a++;
            b++;
            c--;
            d--;



        }

        return grid;
        
    }

    public static void rev(List<Integer> list, int start, int end) {
        end--;
        while (start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }
}

// Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
// Output: [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
// Explanation: The figures above represent the grid at every state.


// 1 2 3 4 8 12 16 15 14 13 9 5 

// 6 7 11 10
// 11 10 6 7

// 2500