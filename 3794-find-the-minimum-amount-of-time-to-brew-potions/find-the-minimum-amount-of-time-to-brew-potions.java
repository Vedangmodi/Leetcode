class Solution {
    public long minTime(int[] skill, int[] mana) {

        int n = skill.length;
        int m = mana.length;
        long[] arr = new long[n];

        for(int j=0; j<m; j++){
            arr[0] += skill[0] * mana[j];

            for(int i=1; i<n; i++){
                arr[i] = Math.max(arr[i], arr[i - 1]) + (long)mana[j] * skill[i];

            }

            for(int i=n-1; i>0; i--){
                arr[i - 1] = arr[i] - ((long) mana[j] * skill[i]);
            }

        }

        return arr[n - 1];

        
    }
}