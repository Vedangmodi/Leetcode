class Robot {
    ArrayList<int[]> list = new ArrayList<>();
    boolean moved = false;

    int idx = 0;

    public Robot(int width, int height) {
        for(int i=0; i<width; i++){
            list.add(new int[]{i, 0, 1});
        }

        for(int i=1; i<height; i++){
            list.add(new int[]{width - 1, i, 2});
        }

        for(int i=width - 2; i>=0; i--){
            list.add(new int[]{i, height - 1, 3});
        }

        for(int i=height - 2; i>0; i--){
            list.add(new int[]{0, i, 4});

        }

        list.get(0)[2] = 4;
        
    }
    
    public void step(int num) {
        moved = true;
        idx = (idx + num) % list.size();

    }
    
    public int[] getPos() {
        // int[] arr = list.get(idx);

        return new int[]{list.get(idx)[0], list.get(idx)[1]};
        
        
    }
    
    public String getDir() {
        if(!moved){
            return "East";
        }

        int dir = list.get(idx)[2];

        if(dir == 1) return "East";
        else if(dir == 2) return "North";
        else if(dir == 3) return "West";
        else return "South";
        
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */