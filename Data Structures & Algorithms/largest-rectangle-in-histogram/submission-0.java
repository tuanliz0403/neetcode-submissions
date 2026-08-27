class Solution {
public int largestRectangleArea(int[] heights) {
        Stack<Integer> h = new Stack<>();
        Stack<Integer> ind = new Stack<>();
        int result = 0;
        for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!h.empty() && h.peek() > heights[i]) {
                int temp = ind.peek();
                int height = h.peek();
                ind.pop();
                h.pop();
                result = Integer.max(result, height * (i - temp));
                start = temp;
            }
            ind.push(start);
            h.push(heights[i]);
        }
        while(!ind.empty()){
            int temp = ind.peek();
            int height = h.peek();
            ind.pop();
            h.pop();
            result = Integer.max(result, height * (heights.length - temp));
        }
        return result;
    }
}
