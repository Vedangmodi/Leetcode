class Solution {

    int[][][][][] dp = new int[301][7][7][7][7];

    public int minimumDistance(String word) {
         for (int i = 0; i < 301; i++)
            for (int a = 0; a < 7; a++)
                for (int b = 0; b < 7; b++)
                    for (int c = 0; c < 7; c++)
                        Arrays.fill(dp[i][a][b][c], -1);

        return solve(word, 0, -1, -1, -1, -1);

        
    }

    public int solve(String word, int i, int x1, int y1, int x2, int y2){
        if(i >= word.length()){
            return 0;
        }

        if (dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] != -1){
            return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1];

        }
            

        int[] arr = coordinates(word.charAt(i));
        int x = arr[0];
        int y = arr[1];


        // both fingure not used
        if(x1 == -1 && y1 == -1 && x2 == -1 && y2 == -1){
            return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] = solve(word, i+1, x, y, x2, y2);
        }

        // first fingure used
        if(x2 == -1 && y2 == -1){
            int move2 = solve(word, i + 1, x1, y1, x, y);

            int dist = distance(x1, y1, x, y);

            int move1 =  dist + solve(word, i+1, x, y, x2, y2);

            return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] = Math.min(move1, move2);


        }

        // if both are used

        int move1 = distance(x1, y1, x, y) + solve(word, i+1, x, y, x2, y2);

        int move2 = distance(x2, y2, x, y) + solve(word, i+1, x1, y1, x, y);

        return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] = Math.min(move1, move2);


    }

    public int distance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int[] coordinates(char ch){
        int[] arr = new int[2];

        int x = ch - 'A';

        int row = x/6;
        int col = x%6;

        arr[0] = row;
        arr[1] = col;

        return arr;

    }
}