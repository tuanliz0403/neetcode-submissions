class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for(int r = 0; r < s2.length(); r++){
            if(r - l + 1 > s1.length()){
                map.put(s2.charAt(l), map.getOrDefault(s2.charAt(l), 0) + 1);
                if (map.get(s2.charAt(l)) == 0){
                    map.remove(s2.charAt(l));
                }
                l++;
            }
            map.put(s2.charAt(r), map.getOrDefault(s2.charAt(r), 0) - 1);
            if(map.get(s2.charAt(r)) == 0){
                map.remove(s2.charAt(r));
            }
            if(map.keySet().isEmpty()){
                return true;
            }
        }
        return false;
    }
}
