class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int m = wordsContainer.length;
        int n = wordsQuery.length;

         int[] result = new int[n];

        TrieNode root = getNode(0);

        for (int i = 0; i < m; i++) {
            if (wordsContainer[root.idx].length() > wordsContainer[i].length()) {
                root.idx = i;
            }
            insert(wordsContainer, root, i);
        }

        for (int i = 0; i < n; i++) {
            result[i] = search(wordsContainer, root, wordsQuery[i]);
        }

        return result; 
    }

    public int search(String[] wordsContainer, TrieNode root, String str){
        int residx = root.idx;
        int n = str.length();

        for(int i = n-1; i>=0; i--){
            int chidx = str.charAt(i) - 'a';

            root = root.children[chidx];

            if(root == null){
                return residx;
            }

            residx = root.idx;
        }

        return residx;
    }

    public void insert(String[] wordsContainer, TrieNode root, int i){
        String word = wordsContainer[i];

        int n = word.length();

        for(int j = n-1; j>=0; j--){
            char ch = word.charAt(j);
            int chidx = ch - 'a';

            if(root.children[chidx] == null){
                root.children[chidx] = getNode(i);
            }

            if(wordsContainer[root.children[chidx].idx].length() > n){
                root.children[chidx].idx = i;
            }

            root = root.children[chidx];
        }

    }






    class TrieNode{
        int idx;
        TrieNode[] children;

        TrieNode(){
            idx = -1;
            children = new TrieNode[26];
        }
    }

    public TrieNode getNode(int idx){
        TrieNode curr = new TrieNode();
        curr.idx = idx;

        for(int i=0; i<26; i++){
            curr.children[i] = null;
        }

        return curr;
    }




}