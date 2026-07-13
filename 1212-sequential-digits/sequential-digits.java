class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> list = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=9; i++){
            q.add(i);
        }

        int x = 8;

        while(!q.isEmpty()){
            int n = q.size();

            for(int i=0; i<n; i++){
                int num = q.poll();

                if(num >= low && num <= high){
                    list.add(num);
                }

                int mod = num % 10;
                if(mod != 9){
                    q.add((num * 10) + mod + 1);

                }
                
            }
            
            x--;
        }

        return list;   
    }
}