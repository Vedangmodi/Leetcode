class Solution {   

    int guard = 2;
    int wall = 3;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];

        for(int[] g : guards){
            mat[g[0]][g[1]] = guard;
        }

        for(int[] w : walls){
            mat[w[0]][w[1]] = wall;
        }

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == guard){
                    fun(i, j, mat);
                }

            }
        }

        int count = 0;

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    count++;
                }

            }
        }

        return count;
        
    }

    public void fun(int m, int n, int[][] mat){

        //up
        for(int i=m-1; i>=0; i--){
            if(mat[i][n] == wall || mat[i][n] == guard){
                break;
            }
            mat[i][n] = 1;
        }
        //down
        for(int i=m+1; i<mat.length; i++){
            if(mat[i][n] == wall || mat[i][n] == guard){
                break;
            }
            mat[i][n] = 1;

        }
        //right
        for(int i=n+1; i<mat[0].length; i++){
            if(mat[m][i] == wall || mat[m][i] == guard){
                break;
            }
            mat[m][i] = 1;
        }
        //left
        for(int i=n-1; i>=0; i--){
            if(mat[m][i] == wall || mat[m][i] == guard){
                break;
            }
            mat[m][i] = 1;
        }


    }
}