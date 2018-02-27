package linkedList;

//Sum Lists: You have two numbers represented by a linked list, where each node contains a single
//digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
//function that adds the two numbers and returns the sum as a linked list.
//EXAMPLE
//Input: (7-) 1 -) 6) + (5 -) 9 -) 2) .That is,617 + 295.
//Output: 2 -) 1 -) 9. That is, 912.
//FOLLOW UP
//Suppose the digits are stored in forward order. Repeat the above problem.
//EXAMPLE
//Input: (6 -) 1 -) 7) + (2 -) 9 -) 5).That is,617 + 295.
//Output: 9 -) 1 -) 2. That is, 912.


public class SumList {
    
    public static void main(String[] args) {
        SumList sm = new SumList();
        
        SingleList a = new SingleList() {{
            add(7);
            add(1);
            add(6);
        }};
        
        SingleList b = new SingleList() {{
            add(5);
            add(9);
            add(3);
        }};

        
        SingleList res = sm.sumReverse(a,b);
        res.print();
        
        a = new SingleList() {{
            add(6);
            add(1);
            add(7);
        }};
        
        b = new SingleList() {{
            add(2);
            add(9);
            add(5);
        }};
        
        //res = sm.sumForward(a,b);
    }
    
    public SingleList sumReverse(SingleList a, SingleList b) {
        
        SingleList res = new SingleList();
        
        Node n = a.head;
        Node m = b.head;
        int c = 0;
        
        while(n.next != null) {
            n = n.next;
            m = m.next;
            
            res.add((m.val + n.val + c) % 10);
            c =  (m.val + n.val + c) / 10;
        }
        
        if(c != 0) {
            res.add(1);
        }
        
        return res;
    }
    
    public SingleList sumForward(SingleList a, SingleList b) {
        
        SingleList res = new SingleList();
        
        Node n = a.head;
        Node m = b.head;
        int c = 0;
        
        while(n.next != null) {
            n = n.next;
            m = m.next;
            
            res.add((m.val + n.val + c) % 10);
            c =  (m.val + n.val + c) / 10;
        }
        
        return res;
    }

}
