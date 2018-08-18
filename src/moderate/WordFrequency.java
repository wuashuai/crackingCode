package moderate;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
	
	Map<String, Integer> map;
	
	public WordFrequency(String[] args){
		map = new HashMap<>();
		for(String s : args){
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
	}
	
	public int query(String s){
		return map.getOrDefault(s, 0);
	} 
	
	public static void main(String[] args){
		String[] ss = {"abc","harry","potter","hello", "world", "abc"};
		
		WordFrequency wf = new WordFrequency(ss);
		System.out.println(wf.query("harry"));
		System.out.println(wf.query("abc"));
		System.out.println(wf.query("exist"));
		
	}
	
}
