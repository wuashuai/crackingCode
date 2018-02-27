package linkedList;

import java.util.LinkedList;

//Implement an algorithm to find the kth to last element of a singly linked list.

public class ReturnKthToLast {
    
    public static void main(String[] args) {
        ReturnKthToLast rk = new ReturnKthToLast();
        SingleList list = new SingleList() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(52);
            add(6);
        }};
        
        System.out.println(rk.returnKth(list, 0));
        System.out.println(rk.returnKth(list, 1));
        System.out.println(rk.returnKth(list, 5));
        System.out.println(rk.returnKth(list, 6));
        

    }
    
    public int returnKth(SingleList list, int k)  {
        
        int res = -1;
                
        Node fast = list.head;
        Node slow = list.head;
        
        while(fast.next != null) {
            fast = fast.next;
            if(k > 0) {
                k--;
            } else {
                slow = slow.next;
            }
          
        }
        return slow.val;
    }
}

class Node {
    int val;
    Node next;
    
    Node(int val){
        this.val = val;
        
    }
}

class SingleList {
    Node head;
    Node current;
    
    SingleList(){
        head = new Node(0);
        current = head;
    }
    
    void add(int val) {
        Node node = new Node(val);
        current.next = node;
        current = node;
    }
    
    void print() {
        Node n = head;
        while(n.next != null) {
            n = n.next;
            System.out.println(n.val);
        }
    }
}
