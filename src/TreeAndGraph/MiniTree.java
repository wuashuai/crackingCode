package TreeAndGraph;

//Minimal Tree: Given a sorted (increasing order) array with unique integer elements, 
//write an algorithm to create a binary search tree with minimal height.

public class MiniTree {
	
	public Node createTree(int[] array){
		return helper(array, 0, array.length-1);
	}
	
	public Node helper(int[] array, int s, int e){
		if(e < s) return null;
		int mid = (e + s) / 2;
		
		Node node = new Node(array[mid]);
		node.left = helper(array, s, mid-1);
		node.right = helper(array, mid+1, e);
		return node;
	}
	
	public static void main(String[] args){
		MiniTree m = new MiniTree();
		int[] array = new int[]{1,2,3,4,5,6,7};
		Node n = m.createTree(array);
		
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
