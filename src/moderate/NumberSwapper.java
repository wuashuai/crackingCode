package moderate;



// Write a function to swap a number in place (that is, without temporary variables).
public class NumberSwapper {
	
	public static void replace(int a, int b){
		
		System.out.println(a + "   "  + b);
		
		a = a ^ b;
		
		System.out.println(a + "   "  + b);
		
		b = a ^ b;
		
		System.out.println(a + "   "  + b);
		a = a ^ b;
		
		System.out.println(a + "   "  + b);
	}
	
	public static void main(String[] args){
		
		replace(4, 100);
	}

}
