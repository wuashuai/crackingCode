package TreeAndGraph;

import java.util.*;


//List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth 
//(e.g., if you have a tree with depth 0, you'll have 0 linked lists).


public class ListDepths {
	public static void main(String[] args){
		ListDepths ld = new ListDepths();
		
		
		Node head = new Node(1);
		Node left = new Node(2);
		Node right = new Node(3);
		Node l = new Node(4);
		Node r = new Node(5);
		
		head.left = left;
		head.right = right;
		left.left = l;
		left.right = r;
		
		List<List<Node>> list = ld.convert(head);
		
		for(List<Node> li : list){
			for(Node ls : li){
				System.out.print(ls.value + "  ");
			}
			System.out.println();
			
		}
		
		
	}
	
	public List<List<Node>> convert(Node head){
		Queue<Node> queue = new LinkedList<>();
		
		List<List<Node>> res = new LinkedList<>();
		
		queue.offer(head);
		
		while(!queue.isEmpty()){
			List<Node> list = new LinkedList<>();
			int size = queue.size();
			
			for(int i = 0; i < size; i++){
				Node n = queue.poll();
				list.add(n);
				if(n.left != null) queue.offer(n.left);
				if(n.right != null) queue.offer(n.right);
			}
			res.add(list);
		}
		
		return res;
	}
}
