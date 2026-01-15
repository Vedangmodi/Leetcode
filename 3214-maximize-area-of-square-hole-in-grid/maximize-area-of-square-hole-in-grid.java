class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] arrh, int[] arrv) {
        Arrays.sort(arrh);
        Arrays.sort(arrv);

        int counth = 1;
        int maxh = 1;
        for(int i=0; i<arrh.length - 1; i++){
            
            while(i<arrh.length - 1 && arrh[i] + 1 == arrh[i + 1]){
                counth++;
                i++;
            }

            maxh = Math.max(counth, maxh);
            counth = 1;
        }

        int countv = 1;
        int maxv = 1;
        for(int i=0; i<arrv.length - 1; i++){
            
            while(i<arrv.length - 1 && arrv[i] + 1 == arrv[i + 1]){
                countv++;
                i++;
            }

            maxv = Math.max(countv, maxv);
            countv = 1;
        }

        int side = Math.min(maxh + 1, maxv + 1);
        return side * side;

    }

        
      















    // public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

    //     int[] ver = new int[n + 2];
    //     int[] hor = new int[m + 2];

    //     for(int i = 0; i<ver.length; i++){
    //         ver[i] = i;
    //     }

    //     for(int i = 0; i<hor.length; i++){
    //         hor[i] = i;
    //     }

    //     HashSet<Integer> seth = new HashSet<>();
    //     HashSet<Integer> setv = new HashSet<>();

    //     for(int i = 0; i< hBars.length; i++){
    //         seth.add(hBars[i]);
    //     }

    //     for(int i = 0; i< vBars.length; i++){
    //         setv.add(vBars[i]);
    //     }


    //     for(int i = 0; i<ver.length; i++){
    //         if(setv.contains(ver[i])){
    //             if(i == 0 || i == ver.length - 1){
    //                 continue;
    //             }
    //             ver[i] = 0;
    //         }
    //     }

    //     for(int i = 0; i<hor.length; i++){
    //         if(seth.contains(hor[i])){

    //             if( i == 0 || i == hor.length - 1){
    //                 continue;
    //             }
    //             hor[i] = 0;
    //         }
    //     }

    //     int vmax = 1;
    //     int hmax = 1;

    //     int a = 0;
    //     int b = 1;

    //     while(b < ver.length){
    //         if(ver[b] != 0){
    //             b++;
    //             a++;
    //             continue;
    //         }
    //         while( b < ver.length && ver[b]== 0){
    //             b++;
    //         }

    //         vmax = Math.max(vmax,b - a);

    //         a = b;
    //     }

    //     int x = 0;
    //     int y = 1;

    //     while(y < hor.length){
    //         if(hor[y] != 0){
    //             x++;
    //             y++;
    //             continue;
    //         }
    //         while(y < hor.length && hor[y]== 0){
    //             y++;
    //         }

    //         hmax = Math.max(hmax,y - x);

    //         x = y;
    //     }

    //     return Math.min(vmax * vmax, hmax * hmax);




    // }
}