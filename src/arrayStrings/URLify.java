package arrayStrings;

//URLify: Write a method to replace all spaces in a string with '%20: 
//You may assume that the string has sufficient space at the end to hold the additional characters,
//and that you are given the "true" length of the string. 
//(Note: If implementing in Java, please use a character array so that you can perform this operation in place.)

//EXAMPLE
//Input: "Mr John Smith " 
//Output: "Mr%20John%20Smith"


public class URLify {

	public char[] replace(char[] URL, int length){
		
		if(length <= 0 || URL == null ){
			return URL;
		}
		
		int index = length;
	
		for(int i = 0; i < length; i++)
			if(URL[i] == ' ')
				index+=2;
		
		for(int i = length-1; i >= 0; i--){
			if(URL[i] == ' '){
				URL[--index] = '0';
				URL[--index] = '2';
				URL[--index] = '%';
			}else{
				URL[--index] = URL[i];
			}
		}
		
		return URL;
	}
	
	public static void main(String[] args) {
		String str = "abc d e f";
		char[] arr = new char[str.length() + 3 * 2 + 1];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		
		URLify u = new URLify();
		
		System.out.println(new String(u.replace(arr, str.length())));
	}
}
