class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();

        for(String query : queries){
            for(String str : dictionary){
                int count = 0;

                for(int i=0; i<query.length(); i++){
                    if(query.charAt(i) != str.charAt(i)){
                        count++;
                    }
                }

                if(count <= 2){
                    list.add(query);
                    break;
                }
            }
        }

        return list;
        
    }
}