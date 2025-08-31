class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);


    }
    public boolean solve(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1'; ch<='9'; ch++){
                        if(isValid(board, i, j, ch)){
                           board[i][j] = ch;

                           if(solve(board)){
                            return true;
                           }
                           
                            board[i][j] = '.';
                           

                        }
                                
                    }
                    return false;
                }
                else{
                    continue;
                }
                
            }
        }
        return true;
    }

    public boolean isValid(char[][] arr, int row, int col, char ch){
        for(int i=0; i<9; i++){  
            if(arr[row][i] == ch){
                return false;
            }
            
        }

        for(int i=0; i<9; i++){  
            if(arr[i][col] == ch){
                return false;
            }
            
        }

        int r = (row/3) * 3;
        int c = (col/3) * 3;

        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if(arr[i][j] == ch){
                    return false;
                }
            }
        }

        return true;
    }
}