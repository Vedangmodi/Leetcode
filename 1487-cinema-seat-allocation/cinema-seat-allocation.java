class Solution {
    public int maxNumberOfFamilies(int n, int[][] mat) {

        int m = mat.length;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0; i<m; i++){
            map.computeIfAbsent(mat[i][0], k -> new ArrayList<>()).add(mat[i][1]);
        }

        int count = 0;

        for(ArrayList<Integer> list : map.values()){
            Collections.sort(list);

            boolean av = true;

            for(int i=2; i<=5; i++){
                if(list.contains(i)){
                    av = false;
                    break;
                }
            }

            // if(av){
            //     count++;
            // }

            boolean bv = true;

            for(int i=4; i<=7; i++){
                if(list.contains(i)){
                    bv = false;
                    break;
                }
            }

            // if(bv){
            //     count++;
            // }

            boolean cv = true;

            for(int i=6; i<=9; i++){
                if(list.contains(i)){
                    cv = false;
                    break;
                }
            }

            // if(cv){
            //     count++;
            // }

            if(av && cv){
                count += 2;
            }
            else if(av || bv || cv){
                count++;
            }


        }

        count += (n - map.size()) * 2;


        return count;  
    }
}