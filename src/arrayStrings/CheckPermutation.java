package arrayStrings;

import java.util.HashMap;
import java.util.Map;

//Check Permutation: Given two strings, 
//write a method to decide if one is a permutation of the other.


public class CheckPermutation {
	
	public static boolean check(String a, String b){
		if(a == null || b == null) return false;
		
		Map<Character, Integer> mapA = new HashMap<>();
		
		if(a.length() != b.length()) return false;
		
		for(char c : a.toCharArray()){
			int num = mapA.getOrDefault(c, 0);
			mapA.put(c, num+1);
		}
		
		for(char c : b.toCharArray()){
			int num = mapA.getOrDefault(c, 0);
			if(num == 0){
				return false;
			}
			mapA.put(c, num-1);
		}
 		
		return true;
	}
	
	public static void main(String[] args){
		
		System.out.println(check("aab", "aaa"));
		
		System.out.println(check("aab", "baa"));
		
		System.out.println(check("abc", "cba"));
		
		System.out.println(check("aaa", "aaaa"));
	}	
}
