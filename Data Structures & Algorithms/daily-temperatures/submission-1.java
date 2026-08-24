class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        Stack<Integer> position = new Stack();
        int result[] = new int[temperatures.length], index = 0;
        for(int temperature : temperatures){
            int days = 1;
            while(!stack.isEmpty() && stack.peek() < temperature){
                result[position.peek()] = index - position.peek();
                stack.pop();
                position.pop();
            }
            position.push(index);
            stack.push(temperature);
            index++;
        }
        for(int i = index; i < temperatures.length; i++){
            result[i] = 0;
        }
        return result;
    }
}
