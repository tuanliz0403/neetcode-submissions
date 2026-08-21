class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int min = s.length();
        String res = "";
        int currentSubstring = t.length();
        for(int c = 0; c < t.length(); c++){
            map.put(t.charAt(c), map.getOrDefault(t.charAt(c), 0) + 1);
        }
        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
                if(map.get(s.charAt(r)) >= 0){
                    currentSubstring--;
                }
            }
            while(true && l < s.length()){
                if(map.containsKey(s.charAt(l))){
                    if(map.get(s.charAt(l)) < 0){
                        map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                        l++;
                    }
                    else break;
                }
                else l++;
            }
            if(currentSubstring <= 0 && (r - l + 1) <= min){
                min = r - l + 1;
                res = s.substring(l, r + 1);
            }
            r++;
        }
        return res;
    }
}
