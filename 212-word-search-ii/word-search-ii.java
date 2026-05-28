class Solution {
    int r;
    int c;

    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        r = board.length;
        c = board[0].length;

        TrieNode root = new TrieNode();

        for(String str : words){
            insert(root, str);
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(root.children[board[i][j] - 'a'] != null){
                    dfs(board, i, j, root);

                }
            }
        }

        return res;
 
    }

    public void dfs(char[][] board, int i, int j, TrieNode root){
        if(i < 0 || i >= r || j < 0 || j >= c){
            return;
        }

        if(board[i][j] == '$'){
            return;
        }

        if(root.children[board[i][j] - 'a'] == null){
            return;
        }

        root = root.children[board[i][j] - 'a'];

        if(root.end == true){
            res.add(root.str);
            root.end = false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        dfs(board, i + 1, j, root);
        dfs(board, i - 1, j, root);
        dfs(board, i, j + 1, root);
        dfs(board, i, j - 1, root);

        board[i][j] = temp;

    }

    public void insert(TrieNode root, String str){
        TrieNode curr = root;

        for(char ch : str.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }

            curr = curr.children[ch - 'a'];
        }

        curr.end = true;
        curr.str = str;
    }

    class TrieNode{
        boolean end;
        TrieNode[] children;
        String str;

        TrieNode(){
            end = false;
            children = new TrieNode[26];
            str = "";
        }
    }
}



//  board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],

//   words = ["oath","pea","eat","rain"]