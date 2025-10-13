class Solution {
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);

        for(int i=1; i<words.length; i++){
            char[] arr1 = words[i - 1].toCharArray();
            char[] arr2 = words[i].toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            if(Arrays.equals(arr1, arr2)){
                continue;
            }
            else{
                list.add(words[i]);
            }
        }

        return list; 
    }
}