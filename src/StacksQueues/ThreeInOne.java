package StacksQueues;

//Three in One: Describe how you could use a single array to implement three stacks


public class ThreeInOne {
    int[] arr;
    int[] index;
    
    public static void main(String[] args) {
        
    }
    
    public ThreeInOne(int length, int numOfStack) {
        arr = new int[length * numOfStack];
        index = new int[numOfStack];
        
        for(int i = 0; i < numOfStack; i++) {
            index[i] = i;
        }
    }
    
    public boolean push(int stackNum, int num) {
        
        if(full(stackNum)) {
            return false;
        }
        
        arr[index[stackNum]] = num;
        
        index[stackNum] += index.length;
        
        return true;
    }
    
    public int top(int stackNum) {
        return arr[index[stackNum]];
    }
    
    public int pop(int stackNum) {
        if(empty(stackNum)) {
            return -1;
        }
        
        int v = arr[index[stackNum]];
        stackNum -= index.length;
        return v;
    }
    
    public boolean empty(int stackNum) {
        if(index[stackNum] < 0) return true;
        return false;
    }
    
    public boolean full(int stackNum) {
        if(stackNum >= arr.length) return true;
        return false;
    }
    
}
