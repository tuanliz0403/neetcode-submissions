class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        minStack.push(min);
        stack.push(val);
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
        if(!minStack.isEmpty())
            min = minStack.peek();
        else min = Integer.MAX_VALUE;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
