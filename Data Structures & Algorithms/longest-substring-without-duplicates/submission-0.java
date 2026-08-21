class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chr = s.toCharArray();
        int l = 0, current = 0, res = 0;
        for(char i:chr){
            if(map.containsKey(i)){
                if(map.get(i) >= l){
                    l = map.get(i) + 1;
                }
            }
            map.put(i, current);
            res = Math.max(res, current - l + 1);
            current++;
        }
        return res;
    }
}
