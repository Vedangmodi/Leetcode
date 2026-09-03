class Solution {
    public boolean uniformArray(int[] arr) {
        Arrays.sort(arr);

        boolean even = (arr[0] % 2 == 0);
        boolean odd = (arr[0] % 2 == 1);

        int target = arr[0]%2;

        for(int i=1; i<arr.length; i++){
            int curr = arr[i] % 2;

            if(curr == target){
                if(curr == 0){
                    even = true;
                }
                else{
                    odd = true;
                }

                continue;
            }

            int req = curr ^ target;


            if(req == 0){
                if(!even){
                    return false;
                }
            }
            else{
                if(!odd){
                    return false;
                }
            }

            if(curr == 0){
                even = true;
            }
            else{
                odd = true;
            }
            
        }

        return true;
        
    }
}