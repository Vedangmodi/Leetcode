class Solution {
    int[][] t;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {

        int[][] roboDist = new int[robots.length][2];
        
        for(int i=0; i<robots.length; i++){
            roboDist[i][0] = robots[i];
            roboDist[i][1] = distance[i];
        }

        Arrays.sort(roboDist, (a,b) ->  a[0] - b[0]);

        Arrays.sort(walls);

        int[][] range = new int[robots.length][2];

        for(int i=0; i<robots.length; i++){
            int pos = roboDist[i][0];
            int dist = roboDist[i][1];

            int left;
            int right;
            
            if(i == 0){
                left = 1;
            }
            else{
                left = roboDist[i - 1][0] + 1;
            }

            if(i == robots.length - 1){
                right = (int) 1e9;
            }
            else{
                right = roboDist[i + 1][0] - 1;
            }

            int l = Math.max(pos - dist, left);
            int r = Math.min(pos + dist, right);

            range[i][0] = l;
            range[i][1] = r;



        }
        
        t = new int[robots.length][2];

        for(int[] arr : t){
            Arrays.fill(arr, -1);
        }

        return solve(walls, roboDist, range, 0, 0);
    }

    int solve(int[] walls, int[][] roboDist, int[][] range, int i, int prevDir) {

        if (i == roboDist.length) return 0;

        if (t[i][prevDir] != -1) return t[i][prevDir];

        int leftStart = range[i][0];

        // If previous robot shot RIGHT
        if (prevDir == 1 && i > 0) {
            leftStart = Math.max(leftStart, range[i - 1][1] + 1);
        }

        // shoot LEFT
        int leftTake = countWalls(walls, leftStart, roboDist[i][0]) +
                       solve(walls, roboDist, range, i + 1, 0);

        // shoot RIGHT
        int rightTake = countWalls(walls, roboDist[i][0], range[i][1]) +
                        solve(walls, roboDist, range, i + 1, 1);

        return t[i][prevDir] = Math.max(leftTake, rightTake);
    }

    int countWalls(int[] walls, int L, int R) {
        int left = lowerBound(walls, L);
        int right = upperBound(walls, R);
        return right - left;
    }

    // Binary search: first index >= target
    int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // Binary search: first index > target
    int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}