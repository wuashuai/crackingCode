package StacksQueues;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args){
		SortStack ss = new SortStack();
		
		ss.push(4);
		System.out.println(ss.top());
		ss.push(6);
		System.out.println(ss.top());
		ss.push(5);
		System.out.println(ss.top());
		ss.push(3);
		System.out.println(ss.top());
		ss.push(8);
		System.out.println(ss.top());
		
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		
	}
	
	Stack<Integer> minStack;
	Stack<Integer> temp;
	
	
	public SortStack(){
		minStack = new Stack<>();
		temp = new Stack<>();
	}
	
	
	public void push(int v){
		while(!minStack.isEmpty() && v > minStack.peek()){
			temp.push(minStack.pop());
		}
		
		minStack.push(v);
		
		while(!temp.isEmpty()){
			minStack.push(temp.pop());
		}
	}
	
	public int top(){
		return minStack.peek();
	}
	
	public int pop(){
		return minStack.pop();
	}
	
	
}
