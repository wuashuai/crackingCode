package TreeGraphs;

import java.util.Random;

//Random Node: You are implementing a binary tree class from scratch which, in addition to
//insert, find, and delete, has a method getRandomNode() which returns a random node
//from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
//for getRandomNode, and explain how you would implement the rest of the methods.



// traversal once! Keep the size



class RandomTreeNode {
    
    RandomTreeNode left;
    RandomTreeNode right;
    int val ;
    int count;
    
    RandomTreeNode(int val) {
        this.val = val;
        this.count = 1;
    }
      
    
    RandomTreeNode getRandom() {
        Random r = new Random();
        
        int i = r.nextInt(count);
        
        if(i == 0) return this;
        
        int l = left == null ? 0 : left.count;
        
        if(i <= l) return left.getRandom();
        return right.getRandom();
        
    }
    
    void insert(int num) {
        
        RandomTreeNode n = new RandomTreeNode(num);
        
        insert(n);
    }
    
    void insert(RandomTreeNode n) {
        
        count++;
        
        if(n.val > val) {
            if(left == null) {
                left = n;
            }else {
                left.insert(n);
            }
        }else {
            if(right == null) {
                right = n;
            }else {
                right.insert(n);
            }
        }
    }
    
}
