class Solution {
    public boolean isValidSudoku(char[][] arr) {
        for(int i=0; i<arr.length; i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j=0; j<arr.length; j++){
                if(arr[i][j] == '.'){
                    continue;
                }
                if(map.containsKey(arr[i][j])){
                    return false;
                }
                else{
                    map.put(arr[i][j],1);
                }
            }
        }

        for(int i=0; i<arr.length; i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j=0; j<arr.length; j++){
                if(arr[j][i] == '.'){
                    continue;
                }
                if(map.containsKey(arr[j][i])){
                    return false;
                }
                else{
                    map.put(arr[j][i],1);
                }
            }
        }

        for(int row = 0; row < 9; row += 3){
            for(int col = 0; col < 9; col += 3){

                HashMap<Character, Integer> map = new HashMap<>();

                for(int i=row; i<row+3; i++){
                    for(int j=col; j<col+3; j++){
                        if(arr[i][j] == '.'){
                            continue;
                        }
                        else if(map.containsKey(arr[i][j])){
                            return false;
                        }
                        else{
                            map.put(arr[i][j],1);
                        }

            
                    }
                }

            }
        }

        return true;
    }
}