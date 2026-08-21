class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            for(int j = i + 1; j < heights.length; j++){
                int delta = j - i;
                int height = heights[i] < heights[j] ? heights[i] : heights[j];
                int volume = delta * height;
                res = res > volume? res : volume;
            }
        }
        return res;
    }
}
