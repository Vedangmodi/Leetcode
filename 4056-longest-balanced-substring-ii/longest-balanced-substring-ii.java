class Solution {
    public int longestBalanced(String str) {

        // case 1

        int max1 = 0;
        int count1 = 1;

        for(int i = 0; i < str.length(); i++) {
            if(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count1++;
            } else {
                max1 = Math.max(max1, count1);
                count1 = 1;
            }
        }

        // case 2
        int x = case2(str, 'a', 'b');
        int y = case2(str, 'b', 'c');
        int z = case2(str, 'c', 'a');

        int max2 = Math.max(x, Math.max(y,z));

        // case 3

        int max3 = case3(str);


        return Math.max(max1, Math.max(max2, max3));


    }

    public int case3(String str){
        int counta = 0;
        int countb = 0;
        int countc = 0;

        int max = 0;

        HashMap<Pair, Integer> map = new HashMap<>();
        map.put(new Pair(0, 0), -1);
        // map.put(new Pair(0, 0), 0);

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == 'a'){
                counta++;
            }
            else if(ch == 'b'){
                countb++;                                                   
            }
            else if(ch == 'c'){
                countc++;
            }

            int sub1 = counta - countb;
            int sub2 = counta - countc;

            if(counta == countb && counta == countc){
                max = Math.max(max, counta + countb + countc);
            } 

            Pair curr = new Pair(sub1, sub2);

            // if(map.containsKey(curr)){
            //     max = Math.max(max, i - map.get(curr));

            // }
            Integer prev = map.get(curr);
            if(prev != null){
                max = Math.max(max, i - prev);
            }

            else{
                map.put(curr, i);
            }

        }

        return max;


    }


   public int case2(String str, char a, char b){
    int n = str.length();
    int[] first = new int[2*n + 1];
    Arrays.fill(first, -2);  // -2 means not set
    
    int diff = n;  // Start at offset n (represents 0)
    int max = 0;
    int clearIdx = -1;
    
    first[diff] = -1;  // diff=0 at index -1
    
    for(int i = 0; i < n; i++){
        char ch = str.charAt(i);
        
        if(ch == a){
            diff++;
        }
        else if(ch == b){
            diff--;
        }
        else {
            clearIdx = i;
            diff = n;  // Reset diff to 0 (offset n)
            first[diff] = clearIdx;  // diff=0 at current index
            continue;
        }
        
        int idx = diff;
        
        if(first[idx] >= clearIdx){
            max = Math.max(max, i - first[idx]);
        } else {
            first[idx] = i;
        }
    }
    
    return max;
}




        
        // HashMap<Integer, Integer> map = new HashMap<>();

        // map.put(0, -1);
        // int counta = 0;
        // int countb = 0;
        // int max = 0;

        // for(int i=0; i<str.length(); i++){
        //     char ch = str.charAt(i);
        //     if(ch == a){
        //         counta++;
        //     }
        //     else if(ch == b){
        //         countb++;
        //     }
        //     else{
        //         counta = 0;
        //         countb = 0;
        //         map.clear();
        //         map.put(0, i);
        //         continue;

        //     }

        //     if(map.containsKey(counta - countb)){
        //         max = Math.max(max, i - map.get(counta - countb));
        //     }
        //     else{
        //         map.put(counta - countb, i);
        //     }

        // }

        // return max;


    }
// }

class Pair{
    int a;
    int b;

    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Pair p = (Pair) o;

        return a == p.a && b == p.b;
    }

    @Override
    public int hashCode(){
        return 31 * a + b;
    }


    // @Override
    // public int hashCode(){
    //     return Objects.hash(a,b);
    // }
    

}









// case 2 - 
// a,b

        // int a1 = 0;
        // int b1 = 0;

        // int max1 = 0;

        // for(int i=0; i<str.length(); i++){
        //     char ch = str.charAt(i);
        //     while(i<str.length() && (ch == 'a' || ch == 'b')){
        //         if(ch == 'a'){
        //             a1++;
        //         }
        //         else if(ch == 'b'){
        //             b1++;
        //         }

        //         if(a1 == b1){
        //             max1 = Math.max(max1, a1 + b1);
        //         }
        //         i++;
        //     }

        //     a1 = 0;
        //     b1 = 0;

        // }