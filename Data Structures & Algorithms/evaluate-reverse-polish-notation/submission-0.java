class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String current:tokens){
            if(current.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if(current.equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }
            else if(current.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if(current.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            }
            else{   
                stack.push(Integer.parseInt(current));
            }
        }
        return stack.pop();
    }
}
