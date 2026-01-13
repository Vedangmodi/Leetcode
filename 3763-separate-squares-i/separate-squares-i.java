class Solution {
    public double separateSquares(int[][] mat) {
        double total = 0;

        for(int i=0; i<mat.length; i++){
            // int x = arr[i][0];
            // int y = arr[i][1];
            int l = mat[i][2];

            total +=  (double) l * l;
        }

        double ans = binary(mat, total);

        return ans;
        
    }

    public double binary(int[][] mat, double total){
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for(int i=0; i<mat.length; i++){
            int y = mat[i][1];
            int l = mat[i][2];

            high = Math.max(high, y+l);

            if(y < low){
                low = y;
            }  
        }

        while(high - low >= 0.00001){
            double mid = low + (high - low)/2;

            if(check(mid, mat) >= total/2.0){
                high = mid;
            }
            else{
                low = mid;
            }

        }

        return low;

    }

    public double check(double mid, int[][] mat){
        double area = 0;
        // int i = 0;
        // int k = 0;
        for(int i=0; i<mat.length; i++){
            
            int y = mat[i][1];
            int l = mat[i][2];

            double bottom = y;
            double top = y + l;

            if(mid <= bottom){
                continue;
            }
            else if(mid > top){
                area += (double) l * l;
            }
            else{
                area += (double) (mid - y) * l;
            }
          

        }

        return area;
    }
} 