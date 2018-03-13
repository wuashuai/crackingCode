package TreeGraphs;

public class CheckSubtree {
    
    public Node check(Node l1, Node l2) {
        if(l1 == null && l2 == null) {
            return l1;
        }
        
        if(l1.value == l2.value && checksub(l1, l2)) {
            return l1;
        }
        
        Node left = check(l1.left, l2);
        Node right = check(l1.right, l2);
        
        if(left == null) {
            return right;
        }else {
            return left;
        }
    }
    
    public boolean checksub(Node l1, Node l2) {
        if(l1 == null && l2 == null) {
            return true;
        }
        if(l1.value != l2.value) return false;
        
        return checksub(l1.left, l1.right) && checksub(l1.right, l2.right);
    }
}

class Node {
    Node left;
    Node right;
    int value;
    
    Node(int v){
        value = v;
    }
}
