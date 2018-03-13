package TreeAndGraph;

import java.util.*;

public class BSTSequence {
	
	public List<List<Integer>> solve(Node node){
		
		List<List<Integer>> res = new ArrayList<>();
		
		if(node == null) {
			res.add(new ArrayList<>());
			return res;
		}
		
		List<List<Integer>> left = solve(node.left);
		List<List<Integer>> right = solve(node.right);
		
		res = helper(left, right, node);
	
		return res;
		
	}
	
	public List<List<Integer>> helper( List<List<Integer>> left, List<List<Integer>> right, Node node){
		
		List<List<Integer>> res = new ArrayList<>();
		
		for(List<Integer> l : left){
			for(List<Integer> r : right){
				List<List<Integer>> list = wave(l, r, node);
				res.addAll(list);
			}
		}

		return res;
	}
	
	public List<List<Integer>> wave(List<Integer> l, List<Integer> r, Node node){
		
		List<List<Integer>> res = new ArrayList<>();
		
		int k = 0, j = 0;
		
		List<Integer> list = new ArrayList<>();
		list.add(node.value);
		
		contribute(res,list, k, j, l, r);
		
		return res;
	}
	
	public void contribute(List<List<Integer>> res, List<Integer> list, int k, int j, List<Integer> l, List<Integer> r){
		if(k == l.size() && j == r.size()){
			res.add(new ArrayList<>(list));
			return;
		}
		
		if(k < l.size()){
			list.add(l.get(k));
			contribute(res,list, k+1, j, l, r);
			list.remove(list.size()-1);
		}
		
		if(j < r.size()){
			list.add(r.get(j));
			contribute(res,list, k, j+1, l, r);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		Node node = new Node(100);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(150);
		
		node.left = node1;
		node1.right = node2;
		node.right = node3;
		
		BSTSequence bst = new BSTSequence();
		
		List<List<Integer>> allSeq = bst.solve(node);
		
		for (List<Integer> list : allSeq) {
			System.out.println(list);
		}
		System.out.println(allSeq.size());
	}

}
