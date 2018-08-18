package interview;

import java.util.*;

class LFUCache {

    //frequency map
    Map<Integer, Integer> map = new HashMap<>();
    //Frequency -> Node
    Map<Integer, Node> fmap = new HashMap<>();

    int cap;
    Node head;
    Node tail;


    public LFUCache(int capacity) {
        this.cap = capacity;
        head = new Node(-1);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = fmap.get(map.get(key));
            int val = n.map.get(key);
            updateFrequece(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int val) {

        if(map.containsKey(key)){
            updateFrequece(key, val);
        }else{
            if(cap == 0){
                removeFirst();
                cap++;
            }
            insert(key, val);
            cap--;
        }

    }

    private void removeFirst(){
        Node n = head.next;
        Map.Entry<Integer, Integer> first = n.map.entrySet().iterator().next();
        n.map.remove(first.getKey());
        map.remove(first.getKey());
        if(n.map.size() == 0){
            head.next = n.next;
        }
    }

    private void insert(int key, int val){
        if(!fmap.containsKey(1)){
            Node n = new Node(1);
            head.next.pre = n;
            n.next = head.next;
            n.pre = head;
            head.next = n;
            fmap.put(1, n);
        }
        fmap.get(1).map.put(key, val);
        map.put(key, 1);
    }

    private void updateFrequece(int key, int val){
        int f = map.get(key);
        map.put(key, f + 1);
        Node n = fmap.get(f);
        n.map.remove(key);

        if(!fmap.containsKey(f+1)){
            Node m = new Node(f+1);
            n.next.pre = m;
            m.next = n.next;
            m.pre = n;
            n.next = m;
            fmap.put(f+1, m);
        }

        fmap.get(f+1).map.put(key, val);

        if(n.map.size() == 0){
            n.next.pre = n.pre;
            n.pre.next = n.next;
            fmap.remove(f);
        }
    }

    public static void main(String[] args){
        LFUCache lfu = new LFUCache(3);
        lfu.put(2,2);
        lfu.put(1,1);
        lfu.get(2);
        lfu.get(1);
        lfu.get(2);
        lfu.put(3,3);
        lfu.put(4,4);
        lfu.get(3);
        lfu.get(2);
        lfu.get(1);
        lfu.get(4);

    }
}

class Node{

    LinkedHashMap<Integer, Integer> map;
    int f;

    Node next;
    Node pre;

    Node(int val){
        f = val;
        map = new LinkedHashMap<>();
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */