package moderate;

import java.util.*;

class AllOne {

    Map<String, Integer> numMap;
    Map<Integer, Node> nodeMap;
    Node head, end;
    
    /** Initialize your data structure here. */
    public AllOne() {
        head = new Node(0);
        end = new Node(0);
        head.right = end;
        end.left = head;
        numMap = new HashMap<>();
        nodeMap = new HashMap<>();
        
        nodeMap.put(0, head);
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int num;
        
        if(numMap.containsKey(key)){
            num = numMap.get(key);
        }else{
            num = 0;
            head.add(key);
            numMap.put(key, 0);
        }
        Node n = nodeMap.get(num);
        Node next;
        
        if(nodeMap.containsKey(num + 1)){
            next = nodeMap.get(num + 1);
        }else{
            next = new Node(num + 1);
            next.left = n;
            next.right = n.right;
            n.right.left = next;
            n.right = next;
            nodeMap.put(num + 1, next);
        }
        next.add(key);
        n.remove(key);
        numMap.put(key, num + 1);
        
        if(num >= 1 && n.list.size() == 0){
            nodeMap.remove(n.num);
            n.left.right = n.right;
            n.right.left = n.left; 
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!numMap.containsKey(key)){
            return;
        }
        int num = numMap.get(key);
        Node n = nodeMap.get(num);
        
        if(num == 1){
            n.remove(key);
            numMap.remove(key);
        }else{
            Node pre;
            if(!nodeMap.containsKey(num - 1)){
                pre = new Node(num - 1);
                pre.right = n;
                pre.left = n.left;
                n.left.right = pre;
                n.left = pre;
                nodeMap.put(num -1, pre);
            }else{
                pre = nodeMap.get(num - 1);
            }
            pre.add(key);
            n.remove(key);
            numMap.put(key, num - 1);
        }
        
        if(n.list.size() == 0){
            nodeMap.remove(n.num);
            n.left.right = n.right;
            n.right.left = n.left; 
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        
        if(end.left == head){
            return "";
        }
        
        return end.left.list.get(0);
        
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(head.right == end){
            return "";
        }
        return  head.right.list.get(0);  
    }
    
    
    public static void main(String[] args){
    	AllOne a = new AllOne();
    	a.inc("hello");
    	a.inc("hello");
    	System.out.println(a.getMinKey());
    }
}

class Node{
    int num;
    Map<String, Integer> keys;
    List<String> list;
    Node left;
    Node right;
    
    Node(int num){
        this.num = num;
        keys = new HashMap<>();
        list = new ArrayList();
    }
    
    void remove(String key){
        int num = keys.get(key);
        int last = list.size()-1;
        String lastStr = list.get(last);
        keys.put(lastStr, num);
        list.set(num, lastStr);
        keys.remove(key);
        list.remove(last);
    }
    
    void add(String key){
        keys.put(key, list.size());
        list.add(key);
    }
}

