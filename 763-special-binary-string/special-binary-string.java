class Solution {
    public String makeLargestSpecial(String str) {
        ArrayList<String> list = new ArrayList<>();

        int balance = 0;
        int start = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                balance++;
            }
            else{
                balance--;
            }

            if(balance == 0){
                String sub = str.substring(start, i+1);

                String inner = sub.substring(1, sub.length() - 1);

                list.add('1' + makeLargestSpecial(inner) + '0');

                start = i + 1;
            }

        }

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for(String s : list){
            sb.append(s);
        }

        return sb.toString();
        
    }
}
// 1 1 0 1 1 0 0 0

// 1 2 1 2 3 2 1 0
// =====
// 1 0 1 1 0 0
// 1 0 