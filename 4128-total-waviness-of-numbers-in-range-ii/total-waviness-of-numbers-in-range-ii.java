class Solution {
    String str;
    int n;

    long[][][] dpnum   = new long[16][10][10];
    long[][][] dpscore = new long[16][10][10];

    public long totalWaviness(long num1, long num2) {
        return func(num2) - func(num1 - 1);
        
    }

    public long func(long num){
        if(num < 100){
            return 0;
        }

        for(long[][] a : dpnum){
            for(long[] b : a){
                Arrays.fill(b, -1);
            }
        }

        for(long[][] a : dpscore){
            for(long[] b : a){
                Arrays.fill(b, -1);
            }
        }

        str = Long.toString(num);

        n = str.length();

        long[] res = solve(0, -1, -1, true, true);

        return res[1];
    }

    public long[] solve(int curr, int prevPrev, int prev, boolean isLimited, boolean isLeadingZero){
        if(curr == n){
            return new long[]{1, 0};
        }

        if(!isLimited && !isLeadingZero && prev >= 0 && prevPrev >= 0){
            if(dpnum[curr][prevPrev][prev] != -1){
                return new long[]{dpnum[curr][prevPrev][prev] , dpscore[curr][prevPrev][prev]};
            }
        }

        int limitDigit = isLimited ? (str.charAt(curr) - '0') : 9;

        long totalNumbers = 0;
        long totalScore = 0;

        for(int i=0; i<= limitDigit; i++){
            boolean newIsLeadingZero = isLeadingZero && (i == 0);
            int newPrevPrev = prev;
            int newPrev = newIsLeadingZero ? -1 : i;

            long[] res = solve(curr + 1, newPrevPrev, newPrev, isLimited && (i == limitDigit), newIsLeadingZero);

            long remnum = res[0];
            long remscore = res[1];


            if (!newIsLeadingZero && prevPrev >= 0 && prev >= 0) {
                boolean isPeak   = (prevPrev < prev && prev > i);
                boolean isValley = (prevPrev > prev && prev < i);

                if (isPeak || isValley) {
                    totalScore += remnum;
                }
            }

            totalNumbers += remnum;
            totalScore += remscore;

        }

        if(!isLimited && !isLeadingZero && prev >= 0 && prevPrev >= 0){
            
            dpnum[curr][prevPrev][prev] = totalNumbers; 
            dpscore[curr][prevPrev][prev] = totalScore;
            
        }

        return new long[]{totalNumbers, totalScore};


    }
}









