//  wrong kind of approach
// class Solution {
//     public int numberOfSpecialChars(String str) {
//         HashSet<Character> set = new HashSet<>();

//         int count = 0;

//         HashSet<Character> seen = new HashSet<>();

//         HashSet<Character> eleminate = new HashSet<>();

//         for(int i=0; i<str.length(); i++){
//             char ch = str.charAt(i);

//             if(eleminate.contains(ch)){
//                 continue;
//             }

//             if(ch >= 'a' && ch <= 'z'){
//                 set.add(ch);
//             }

//             if(ch >= 'A' && ch <= 'Z'){
//                 if(!seen.contains(ch) && set.contains((char)(ch + 32))){
//                     count++;
//                 }

//                 seen.add(ch);
//             }

//             if(ch >= 'a' && ch <= 'z'){
//                 if(set.contains(ch) && seen.contains((char)(ch - 32))){
//                     count--;
//                     eleminate.add(ch);

//                 }

//             }

//         }

//         return count;
        
//     }
// }

// // A = 65 and a = 97

class Solution {
    public int numberOfSpecialChars(String word) {
        
        int[] lastSmall = new int[26];
        int[] firstCapital = new int[26];

        java.util.Arrays.fill(lastSmall, -1);
        java.util.Arrays.fill(firstCapital, -1);

        for(int i = 0; i < word.length(); i++) {
            
            char ch = word.charAt(i);

            if(Character.isLowerCase(ch)) {
                lastSmall[ch - 'a'] = i;
            }
            else {
                if(firstCapital[ch - 'A'] == -1) {
                    firstCapital[ch - 'A'] = i;
                }
            }
        }

        int count = 0;

        for(int i = 0; i < 26; i++) {

            if(lastSmall[i] != -1 && firstCapital[i] != -1 &&
               lastSmall[i] < firstCapital[i]) {
                count++;
            }
        }

        return count;
    }
}