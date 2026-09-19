class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        int x;
        int y;

        if(xCenter < x1){
            x = x1;
        }
        else if(xCenter > x2){
            x = x2;
        }
        else{
            x = xCenter;
        }
        
        if(yCenter < y1){
            y = y1;
        }
        else if(yCenter > y2){
            y = y2;
        }
        else{
            y = yCenter;
        }

        long dx = x - xCenter;
        long dy = y - yCenter;

        return dx * dx + dy * dy <= (long) radius * radius;
    }
}