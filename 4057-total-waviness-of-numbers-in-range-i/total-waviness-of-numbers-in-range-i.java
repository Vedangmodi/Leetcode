class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;

        for(int i = num1; i<=num2; i++){
            int x = fun(i);
            count += x;
        }

        return count;
        
    }

    public int fun(int num){
        String str = Integer.toString(num);

        if(str.length() <= 1){
            return 0;
        }

        int count = 0;

        for(int i = 1; i<str.length() - 1; i++){
            char ch0 = str.charAt(i - 1);
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i + 1);

            if(ch0 < ch1 && ch1 > ch2){
                count++;
            }
            else if(ch0 > ch1 && ch1 < ch2){
                count++;
            }
        }

        return count;
    }


}

