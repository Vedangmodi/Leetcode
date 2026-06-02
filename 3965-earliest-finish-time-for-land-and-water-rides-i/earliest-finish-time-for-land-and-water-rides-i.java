class Solution {
    public int earliestFinishTime(int[] lTime, int[] lDur, int[] wTime, int[] wDur){
        int min = Integer.MAX_VALUE;

        for(int i=0; i<lTime.length; i++){
            
            for(int j=0; j<wTime.length; j++){
                int landFinish = lTime[i] + lDur[i];
                int waterStart = Math.max(landFinish, wTime[j]);
                int finish1 = waterStart + wDur[j];

                int waterFinish = wTime[j] + wDur[j];
                int landStart = Math.max(waterFinish, lTime[i]);
                int finish2 = landStart + lDur[i];

                min = Math.min(min, Math.min(finish1, finish2));
                
            }
        }

        return min;
        
    }
}