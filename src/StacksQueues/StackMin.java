package StacksQueues;

import java.util.Stack;

public class StackMin {

    public static void main(String[] args) {
        
    }
    
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    
    public void add(int a) {
        stack.push(a);
        if(a <= min.peek()) {
            min.push(a);
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int pop() {
        int a = stack.pop();
        
        if(a == min.peek()) {
            min.pop();
        }
        return a;
    }
    
    public int getMin() {
        return min.peek();
    }
    
    
    
}
