class Solution {
    public int robotSim(int[] arr, int[][] obstacles) {
        HashSet<Long> set = new HashSet<>();

        for(int i=0; i<obstacles.length; i++){
            int a = obstacles[i][0];
            int b = obstacles[i][1];

            Long key = ((long) obstacles[i][0] << 32) | (obstacles[i][1] & 0xffffffffL);
            // Moves obstacles[i][0] to upper 32 bits
            // Because y can be negative In Java, 
            // negative numbers have leading 1s This mask ensures we only take lower 32 bits of y

            set.add(key);
        }

        boolean north = true;
        boolean east = false;
        boolean south = false;
        boolean west = false;

        int x = 0;
        int y = 0;

        int max = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == -2){
                if(north){
                    north = false;
                    west = true;
                }
                else if(west){
                    west = false;
                    south = true;
                }
                else if(south){
                    south = false;
                    east = true;
                }
                else if(east){
                    east = false;
                    north = true;
                }
                
            }
            else if(arr[i] == -1){
                if(north){
                    north = false;
                    east = true;
                    
                }
                else if(west){
                    west = false;
                    north = true;
                }
                else if(south){
                    south = false;
                    west = true;
                }
                else if(east){
                    east = false;
                    south = true;
                } 
            }
            else{

                if(north){
                    int num = arr[i];

                    while(num > 0){
                        int nextY = y + 1;
                        long key = ((long)x << 32) | (nextY & 0xffffffffL);

                        if(set.contains(key)){
                            break;
                        }
                        else{
                            y = nextY;
                        }
                        num--;
                        max = Math.max(max, x*x + y*y);

                    }
                }
                else if (east) {
                    int num = arr[i];

                    while (num > 0) {
                        int nextX = x + 1;

                        long key = ((long)nextX << 32) | (y & 0xffffffffL);

                        if (set.contains(key)) {
                            break;
                        } else {
                            x = nextX;
                        }

                        // update max distance here if needed
                        max = Math.max(max, x*x + y*y);

                        num--;
                    }
                }
                else if (south) {
                    int num = arr[i];

                    while (num > 0) {
                        int nextY = y - 1;

                        long key = ((long)x << 32) | (nextY & 0xffffffffL);

                        if (set.contains(key)) {
                            break;
                        } else {
                            y = nextY;
                        }

                        max = Math.max(max, x*x + y*y);

                        num--;
                    }
                }
                else if (west) {
                    int num = arr[i];

                    while (num > 0) {
                        int nextX = x - 1;

                        long key = ((long)nextX << 32) | (y & 0xffffffffL);

                        if (set.contains(key)) {
                            break;
                        } else {
                            x = nextX;
                        }

                        max = Math.max(max, x*x + y*y);

                        num--;
                    }
                }


            }

        }

        return max;



    }
}
