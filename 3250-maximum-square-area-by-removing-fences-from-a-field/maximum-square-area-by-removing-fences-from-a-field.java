class Solution {
    
    public int maximizeSquareArea(int h, int v, int[] arrh, int[] arrv) {

        ArrayList<Integer> listh = new ArrayList<>();
        listh.add(1);
        listh.add(h);
        for(int x : arrh){
            listh.add(x);
        }
        Collections.sort(listh);

        ArrayList<Integer> listv = new ArrayList<>();
        listv.add(1);
        listv.add(v);
        for(int x : arrv){
            listv.add(x);
        }
        Collections.sort(listv);

        HashSet<Integer> seth = new HashSet<>();
        HashSet<Integer> setv = new HashSet<>();

        for(int i=0; i<listh.size(); i++){
            for(int j=i+1; j<listh.size(); j++){
                seth.add(listh.get(j) - listh.get(i));
            }
        }

        for(int i=0; i<listv.size(); i++){
            for(int j=i+1; j<listv.size(); j++){
                setv.add(listv.get(j) - listv.get(i));
            }
        }

        int ans = -1;


        for(int x : seth){
            if(setv.contains(x)){
                ans = Math.max(ans, x);
                
            }
        }
        if(ans == -1){
            return -1;
        }

        return (int) ((long) ans * ans % 1000000007);
        





        // Arrays.sort(arrh);
        // Arrays.sort(arrv);

        // HashSet<Integer> seth = new HashSet<>();

        // for(int i=0; i<arrh.length; i++){
        //     seth.add(arrh[i] - 1);
        // }
        // seth.add(h - 1);

        // for(int i=0; i<arrh.length - 1; i++){
        //     for(int j=i+1; j<arrh.length; j++){
        //         seth.add(arrh[j] - arrh[i]);
        //     }
        //     seth.add(h - arrh[i]);

        // }
        // seth.add(h - arrh[arrh.length - 1]);


        // HashSet<Integer> setv = new HashSet<>();

        // for(int i=0; i<arrv.length; i++){
        //     setv.add(arrv[i] - 1);
        // }
        // setv.add(v - 1);

        // for(int i=0; i<arrv.length - 1; i++){
        //     for(int j=i+1; j<arrv.length; j++){
        //         setv.add(arrv[j] - arrv[i]);
        //     }
        //     setv.add(v - arrv[i]);

        // }
        // setv.add(v - arrv[arrv.length - 1]);


        // int ans = -1;

        // for(int x : seth){
        //     if(setv.contains(x)){
        //         int val = x * x % 1000000007;
        //         ans = Math.max(val, ans);

        //     }

        // }

        // return ans;





        
    }
}