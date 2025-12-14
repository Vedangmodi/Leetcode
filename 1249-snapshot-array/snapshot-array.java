class SnapshotArray {

    public HashMap<Integer, HashMap<Integer, Integer>> map;
    public int count;

    public SnapshotArray(int length) {
        map = new HashMap<>();
        count = 0;
        
    }
    
    public void set(int index, int val) {
        if(!map.containsKey(count)){
            map.put(count, new HashMap<>());

        }

        map.get(count).put(index, val);
         
    }
    
    public int snap() {
        count++;
        return count - 1;
        
    }
    
    public int get(int index, int snapId) {
         while(snapId >= 0){
            if(map.containsKey(snapId) && map.get(snapId).containsKey(index)){
                return map.get(snapId).get(index);
            }
            else {
                snapId--;
            }

        }

        return 0;
        
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */