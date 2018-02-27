package linkedList;


//Implement an algorithm to delete a node in the middle (i.e., any node but
//the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
//that node.
//EXAMPLE
//Input: the node c from the linked list a - >b- >c - >d - >e- >f
//Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f


public class RemoveMiddleNode {
    
    public static void main(String[] args) {
        RemoveMiddleNode rm = new RemoveMiddleNode();
        
        SingleList list = new SingleList() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(52);
            add(6);
        }};
        
        list.print();
        
        Node n = list.head.next.next;
        rm.remove(n);
        
        list.print();
        
    }
    
    public void remove(Node c) {
        c.val = c.next.val;
        c.next = c.next.next;
       
    }

}
