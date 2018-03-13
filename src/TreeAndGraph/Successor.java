package TreeAndGraph;

//Successor: Write an algorithm to find the "next" node 
//(i.e., in-order successor) of a given node in a binary search tree. 
//You may assume that each node has a link to its parent.

public class Successor {
	
	//in-order
	public DoubleNode findNext(DoubleNode node){
		if(node == null) return null;
		
		if(node.right == null) return node.ance;
		
		DoubleNode dn = node.right;
		while(dn.left != null){
			dn = dn.left;
		}
		return dn;
	}
}

class DoubleNode {
	DoubleNode ance;
	DoubleNode left;
	DoubleNode right;
	int val;
	
	DoubleNode(int val){
		this.val = val;
	}
}