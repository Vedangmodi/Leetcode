class Solution {
  
     public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Stack<Integer> stack = new Stack<>();

        Arrays.sort(indices, (i, j) -> Integer.compare(positions[i], positions[j]));

        List<Integer> result = new ArrayList<>();
        
        for (int currentIndex : indices) {
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.pop();

                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }

        return result;
    }

}



// class Solution {
//     public List<Integer> survivedRobotsHealths(int[] nums, int[] healths, String directions) {
//         int rcount = 0;
//         int lcount = 0;
//         for(int i=0; i<directions.length(); i++){
//             if(directions.charAt(i) == 'R'){
//                 rcount++;
//             }
//             else{
//                 lcount++;
//             }
//         }

//         if(rcount == 0 || lcount == 0){
//             ArrayList<Integer> anslist = new ArrayList<>();

//             for (int num : healths) {
//                 anslist.add(num);
//             }

//             return anslist;
//         }



//         int[] arr = nums.clone();

//         Arrays.sort(arr);

//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int i=0; i<nums.length; i++){
//             map.put(nums[i], i);
//         }

//         Stack<Pair> left = new Stack<>();
//         Stack<Pair> right = new Stack<>();

//         // nums - [3,5,2,6]
//         // arr = 2,3,5,6

//         for(int i=arr.length - 1; i>=0; i--){
//             int idx = map.get(arr[i]);

//             int pnum = nums[idx];
//             int hnum = healths[idx];
//             char ch = directions.charAt(idx);

//             if(ch == 'R'){
//                 right.push(new Pair(pnum, hnum, ch));
//             }
//             else{
//                 left.push(new Pair(pnum, hnum, ch));

//             }

//         }

//         while(!right.isEmpty() || !left.isEmpty()){
//             Pair rpair = right.pop();
//             Pair lpair = left.pop();

//             int rpos = rpair.pos;
//             int lpos = lpair.pos;

//             int rhel = rpair.health;
//             int lhel = lpair.health;

//             char rdir = rpair.dir;
//             char ldir = lpair.dir;

//             if(rhel > lhel){
//                 right.push(new Pair(rpos, rhel - 1, rdir));

//             }
//             else if(rhel < lhel){
//                 left.push(new Pair(lpos, lhel - 1, ldir));
//             }

//         }

//         ArrayList<Integer> list = new ArrayList<>();

//         if(right.isEmpty() && left.isEmpty()){
//             return new ArrayList<>();
//         }

//         if(!right.isEmpty()){

//             while(!right.isEmpty()){
//                 Pair pair = right.pop();
//                 int hel = pair.health;

//                 list.add(hel);

//             }
            

//         }

//         if(!left.isEmpty()){
//             while(!left.isEmpty()){
//                 Pair pair = left.pop();
//                 int hel = pair.health;

//                 list.add(hel);
//             }
//         }

//         return list;


        
//     }
// }

// class Pair{
//     int pos;
//     int health;
//     char dir;

//     Pair(int pos, int health, char dir){
//         this.pos = pos;
//         this.health = health;
//         this.dir = dir;
//     }

// }