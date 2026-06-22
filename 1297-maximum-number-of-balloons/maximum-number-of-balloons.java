class Solution {
    public int maxNumberOfBalloons(String str) {
        int[] arr = new int[26];

        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i) - 'a']++;
        }

        int a = arr['b' - 'a'];
        int b = arr['a' - 'a'];
        int c = arr['l' - 'a']/2;
        int d = arr['o' - 'a']/2;
        int e = arr['n' - 'a'];


        return Math.min(a, Math.min(b, Math.min(c, Math.min(d, e))));

        
    }
}

