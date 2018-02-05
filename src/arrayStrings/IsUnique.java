package arrayStrings;

import java.util.HashSet;
import java.util.Set;

// Is Unique: Implement an algorithm to determine if a string has all unique characters. 
// What if you cannot use additional data structures?

public class IsUnique {

	public boolean isUnique(String s){
		
		Set<Character> set = new HashSet<>();
		
		for(char c : s.toCharArray()){
			if(set.contains(c)){
				return false;
			}
			set.add(c);
		}
		return true;
	}
	
	public static void main(String[] args){
		IsUnique isU = new IsUnique();
		
		System.out.println(isU.isUnique("aab"));
		
		System.out.println(isU.isUnique("a2124"));
		
		System.out.println(isU.isUnique("abhcs"));
		
		System.out.println(isU.isUnique("abhc*s"));
	}
	
}


