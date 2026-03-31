class Solution {
    public String generateString(String str, String str2) {
        int n = str.length();
        int m = str2.length();

        char[] arr = new char[n + m - 1];
        boolean[] canChange = new boolean[n + m - 1];

        Arrays.fill(arr, '#');

        for(int i=0; i<n; i++){
            if(str.charAt(i) == 'T'){
                for(int j=0; j<m; j++){
                    if(arr[i+j] == '#' || arr[i + j] == str2.charAt(j)){
                        arr[i + j] = str2.charAt(j);
                        canChange[i + j] = false;
                    }
                    else{
                        return "";
                    }
                }
            }

        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] == '#'){
                arr[i] = 'a';
                canChange[i] = true;
            }
        }

        // for(int i=0; i<arr.length; i++){
        //     if(i < str.length() && str.charAt(i) == 'T'){
        //         int x = 0;

        //         while(x < m){
        //             arr[i] = str2.charAt(x);
        //             x++;
        //             i++;
        //         }
        //         i--;
        //     }
        //     else{
        //         arr[i] = 'a';
        //     }
        // }

        for(int i=0; i<=arr.length - m; i++){
            if(i < n && str.charAt(i) == 'F'){
                boolean match = true;

                for(int j=0; j<m; j++){
                    if(arr[i + j] != str2.charAt(j)){
                        match = false;
                        break;
                    }
                }

                

                if(match){
                    boolean change = false;
                    
                    for(int j=m-1; j>=0; j--){
                        if(canChange[i + j]){
                            arr[i + j] = 'b';
                            canChange[i + j] = false;
                            change = true;
                            break;
                        }
                    }
                    if(!change){
                        return "";
                    }
                }

                

            }
        }

        for(int i = 0; i < n; i++){
            if(str.charAt(i) == 'T'){
                for(int j = 0; j < m; j++){
                    if(arr[i + j] != str2.charAt(j)){
                        return "";
                    }
                }
            }
        }

        return new String(arr); 

        // String s = new String(arr).trim();
        // StringBuilder sb = new StringBuilder(s);

        // for(int i=0; i<sb.length() - m + 1; i++){
        //     String sub = sb.substring(i, i + m);

            
        // }


      // StringBuilder sb = new StringBuilder();

        // int x = 0;
        
        // for(int i=0; i<str.length(); i++){
        //     if(str.charAt(i) == 'T'){
        //         sb.append(str2);
        //     }
        //     if(sb.length() - 1 >= i && sb.charAt(i) == str2.charAt(0))
            
        // }
        
        
    }
}

// ArrayList<Integer> list = new ArrayList<>();

        // for(int i=0; i<str.length(); i++){
        //     if(str.charAt(i) == 'T'){
        //         list.add(i);
        //     }
        // }

        // for(int i=1; i<list.size(); i++){
        //     if(list.get(i) - list.get(i - 1) < m){
        //         return "";
        //     }
        // }


