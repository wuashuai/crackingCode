package arrayStrings;

import java.util.HashSet;
import java.util.Set;

//One Away: 
//There are three types of edits that can be performed on strings: 
//insert a character, remove a character, or replace a character. 
//Given two strings, write a function to check if they are one edit (or zero edits) away.
//EXAMPLE
//pale, pIe -> true 
//pales. pale -> true 
//pale. bale -> true 
//pale. bake -> false

public class OneAway {
	
	public boolean check(String a, String b){
		
		if(a == null || b == null) return false;
		
		if(a.length() == b.length()) {
			return oneEdit(a.toCharArray(), b.toCharArray());
		}else if (a.length() == b.length() - 1) {
			return oneInsert(a.toCharArray(), b.toCharArray());
		}else if (a.length() == b.length() + 1) {
			return oneDelete(a.toCharArray(), b.toCharArray());
		}else{
			return false;
		}
	}
	
	public boolean oneInsert(char[] a, char[] b){
		
		int count = 0;
		
		for(int i = 0; i < a.length; i++){
			if(a[i] != b[i+count]) {
				count++;
			}
			
			if(count > 1) return false;
		}
		
		return true;
	}
	
	public boolean oneDelete(char[] a, char[] b){
		return oneInsert(b, a);
	}
	
	public boolean oneEdit(char[] a, char[] b){
		
		int count = 0;
		
		for(int i = 0; i < a.length; i++){
			if(a[i] == b[i]){
				continue;
			}else{
				count++;
			}
		}
		
		return count <= 1;
	}
	
	public static void main(String[] args){
		OneAway o = new OneAway();
		
		System.out.println(o.check("pale", "ple"));
		System.out.println(o.check("pales", "pale"));
		System.out.println(o.check("pale", "bale"));
		System.out.println(o.check("pale", "bake"));
	}
}
