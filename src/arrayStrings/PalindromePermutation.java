package arrayStrings;

import java.util.HashSet;
import java.util.Set;

//palindrome Permutation: 
//Given a string, write a function to check if it is a permutation of a palin- drome. 
//A palindrome is a word or phrase that is the same forwards and backwards. 
//A permutation is a rearrangement of letters.The palindrome does not need to be limited to just dictionary words.

//EXAMPLE
//Input: Tact Coa
//Output: True (permutations: "taco cat". "atco cta". etc.) Hints: #106, #121, #134, #136


public class PalindromePermutation {
	public boolean check(String s){
		Set<Character> set = new HashSet<>(); 
		
		for(char c : s.toCharArray()){
			
			c = convert(c);
			if(c == ' ') continue;
			
			if(set.contains(c)){
				set.remove(c);
			}else{
				set.add(c);
			}
		}
		
		return set.size() == 0 || set.size() == 1;
	}
	
	public char convert(char c){
		if(c <= 'z' && c >= 'a'){
			return c;
		}else if(c <= 'Z' && c >= 'A'){
			return (char)(c-'A'+'a'); 
		}else{
			return ' ';
		}
	}
	
	public static void main(String[] args){
		PalindromePermutation pp = new PalindromePermutation();
		
		System.out.println(pp.check("Tact Coa"));
	}
	
}
