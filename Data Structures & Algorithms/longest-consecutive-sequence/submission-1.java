class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int best = 0;
        for(int i : nums) set.add(i);
        for(int i : set){
            if(set.contains(i - 1)) continue;
            int len = 1;
            int current = i;
            while(set.contains(current + 1)){
                current++;
                len++;
            }
            best = best < len? len:best;
        }
        return best;
    }
}
