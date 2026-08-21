class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String string : strs){
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if(map.containsKey(sortedString)){
                List<String> ls = new ArrayList<>(map.get(sortedString));
                ls.add(string);
                map.put(sortedString, ls);
            }
            else{
                List<String> newLs = new ArrayList<String>();
                newLs.add(string);
                map.put(sortedString, newLs);
            }
        }
        for(var value:map.values()){
            res.add(value);
        }
        return res;
    }
}
