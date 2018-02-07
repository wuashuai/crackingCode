package arrayStrings;

//String Rotation: 
//Assume you have a method isSubstring which checks if one word is a substring of another. 
//Given two strings, 51 and 52, 
//write code to check if 52 is a rotation of 51 using only one call to isSubstring 
//(e.g.,"waterbottle"is a rotation of"erbottlewat").

public class StringRotation {
	public boolean rotate(String a, String b){
		if(a == null || b == null){
			return false;
		}
		if(a.length() != b.length()){
			return false;
		}
		
		String b2 = b + b;
		return b2.contains(a);
	}
	
	public static void main(String[] args){
		StringRotation sr = new StringRotation();
		
		System.out.println(sr.rotate("waterbottle", "erbottlewat"));
		System.out.println(sr.rotate("erbottlewat", "waterbottle"));
		System.out.println(sr.rotate("waterbottel", "erbottlewat"));
	}
	
	
	
	
}
