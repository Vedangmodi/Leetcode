class Solution {
    public List<String> letterCombinations(String str) {
        if(str== null || str.length() == 0){
            return new ArrayList<>();
        }
        List<String> list = fun("", str);
        return list;
        
    }
    public String[] arr = {
        "abc","def",
        "ghi","jkl",
        "mno","pqrs", 
        "tuv","wxyz"
    
    };

    public List<String> fun(String p, String up) {
        if(up.isEmpty()){
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        List<String> list = new ArrayList<>();

        int x = up.charAt(0) - '0';
        String str = arr[x - 2];

        for(int i=0; i<str.length(); i++){
            
            list.addAll(fun(p + str.charAt(i), up.substring(1)));
        }

        return list;

        
    }
}