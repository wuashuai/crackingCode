package TreeAndGraph;

import java.util.*;

public class BuildOrder {
	public List<String> solve(String[] projects, String[][] dependencies){
		
		List<String> res = new LinkedList<>();
		
		Map<String, List<String>> relation = new HashMap<>();
		Map<String, Integer> in = new HashMap<>();
		
		int count = 0;
		
		for(String project : projects ){
			relation.put(project, new ArrayList<>());
			in.put(project, 0);
		}
		
		for(String[] dependency : dependencies){
			relation.get(dependency[1]).add(dependency[0]);
			in.put(dependency[0], in.get(dependency[0]) + 1);
		}
		
		Queue<String> queue = new LinkedList<>();
		
		for(String project : projects){
			if(in.get(project) == 0){
				queue.offer(project);
			}
		}
		
		while(!queue.isEmpty()){
			String s = queue.poll();
			
			for(String re : relation.get(s)){
				in.put(re, in.get(re) - 1);
				if(in.get(re) == 0){
					queue.offer(re);
				}
			}
			
			res.add(s);
		}
		
		if(res.size() != projects.length){
			return null;
		}
		return res;
	}
	
}
